/*
 * Copyright 2015 The gRPC Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.grpc.examples.routeguide;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.routeguide.RouteGuideGrpc.RouteGuideStub;
import io.grpc.stub.StreamObserver;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


/**
 * Sample client code that makes gRPC calls to the server.
 */
public class RouteGuideClient {

    private final RouteGuideStub asyncStub;

    private Random random = new Random();

    /**
     * Construct client for accessing RouteGuide server using the existing channel.
     */
    public RouteGuideClient(Channel channel) {
        asyncStub = RouteGuideGrpc.newStub(channel);
    }


    /**
     * Async client-streaming example. Sends {@code numPoints} randomly chosen points from {@code
     * features} with a variable delay in between. Prints the statistics when they are sent from the
     * server.
     */
    public void recordRoute(int numPoints) throws InterruptedException {
        final CountDownLatch finishLatch = new CountDownLatch(1);
        StreamObserver<RouteSummary> responseObserver = new StreamObserver<RouteSummary>() {
            @Override
            public void onNext(RouteSummary summary) {
                System.out.println(System.nanoTime()+"next");
            }

            //
            @Override
            public void onError(Throwable t) {
                System.out.println("onError");
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
                finishLatch.countDown();
            }
        };

        StreamObserver<Point> requestObserver = asyncStub.recordRoute(responseObserver);
        try {
            for (int i = 0; i < numPoints; ++i) {
                Point point = Point.newBuilder().setLatitude(11).setLongitude(12).build();
                System.out.println("正在发送第" + i + "条数据");
                requestObserver.onNext(point);
                Thread.sleep(random.nextInt(1000) + 500);
                if (finishLatch.getCount() == 0) {
                    return;
                }
            }
        } catch (RuntimeException e) {
            requestObserver.onError(e);
            throw e;
        }
        // Mark the end of requests
        System.out.println(System.nanoTime()+"即将结束");
        requestObserver.onCompleted();

        // Receiving happens asynchronously
        if (!finishLatch.await(5, TimeUnit.SECONDS)) {
            System.out.println("recordRoute can not finish within 1 minutes");
        }
    }

    /**
     * Issues several different requests and then exits.
     */
    public static void main(String[] args) throws InterruptedException {
        String target = "localhost:8980";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();
        RouteGuideClient client = new RouteGuideClient(channel);
        try {

            client.recordRoute(10);
        } finally {
            System.out.println("调用结束1");
            client.recordRoute(10);
            System.out.println("调用结束2");
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
