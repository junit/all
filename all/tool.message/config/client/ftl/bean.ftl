using ClientDemon.message;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClientDemon.logic.${pkg}
{
    public class ${name} : Message
    {
    	<#list fields as field>
		<#if field.listFlag==1>
		//${field.note}
		private List<${field.clazz?cap_first}> ${field.name} = new ArrayList<>();
		<#else>
		//${field.note}
		private ${field.clazz} ${field.name};
		
		</#if>
		</#list>
        private string accountName;
        private int platform;
        private int server;
        private string check;
        
        public override int getId()
        {
            return 100101;
        }

        public override void read(ByteBuf stream)
        {
            accountName = ByteBufUtil.readString(stream);
            platform = ByteBufUtil.readInt(stream);
            server = ByteBufUtil.readInt(stream);
            check = ByteBufUtil.readString(stream);
        }

        public override void write(ByteBuf stream)
        {
            ByteBufUtil.writeString(stream, accountName);
            ByteBufUtil.writeInt(stream, platform);
            ByteBufUtil.writeInt(stream, server);
            ByteBufUtil.writeString(stream, check);
        }

        public string Check
        {
            get { return check; }
            set { check = value; }
        }
        public int Server
        {
            get { return server; }
            set { server = value; }
        }
        public string AccountName
        {
            get { return accountName; }
            set { accountName = value; }
        }
        public int Platform
        {
            get { return platform; }
            set { platform = value; }
        }
    }
}