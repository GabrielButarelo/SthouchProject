package org.sthouch.api.server;

import java.util.List;
import java.util.logging.Logger;

import org.sthouch.api.player.Player;
import org.sthouch.api.world.World;

/**
 * <p>Interface de ger�nciamento b�sico do Servidor.</p>
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
	 * <p>Marcar se a chuva est� ou n�o permitida.</p>
	 * @param allowed
	 */
	public void setStormAllowed(boolean allowed);

	/**
	 * <p>Efetuar Download de uma vers�o do Sthouch.</p>
	 * @param version
	 */
	public void downloadSthouch(String version);

	/**
	 * <p>Efetuar Download da ultima vers�o do Sthouch.</p>
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
	 * <p>Banir um Jogador pela vari�vel Player.</p>
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
	 * <p>Desbanir um Jogador pela vari�vel Player.</p>
	 * @param player
	 */
	public void unbanPlayer(Player player);

	/**
	 * <p>Retorna a Vari�vel Player pega pelo nome do Jogador.</p>
	 * @param player
	 * @return Player
	 */
	public Player getPlayerByName(String player);

    /**
     * <p>Retorna a Vari�vel World pega pelo Nome dele.</p>
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
	 * <p>Retorna uma Lista de Jogadores que s�o Operadores (OP).</p>
	 * @return List
	 */
	public List<Player> getOperators();

    /**
     * <p>Retorna uma Lista de Jogadores que est�o na Whitelist.</p>
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
	 * <p>Verifica se o Jogador est� banido, pelo nome dele.</p>
	 * @param player
	 * @return boolean
	 */
	public Boolean isBanned(String player);

	/**
	 * <p>Verifica se o Jogador est� banido, pela vari�vel Player.</p>
	 * @param player
	 * @return boolean
	 */
	public Boolean isBanned(Player player);

	/**
	 * <p>Verifica se h� novos updates do Sthouch a serem baixados.</p>
	 * @return boolean
	 */
	public Boolean hasSthouchUpdates();

	/**
	 * <p>Retorna se a Chuva � ou n�o permitida.</p>
	 * @return boolean
	 */
	public Boolean stormAllowed();

	/**
	 * <p>Retorna com a vers�o que o Servidor est� usando do Sthouch.</p>
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