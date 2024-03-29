// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: core.proto

package org.ek.hedgehog.core.proto;

/**
 * Protobuf type {@code RpcRequest}
 */
public  final class RpcRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:RpcRequest)
    RpcRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RpcRequest.newBuilder() to construct.
  private RpcRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RpcRequest() {
    className_ = "";
    methodName_ = "";
    parms_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new RpcRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RpcRequest(
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
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            className_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            methodName_ = s;
            break;
          }
          case 34: {

            parms_ = input.readBytes();
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
    return org.ek.hedgehog.core.proto.Core.internal_static_RpcRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.ek.hedgehog.core.proto.Core.internal_static_RpcRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.ek.hedgehog.core.proto.RpcRequest.class, org.ek.hedgehog.core.proto.RpcRequest.Builder.class);
  }

  public static final int RID_FIELD_NUMBER = 1;
  private long rid_;
  /**
   * <code>int64 rid = 1;</code>
   */
  public long getRid() {
    return rid_;
  }

  public static final int CLASSNAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object className_;
  /**
   * <code>string className = 2;</code>
   */
  public java.lang.String getClassName() {
    java.lang.Object ref = className_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      className_ = s;
      return s;
    }
  }
  /**
   * <code>string className = 2;</code>
   */
  public com.google.protobuf.ByteString
      getClassNameBytes() {
    java.lang.Object ref = className_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      className_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int METHODNAME_FIELD_NUMBER = 3;
  private volatile java.lang.Object methodName_;
  /**
   * <code>string methodName = 3;</code>
   */
  public java.lang.String getMethodName() {
    java.lang.Object ref = methodName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      methodName_ = s;
      return s;
    }
  }
  /**
   * <code>string methodName = 3;</code>
   */
  public com.google.protobuf.ByteString
      getMethodNameBytes() {
    java.lang.Object ref = methodName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      methodName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PARMS_FIELD_NUMBER = 4;
  private com.google.protobuf.ByteString parms_;
  /**
   * <code>bytes parms = 4;</code>
   */
  public com.google.protobuf.ByteString getParms() {
    return parms_;
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
    if (!getClassNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, className_);
    }
    if (!getMethodNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, methodName_);
    }
    if (!parms_.isEmpty()) {
      output.writeBytes(4, parms_);
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
    if (!getClassNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, className_);
    }
    if (!getMethodNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, methodName_);
    }
    if (!parms_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(4, parms_);
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
    if (!(obj instanceof org.ek.hedgehog.core.proto.RpcRequest)) {
      return super.equals(obj);
    }
    org.ek.hedgehog.core.proto.RpcRequest other = (org.ek.hedgehog.core.proto.RpcRequest) obj;

    if (getRid()
        != other.getRid()) return false;
    if (!getClassName()
        .equals(other.getClassName())) return false;
    if (!getMethodName()
        .equals(other.getMethodName())) return false;
    if (!getParms()
        .equals(other.getParms())) return false;
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
    hash = (37 * hash) + CLASSNAME_FIELD_NUMBER;
    hash = (53 * hash) + getClassName().hashCode();
    hash = (37 * hash) + METHODNAME_FIELD_NUMBER;
    hash = (53 * hash) + getMethodName().hashCode();
    hash = (37 * hash) + PARMS_FIELD_NUMBER;
    hash = (53 * hash) + getParms().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.ek.hedgehog.core.proto.RpcRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ek.hedgehog.core.proto.RpcRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ek.hedgehog.core.proto.RpcRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ek.hedgehog.core.proto.RpcRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ek.hedgehog.core.proto.RpcRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ek.hedgehog.core.proto.RpcRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ek.hedgehog.core.proto.RpcRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ek.hedgehog.core.proto.RpcRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ek.hedgehog.core.proto.RpcRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.ek.hedgehog.core.proto.RpcRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ek.hedgehog.core.proto.RpcRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ek.hedgehog.core.proto.RpcRequest parseFrom(
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
  public static Builder newBuilder(org.ek.hedgehog.core.proto.RpcRequest prototype) {
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
   * Protobuf type {@code RpcRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:RpcRequest)
      org.ek.hedgehog.core.proto.RpcRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.ek.hedgehog.core.proto.Core.internal_static_RpcRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.ek.hedgehog.core.proto.Core.internal_static_RpcRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.ek.hedgehog.core.proto.RpcRequest.class, org.ek.hedgehog.core.proto.RpcRequest.Builder.class);
    }

    // Construct using org.ek.hedgehog.core.proto.RpcRequest.newBuilder()
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

      className_ = "";

      methodName_ = "";

      parms_ = com.google.protobuf.ByteString.EMPTY;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.ek.hedgehog.core.proto.Core.internal_static_RpcRequest_descriptor;
    }

    @java.lang.Override
    public org.ek.hedgehog.core.proto.RpcRequest getDefaultInstanceForType() {
      return org.ek.hedgehog.core.proto.RpcRequest.getDefaultInstance();
    }

    @java.lang.Override
    public org.ek.hedgehog.core.proto.RpcRequest build() {
      org.ek.hedgehog.core.proto.RpcRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.ek.hedgehog.core.proto.RpcRequest buildPartial() {
      org.ek.hedgehog.core.proto.RpcRequest result = new org.ek.hedgehog.core.proto.RpcRequest(this);
      result.rid_ = rid_;
      result.className_ = className_;
      result.methodName_ = methodName_;
      result.parms_ = parms_;
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
      if (other instanceof org.ek.hedgehog.core.proto.RpcRequest) {
        return mergeFrom((org.ek.hedgehog.core.proto.RpcRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.ek.hedgehog.core.proto.RpcRequest other) {
      if (other == org.ek.hedgehog.core.proto.RpcRequest.getDefaultInstance()) return this;
      if (other.getRid() != 0L) {
        setRid(other.getRid());
      }
      if (!other.getClassName().isEmpty()) {
        className_ = other.className_;
        onChanged();
      }
      if (!other.getMethodName().isEmpty()) {
        methodName_ = other.methodName_;
        onChanged();
      }
      if (other.getParms() != com.google.protobuf.ByteString.EMPTY) {
        setParms(other.getParms());
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
      org.ek.hedgehog.core.proto.RpcRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.ek.hedgehog.core.proto.RpcRequest) e.getUnfinishedMessage();
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

    private java.lang.Object className_ = "";
    /**
     * <code>string className = 2;</code>
     */
    public java.lang.String getClassName() {
      java.lang.Object ref = className_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        className_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string className = 2;</code>
     */
    public com.google.protobuf.ByteString
        getClassNameBytes() {
      java.lang.Object ref = className_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        className_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string className = 2;</code>
     */
    public Builder setClassName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      className_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string className = 2;</code>
     */
    public Builder clearClassName() {
      
      className_ = getDefaultInstance().getClassName();
      onChanged();
      return this;
    }
    /**
     * <code>string className = 2;</code>
     */
    public Builder setClassNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      className_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object methodName_ = "";
    /**
     * <code>string methodName = 3;</code>
     */
    public java.lang.String getMethodName() {
      java.lang.Object ref = methodName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        methodName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string methodName = 3;</code>
     */
    public com.google.protobuf.ByteString
        getMethodNameBytes() {
      java.lang.Object ref = methodName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        methodName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string methodName = 3;</code>
     */
    public Builder setMethodName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      methodName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string methodName = 3;</code>
     */
    public Builder clearMethodName() {
      
      methodName_ = getDefaultInstance().getMethodName();
      onChanged();
      return this;
    }
    /**
     * <code>string methodName = 3;</code>
     */
    public Builder setMethodNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      methodName_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString parms_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes parms = 4;</code>
     */
    public com.google.protobuf.ByteString getParms() {
      return parms_;
    }
    /**
     * <code>bytes parms = 4;</code>
     */
    public Builder setParms(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      parms_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes parms = 4;</code>
     */
    public Builder clearParms() {
      
      parms_ = getDefaultInstance().getParms();
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


    // @@protoc_insertion_point(builder_scope:RpcRequest)
  }

  // @@protoc_insertion_point(class_scope:RpcRequest)
  private static final org.ek.hedgehog.core.proto.RpcRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.ek.hedgehog.core.proto.RpcRequest();
  }

  public static org.ek.hedgehog.core.proto.RpcRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RpcRequest>
      PARSER = new com.google.protobuf.AbstractParser<RpcRequest>() {
    @java.lang.Override
    public RpcRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RpcRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RpcRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RpcRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.ek.hedgehog.core.proto.RpcRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

