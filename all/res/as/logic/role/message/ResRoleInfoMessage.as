using ClientDemon.message;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClientDemon.logic.role.message
{
    public class ResRoleInfoMessage : Message
    {
		//角色列表
		private List<RoleInfo> roles = new ArrayList<>();
		
        public override int getId()
        {
            return 101201;;
        }
        
        /**
		 * 写入字节缓存
		 */
		public override void write(ByteBuf buf){
			//角色列表
			writeShort(buf, (short)roles.size());
			for (int i = 0; i < roles.size(); i++) {
				writeRoleInfo(buf, this.roles);
			}
		}
		
		/**
		 * 读取字节缓存
		 */
		public override void read(ByteBuf buf){
			//角色列表
			int roles_length = readShort(buf);
			for (int i = 0; i < roles_length; i++) {
				roles.add(readRoleInfo(buf));
			}
		}

		/**
		 * get 角色列表
		 * @return 
		 */
		public List<RoleInfo> getRoles(){
			return roles;
		}
		
		/**
		 * set 角色列表
		 */
		public void setRoles(List<RoleInfo> roles){
			this.roles = roles;
		}
		
    }
}
