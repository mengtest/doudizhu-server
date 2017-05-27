// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Role.proto

package com.randioo.doudizhu_server.protocol;

public final class Role {
  private Role() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public static final class RoleRenameRequest extends
      com.google.protobuf.GeneratedMessage {
    // Use RoleRenameRequest.newBuilder() to construct.
    private RoleRenameRequest() {
      initFields();
    }
    private RoleRenameRequest(boolean noInit) {}
    
    private static final RoleRenameRequest defaultInstance;
    public static RoleRenameRequest getDefaultInstance() {
      return defaultInstance;
    }
    
    public RoleRenameRequest getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.randioo.doudizhu_server.protocol.Role.internal_static_com_randioo_doudizhu_server_protocol_RoleRenameRequest_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.randioo.doudizhu_server.protocol.Role.internal_static_com_randioo_doudizhu_server_protocol_RoleRenameRequest_fieldAccessorTable;
    }
    
    // optional string name = 1;
    public static final int NAME_FIELD_NUMBER = 1;
    private boolean hasName;
    private java.lang.String name_ = "";
    public boolean hasName() { return hasName; }
    public java.lang.String getName() { return name_; }
    
    private void initFields() {
    }
    public final boolean isInitialized() {
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (hasName()) {
        output.writeString(1, getName());
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (hasName()) {
        size += com.google.protobuf.CodedOutputStream
          .computeStringSize(1, getName());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    public static com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> {
      private com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest result;
      
      // Construct using com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest();
        return builder;
      }
      
      protected com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest.getDescriptor();
      }
      
      public com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest getDefaultInstanceForType() {
        return com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest) {
          return mergeFrom((com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest other) {
        if (other == com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest.getDefaultInstance()) return this;
        if (other.hasName()) {
          setName(other.getName());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                return this;
              }
              break;
            }
            case 10: {
              setName(input.readString());
              break;
            }
          }
        }
      }
      
      
      // optional string name = 1;
      public boolean hasName() {
        return result.hasName();
      }
      public java.lang.String getName() {
        return result.getName();
      }
      public Builder setName(java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.hasName = true;
        result.name_ = value;
        return this;
      }
      public Builder clearName() {
        result.hasName = false;
        result.name_ = getDefaultInstance().getName();
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:com.randioo.doudizhu_server.protocol.RoleRenameRequest)
    }
    
    static {
      defaultInstance = new RoleRenameRequest(true);
      com.randioo.doudizhu_server.protocol.Role.internalForceInit();
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:com.randioo.doudizhu_server.protocol.RoleRenameRequest)
  }
  
  public static final class RoleRenameResponse extends
      com.google.protobuf.GeneratedMessage {
    // Use RoleRenameResponse.newBuilder() to construct.
    private RoleRenameResponse() {
      initFields();
    }
    private RoleRenameResponse(boolean noInit) {}
    
    private static final RoleRenameResponse defaultInstance;
    public static RoleRenameResponse getDefaultInstance() {
      return defaultInstance;
    }
    
    public RoleRenameResponse getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.randioo.doudizhu_server.protocol.Role.internal_static_com_randioo_doudizhu_server_protocol_RoleRenameResponse_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.randioo.doudizhu_server.protocol.Role.internal_static_com_randioo_doudizhu_server_protocol_RoleRenameResponse_fieldAccessorTable;
    }
    
    // optional int32 errorCode = 1 [default = 1];
    public static final int ERRORCODE_FIELD_NUMBER = 1;
    private boolean hasErrorCode;
    private int errorCode_ = 1;
    public boolean hasErrorCode() { return hasErrorCode; }
    public int getErrorCode() { return errorCode_; }
    
    private void initFields() {
    }
    public final boolean isInitialized() {
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (hasErrorCode()) {
        output.writeInt32(1, getErrorCode());
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (hasErrorCode()) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, getErrorCode());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    public static com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> {
      private com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse result;
      
      // Construct using com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse();
        return builder;
      }
      
      protected com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse.getDescriptor();
      }
      
      public com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse getDefaultInstanceForType() {
        return com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse) {
          return mergeFrom((com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse other) {
        if (other == com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse.getDefaultInstance()) return this;
        if (other.hasErrorCode()) {
          setErrorCode(other.getErrorCode());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                return this;
              }
              break;
            }
            case 8: {
              setErrorCode(input.readInt32());
              break;
            }
          }
        }
      }
      
      
      // optional int32 errorCode = 1 [default = 1];
      public boolean hasErrorCode() {
        return result.hasErrorCode();
      }
      public int getErrorCode() {
        return result.getErrorCode();
      }
      public Builder setErrorCode(int value) {
        result.hasErrorCode = true;
        result.errorCode_ = value;
        return this;
      }
      public Builder clearErrorCode() {
        result.hasErrorCode = false;
        result.errorCode_ = 1;
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:com.randioo.doudizhu_server.protocol.RoleRenameResponse)
    }
    
    static {
      defaultInstance = new RoleRenameResponse(true);
      com.randioo.doudizhu_server.protocol.Role.internalForceInit();
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:com.randioo.doudizhu_server.protocol.RoleRenameResponse)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_com_randioo_doudizhu_server_protocol_RoleRenameRequest_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_randioo_doudizhu_server_protocol_RoleRenameRequest_fieldAccessorTable;
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_com_randioo_doudizhu_server_protocol_RoleRenameResponse_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_randioo_doudizhu_server_protocol_RoleRenameResponse_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nRole.proto\022$com.randioo.doudizhu_serve" +
      "r.protocol\"!\n\021RoleRenameRequest\022\014\n\004name\030" +
      "\001 \001(\t\"*\n\022RoleRenameResponse\022\024\n\terrorCode" +
      "\030\001 \001(\005:\0011"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_com_randioo_doudizhu_server_protocol_RoleRenameRequest_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_com_randioo_doudizhu_server_protocol_RoleRenameRequest_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_com_randioo_doudizhu_server_protocol_RoleRenameRequest_descriptor,
              new java.lang.String[] { "Name", },
              com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest.class,
              com.randioo.doudizhu_server.protocol.Role.RoleRenameRequest.Builder.class);
          internal_static_com_randioo_doudizhu_server_protocol_RoleRenameResponse_descriptor =
            getDescriptor().getMessageTypes().get(1);
          internal_static_com_randioo_doudizhu_server_protocol_RoleRenameResponse_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_com_randioo_doudizhu_server_protocol_RoleRenameResponse_descriptor,
              new java.lang.String[] { "ErrorCode", },
              com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse.class,
              com.randioo.doudizhu_server.protocol.Role.RoleRenameResponse.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
  
  public static void internalForceInit() {}
  
  // @@protoc_insertion_point(outer_class_scope)
}
