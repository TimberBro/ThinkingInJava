package com.test.generics;

import static com.test.util.Tuple.tuple;

import com.test.util.TwoTuple;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

class MixinProxy implements InvocationHandler {
  Map<String, Object> delegatesByMethod;

  public MixinProxy(TwoTuple<Object, Class<?>>... pairs) {
    delegatesByMethod = new HashMap<String, Object>();
    for (TwoTuple<Object, Class<?>> pair : pairs) {
      for (Method method : pair.second.getMethods()) {
        String methodName = method.getName();
        // The first interface in the map
        // implements the method.
        if (!delegatesByMethod.containsKey(methodName)) {
          delegatesByMethod.put(methodName, pair.first);
        }
      }
    }
  }

  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    String methodName = method.getName();
    Object delegate = delegatesByMethod.get(methodName);
    return method.invoke(delegate, args);
  }

  @SuppressWarnings("unchecked")
  public static Object newInstance(TwoTuple... pairs) {
    Class[] interfaces = new Class[pairs.length];
    for (int i = 0; i < pairs.length; i++) {
      interfaces[i] = (Class) pairs[i].second;
    }
    ClassLoader cl = pairs[0].first.getClass().getClassLoader();
    return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
  }
}

public class DynamicProxyMixin {
  public static void main(String[] args) {
    Object mixin =
        MixinProxy.newInstance(
            tuple(new BasicImp(), Basic.class),
            tuple(new TimeStampedImp(), TimeStamped.class),
            tuple(new SerialNumberedImp(), SerialNumbered.class),
            tuple(new ColoredImpl(), Colored.class));
    Basic b = (Basic) mixin;
    b.set("Hello");
    System.out.println(b.get());
    TimeStamped t = (TimeStamped) mixin;
    System.out.println(t.getStamp());
    SerialNumbered s = (SerialNumbered) mixin;
    System.out.println(s.getSerialNumber());
    Colored c = (Colored) mixin;
    System.out.println(c.getColor());
  }
}
