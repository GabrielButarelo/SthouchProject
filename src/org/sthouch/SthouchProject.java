package org.sthouch;

import java.io.File;

/**
 * <b>Classe Principal do Sthouch Project</b>
 * @author Pedro
 *
 */
public class SthouchProject {

	/**
	 * <b>Propriedade que define a Classe como Main (Principal)</b>
	 * @param args
	 * @author Pedro
	 */
	public static void main(String[] args) {
		version = "1.2.2D Alpha (1.5.2)";
		getDirectory();
	}

	/**
	 * <b>Representa o Diretório onde está o arquivo .jar do Sthouch</b>
	 * @author Pedro
	 * @return Directory of Sthouch Jar File
	 */
	public static File getDirectory() {
		String path = System.getProperty("java.class.path");
		return new File(path);
	}

	public static  String version = "";

}