/*
 * 
  * Este arquivo pertence (e faz parte) ao/do Sthouch Project, que est� Licenciado com a MIT Licence (MIT).
  * 
  * Copyright (C) 2014 Sthouch Team <http://www.sthouch.org/ e contribuidores>
  * 
  * A permiss�o � concedida, a t�tulo gratuito, a qualquer pessoa que obtenha uma c�pia
  * deste software e arquivos de documenta��o associados (o "Software"), para negociar
  * o Software sem restri��o, incluindo, sem limita��o, os direitos
  * para usar, copiar, modificar, mesclar, publicar, distribuir, sublicenciar e/ou vender
  * c�pias do Software, e permitir que as pessoas a quem o Software �
  * fornecido fa�am isso, sujeito �s seguintes condi��es:
  *
  * ---------
  *
  * O aviso de copyright acima, os avisos abaixo, e este aviso de permiss�o devem ser inclu�dos em todas as c�pias ou partes 
  * substanciais do Software, obrigatoriamente;
  * 
  * Os Nome(s) dos detentores de direitos autorais acima dever� n�o poder ser usado em publicidade ou de outra forma para promover
  * a venda, uso ou outras negocia��es em Este Software sem autoriza��o pr�via por escrito, do L�der do Projeto.
  * 
  * O Intitulado Contribuidor do Projeto (Citado acima, no Copyright), �/s�o aquele/aqueles que fazem, ou, por sua vez,
  * fizeram parte da equipe oficial, sendo assim ent�o ou um dia, aceitos pela equipe oficial do  Sthouch como, por sua vez,
  * Contribu�ntes e Desenvolvedores do mesmo. Qualquer outro usu�rio que, por sua vez, n�o seja/esteja dentro/participando da
  * equipe oficial, ou nunca tenha participado oficialmente da equipe, n�o tem direitos como "contribuidores" ou "contribuinte" do
  * projeto Sthouch (ou Sthouch Project).
  * 
  * ---------
  * 
  * O SOFTWARE � FORNECIDO "COMO EST�", SEM GARANTIA DE QUALQUER TIPO, EXPRESSA OU IMPL�CITA, INCLUINDO, SEM LIMITA��O, 
  * AS GARANTIAS DE COMERCIALIZA��O,ADEQUA��O A UM DETERMINADO FIM E N�O VIOLA��O.
  * EM NENHUM CASO A AUTORES OU DETENTORES DOS DIREITOS AUTORAIS SER� RESPONS�VEL POR QUALQUER RECLAMA��O, DANOS OU OUTRAS
  * RESPONSABILIDADE, SEJA EM UMA A��O DE CUMPRIMENTO DE CONTRATO OU QUALQUER OUTRO MEIO, DE OU EM CONEX�O COM O SOFTWARE OU O 
  * USO OU OUTRAS NEGOCIA��ES O SOFTWARE.
  * 
  * MIT Licence (MIT), Fonte: < http://pt.wikipedia.org/wiki/Licen%C3%A7a_MIT >
 */

package org.sthouch;

import java.io.*;

import biz.source_code.base64Coder.*;

import org.sthouch.internal.events.PreparedListeners;
import org.sthouch.logger.Logger;

/**
 * <p>Classe Principal do Sthouch Project</p>
 * @author Pedro
 *
 */
public class SthouchProject {

	public static String version = "";
	public static File directory = null;
    private static final Logger logger = new Logger();
    private static SthouchServer server;

	/**
	 * <p>M�todo Principal, In�cio do Projeto</p>
	 * @param args
	 * @author Pedro
	 */
	public static void main(String[] args) {
        PreparedListeners.init();
        logger.info("Preparando para Iniciar Sthouch Project 1.5.2-D1");
		version = "1.2.2D Alpha (1.5.2)";


		// START OF PREPARING DIRECTORY
		directory = new File(".");
		String new_dir = directory.getAbsolutePath();
		new_dir = new_dir.substring(0, new_dir.length() - 1);
		directory = new File(new_dir);
		// END OF PREPRING DIRECTORY

		logger.info("Iniciando Sthouch Project 1.5.2-D1");
		//start();
        server = new SthouchServer();
	}

	/**
	 * <p>Representa o Diret�rio onde est� o arquivo .jar do Sthouch</p>
	 * @author Pedro
	 * @return Directory of Sthouch Jar File
	 */
	public static File getDirectory() {
		return directory;
	}

	/**
	 * <p>Criar arquivos padr�es do Sistema.</p>
	 * @author Pedro
	 */
	public static void start() {
		logger.info("Verificando arquivos padr�es..");
		createFiles();
		logger.info("Arquivos n�o existentes foram criados!");
	}

	/**
	 * 
	 * @author Pedro
	 * 
	 */
	public final static void buildLicense() {
		String license = Base64Coder.decodeString(MITLicense.license);
		File file = new File(getDirectory() + File.separator + "license.txt");
		try {
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(license);
			pw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return Pegar logger global do SthouchProject
	 * @author JonathanScripter
	 * 
	 */
    public static Logger getLogger() {
        return logger;
    }

    /**
     * <p>Criar arquivos padr�es.</p>
     * @author Pedro
     */
    private static void createFiles() {
    	File file = new File(directory + File.separator + "server-plugins");
		if (!file.exists()) {
			try {
				file.mkdir();
				logger.info("Novo arquivo criado: " + file.getAbsolutePath());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		file = new File(directory + File.separator + "downloads");
		if (!file.exists()) {
			try {
				file.mkdir();
				logger.info("Novo arquivo criado: " + file.getAbsolutePath());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		file = new File(directory + File.separator + "worlds");
		if (!file.exists()) {
			try {
				file.mkdir();
				logger.info("Novo arquivo criado: " + file.getAbsolutePath());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		file = new File(directory + File.separator + "logs");
		if (!file.exists()) {
			try {
				file.mkdir();
				logger.info("Novo arquivo criado: " + file.getAbsolutePath());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		file = new File(directory + File.separator + "news");
		if (!file.exists()) {
			try {
				file.mkdir();
				logger.info("Novo arquivo criado: " + file.getAbsolutePath());
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
			logger.info("Novo arquivo criado: " + file.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		buildLicense();
    }

    public static SthouchServer getServer(){
        return server;
    }

}