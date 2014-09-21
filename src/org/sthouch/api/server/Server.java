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

package org.sthouch.api.server;

import java.util.List;

import org.sthouch.api.commands.CommandManager;
import org.sthouch.api.commands.PluginCommandManager;
import org.sthouch.api.listeners.Listener;
import org.sthouch.api.logs.LogManager;
import org.sthouch.api.player.Player;
import org.sthouch.api.plugin.Plugin;
import org.sthouch.api.plugin.PluginManager;
import org.sthouch.api.world.World;

/**
 * <p>Interface de ger�nciamento b�sico do Servidor.</p>
 * @author Pedro
 *
 */
public interface Server {

	/**
	 * <p>Marcar o nome do Servidor.</p>
	 * @author Pedro
	 * @param name
	 */
	public void setServerName(String name);

	/**
	 * <p>Marcar a Motd do Servidor.</p>
	 * @author Pedro
	 * @param motd
	 */
	public void setServerMotd(String motd);

	/**
	 * <p>Marcar se a chuva est� ou n�o permitida.</p>
	 * @author Pedro
	 * @param allowed
	 */
	public void setStormAllowed(boolean allowed);

	/**
	 * <p>Efetuar Download de uma vers�o do Sthouch.</p>
	 * @author Pedro
	 * @param version
	 */
	public void downloadSthouch(String version);

	/**
	 * <p>Efetuar Download da ultima vers�o do Sthouch.</p>
	 * @author Pedro
	 */
	public void downloadLastSthouch();

	/**
	 * <p>Enviar uma Mensagem no Broadcast.</p>
	 * @author Pedro
	 * @param message
	 */
	public void broadcast(String message);

	/**
	 * <p>Banir um Jogador pelo nome dele.</p>
	 * @author Pedro
	 * @param player
	 * @param reason
	 */
	public void banPlayer(String player, String reason);

	/**
	 * <p>Banir um Jogador pela vari�vel Player.</p>
	 * @author Pedro
	 * @param player
	 * @param reason
	 */
	public void banPlayer(Player player, String reason);

	/**
	 * <p>Desbanir um Jogador pelo nome dele.</p>
	 * @author Pedro
	 * @param player
	 */
	public void unbanPlayer(String player);

	/**
	 * <p>Desbanir um Jogador pela vari�vel Player.</p>
	 * @author Pedro
	 * @param player
	 */
	public void unbanPlayer(Player player);

	/**
	 * <p>Retorna a Vari�vel Player pega pelo nome do Jogador.</p>
	 * @author Pedro
	 * @param player
	 * @return Player
	 */
	public Player getPlayerByName(String player);

    /**
     * <p>Retorna a Vari�vel World pega pelo Nome dele.</p>
     * @author Pedro
     * @param world
     * @return
     */
	public World getWorldByName(String world);

	/**
	 * <p>Retorna a Lista de Jogadores banidos pelo Sistema.</p>
	 * @author Pedro
	 * @return List
	 */
	public List<Player> getBannedPlayers();

	/**
	 * <p>Retorna uma Lista de Jogadores que s�o Operadores (OP).</p>
	 * @author Pedro
	 * @return List
	 */
	public List<Player> getOperators();

    /**
     * <p>Retorna uma Lista de Jogadores que est�o na Whitelist.</p>
     * @author Pedro
     * @return List
     */
	public List<Player> getPlayersInWhiteList();

	/**
	 * <p>Retorna a Lista de Jogadores Online no momento.</p>
	 * @author Pedro
	 * @return List
	 */
	public List<Player> getOnlinePlayers();

	/**
	 * <p>Retorna a Lista de Mundos existentes.</p>
	 * @author Pedro
	 * @return List
	 */
	public List<World> getWorlds();

	/**
	 * <p>Verifica se o Jogador est� banido, pelo nome dele.</p>
	 * @author Pedro
	 * @param player
	 * @return boolean
	 */
	public Boolean isBanned(String player);

	/**
	 * <p>Verifica se o Jogador est� banido, pela vari�vel Player.</p>
	 * @author Pedro
	 * @param player
	 * @return boolean
	 */
	public Boolean isBanned(Player player);

	/**
	 * <p>Verifica se h� novos updates do Sthouch a serem baixados.</p>
	 * @author Pedro
	 * @return boolean
	 */
	public Boolean hasSthouchUpdates();

	/**
	 * <p>Retorna se a Chuva � ou n�o permitida.</p>
	 * @author Pedro
	 * @return boolean
	 */
	public Boolean stormAllowed();

	/**
	 * <p>Retorna com a vers�o que o Servidor est� usando do Sthouch.</p>
	 * @author Pedro
	 * @return String
	 */
	public String getSthouchVersion();

	/**
	 * <p>Retorna o Nome do Servidor.</p>
	 * @author Pedro
	 * @return String
	 */
	public String getServerName();

	/**
	 * <p>Retorna o IP do Servidor.</p>
	 * @author Pedro
	 * @return String
	 */
	public String getServerAddress();

	/**
	 * <p>Retorna o Motd do Servidor.</p>
	 * @author Pedro
	 * @return String
	 */
	public String getServerMotd();

	/**
	 * @author Pedro
	 * @return PluginManager Instance
	 */
	public PluginManager getPluginManager();

	/**
	 * 
	 * @author Pedro
	 * @return LogManager Instance
	 */
	public LogManager getLogManager();

	/**
	 * @author Pedro
	 * @return Console Instance
	 */
	public Console getConsole();

	/**
	 * @author Pedro
	 * @return CommandManager Instance
	 */
	public CommandManager getCommandManager();

	/**
	 * @author Pedro
	 * @param plugin Variavel que representa o seu Plugin
	 * @return PluginCommandManager Instance
	 */
	public PluginCommandManager getPluginCommandManager(Plugin plugin);

    /**.
     * @author JonathanScripter
     * @return O gerenciador dos eventos e listeners
     */
    public Listener getListenerManager();
}