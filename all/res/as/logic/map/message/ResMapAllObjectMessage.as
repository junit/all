using ClientDemon.message;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClientDemon.logic.map.message
{
    public class ResMapAllObjectMessage : Message
    {
		//地图
		private Int map;
		//线
		private Int line;
		//角色信息
		private List<MapRoleInfo> roles = new ArrayList<>();
		
        public override int getId()
        {
            return 102201;;
        }
        
        /**
		 * 写入字节缓存
		 */
		public override void write(ByteBuf buf){
			//地图
			writeInt(buf, this.map);
			//线
			writeInt(buf, this.line);
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
			//地图
			this.map = readInt(buf);
			//线
			this.line = readInt(buf);
			//角色信息
			int roles_length = readShort(buf);
			for (int i = 0; i < roles_length; i++) {
				roles.add(readMapRoleInfo(buf));
			}
		}

		public Int Map
        {
            get { return map; }
            set { map = value; }
        }
        
		public Int Line
        {
            get { return line; }
            set { line = value; }
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
