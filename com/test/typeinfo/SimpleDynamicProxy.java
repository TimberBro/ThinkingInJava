package com.test.typeinfo;

import java.lang.reflect.*;

class DynamicProxyHandler implements InvocationHandler {
  private Object proxied;

  public DynamicProxyHandler(Object proxied) {
    this.proxied = proxied;
  }

  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println(
        "**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
    if (args != null) {
      for (Object arg : args) {
        System.out.println(" " + arg);
      }
    }
    // System.out.println("Proxy: " + proxy);
    // This row will lead to java.lang.StackOverflowError error.
    // Because we called proxy.toString() and toString method will be proxied.
    return method.invoke(proxied, args);
  }
}

public class SimpleDynamicProxy {
  public static void consumer(Interface iface) {
    iface.doSomething();
    iface.somethingElse("bonobo");
  }

  public static void main(String[] args) {
    RealObject real = new RealObject();
    consumer(real);
    // Insert a proxy and call again:
    Interface proxy =
        (Interface)
            Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[] {Interface.class},
                new DynamicProxyHandler(real));
    consumer(proxy);
  }
}
