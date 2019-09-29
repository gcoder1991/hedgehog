// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: core.proto

package org.ek.hedgehog.core.proto;

/**
 * Protobuf type {@code RpcResponse}
 */
public  final class RpcResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:RpcResponse)
    RpcResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RpcResponse.newBuilder() to construct.
  private RpcResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RpcResponse() {
    result_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new RpcResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RpcResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            rid_ = input.readInt64();
            break;
          }
          case 16: {

            ret_ = input.readInt32();
            break;
          }
          case 26: {

            result_ = input.readBytes();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.ek.hedgehog.core.proto.Core.internal_static_RpcResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.ek.hedgehog.core.proto.Core.internal_static_RpcResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.ek.hedgehog.core.proto.RpcResponse.class, org.ek.hedgehog.core.proto.RpcResponse.Builder.class);
  }

  public static final int RID_FIELD_NUMBER = 1;
  private long rid_;
  /**
   * <code>int64 rid = 1;</code>
   */
  public long getRid() {
    return rid_;
  }

  public static final int RET_FIELD_NUMBER = 2;
  private int ret_;
  /**
   * <code>int32 ret = 2;</code>
   */
  public int getRet() {
    return ret_;
  }

  public static final int RESULT_FIELD_NUMBER = 3;
  private com.google.protobuf.ByteString result_;
  /**
   * <code>bytes result = 3;</code>
   */
  public com.google.protobuf.ByteString getResult() {
    return result_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (rid_ != 0L) {
      output.writeInt64(1, rid_);
    }
    if (ret_ != 0) {
      output.writeInt32(2, ret_);
    }
    if (!result_.isEmpty()) {
      output.writeBytes(3, result_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (rid_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, rid_);
    }
    if (ret_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, ret_);
    }
    if (!result_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(3, result_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.ek.hedgehog.core.proto.RpcResponse)) {
      return super.equals(obj);
    }
    org.ek.hedgehog.core.proto.RpcResponse other = (org.ek.hedgehog.core.proto.RpcResponse) obj;

    if (getRid()
        != other.getRid()) return false;
    if (getRet()
        != other.getRet()) return false;
    if (!getResult()
        .equals(other.getResult())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + RID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getRid());
    hash = (37 * hash) + RET_FIELD_NUMBER;
    hash = (53 * hash) + getRet();
    hash = (37 * hash) + RESULT_FIELD_NUMBER;
    hash = (53 * hash) + getResult().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.ek.hedgehog.core.proto.RpcResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ek.hedgehog.core.proto.RpcResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ek.hedgehog.core.proto.RpcResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ek.hedgehog.core.proto.RpcResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ek.hedgehog.core.proto.RpcResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ek.hedgehog.core.proto.RpcResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ek.hedgehog.core.proto.RpcResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ek.hedgehog.core.proto.RpcResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ek.hedgehog.core.proto.RpcResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.ek.hedgehog.core.proto.RpcResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ek.hedgehog.core.proto.RpcResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ek.hedgehog.core.proto.RpcResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.ek.hedgehog.core.proto.RpcResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code RpcResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:RpcResponse)
      org.ek.hedgehog.core.proto.RpcResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.ek.hedgehog.core.proto.Core.internal_static_RpcResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.ek.hedgehog.core.proto.Core.internal_static_RpcResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.ek.hedgehog.core.proto.RpcResponse.class, org.ek.hedgehog.core.proto.RpcResponse.Builder.class);
    }

    // Construct using org.ek.hedgehog.core.proto.RpcResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      rid_ = 0L;

      ret_ = 0;

      result_ = com.google.protobuf.ByteString.EMPTY;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.ek.hedgehog.core.proto.Core.internal_static_RpcResponse_descriptor;
    }

    @java.lang.Override
    public org.ek.hedgehog.core.proto.RpcResponse getDefaultInstanceForType() {
      return org.ek.hedgehog.core.proto.RpcResponse.getDefaultInstance();
    }

    @java.lang.Override
    public org.ek.hedgehog.core.proto.RpcResponse build() {
      org.ek.hedgehog.core.proto.RpcResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.ek.hedgehog.core.proto.RpcResponse buildPartial() {
      org.ek.hedgehog.core.proto.RpcResponse result = new org.ek.hedgehog.core.proto.RpcResponse(this);
      result.rid_ = rid_;
      result.ret_ = ret_;
      result.result_ = result_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.ek.hedgehog.core.proto.RpcResponse) {
        return mergeFrom((org.ek.hedgehog.core.proto.RpcResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.ek.hedgehog.core.proto.RpcResponse other) {
      if (other == org.ek.hedgehog.core.proto.RpcResponse.getDefaultInstance()) return this;
      if (other.getRid() != 0L) {
        setRid(other.getRid());
      }
      if (other.getRet() != 0) {
        setRet(other.getRet());
      }
      if (other.getResult() != com.google.protobuf.ByteString.EMPTY) {
        setResult(other.getResult());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.ek.hedgehog.core.proto.RpcResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.ek.hedgehog.core.proto.RpcResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long rid_ ;
    /**
     * <code>int64 rid = 1;</code>
     */
    public long getRid() {
      return rid_;
    }
    /**
     * <code>int64 rid = 1;</code>
     */
    public Builder setRid(long value) {
      
      rid_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 rid = 1;</code>
     */
    public Builder clearRid() {
      
      rid_ = 0L;
      onChanged();
      return this;
    }

    private int ret_ ;
    /**
     * <code>int32 ret = 2;</code>
     */
    public int getRet() {
      return ret_;
    }
    /**
     * <code>int32 ret = 2;</code>
     */
    public Builder setRet(int value) {
      
      ret_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 ret = 2;</code>
     */
    public Builder clearRet() {
      
      ret_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString result_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes result = 3;</code>
     */
    public com.google.protobuf.ByteString getResult() {
      return result_;
    }
    /**
     * <code>bytes result = 3;</code>
     */
    public Builder setResult(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      result_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes result = 3;</code>
     */
    public Builder clearResult() {
      
      result_ = getDefaultInstance().getResult();
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:RpcResponse)
  }

  // @@protoc_insertion_point(class_scope:RpcResponse)
  private static final org.ek.hedgehog.core.proto.RpcResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.ek.hedgehog.core.proto.RpcResponse();
  }

  public static org.ek.hedgehog.core.proto.RpcResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RpcResponse>
      PARSER = new com.google.protobuf.AbstractParser<RpcResponse>() {
    @java.lang.Override
    public RpcResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RpcResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RpcResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RpcResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.ek.hedgehog.core.proto.RpcResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
