package org.ek.hedgehog.handler;

import co.paralleluniverse.actors.Actor;
import co.paralleluniverse.actors.ActorRef;
import co.paralleluniverse.actors.MailboxConfig;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.channels.Channels;
import com.ek.hedgehog.core.proto.BasicTransform;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.ek.hedgehog.network.ActorProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FiberHandler extends SimpleChannelInboundHandler<BasicTransform> {

    private static final Logger LOG = LoggerFactory.getLogger(FiberHandler.class);

    private ActorRef<ActorProtocol<BasicTransform>> actorRef;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MailboxConfig mc = new MailboxConfig(128, Channels.OverflowPolicy.THROW);
        actorRef = new Actor<ActorProtocol<BasicTransform>, Void>(ctx.channel().id().asLongText(), mc) {

            private Channel nettyChannel() {
                return ctx.channel();
            }

            @Override
            protected Void doRun() throws InterruptedException, SuspendExecution {
                for (;;) {
                     ActorProtocol<BasicTransform> protocol = receive();
                    if (protocol.getOption() == ActorProtocol.Option.EXIT) {

                        break;
                    }
                    switch (protocol.getOption()) {
                        case MESSAGE:
                            System.out.println(protocol.getOption());
                            break;
                    }
                }
                return null;
            }
        }.register().spawn();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        actorRef.send(new ActorProtocol<>(ActorProtocol.Option.EXIT));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        actorRef.send(new ActorProtocol<>(cause));
        ctx.channel().close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, BasicTransform msg) throws Exception {
        actorRef.send(new ActorProtocol<>(msg));
    }
}
