package com.test.concurrency;

import com.test.util.BasicGenerator;
import com.test.util.Generator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ExchangerProducer<T> implements Runnable {

  private Generator<T> generator;
  private Exchanger<List<T>> exchanger;
  private List<T> holder;

  ExchangerProducer(Exchanger<List<T>> exchg, Generator<T> gen, List<T> holder) {
    exchanger = exchg;
    generator = gen;
    this.holder = holder;
  }

  public void run() {
    try {
      while (!Thread.interrupted()) {
        for (int i = 0; i < ExchangerDemo.size; i++) {
          holder.add(generator.next());
        }
        // Exchange full for empty:
        holder = exchanger.exchange(holder);
      }
    } catch (InterruptedException e) {
      // OK to terminate this way.
    }
  }
}

class ExchangerConsumer<T> implements Runnable {

  private Exchanger<List<T>> exchanger;
  private List<T> holder;
  private volatile T value;

  ExchangerConsumer(Exchanger<List<T>> ex, List<T> holder) {
    exchanger = ex;
    this.holder = holder;
  }

  public void run() {
    try {
      while (!Thread.interrupted()) {
        holder = exchanger.exchange(holder);
        for (T x : holder) {
          value = x; // Fetch out value
          holder.remove(x); // OK for CopyOnWriteArrayList
        }
      }
    } catch (InterruptedException e) {
      // OK to terminate this way.
    }
    System.out.println("Final value: " + value);
  }
}

public class ExchangerDemo {

  static int size = 10;
  static int delay = 5; // Seconds

  public static void main(String[] args) throws Exception {
    if (args.length > 0) {
      size = Integer.parseInt(args[0]);
    }
    if (args.length > 1) {
      delay = Integer.parseInt(args[1]);
    }
    ExecutorService exec = Executors.newCachedThreadPool();
    Exchanger<List<MyFat>> xc = new Exchanger<>();
    List<MyFat> producerList = new CopyOnWriteArrayList<>(), consumerList = new CopyOnWriteArrayList<>();
    exec.execute(
        new ExchangerProducer<>(xc, BasicGenerator.create(MyFat.class), producerList));
    exec.execute(new ExchangerConsumer<>(xc, consumerList));
    TimeUnit.SECONDS.sleep(delay);
    exec.shutdownNow();
  }
}