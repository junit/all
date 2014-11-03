package com.mokylin.game.server.db.data;

<#list names as name>
import com.mokylin.game.server.db.data.dao.${name?cap_first};
</#list>

public class DaoPool {
<#list names as name>
	public static ${name?cap_first} ${name?uncap_first} = new ${name?cap_first}();
</#list>
}
