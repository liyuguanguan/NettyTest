import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {

	public  void client() throws Exception {
		EventLoopGroup group = new NioEventLoopGroup();
		  try {
			    Bootstrap b = new Bootstrap();
			  b.group(group).channel(NioSocketChannel.class).remoteAddress(new InetSocketAddress("127.0.0.1", 65535))
			 .handler(new ChannelInitializer<SocketChannel>() {
			   @Override
			  protected void initChannel(SocketChannel ch) throws Exception {
			  ch.pipeline().addLast(new ClientResponse());
			 }
			   });
			 ChannelFuture f = b.connect().sync();
			  f.channel().closeFuture().sync();
			    } finally {
			  group.shutdownGracefully().sync();
			 }
	}

	public static void main(String[] args) throws Exception {
		new NettyClient().client();

	}

}
