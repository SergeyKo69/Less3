package ru.kogut.proxy;

import lombok.SneakyThrows;

import java.util.logging.Logger;

/**
 * @author S.Kogut on 2019-03-21
 */
public class Product implements CRUDOperation {

    private final Logger logger = Logger.getLogger("Product");

    @Override
    @SneakyThrows
    public void create() {
        Thread.sleep(200);
        logger.info("LOG: product create");
    }

    @Override
    @SneakyThrows
    public void read() {
        Thread.sleep(300);
        logger.info("LOG: product read");
    }

    @Override
    @SneakyThrows
    public void update() {
        Thread.sleep(250);
        logger.info("LOG: product update");
    }

    @Override
    @SneakyThrows
    public void delete() {
        Thread.sleep(350);
        logger.info("LOG: product delete");
    }
}
