package two.client;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * 代码清单 2-3 客户端的 ChannelHandler
 *
 * @author <a href="mailto:norman.maurer@gmail.com">Norman Maurer</a>
 */
@Sharable
//标记该类的实例可以被多个 Channel 共享
public class EchoClientHandler
    extends SimpleChannelInboundHandler<ByteBuf> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        //当被通知 Channel是活跃的时候，发送一条消息
    	    ctx.writeAndFlush(Unpooled.copiedBuffer("水电费健康是的房间看电视了附近考虑的时间考虑的实际付款了时间看房了圣诞节疯狂老师讲课了附近的开始了附近的卢卡斯荆防颗粒打手机疯狂拉升荆防颗粒；阿胶颗粒；按揭付款了；按揭付款了；大家是否考虑；就打死了；快放假快乐大；实际付款方法发大水大书法家搜附近ad搜if阿萨德大师傅",
                    CharsetUtil.UTF_8));
    
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, ByteBuf in) {
        //记录已接收消息的转储
        System.out.println(
                "Client received: " + in.toString(CharsetUtil.UTF_8));
    }

    @Override
    //在发生异常时，记录错误并关闭Channel
    public void exceptionCaught(ChannelHandlerContext ctx,
        Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
