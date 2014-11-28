using ClientDemon.message;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClientDemon.logic.account.message
{
    public class ReqAccountLoginMessage : Message
    {
		//帐号名称
		private String accountName;
		//平台
		private Int platform;
		//服务器
		private Int server;
		//验证key/密码
		private String check;
		
        public override int getId()
        {
            return 100101;;
        }
        
        /**
		 * 写入字节缓存
		 */
		public override void write(ByteBuf buf){
			//帐号名称
			writeString(buf, this.accountName);
			//平台
			writeInt(buf, this.platform);
			//服务器
			writeInt(buf, this.server);
			//验证key/密码
			writeString(buf, this.check);
		}
		
		/**
		 * 读取字节缓存
		 */
		public override void read(ByteBuf buf){
			//帐号名称
			this.accountName = readString(buf);
			//平台
			this.platform = readInt(buf);
			//服务器
			this.server = readInt(buf);
			//验证key/密码
			this.check = readString(buf);
		}

		public String AccountName
        {
            get { return accountName; }
            set { accountName = value; }
        }
        
		public Int Platform
        {
            get { return platform; }
            set { platform = value; }
        }
        
		public Int Server
        {
            get { return server; }
            set { server = value; }
        }
        
		public String Check
        {
            get { return check; }
            set { check = value; }
        }
        
    }
}
