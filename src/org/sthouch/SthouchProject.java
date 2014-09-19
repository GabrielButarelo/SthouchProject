/*
 * 
  * Este arquivo pertence (e faz parte) ao/do Sthouch Project, que está Licenciado com a MIT Licence (MIT).
  * 
  * Copyright (C) 2014 Sthouch Team <http://www.sthouch.org/ e contribuidores>
  * 
  * A permissão é concedida, a título gratuito, a qualquer pessoa que obtenha uma cópia
  * deste software e arquivos de documentação associados (o "Software"), para negociar
  * o Software sem restrição, incluindo, sem limitação, os direitos
  * para usar, copiar, modificar, mesclar, publicar, distribuir, sublicenciar e/ou vender
  * cópias do Software, e permitir que as pessoas a quem o Software é
  * fornecido façam isso, sujeito às seguintes condições:
  *
  * ---------
  *
  * O aviso de copyright acima, os avisos abaixo, e este aviso de permissão devem ser incluídos em todas as cópias ou partes 
  * substanciais do Software, obrigatoriamente;
  * 
  * Os Nome(s) dos detentores de direitos autorais acima deverá não poder ser usado em publicidade ou de outra forma para promover
  * a venda, uso ou outras negociações em Este Software sem autorização prévia por escrito, do Líder do Projeto.
  * 
  * O Intitulado Contribuidor do Projeto (Citado acima, no Copyright), é/são aquele/aqueles que fazem, ou, por sua vez,
  * fizeram parte da equipe oficial, sendo assim então ou um dia, aceitos pela equipe oficial do  Sthouch como, por sua vez,
  * Contribuíntes e Desenvolvedores do mesmo. Qualquer outro usuário que, por sua vez, não seja/esteja dentro/participando da
  * equipe oficial, ou nunca tenha participado oficialmente da equipe, não tem direitos como "contribuidores" ou "contribuinte" do
  * projeto Sthouch (ou Sthouch Project).
  * 
  * ---------
  * 
  * O SOFTWARE É FORNECIDO "COMO ESTÁ", SEM GARANTIA DE QUALQUER TIPO, EXPRESSA OU IMPLÍCITA, INCLUINDO, SEM LIMITAÇÃO, 
  * AS GARANTIAS DE COMERCIALIZAÇÃO,ADEQUAÇÃO A UM DETERMINADO FIM E NÃO VIOLAÇÃO.
  * EM NENHUM CASO A AUTORES OU DETENTORES DOS DIREITOS AUTORAIS SERÁ RESPONSÁVEL POR QUALQUER RECLAMAÇÃO, DANOS OU OUTRAS
  * RESPONSABILIDADE, SEJA EM UMA AÇÃO DE CUMPRIMENTO DE CONTRATO OU QUALQUER OUTRO MEIO, DE OU EM CONEXÃO COM O SOFTWARE OU O 
  * USO OU OUTRAS NEGOCIAÇÕES O SOFTWARE.
  * 
  * MIT Licence (MIT), Fonte: < http://pt.wikipedia.org/wiki/Licen%C3%A7a_MIT >
 */

package org.sthouch;

import java.io.*;

import org.sthouch.dll.*;

import biz.source_code.base64Coder.*;

/**
 * <p>Classe Principal do Sthouch Project</p>
 * @author Pedro
 *
 */
public class SthouchProject {

	public static String version = "";
	public static File directory = null;

	/**
	 * <p>Método Principal, Início do Projeto</p>
	 * @param args
	 * @author Pedro
	 */
	public static void main(String[] args) {
		version = "1.2.2D Alpha (1.5.2)";

		// START OF PREPARING DIRECTORY
		directory = new File(".");
		String new_dir = directory.getAbsolutePath();
		new_dir = new_dir.substring(0, new_dir.length() - 1);
		directory = new File(new_dir);
		// END OF PREPRING DIRECTORY

		start();
	}

	/**
	 * <p>Representa o Diretório onde está o arquivo .jar do Sthouch</p>
	 * @author Pedro
	 * @return Directory of Sthouch Jar File
	 */
	public static File getDirectory() {
		return directory;
	}

	/**
	 * <p>Criar arquivos padrões do Sistema.</p>
	 * @author Pedro
	 */
	public static void start() {
		File file = new File(directory + File.separator + "server-plugins");
		if (!file.exists()) {
			try {
				file.mkdir();
				System.out.println("Novo arquivo criado: " + file.getAbsolutePath());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		file = new File(directory + File.separator + "downloads");
		if (!file.exists()) {
			try {
				file.mkdir();
				System.out.println("Novo arquivo criado: " + file.getAbsolutePath());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		file = new File(directory + File.separator + "worlds");
		if (!file.exists()) {
			try {
				file.mkdir();
				System.out.println("Novo arquivo criado: " + file.getAbsolutePath());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		file = new File(directory + File.separator + "logs");
		if (!file.exists()) {
			try {
				file.mkdir();
				System.out.println("Novo arquivo criado: " + file.getAbsolutePath());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		file = new File(directory + File.separator + "news");
		if (!file.exists()) {
			try {
				file.mkdir();
				System.out.println("Novo arquivo criado: " + file.getAbsolutePath());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		file = new File(directory + File.separator + "license.txt");
		if (file.exists()) {
			file.delete();
		}

		file = new File(directory + File.separator + "license.txt");
		try {
			file.createNewFile();
			System.out.println("Novo arquivo criado: " + file.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		copyLicence();

		File download = new File("Sthouch-last.jar");
		DownloadLib.download(download, "http://dll.atomgamers.com/sthouch/last/Sthouch.jar");
	}

	/**
	 * <p>Método para extrair a Licença GPLv3 (General Public Licence, Version 3)</p>
	 * @author Pedro
	 */
	private static void copyLicence() {
		String licence = Base64Coder.decodeString(MITLicense.licence);
		File file = new File(getDirectory() + File.separator + "license.txt");
		try {
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(licence);
			pw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}