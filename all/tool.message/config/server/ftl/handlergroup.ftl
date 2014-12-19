package message;

import com.google.inject.Singleton;
import event.GameEventHandler;
import io.netty.channel.ChannelHandlerContext;
import logic.account.Account;

import java.util.HashMap;

@Singleton
public class MessageHandlerGroup {
	@SuppressWarnings("rawtypes")
	private HashMap<Integer, GameEventHandler> handlers = new HashMap<>();

	@SuppressWarnings("unchecked")
	public GameEventHandler<ChannelHandlerContext, Message> getCtxHandler(int id) {
		return handlers.get(id);
	}

	@SuppressWarnings("unchecked")
	public GameEventHandler<Account, Message> getAccountHandler(int id) {
		return handlers.get(id);
	}
	
	public MessageHandlerGroup() {<#list details as detail>
		handlers.put(${detail.id?c}, new logic.${detail.pkg}.handler.${detail.name}Handler());</#list>
	}
}
