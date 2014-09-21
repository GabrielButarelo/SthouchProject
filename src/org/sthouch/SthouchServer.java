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

import java.util.List;

import org.sthouch.api.commands.CommandManager;
import org.sthouch.api.commands.PluginCommandManager;
import org.sthouch.api.logs.LogManager;
import org.sthouch.api.player.Player;
import org.sthouch.api.plugin.Plugin;
import org.sthouch.api.plugin.PluginManager;
import org.sthouch.api.server.Console;
import org.sthouch.api.server.Server;
import org.sthouch.api.world.World;
import org.sthouch.logger.Logger;

/**
 * 
 * @author Pedro
 *
 */
public class SthouchServer implements Server {

	public static final Logger logger = SthouchProject.getLogger();

	@Override
	public void setServerName(String name) {
		
	}

	@Override
	public void setServerMotd(String motd) {
		
	}

	@Override
	public void setStormAllowed(boolean allowed) {
		
	}

	@Override
	public void downloadSthouch(String version) {
		
	}

	@Override
	public void downloadLastSthouch() {
		
	}

	@Override
	public void broadcast(String message) {
		
	}

	@Override
	public void banPlayer(String player, String reason) {
		if (player == null) {
			throw new NullPointerException("Variável de Player Nula!");
		}
	}

	@Override
	public void banPlayer(Player player, String reason) {
		if (player == null) {
			throw new NullPointerException("Variável de Player Nula!");
		}
	}

	@Override
	public void unbanPlayer(String player) {
		
	}

	@Override
	public void unbanPlayer(Player player) {
		if (player == null) {
			throw new NullPointerException("Variável de Player Nula!");
		}
	}

	@Override
	public Player getPlayerByName(String player) {
		return null;
	}

	@Override
	public World getWorldByName(String world) {
		return null;
	}

	@Override
	public List<Player> getBannedPlayers() {
		return null;
	}

	@Override
	public List<Player> getOperators() {
		return null;
	}

	@Override
	public List<Player> getPlayersInWhiteList() {
		return null;
	}

	@Override
	public List<Player> getOnlinePlayers() {
		return null;
	}

	@Override
	public List<World> getWorlds() {
		return null;
	}

	@Override
	public Boolean isBanned(String player) {
		return null;
	}

	@Override
	public Boolean isBanned(Player player) {
		if (player == null) {
			throw new NullPointerException("Variável de Player Nula!");
		}
		return null;
	}

	@Override
	public Boolean hasSthouchUpdates() {
		return null;
	}

	@Override
	public Boolean stormAllowed() {
		return null;
	}

	@Override
	public String getSthouchVersion() {
		return null;
	}

	@Override
	public String getServerName() {
		return null;
	}

	@Override
	public String getServerAddress() {
		return null;
	}

	@Override
	public String getServerMotd() {
		return null;
	}

	@Override
	public PluginManager getPluginManager() {
		return new PluginManager();
	}

	@Override
	public LogManager getLogManager() {
		return new LogManager();
	}

	@Override
	public Console getConsole() {
		return new SthouchConsole();
	}

	@Override
	public CommandManager getCommandManager() {
		return new CommandManager();
	}

	@Override
	public PluginCommandManager getPluginCommandManager(Plugin plugin) {
		if (plugin == null) {
			throw new NullPointerException("Plugin não encontrado!");
		}
		return new PluginCommandManager(plugin);
	}

}