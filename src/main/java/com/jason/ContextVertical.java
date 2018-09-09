package com.jason;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Context;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author qiushengsen
 * @dateTime 2018/5/30 下午10:18
 * @descripiton
 **/
public class ContextVertical extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        final Context context = vertx.getOrCreateContext();
        if (context.isEventLoopContext()) {
            System.out.println("this is event loop context");
        }
        context.put("name", "context_vertical");
        /**这是异步操作*/
        context.runOnContext(v -> {
            System.out.println(context.get("name").toString());
        });
        context.put("name", "context_gone");
    }
}
