import org.ek.hedgehog.core.proto.BasicTransform;
import org.ek.hedgehog.handler.FiberHandler;
import org.ek.hedgehog.network.DefaultChannelInitializer;
import org.ek.hedgehog.network.NettyTcpClient;
import org.ek.hedgehog.network.NettyTcpServer;
import org.junit.Test;

import java.net.InetSocketAddress;

public class TcpTest {

    @Test
    public void t() {
        NettyTcpServer server = new NettyTcpServer();
        server.localAddress(new InetSocketAddress(1024))
                .initChannelInitializer(new DefaultChannelInitializer(new FiberHandler()))
                .start().thenRun(() -> {
            NettyTcpClient client = new NettyTcpClient();
            client.remoteAddress(new InetSocketAddress("127.0.0.1",1024))
                    .initChannelInitializer(new DefaultChannelInitializer(new FiberHandler()))
                    .connect().thenRun(()->{
                for (int i = 0; i < 4; i++) {

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
