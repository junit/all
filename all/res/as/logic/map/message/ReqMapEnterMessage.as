using ClientDemon.message;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClientDemon.logic.map.message
{
    public class ReqMapEnterMessage : Message
    {
		//角色id
		private Int role;
		
        public override int getId()
        {
            return 102101;;
        }
        
        /**
		 * 写入字节缓存
		 */
		public override void write(ByteBuf buf){
			//角色id
			writeInt(buf, this.role);
		}
		
		/**
		 * 读取字节缓存
		 */
		public override void read(ByteBuf buf){
			//角色id
			this.role = readInt(buf);
		}

		public Int Role
        {
            get { return role; }
            set { role = value; }
        }
        
    }
}
