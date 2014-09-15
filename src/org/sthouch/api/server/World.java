package org.sthouch.api.server;

import java.util.List;

import org.sthouch.api.player.Player;

/**
 * <b>Gerenciamento de Mundos por Mundo específico</b>
 * @author Pedro
 *
 */
public interface World {

	public String getName();

	public List<Player> getPlayersIn();

	public boolean withPvPEnabled();
	public boolean setPvPEnabled(boolean enabled);

}