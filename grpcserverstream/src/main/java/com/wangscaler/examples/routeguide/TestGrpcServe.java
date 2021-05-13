package com.wangscaler.examples.routeguide;

import io.grpc.Server;
import io.grpc.netty.NettyServerBuilder;

public class TestGrpcServe {
    public static void main(String[] args) throws Exception {
        int port = 8980;
        Server server = NettyServerBuilder.forPort(port)
                .addService(new RouteGuideServer.RouteGuideService())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);
        server.awaitTermination();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("Server Stop");
            }
        });
    }
}
