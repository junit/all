using ClientDemon.message;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClientDemon.logic.map.message
{
    public class ResMapRoleMessage : Message
    {
		//角色信息
		private List<MapRoleInfo> roles = new ArrayList<>();
		
        public override int getId()
        {
            return 102202;;
        }
        
        /**
		 * 写入字节缓存
		 */
		public override void write(ByteBuf buf){
			//角色信息
			writeShort(buf, (short)roles.size());
			for (int i = 0; i < roles.size(); i++) {
				writeMapRoleInfo(buf, this.roles);
			}
		}
		
		/**
		 * 读取字节缓存
		 */
		public override void read(ByteBuf buf){
			//角色信息
			int roles_length = readShort(buf);
			for (int i = 0; i < roles_length; i++) {
				roles.add(readMapRoleInfo(buf));
			}
		}

		/**
		 * get 角色信息
		 * @return 
		 */
		public List<MapRoleInfo> getRoles(){
			return roles;
		}
		
		/**
		 * set 角色信息
		 */
		public void setRoles(List<MapRoleInfo> roles){
			this.roles = roles;
		}
		
    }
}
