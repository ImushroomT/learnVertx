package com.jason;

import io.vertx.core.AbstractVerticle;

/**
 * @author qiushengsen
 * @dateTime 2018/5/21 下午9:50
 * @descripiton
 **/
public class UnDeployVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        System.out.println("this is undeploy verticle");
    }

    @Override
    public void stop() throws Exception {
        System.out.println("undeploy verticle was killed");
    }
}
