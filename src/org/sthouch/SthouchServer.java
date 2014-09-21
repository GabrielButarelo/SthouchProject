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

import java.util.List;

import org.sthouch.api.commands.CommandManager;
import org.sthouch.api.commands.PluginCommandManager;
import org.sthouch.api.listeners.Listener;
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

    private static final Listener defaultListener = new Listener();

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
			throw new NullPointerException("Vari�vel de Player Nula!");
		}
	}

	@Override
	public void banPlayer(Player player, String reason) {
		if (player == null) {
			throw new NullPointerException("Vari�vel de Player Nula!");
		}
	}

	@Override
	public void unbanPlayer(String player) {
		
	}

	@Override
	public void unbanPlayer(Player player) {
		if (player == null) {
			throw new NullPointerException("Vari�vel de Player Nula!");
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
			throw new NullPointerException("Vari�vel de Player Nula!");
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
			throw new NullPointerException("Plugin n�o encontrado!");
		}
		return new PluginCommandManager(plugin);
	}

    @Override
    public Listener getListenerManager() {
        return defaultListener;
    }

}