using ClientDemon.message;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClientDemon.logic.${pkg}.message
{
    public class ${name}Message : Message
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
		
        public override int getId()
        {
            return ${id?c};;
        }
        
        /**
		 * 写入字节缓存
		 */
		public override void write(ByteBuf buf){
			<#list fields as field>
			<#if field.listFlag==1>
			//${field.note}
			writeShort(buf, (short)${field.name}.size());
			for (int i = 0; i < ${field.name}.size(); i++) {
				<#if field.clazz?index_of(".")==-1>
				write${field.clazz?cap_first}(buf, this.${field.name});
				<#else>
				write(buf, ${field.name}.get(i));
				</#if>
			}
			<#else>
			//${field.note}
			<#if field.clazz?index_of(".")==-1>
			write${field.clazz?cap_first}(buf, this.${field.name});
			<#else>
			write(buf, this.${field.name});
			</#if>
			</#if>
			</#list>
		}
		
		/**
		 * 读取字节缓存
		 */
		public override void read(ByteBuf buf){
			<#list fields as field>
			<#if field.listFlag==1>
			//${field.note}
			int ${field.name}_length = readShort(buf);
			for (int i = 0; i < ${field.name}_length; i++) {
				<#if field.clazz?index_of(".")==-1>
				${field.name}.add(read${field.clazz?cap_first}(buf));
				<#else>
				${field.name}.add(read(buf));
				</#if>
			}
			<#else>
			//${field.note}
			<#if field.clazz?index_of(".")==-1>
			this.${field.name} = read${field.clazz?cap_first}(buf);
			<#else>
			this.${field.name} = (${field.clazz})read(buf);
			</#if>
			</#if>
			</#list>
		}

        <#list fields as field>
		<#if field.listFlag==1>
		/**
		 * get ${field.note}
		 * @return 
		 */
		public List<${field.clazz?cap_first}> get${field.name?cap_first}(){
			return ${field.name};
		}
		
		/**
		 * set ${field.note}
		 */
		public void set${field.name?cap_first}(List<${field.clazz?cap_first}> ${field.name}){
			this.${field.name} = ${field.name};
		}
		
		<#else>
		public ${field.clazz} ${field.name?cap_first}
        {
            get { return ${field.name}; }
            set { ${field.name} = value; }
        }
        
		</#if>
		</#list>
    }
}
