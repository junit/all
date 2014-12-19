<#import "Class.ftl" as Class>
package logic.${pkg}.message{
	import net.Bean;
	import utils.long;<#list imports as import>
	import ${import};
	</#list>
	
	/** 
	 * @author Commuication Auto Maker
	 * 
	 * @version 1.0.0
	 * 
	 * @since 2011-5-8
	 * 
	 * ${note}
	 */
	public class ${name} extends Bean {
	
		<#list fields as field>
		<#if field.listFlag==1>
		//${field.note}
		private var _${field.name}: Vector.<${.globals[field.clazz]!field.clazz}> = new Vector.<${.globals[field.clazz]!field.clazz}>();
		<#else>
		//${field.note}
		private var _${field.name}: ${.globals[field.clazz]!field.clazz};
		
		</#if>
		</#list>
		/**
		 * 写入字节缓存
		 */
		override protected function writing(): Boolean{
			<#list fields as field>
			<#if field.listFlag==1>
			//${field.note}
			writeShort(_${field.name}.length);
			for (var i: int = 0; i < _${field.name}.length; i++) {
				<#if field.clazz=="int">
				writeInt(_${field.name}[i]);
				<#elseif field.clazz=="short">
				writeShort(_${field.name}[i]);
				<#elseif field.clazz=="float">
				writeFloat(_${field.name}[i]);
				<#elseif field.clazz=="long">
				writeLong(_${field.name}[i]);
				<#elseif field.clazz=="byte">
				writeByte(_${field.name}[i]);
				<#elseif field.clazz=="String">
				writeString(_${field.name}[i]);
				<#elseif field.clazz=="byte[]">
				writeBytes(_${field.name}[i]);
				<#else>
				writeBean(_${field.name}[i]);
				</#if>
			}
			<#else>
			//${field.note}
			<#if field.clazz=="int">
			writeInt(_${field.name});
			<#elseif field.clazz=="short">
			writeShort(_${field.name});
			<#elseif field.clazz=="float">
			writeFloat(_${field.name});
			<#elseif field.clazz=="long">
			writeLong(_${field.name});
			<#elseif field.clazz=="byte">
			writeByte(_${field.name});
			<#elseif field.clazz=="String">
			writeString(_${field.name});
			<#elseif field.clazz=="byte[]">
			writeBytes(_${field.name}[i]);
			<#else>
			writeBean(_${field.name});
			</#if>
			</#if>
			</#list>
			return true;
		}
		
		/**
		 * 读取字节缓存
		 */
		override protected function reading(): Boolean{
			<#list fields as field>
			<#if field.listFlag==1>
			//${field.note}
			var ${field.name}_length : int = readShort();
			for (var i: int = 0; i < ${field.name}_length; i++) {
				<#if field.clazz=="int">
				_${field.name}[i] = readInt();
				<#elseif field.clazz=="short">
				_${field.name}[i] = readShort();
				<#elseif field.clazz=="float">
				_${field.name}[i] = readFloat();
				<#elseif field.clazz=="long">
				_${field.name}[i] = readLong();
				<#elseif field.clazz=="byte">
				_${field.name}[i] = readByte();
				<#elseif field.clazz=="String">
				_${field.name}[i] = readString();
				<#elseif field.clazz=="byte[]">
				_${field.name}[i] = readBytes();
				<#else>
				_${field.name}[i] = readBean(${field.clazz}) as ${field.clazz};
				</#if>
			}
			<#else>
			//${field.note}
			<#if field.clazz=="int">
			_${field.name} = readInt();
			<#elseif field.clazz=="short">
			_${field.name} = readShort();
			<#elseif field.clazz=="float">
			_${field.name} = readFloat();
			<#elseif field.clazz=="long">
			_${field.name} = readLong();
			<#elseif field.clazz=="byte">
			_${field.name} = readByte();
			<#elseif field.clazz=="String">
			_${field.name} = readString();
			<#elseif field.clazz=="byte[]">
			_${field.name}[i] = readBytes();
			<#else>
			_${field.name} = readBean(${field.clazz}) as ${field.clazz};
			</#if>
			</#if>
			</#list>
			return true;
		}
		
		<#list fields as field>
		<#if field.listFlag==1>
		/**
		 * get ${field.note}
		 * @return 
		 */
		public function get ${field.name}(): Vector.<${.globals[field.clazz]!field.clazz}>{
			return _${field.name};
		}
		
		/**
		 * set ${field.note}
		 */
		public function set ${field.name}(value: Vector.<${.globals[field.clazz]!field.clazz}>): void{
			this._${field.name} = value;
		}
		
		<#else>
		/**
		 * get ${field.note}
		 * @return 
		 */
		public function get ${field.name}(): ${.globals[field.clazz]!field.clazz}{
			return _${field.name};
		}
		
		/**
		 * set ${field.note}
		 */
		public function set ${field.name}(value: ${.globals[field.clazz]!field.clazz}): void{
			this._${field.name} = value;
		}
		
		</#if>
		</#list>
	}
}