package logic.${pkg}.handler{

	import logic.${pkg}.message.${name}Message;
	import net.Handler;

	public class ${name}Handler extends Handler {
	
		public override function action(): void{
			var msg: ${name}Message = ${name}Message(this.message);
			//TODO 添加消息处理
		}
	}
}