package org.sthouch;

import java.io.File;
import java.io.IOException;

/**
 * <p>Classe Principal do Sthouch Project</p>
 * @author Pedro
 *
 */
public class SthouchProject {

	public static String version = "";

	public static void main(String[] args) {
		version = "1.2.2D Alpha (1.5.2)";
		createDefaultFiles();
	}

	/**
	 * <p>Representa o Diretório onde está o arquivo .jar do Sthouch</p>
	 * @author Pedro
	 * @return Directory of Sthouch Jar File
	 */
	public static File getDirectory() {
		String path = System.getProperty("java.class.path");
		return new File(path);
	}

	/**
	 * <p>Criar arquivos padrões do Sistema.</p>
	 */
	public static void createDefaultFiles() {
		File directory = getDirectory();

		File plugins = new File(directory, "server-plugins");
		if (!plugins.exists()) {
			try {
				plugins.mkdir();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		File downloads = new File(directory, "downloads");
		if (!downloads.exists()) {
			try {
				downloads.mkdir();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		File worlds = new File(directory, "worlds");
		if (!worlds.exists()) {
			try {
				worlds.mkdir();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		File logs = new File(directory, "logs");
		if (!logs.exists()) {
			try {
				logs.mkdir();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		File licence = new File(directory, "licence.txt");
		if (!licence.exists()) {
			try {
				licence.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		File news = new File(directory, "news");
		if (!news.exists()) {
			try {
				news.mkdir();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}