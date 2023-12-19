package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Foo foo = new Foo();
        Method[] methods = Arrays.stream(Foo.class.getMethods()).filter(m -> m.getName().contains("fun")).toArray(Method[]::new);

        String omitted = "fun2";
        String[] data = { "For fun1 !!!", "For fun2 !!!", "For fun3 !!!" };

        for (int i = 0; i < methods.length; i++) {

            if (!methods[i].getName().contains(omitted)) {
                methods[i].invoke(foo, data[i]);
            }
        }
    }
}