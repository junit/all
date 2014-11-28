using ClientDemon.message;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClientDemon.logic.role.message
{
    public class ResRoleCreateMessage : Message
    {
		//角色
		private RoleInfo role;
		
        public override int getId()
        {
            return 101202;;
        }
        
        /**
		 * 写入字节缓存
		 */
		public override void write(ByteBuf buf){
			//角色
			writeRoleInfo(buf, this.role);
		}
		
		/**
		 * 读取字节缓存
		 */
		public override void read(ByteBuf buf){
			//角色
			this.role = readRoleInfo(buf);
		}

		public RoleInfo Role
        {
            get { return role; }
            set { role = value; }
        }
        
    }
}
