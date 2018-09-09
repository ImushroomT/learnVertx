package com.jason;

import io.vertx.core.AbstractVerticle;

/**
 * @author qiushengsen
 * @dateTime 2018/5/13 下午8:20
 * @descripiton
 **/
public class MyFirstVertical extends AbstractVerticle{
    @Override
    public void start() {
        vertx.createHttpServer().requestHandler(req -> {
            req.response().putHeader("content-type", "text/plain")
                    .end("hello vertx");
            System.out.println("current thread is " + Thread.currentThread().getName());
        }).listen(8080);
    }

    @Override
    public void stop() {
        System.out.println("i am angry, you should not evict me");
    }
}
