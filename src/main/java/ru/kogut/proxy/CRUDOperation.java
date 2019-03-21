package ru.kogut.proxy;

import ru.kogut.proxy.annotations.Logger;
import ru.kogut.proxy.annotations.Profiler;

/**
 * @author S.Kogut on 2019-03-21
 */
public interface CRUDOperation {

    @Logger
    void create();

    @Logger
    void read();

    @Profiler
    void update();

    @Profiler
    void delete();

}
