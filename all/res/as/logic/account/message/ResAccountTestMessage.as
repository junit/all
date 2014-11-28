using ClientDemon.message;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClientDemon.logic.account.message
{
    public class ResAccountTestMessage : Message
    {
		//time
		private Int time;
		//字符串
		private String str;
		
        public override int getId()
        {
            return 100202;;
        }
        
        /**
		 * 写入字节缓存
		 */
		public override void write(ByteBuf buf){
			//time
			writeInt(buf, this.time);
			//字符串
			writeString(buf, this.str);
		}
		
		/**
		 * 读取字节缓存
		 */
		public override void read(ByteBuf buf){
			//time
			this.time = readInt(buf);
			//字符串
			this.str = readString(buf);
		}

		public Int Time
        {
            get { return time; }
            set { time = value; }
        }
        
		public String Str
        {
            get { return str; }
            set { str = value; }
        }
        
    }
}
