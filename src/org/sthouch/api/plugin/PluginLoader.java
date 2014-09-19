/*
 * 
  * Este arquivo pertence (e faz parte) ao/do Sthouch Project, que est� Licenciado com a MIT Licence (MIT).
  * 
  * Copyright (C) 2014 <http://www.sthouch.org/ e contribuidores (Contribuidores do Projeto)>
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

package org.sthouch.api.plugin;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.*;

import org.sthouch.SthouchServer;
import org.sthouch.api.server.Server;

/**
 * 
 * @author Pedro
 *
 */
public class PluginLoader {

	@SuppressWarnings({"rawtypes", "unchecked"})
	public static Plugin loadPlugin(File file) throws ClassNotFoundException {
		SthouchPlugin sthouch = null;
		PluginClassLoader pcl = null;

		if (!file.exists()) {
			throw new NullPointerException("Falha ao tentar carregar o plugin: O Arquivo do JAR n�o foi encotrado!");
		}

		if (!file.getName().endsWith(".jar")) {
			throw new UnsupportedOperationException("Falha ao tentar carregar o plugin: A Extens�o do arquivo n�o � aceit�vel!");
		}

		try {
			URL local = file.toURI().toURL();
			URL[] links = new URL[1];
			links[0] = local;

			pcl = new PluginClassLoader(new PluginLoader(), links, PluginLoader.class.getClass().getClassLoader());

			Class principal = null;
			Class main = null;
			try {
				main = Class.forName("Main", true, pcl);
			} catch (ClassNotFoundException e) {
				throw new ClassNotFoundException("Falha ao tentar carregar o plugin: Classe 'Main' dentro do Jar, n�o foi encontrada!");
			}

			Define define = new DefineLoader(main).getAnnotation();
			Team team = new TeamLoader(main).getAnnotation();
			if (define == null) {
				throw new UnsupportedOperationException("Falha ao tentar carregar o plugin: N�o foi encontrado o par�metro de defini��o @Define");
			}

			boolean teamnull = false;
			if (team == null) {
				teamnull=true;
			}

			String pplugin = define.plugin();
			String pversion = define.version();
			String pmain = define.main();

			if (pplugin.isEmpty()) {
				throw new NullPointerException("Falha ao tentar carregar o plugin: Par�metro vazio em @Define plugin=" + '"' + '"' + ")");
			}

			if (pversion.isEmpty()) {
				throw new NullPointerException("Falha ao tentar carregar o plugin: Par�metro vazio em @Define version=" + '"' + '"' + ")");
			}

			if (pmain.isEmpty()) {
				throw new NullPointerException("Falha ao tentar carregar o plugin: Par�metro vazio em @Define main=" + '"' + '"' + ")");
			}

			try {
				principal = Class.forName(pmain, true, pcl);
			} catch (ClassNotFoundException e) {
				throw new ClassNotFoundException("Falha ao tentar carregar o plugin: Classe principal definida n�o encontrada!");
			} catch (Exception e) {
				throw new ClassNotFoundException("Falha ao tentar carregar o plugin: Erro ao tentar pegar a classe Principal definida!");
			}

			Class c = null;
			c = principal.asSubclass(SthouchPlugin.class);

			Constructor constructor = c.getConstructor(new Class[0]);
			sthouch = (SthouchPlugin)constructor.newInstance(new Object[0]);

			Server server = new SthouchServer();
			sthouch.buildPlugin(pplugin, server);

			ModData md = new ModData(pplugin);
			md.setMainClass(principal);
			md.setVersion(pversion);;
			if (teamnull == false) md.setDevelopers(team.developers());
		} catch (MalformedURLException | ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}

		return sthouch;
	}

}