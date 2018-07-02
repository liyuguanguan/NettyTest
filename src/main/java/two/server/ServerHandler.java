package two.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler extends ChannelInboundHandlerAdapter{
	
	
		/**
		 * 读取消息
		 */
	  	@Override
	    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
	  		System.out.println("接受消息");
	        ctx.fireChannelRead(msg);
	    }
	  	
	  	
	  	/**
	  	 * 连接时候调用
	  	 */
	    @Override
	    public void channelActive(ChannelHandlerContext ctx) throws Exception {
	    	System.out.println("连接");
	        ctx.fireChannelActive();
	    }
	    
	    
	    /**
	     * 异常打印
	     */
	    @Override
	    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
	            throws Exception {
	    	System.out.println("打印异常");
	        ctx.fireExceptionCaught(cause);
	    }

}
