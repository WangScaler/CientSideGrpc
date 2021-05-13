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
import static java.util.concurrent.TimeUnit.NANOSECONDS;
import io.grpc.stub.StreamObserver;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RouteGuideServer {
    private static final Logger logger = Logger.getLogger(RouteGuideServer.class.getName());

    public static class RouteGuideService extends RouteGuideGrpc.RouteGuideImplBase {
        @Override
        public StreamObserver<Point> recordRoute(final StreamObserver<RouteSummary> responseObserver) {
            return new StreamObserver<Point>() {
                int pointCount;
                int featureCount;
                int distance;
                Point previous;
                final long startTime = System.nanoTime();

                @Override
                public void onNext(Point point) {
                    System.out.println(System.nanoTime()+"进来了");
                    pointCount++;
                    previous = point;
                }

                @Override
                public void onError(Throwable t) {
                    System.out.println(t.getMessage());
                    System.out.println(t.getCause());
                    System.out.println("error");
                    logger.log(Level.WARNING, "recordRoute cancelled");
                }

                @Override
                public void onCompleted() {
                    System.out.println(System.nanoTime()+"结束了");
                    long seconds = NANOSECONDS.toSeconds(System.nanoTime() - startTime);
                    responseObserver.onNext(RouteSummary.newBuilder().setPointCount(pointCount)
                            .setFeatureCount(featureCount).setDistance(distance)
                            .setElapsedTime((int) seconds).build());
                    responseObserver.onCompleted();
                }
            };
        }
    }
}
