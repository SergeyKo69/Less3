package ru.kogut.proxy;

import ru.kogut.proxy.annotations.Logger;
import ru.kogut.proxy.annotations.Profiler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author S.Kogut on 2019-03-21
 */
public class GlobalHandler implements InvocationHandler {

    private Object target;

    private final LoggerHandler loggerHandler;

    private final ProfilerHandler profileHandler;

    public GlobalHandler(final Object target) {
        this.target = target;
        this.loggerHandler = new LoggerHandler(target);
        this.profileHandler = new ProfilerHandler(target);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (target == null) return null;

        if (method.isAnnotationPresent(Logger.class))
            loggerHandler.invoke(target,method,args);
        if (method.isAnnotationPresent(Profiler.class))
            profileHandler.invoke(target,method,args);

        return method.invoke(target,args);
    }
}
