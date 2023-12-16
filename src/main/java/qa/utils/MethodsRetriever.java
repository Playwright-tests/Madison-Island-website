package qa.utils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class MethodsRetriever<T> {

    private final Class<T> tClass;

    public MethodsRetriever(Class<T> tClass) {

        this.tClass = tClass;
    }

    public Method[] getMethods() {

        return Arrays.stream(tClass.getMethods())
                .filter(method -> method.getName().toLowerCase().contains("set"))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);
    }
}
