package org.sthouch.api.server;

import java.util.List;
import java.util.logging.Logger;

import org.sthouch.api.player.Player;
import org.sthouch.api.world.World;

/**
 * <p>Interface de gerênciamento básico do Servidor.</p>
 * @author Pedro
 *
 */
public interface Server {

	/**
	 * <p>Marcar o nome do Servidor.</p>
	 * @param name
	 */
	public void setServerName(String name);

	/**
	 * <p>Marcar a Motd do Servidor.</p>
	 * @param motd
	 */
	public void setServerMotd(String motd);

	/**
	 * <p>Marcar se a chuva está ou não permitida.</p>
	 * @param allowed
	 */
	public void setStormAllowed(boolean allowed);

	/**
	 * <p>Efetuar Download de uma versão do Sthouch.</p>
	 * @param version
	 */
	public void downloadSthouch(String version);

	/**
	 * <p>Efetuar Download da ultima versão do Sthouch.</p>
	 */
	public void downloadLastSthouch();

	/**
	 * <p>Enviar uma Mensagem no Broadcast.</p>
	 * @param message
	 */
	public void broadcast(String message);

	/**
	 * <p>Banir um Jogador pelo nome dele.</p>
	 * @param player
	 * @param reason
	 */
	public void banPlayer(String player, String reason);

	/**
	 * <p>Banir um Jogador pela variável Player.</p>
	 * @param player
	 * @param reason
	 */
	public void banPlayer(Player player, String reason);

	/**
	 * <p>Desbanir um Jogador pelo nome dele.</p>
	 * @param player
	 */
	public void unbanPlayer(String player);

	/**
	 * <p>Desbanir um Jogador pela variável Player.</p>
	 * @param player
	 */
	public void unbanPlayer(Player player);

	/**
	 * <p>Retorna a Variável Player pega pelo nome do Jogador.</p>
	 * @param player
	 * @return Player
	 */
	public Player getPlayerByName(String player);

    /**
     * <p>Retorna a Variável World pega pelo Nome dele.</p>
     * @param world
     * @return
     */
	public World getWorldByName(String world);

	/**
	 * <p>Retorna a Lista de Jogadores banidos pelo Sistema.</p>
	 * @return List
	 */
	public List<Player> getBannedPlayers();

	/**
	 * <p>Retorna uma Lista de Jogadores que são Operadores (OP).</p>
	 * @return List
	 */
	public List<Player> getOperators();

    /**
     * <p>Retorna uma Lista de Jogadores que estão na Whitelist.</p>
     * @return List
     */
	public List<Player> getPlayersInWhiteList();

	/**
	 * <p>Retorna a Lista de Jogadores Online no momento.</p>
	 * @return List
	 */
	public List<Player> getOnlinePlayers();

	/**
	 * <p>Retorna a Lista de Mundos existentes.</p>
	 * @return List
	 */
	public List<World> getWorlds();

	/**
	 * <p>Verifica se o Jogador está banido, pelo nome dele.</p>
	 * @param player
	 * @return boolean
	 */
	public Boolean isBanned(String player);

	/**
	 * <p>Verifica se o Jogador está banido, pela variável Player.</p>
	 * @param player
	 * @return boolean
	 */
	public Boolean isBanned(Player player);

	/**
	 * <p>Verifica se há novos updates do Sthouch a serem baixados.</p>
	 * @return boolean
	 */
	public Boolean hasSthouchUpdates();

	/**
	 * <p>Retorna se a Chuva é ou não permitida.</p>
	 * @return boolean
	 */
	public Boolean stormAllowed();

	/**
	 * <p>Retorna com a versão que o Servidor está usando do Sthouch.</p>
	 * @return String
	 */
	public String getSthouchVersion();

	/**
	 * <p>Retorna o Nome do Servidor.</p>
	 * @return String
	 */
	public String getServerName();

	/**
	 * <p>Retorna o IP do Servidor.</p>
	 * @return String
	 */
	public String getServerAddress();

	/**
	 * <p>Retorna o Motd do Servidor.</p>
	 * @return String
	 */
	public String getServerMotd();

	/**
	 * <p>Utilize isto para fazer enviar Log's ao Console.</p>
	 * @return Logger
	 */
	public Logger getLog();

}