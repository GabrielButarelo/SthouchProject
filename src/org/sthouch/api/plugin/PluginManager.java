package org.sthouch.api.plugin;

import java.util.HashMap;

import org.eclipse.jdt.annotation.Nullable;

public class PluginManager {

	protected static final HashMap<String, Plugin> plugins = new HashMap<>();

	/**
	 * 
	 * @param plugin
	 * @return Plugin instanciado pelo Nome
	 * 
	 */
	@Nullable
	public Plugin getPlugin(String plugin) {
		if (plugins.containsKey(plugin.toLowerCase())) {
			return plugins.get(plugin.toLowerCase());
		} else {
			return null;
		}
	}

}