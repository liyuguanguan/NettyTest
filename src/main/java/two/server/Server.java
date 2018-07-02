package two.server;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server {
	
	int port;
	
	public Server(int port) {
		this.port = port;
	}
	
	public void server() throws InterruptedException {
		
		ServerBootstrap bootstrap = new ServerBootstrap();
		
		EventLoopGroup group  = new NioEventLoopGroup();
		try {
		bootstrap.group(group)
				 .channel(NioServerSocketChannel.class)
				 .localAddress(new InetSocketAddress(port))
				 .childHandler(new ChannelInitializer<SocketChannel>() {

					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						ch.pipeline().addLast(new ServerHandler());
						
					}
				});
		
			ChannelFuture  channelFuture = bootstrap.bind().sync();
			System.out.println(getClass()+""+channelFuture.channel().localAddress());
			channelFuture.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			group.shutdownGracefully().sync();
		}
				 
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		new Server(8111).server();
	}

}
