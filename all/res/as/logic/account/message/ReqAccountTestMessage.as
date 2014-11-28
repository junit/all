using ClientDemon.message;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClientDemon.logic.account.message
{
    public class ReqAccountTestMessage : Message
    {
		//字符串
		private String str;
		//time
		private Int time;
		
        public override int getId()
        {
            return 100102;;
        }
        
        /**
		 * 写入字节缓存
		 */
		public override void write(ByteBuf buf){
			//字符串
			writeString(buf, this.str);
			//time
			writeInt(buf, this.time);
		}
		
		/**
		 * 读取字节缓存
		 */
		public override void read(ByteBuf buf){
			//字符串
			this.str = readString(buf);
			//time
			this.time = readInt(buf);
		}

		public String Str
        {
            get { return str; }
            set { str = value; }
        }
        
		public Int Time
        {
            get { return time; }
            set { time = value; }
        }
        
    }
}
