// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: core.proto

package org.ek.hedgehog.core.proto;

public interface RpcRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:RpcRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 rid = 1;</code>
   */
  long getRid();

  /**
   * <code>string className = 2;</code>
   */
  java.lang.String getClassName();
  /**
   * <code>string className = 2;</code>
   */
  com.google.protobuf.ByteString
      getClassNameBytes();

  /**
   * <code>string methodName = 3;</code>
   */
  java.lang.String getMethodName();
  /**
   * <code>string methodName = 3;</code>
   */
  com.google.protobuf.ByteString
      getMethodNameBytes();

  /**
   * <code>bytes parms = 4;</code>
   */
  com.google.protobuf.ByteString getParms();
}
