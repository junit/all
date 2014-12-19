package net {
	import flash.utils.Dictionary;<#list details as detail>
	import logic.${detail.pkg}.message.${detail.name}Message;
	import logic.${detail.pkg}.handler.${detail.name}Handler;</#list>

	/** 
	 * @author Commuication Auto Maker
	 * 
	 * @version 1.0.0
	 * 
	 * 引用类列表
	 */
	public class MessagePool {
		//消息类字典
		private var messages:Dictionary = new Dictionary();
		//处理类字典
		private var handlers:Dictionary = new Dictionary();
		
		public function MessagePool(){<#list details as detail>
			register(${detail.id?c}, ${detail.name}Message, ${detail.name}Handler);</#list>
		}
		
		private function register(id: int, messageClass: Class, handlerClass: Class): void{
			messages[id] = messageClass;
			handlers[id] = handlerClass;
		}
		
		public function getMessage(id: int) : Message{
			if(messages[id] == null) return null;
			else return new messages[id] as Message;
		}
		
		public function getHandler(id: int) : Handler{
			if(handlers[id] == null) return null;
			else return new handlers[id] as Handler;
		}
	}
}