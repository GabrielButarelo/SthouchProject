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

package org.sthouch.api.plugin;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.*;

import org.sthouch.SthouchServer;
import org.sthouch.api.server.Server;
import org.sthouch.exceptions.PluginLoadException;

/**
 * 
 * @author Pedro
 *
 */
public class PluginLoader {

	@SuppressWarnings({"rawtypes", "unchecked"})
	protected static Plugin loadPlugin(File file) throws PluginLoadException {
		SthouchPlugin sthouch = null;
		PluginClassLoader pcl = null;

		if (!file.exists()) {
			throw new PluginLoadException("Falha ao tentar carregar o plugin: O Arquivo do JAR não foi encotrado!");
		}

		if (!file.getName().endsWith(".jar")) {
			throw new PluginLoadException("Falha ao tentar carregar o plugin: A Extensão do arquivo não é aceitável!");
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
				throw new PluginLoadException("Falha ao tentar carregar o plugin: Classe 'Main' dentro do Jar, não foi encontrada!");
			}

			Define define = new DefineLoader(main).getAnnotation();
			Team team = new TeamLoader(main).getAnnotation();
			if (define == null) {
				throw new PluginLoadException("Falha ao tentar carregar o plugin: Não foi encontrado o parâmetro de definição @Define");
			}

			boolean teamnull = false;
			if (team == null) {
				teamnull=true;
			}

			String pplugin = define.plugin();
			String pversion = define.version();
			String pmain = define.main();

			if (pplugin.isEmpty()) {
				throw new PluginLoadException("Falha ao tentar carregar o plugin: Parâmetro vazio em @Define plugin=" + '"' + '"' + ")");
			}

			if (pversion.isEmpty()) {
				throw new PluginLoadException("Falha ao tentar carregar o plugin: Parâmetro vazio em @Define version=" + '"' + '"' + ")");
			}

			if (pmain.isEmpty()) {
				throw new PluginLoadException("Falha ao tentar carregar o plugin: Parâmetro vazio em @Define main=" + '"' + '"' + ")");
			}

			try {
				principal = Class.forName(pmain, true, pcl);
			} catch (ClassNotFoundException e) {
				throw new PluginLoadException("Falha ao tentar carregar o plugin: Classe principal definida não encontrada!");
			} catch (Exception e) {
				throw new PluginLoadException("Falha ao tentar carregar o plugin: Erro ao tentar pegar a classe Principal definida!");
			}

			Class c = null;
			c = principal.asSubclass(SthouchPlugin.class);

			Constructor constructor = c.getConstructor(new Class[0]);
			sthouch = (SthouchPlugin)constructor.newInstance(new Object[0]);

			Server server = new SthouchServer();

			if (teamnull == true) {
				sthouch.buildPlugin(pplugin, pversion, new String[] {"Unknown"}, server, pmain, principal);
			} else {
				sthouch.buildPlugin(pplugin, pversion, team.developers(), server, pmain, principal);
			}

			PluginManager.plugins.put(pplugin.toLowerCase(), sthouch);
		} catch (MalformedURLException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}

		return sthouch;
	}

}