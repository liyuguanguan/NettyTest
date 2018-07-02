package two.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class EchoServerHandler extends ChannelInboundHandlerAdapter{
	
		/**
		 * 读消息
		 */
	  	@Override
	    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
	  		System.out.println("读消息");
	    }
	  	
	    @Override
	    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
	    	System.out.println("注册连接");
	    }
	    
	    /**
	     * 取消注册
	     */
	    @Override
	    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
	        System.out.println("取消注册");
	    }
	    
	    /**
	     * 
	     */
	    @Override
	    public void channelActive(ChannelHandlerContext ctx) throws Exception {
	       System.out.println("连接激活");
	    }
	    
	    
	    @Override
	    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
	    	 System.out.println("检测到连接断开");
	    }
	
	    @Override
	    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
	        System.out.println("读取完成");
	    }

}
