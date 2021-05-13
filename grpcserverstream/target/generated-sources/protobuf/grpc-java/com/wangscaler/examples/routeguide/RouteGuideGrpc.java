package com.wangscaler.examples.routeguide;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: route_guide.proto")
public final class RouteGuideGrpc {

  private RouteGuideGrpc() {}

  public static final String SERVICE_NAME = "routeguide.RouteGuide";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.wangscaler.examples.routeguide.Point,
      com.wangscaler.examples.routeguide.RouteSummary> METHOD_RECORD_ROUTE =
      io.grpc.MethodDescriptor.<com.wangscaler.examples.routeguide.Point, com.wangscaler.examples.routeguide.RouteSummary>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "routeguide.RouteGuide", "RecordRoute"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.wangscaler.examples.routeguide.Point.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.wangscaler.examples.routeguide.RouteSummary.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RouteGuideStub newStub(io.grpc.Channel channel) {
    return new RouteGuideStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RouteGuideBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RouteGuideBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RouteGuideFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RouteGuideFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class RouteGuideImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * A client-to-server streaming RPC.
     * Accepts a stream of Points on a route being traversed, returning a
     * RouteSummary when traversal is completed.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.wangscaler.examples.routeguide.Point> recordRoute(
        io.grpc.stub.StreamObserver<com.wangscaler.examples.routeguide.RouteSummary> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_RECORD_ROUTE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_RECORD_ROUTE,
            asyncClientStreamingCall(
              new MethodHandlers<
                com.wangscaler.examples.routeguide.Point,
                com.wangscaler.examples.routeguide.RouteSummary>(
                  this, METHODID_RECORD_ROUTE)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class RouteGuideStub extends io.grpc.stub.AbstractStub<RouteGuideStub> {
    private RouteGuideStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RouteGuideStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RouteGuideStub(channel, callOptions);
    }

    /**
     * <pre>
     * A client-to-server streaming RPC.
     * Accepts a stream of Points on a route being traversed, returning a
     * RouteSummary when traversal is completed.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.wangscaler.examples.routeguide.Point> recordRoute(
        io.grpc.stub.StreamObserver<com.wangscaler.examples.routeguide.RouteSummary> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_RECORD_ROUTE, getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class RouteGuideBlockingStub extends io.grpc.stub.AbstractStub<RouteGuideBlockingStub> {
    private RouteGuideBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RouteGuideBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RouteGuideBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class RouteGuideFutureStub extends io.grpc.stub.AbstractStub<RouteGuideFutureStub> {
    private RouteGuideFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RouteGuideFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RouteGuideFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_RECORD_ROUTE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RouteGuideImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RouteGuideImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RECORD_ROUTE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.recordRoute(
              (io.grpc.stub.StreamObserver<com.wangscaler.examples.routeguide.RouteSummary>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class RouteGuideDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.wangscaler.examples.routeguide.RouteGuideProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RouteGuideGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RouteGuideDescriptorSupplier())
              .addMethod(METHOD_RECORD_ROUTE)
              .build();
        }
      }
    }
    return result;
  }
}
