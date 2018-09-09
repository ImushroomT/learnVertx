package com.jason;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * @author qiushengsen
 * @dateTime 2018/5/21 下午10:06
 * @descripiton
 **/
public class ParentVerticle extends AbstractVerticle {
    @Override
    public void start(Future<Void> startFuture) throws Exception {
        vertx.deployVerticle(new ChildVerticle(), result -> {
            if (result.succeeded()) {
                startFuture.complete();
            }
        });
    }
}
