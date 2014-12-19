package logic.${pkg}.handler;

import event.GameEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import logic.${pkg}.message.${name}Message;

<#if owner==1>
import io.netty.channel.ChannelHandlerContext;

public class ${name}Handler implements GameEventHandler<ChannelHandlerContext, ${name}Message> {
	@Override
	public void onEvent(ChannelHandlerContext owner, ${name}Message event) {
<#else>
import logic.account.Account;

public class ${name}Handler implements GameEventHandler<Account, ${name}Message> {
	@Override
	public void onEvent(Account owner, ${name}Message event) {
</#if>
		try {
			// TODO 事件处理
		} catch (Exception e) {
			logger.error("", e);
		}
	}
	
	private final static Logger logger = LoggerFactory.getLogger(${name}Handler.class);
}
