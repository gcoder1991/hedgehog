import com.ek.hedgehog.core.proto.BasicTransform;
import com.ek.hedgehog.core.proto.MessageType;
import org.ek.hedgehog.network.DefaultChannelInitializer;
import org.ek.hedgehog.network.FiberHandler;
import org.ek.hedgehog.network.NettyTcpClient;
import org.ek.hedgehog.network.NettyTcpServer;

import java.net.InetSocketAddress;

public class T {
    public static void main(String[] args) {
        NettyTcpServer server = new NettyTcpServer();
        server.localAddress(new InetSocketAddress(1024))
                .initChannelInitializer(new DefaultChannelInitializer(new FiberHandler()))
                .start().thenRun(() -> {
            NettyTcpClient client = new NettyTcpClient();
            client.remoteAddress(new InetSocketAddress("127.0.0.1",1024))
                    .initChannelInitializer(new DefaultChannelInitializer(new FiberHandler()))
                    .connect().thenRun(()->{
                for (int i = 0; i < 4; i++) {
                    client.getChannel().writeAndFlush(BasicTransform.newBuilder().setType(MessageType.HEARTBEAT).build());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        });
    }
}
