package com.jason;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.Message;

import java.util.concurrent.TimeUnit;

/**
 * @author qiushengsen
 * @dateTime 2018/5/13 下午8:18
 * @descripiton
 **/
public class Main {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        /**p2p test*/
        Future.<Message<String>>future(future -> {
            vertx.eventBus().consumer("jason.vert", message -> {
                System.out.println("receive p2p msg is " + message.body());
                message.reply("got it!");
            });
        });
        Future.<Message<String>>future(future -> {
            vertx.eventBus().send("jason.vert", "hello", future);
        }).compose((msg) -> Future.<Message<String>>future(f -> {
            System.out.println(msg.body());
        }));

        /**运行阻塞操作，第一个参数是动作，结果放入future，第二个操作的参数是动作执行结果
         * 如果成功会得到上一步设置的结果
         * */
        vertx.executeBlocking(future -> {
            System.out.println("this is an blocking action");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            future.complete("complete blocking action");
        }, res -> {
            if (res.succeeded()) {
                System.out.println(res.result());
            }
        });
        System.out.println("deploy first vertical");
        //DeploymentOptions options = new DeploymentOptions().setInstances(8);
        vertx.deployVerticle(MyFirstVertical.class.getName());

        vertx.deployVerticle(new UnDeployVerticle(), result -> {
            System.out.println("deployment id is " + result.result());
            vertx.undeploy(result.result());
        });

        vertx.deployVerticle(new ParentVerticle(), result -> {
            vertx.undeploy(result.result());
        });

    }
}
