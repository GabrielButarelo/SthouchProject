package org.sthouch.api.plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.sthouch.SthouchProject;
import org.sthouch.exceptions.PluginLoadException;

public class PluginLoadManager {

	private static boolean already = false;

	public PluginLoadManager() {}

	/**
	 * <p>Carregar todos os plugins do Servidor.</p>
	 * @author Pedro
	 */
	public void loadAll() {
		if (already == true) return;

		already = true;
		List<File> files = new ArrayList<>();
		for (File file : new File(SthouchProject.getDirectory(), "plugins").listFiles()) {
			if (file.getName().toLowerCase().endsWith(".jar")) {
				files.add(file);
			}
		}

		for (File jar : files) {
			try {
				PluginLoader.loadPlugin(jar);
			} catch (PluginLoadException e) {
				e.printStackTrace();
			}
		}
	}

}