using ClientDemon.message;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClientDemon.logic.account.message
{
    public class ResAccountLoginFailedMessage : Message
    {
		//错误代码
		private Int err;
		
        public override int getId()
        {
            return 100201;;
        }
        
        /**
		 * 写入字节缓存
		 */
		public override void write(ByteBuf buf){
			//错误代码
			writeInt(buf, this.err);
		}
		
		/**
		 * 读取字节缓存
		 */
		public override void read(ByteBuf buf){
			//错误代码
			this.err = readInt(buf);
		}

		public Int Err
        {
            get { return err; }
            set { err = value; }
        }
        
    }
}
