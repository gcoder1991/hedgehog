package org.ek.hedgehog.network;

import com.ek.hedgehog.core.proto.BasicTransform;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ServerChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class DefaultChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Setter
    private ChannelHandler handler;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ch.pipeline()
                .addLast("frameDecoder", new ProtobufVarint32FrameDecoder())
                .addLast("protobufDecoder", new ProtobufDecoder(BasicTransform.getDefaultInstance()))
                .addLast("frameEncoder", new ProtobufVarint32LengthFieldPrepender())
                .addLast("protobufEncoder", new ProtobufEncoder())
                .addLast("handler", handler);
    }

}
