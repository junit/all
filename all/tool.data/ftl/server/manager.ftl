package com.mokylin.game.server.db.config;

<#list names as name>
import com.mokylin.game.server.db.config.container.${name?cap_first};
</#list>

public class ContainerPool {
<#list names as name>
	public ${name?cap_first} ${name?uncap_first} = new ${name?cap_first}();
</#list>
}
