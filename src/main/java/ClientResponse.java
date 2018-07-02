import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class ClientResponse extends SimpleChannelInboundHandler<ByteBuf> {

	/**
	 * 从服务器接收到数据后调用
	 */
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
		System.out.println("Client received" + ByteBufUtil.hexDump(msg.readBytes(msg.readableBytes())));

	}

	@Override

	/**
	 * 客户端连接服务器后被调用
	 */
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ctx.write(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));
		System.out.println("aa");
	}

	/**
	 * 发生异常时被调用
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
	
	 @Override
	    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
	        System.out.println("连接关闭! ");
	        super.channelInactive(ctx);
	    }
}
