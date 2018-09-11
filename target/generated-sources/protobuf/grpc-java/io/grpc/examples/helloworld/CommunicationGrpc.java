package io.grpc.examples.helloworld;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.13.1)",
    comments = "Source: communication_service.proto")
public final class CommunicationGrpc {

  private CommunicationGrpc() {}

  public static final String SERVICE_NAME = "communication_service.Communication";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.helloworld.CommunicationRequest,
      io.grpc.examples.helloworld.CommunicationResponse> getCommunicationRequestHandlerMethod;

  public static io.grpc.MethodDescriptor<io.grpc.examples.helloworld.CommunicationRequest,
      io.grpc.examples.helloworld.CommunicationResponse> getCommunicationRequestHandlerMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.helloworld.CommunicationRequest, io.grpc.examples.helloworld.CommunicationResponse> getCommunicationRequestHandlerMethod;
    if ((getCommunicationRequestHandlerMethod = CommunicationGrpc.getCommunicationRequestHandlerMethod) == null) {
      synchronized (CommunicationGrpc.class) {
        if ((getCommunicationRequestHandlerMethod = CommunicationGrpc.getCommunicationRequestHandlerMethod) == null) {
          CommunicationGrpc.getCommunicationRequestHandlerMethod = getCommunicationRequestHandlerMethod = 
              io.grpc.MethodDescriptor.<io.grpc.examples.helloworld.CommunicationRequest, io.grpc.examples.helloworld.CommunicationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "communication_service.Communication", "CommunicationRequestHandler"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.helloworld.CommunicationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.helloworld.CommunicationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CommunicationMethodDescriptorSupplier("CommunicationRequestHandler"))
                  .build();
          }
        }
     }
     return getCommunicationRequestHandlerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommunicationStub newStub(io.grpc.Channel channel) {
    return new CommunicationStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommunicationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CommunicationBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommunicationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CommunicationFutureStub(channel);
  }

  /**
   */
  public static abstract class CommunicationImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a message
     * </pre>
     */
    public void communicationRequestHandler(io.grpc.examples.helloworld.CommunicationRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.helloworld.CommunicationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCommunicationRequestHandlerMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCommunicationRequestHandlerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.examples.helloworld.CommunicationRequest,
                io.grpc.examples.helloworld.CommunicationResponse>(
                  this, METHODID_COMMUNICATION_REQUEST_HANDLER)))
          .build();
    }
  }

  /**
   */
  public static final class CommunicationStub extends io.grpc.stub.AbstractStub<CommunicationStub> {
    private CommunicationStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommunicationStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommunicationStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommunicationStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a message
     * </pre>
     */
    public void communicationRequestHandler(io.grpc.examples.helloworld.CommunicationRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.helloworld.CommunicationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCommunicationRequestHandlerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CommunicationBlockingStub extends io.grpc.stub.AbstractStub<CommunicationBlockingStub> {
    private CommunicationBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommunicationBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommunicationBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommunicationBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a message
     * </pre>
     */
    public io.grpc.examples.helloworld.CommunicationResponse communicationRequestHandler(io.grpc.examples.helloworld.CommunicationRequest request) {
      return blockingUnaryCall(
          getChannel(), getCommunicationRequestHandlerMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CommunicationFutureStub extends io.grpc.stub.AbstractStub<CommunicationFutureStub> {
    private CommunicationFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommunicationFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommunicationFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommunicationFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a message
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.helloworld.CommunicationResponse> communicationRequestHandler(
        io.grpc.examples.helloworld.CommunicationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCommunicationRequestHandlerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COMMUNICATION_REQUEST_HANDLER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CommunicationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CommunicationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COMMUNICATION_REQUEST_HANDLER:
          serviceImpl.communicationRequestHandler((io.grpc.examples.helloworld.CommunicationRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.helloworld.CommunicationResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CommunicationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommunicationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.examples.helloworld.HelloWorldProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Communication");
    }
  }

  private static final class CommunicationFileDescriptorSupplier
      extends CommunicationBaseDescriptorSupplier {
    CommunicationFileDescriptorSupplier() {}
  }

  private static final class CommunicationMethodDescriptorSupplier
      extends CommunicationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CommunicationMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CommunicationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommunicationFileDescriptorSupplier())
              .addMethod(getCommunicationRequestHandlerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
