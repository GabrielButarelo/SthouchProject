package org.sthouch.api.server;

import java.util.List;
import java.util.logging.Logger;

import org.sthouch.api.player.Player;

public interface Server {

	public void setServerName(String name);
	public void setServerMotd(String motd);
	public void setStormAllowed(boolean allowed);
	public void downloadSthouch(String version);
	public void downloadLastSthouch();
	public void broadcast(String message);
	public void banPlayer(String player, String reason);
	public void banPlayer(Player player, String reason);
	public void unbanPlayer(String player);
	public void unbanPlayer(Player player);

	public Player getPlayerByName(String player);
	public World getWorldByName(String world);

	public List<Player> getBannedPlayers();
	public List<Player> getOperators();
	public List<Player> getPlayersInWhiteList();
	public List<Player> getOnlinePlayers();
	public List<World> getWorlds();

	public Boolean isBanned(String player);
	public Boolean isBanned(Player player);
	public Boolean hasSthouchUpdates();
	public Boolean stormAllowed();

	public String getSthouchVersion();
	public String getServerName();
	public String getServerAddress();
	public String getServerMotd();

	public Logger getLog();

}