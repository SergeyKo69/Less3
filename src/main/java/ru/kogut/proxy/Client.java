package ru.kogut.proxy;

import lombok.SneakyThrows;

import java.util.logging.Logger;

/**
 * @author S.Kogut on 2019-03-21
 */
public class Client implements CRUDOperation {

    private final Logger logger = Logger.getLogger("Client");

    @Override
    @SneakyThrows
    public void create() {
        Thread.sleep(200);
        logger.info("LOG: client create");
    }

    @Override
    @SneakyThrows
    public void read() {
        Thread.sleep(300);
        logger.info("LOG: client read");
    }

    @Override
    @SneakyThrows
    public void update() {
        Thread.sleep(250);
        logger.info("LOG: client update");
    }

    @Override
    @SneakyThrows
    public void delete() {
        Thread.sleep(350);
        logger.info("LOG: client delete");
    }

}
