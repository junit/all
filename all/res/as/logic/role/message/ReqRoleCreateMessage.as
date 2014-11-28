using ClientDemon.message;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClientDemon.logic.role.message
{
    public class ReqRoleCreateMessage : Message
    {
		//角色名
		private String name;
		//性别
		private Int sex;
		
        public override int getId()
        {
            return 101101;;
        }
        
        /**
		 * 写入字节缓存
		 */
		public override void write(ByteBuf buf){
			//角色名
			writeString(buf, this.name);
			//性别
			writeInt(buf, this.sex);
		}
		
		/**
		 * 读取字节缓存
		 */
		public override void read(ByteBuf buf){
			//角色名
			this.name = readString(buf);
			//性别
			this.sex = readInt(buf);
		}

		public String Name
        {
            get { return name; }
            set { name = value; }
        }
        
		public Int Sex
        {
            get { return sex; }
            set { sex = value; }
        }
        
    }
}
