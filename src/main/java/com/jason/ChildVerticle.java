package com.jason;

import io.vertx.core.AbstractVerticle;

/**
 * @author qiushengsen
 * @dateTime 2018/5/21 下午10:07
 * @descripiton
 **/
public class ChildVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        System.out.println("this is child verticle");
    }

    /**
     * @author qiushengsen
     * @time 2018/5/21 下午10:14
     * @param
     * @return void
     * @descripiton 父verticle撤销时，子也会被撤销
     **/
    @Override
    public void stop() throws Exception {
        System.out.println("undeploy child verticle");
    }
}
