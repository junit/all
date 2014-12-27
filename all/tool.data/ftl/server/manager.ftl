package com.mokylin.game.server.db.config;

<#list names as name>
import com.mokylin.game.server.db.config.container.${name?cap_first};
</#list>
import com.manager.Manager;

public class DbConfigManager extends Manager {
<#list names as name>
	public ${name?cap_first} ${name} = new ${name?cap_first}();
</#list>
	
	@Override
	public boolean init() {
		<#list names as name>
		if (!${name}.init()) return false;
		</#list>
		return true;
	}

	@Override
	public void stop() {
	}
}
