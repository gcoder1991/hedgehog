// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: core.proto

package com.ek.hedgehog.core.proto;

public final class Core {
  private Core() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_TransformLog_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TransformLog_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_BasicTransform_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_BasicTransform_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RpcRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RpcRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RpcResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RpcResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\ncore.proto\"\016\n\014TransformLog\"n\n\016BasicTra" +
      "nsform\022\032\n\004type\030\001 \001(\0162\014.MessageType\022\017\n\007ha" +
      "shKey\030\002 \001(\003\022\036\n\007history\030\003 \003(\0132\r.Transform" +
      "Log\022\017\n\007content\030\004 \001(\014\"\031\n\nRpcRequest\022\013\n\003ri" +
      "d\030\001 \001(\003\"\032\n\013RpcResponse\022\013\n\003rid\030\001 \001(\003*=\n\013M" +
      "essageType\022\n\n\006UNKNOW\020\000\022\r\n\tHEARTBEAT\020\001\022\n\n" +
      "\006COMMON\020\002\022\007\n\003RPC\020\003B \n\032com.ek.hedgehog.co" +
      "re.protoH\001P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_TransformLog_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_TransformLog_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TransformLog_descriptor,
        new java.lang.String[] { });
    internal_static_BasicTransform_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_BasicTransform_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_BasicTransform_descriptor,
        new java.lang.String[] { "Type", "HashKey", "History", "Content", });
    internal_static_RpcRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_RpcRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RpcRequest_descriptor,
        new java.lang.String[] { "Rid", });
    internal_static_RpcResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_RpcResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RpcResponse_descriptor,
        new java.lang.String[] { "Rid", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
