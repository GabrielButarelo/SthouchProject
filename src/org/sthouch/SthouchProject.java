/*
 * 
  * Este arquivo pertence (e faz parte) ao/do Sthouch Project, que estï¿½ Licenciado com a MIT Licence (MIT).
  * 
  * Copyright (C) 2014 Sthouch Team <http://www.sthouch.org/ e contribuidores>
  * 
  * A permissï¿½o ï¿½ concedida, a tï¿½tulo gratuito, a qualquer pessoa que obtenha uma cï¿½pia
  * deste software e arquivos de documentaï¿½ï¿½o associados (o "Software"), para negociar
  * o Software sem restriï¿½ï¿½o, incluindo, sem limitaï¿½ï¿½o, os direitos
  * para usar, copiar, modificar, mesclar, publicar, distribuir, sublicenciar e/ou vender
  * cï¿½pias do Software, e permitir que as pessoas a quem o Software ï¿½
  * fornecido faï¿½am isso, sujeito ï¿½s seguintes condiï¿½ï¿½es:
  *
  * ---------
  *
  * O aviso de copyright acima, os avisos abaixo, e este aviso de permissï¿½o devem ser incluï¿½dos em todas as cï¿½pias ou partes 
  * substanciais do Software, obrigatoriamente;
  * 
  * Os Nome(s) dos detentores de direitos autorais acima deverï¿½ nï¿½o poder ser usado em publicidade ou de outra forma para promover
  * a venda, uso ou outras negociaï¿½ï¿½es em Este Software sem autorizaï¿½ï¿½o prï¿½via por escrito, do Lï¿½der do Projeto.
  * 
  * O Intitulado Contribuidor do Projeto (Citado acima, no Copyright), ï¿½/sï¿½o aquele/aqueles que fazem, ou, por sua vez,
  * fizeram parte da equipe oficial, sendo assim entï¿½o ou um dia, aceitos pela equipe oficial do  Sthouch como, por sua vez,
  * Contribuï¿½ntes e Desenvolvedores do mesmo. Qualquer outro usuï¿½rio que, por sua vez, nï¿½o seja/esteja dentro/participando da
  * equipe oficial, ou nunca tenha participado oficialmente da equipe, nï¿½o tem direitos como "contribuidores" ou "contribuinte" do
  * projeto Sthouch (ou Sthouch Project).
  * 
  * ---------
  * 
  * O SOFTWARE ï¿½ FORNECIDO "COMO ESTï¿½", SEM GARANTIA DE QUALQUER TIPO, EXPRESSA OU IMPLï¿½CITA, INCLUINDO, SEM LIMITAï¿½ï¿½O, 
  * AS GARANTIAS DE COMERCIALIZAï¿½ï¿½O,ADEQUAï¿½ï¿½O A UM DETERMINADO FIM E Nï¿½O VIOLAï¿½ï¿½O.
  * EM NENHUM CASO A AUTORES OU DETENTORES DOS DIREITOS AUTORAIS SERï¿½ RESPONSï¿½VEL POR QUALQUER RECLAMAï¿½ï¿½O, DANOS OU OUTRAS
  * RESPONSABILIDADE, SEJA EM UMA Aï¿½ï¿½O DE CUMPRIMENTO DE CONTRATO OU QUALQUER OUTRO MEIO, DE OU EM CONEXï¿½O COM O SOFTWARE OU O 
  * USO OU OUTRAS NEGOCIAï¿½ï¿½ES O SOFTWARE.
  * 
  * MIT Licence (MIT), Fonte: < http://pt.wikipedia.org/wiki/Licen%C3%A7a_MIT >
 */

package org.sthouch;

import java.io.*;

import biz.source_code.base64Coder.*;
import org.sthouch.logger.Logger;

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

	/**
	 * <p>Mï¿½todo Principal, Inï¿½cio do Projeto</p>
	 * @param args
	 * @author Pedro
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * <p>Representa o Diretï¿½rio onde estï¿½ o arquivo .jar do Sthouch</p>
	 * @author Pedro
	 * @return Directory of Sthouch Jar File
	 */
	public static File getDirectory() {
		return directory;
	}

	/**
	 * <p>Criar arquivos padrï¿½es do Sistema.</p>
	 * @author Pedro
	 */
	public static void start() {
		logger.info("Verificando arquivos padrões..");
		createFiles();
		logger.info("Arquivos não existentes foram criados!");
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
     * <p>Criar arquivos padrões.</p>
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

    /**
     * <p> Pegar logger global do SthouchProject</p>
     * @author JonathanScripter
     */

    public static Logger getLogger(){
        return logger;
    }


}