package internal.org.springframework.content.commons.config;

import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

public class StoreFragment<T> {

    private final Class<T> iFace;

    private final T implementation;

    public StoreFragment(Class<T> iFace, T implementation) {
        this.iFace = iFace;
        this.implementation = implementation;
    }

    public T getImplementation() {
        return implementation;
    }

    public boolean hasMethod(Method method) {
        Assert.notNull(method, "Method must not be null!");
        return ReflectionUtils.findMethod(iFace, method.getName(), method.getParameterTypes()) != null;
    }

    public boolean hasImplementationMethod(Method method) {
        Assert.notNull(method, "Method must not be null!");
        return ReflectionUtils.findMethod(implementation.getClass(), method.getName(), method.getParameterTypes()) != null;
    }
}
