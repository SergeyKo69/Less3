package ru.kogut.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * @author S.Kogut on 2019-03-21
 */
public class ProfilerHandler implements InvocationHandler {

    private Object target;

    Logger logger = Logger.getLogger("Profile");

    public ProfilerHandler(final Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final long start = System.currentTimeMillis();
        final Object result = method.invoke(target, args);
        logger.info("Profiler:" + target.getClass().getSimpleName() + " was performed: " + (System.currentTimeMillis() - start) + " ms.");
        return result;
    }
}
