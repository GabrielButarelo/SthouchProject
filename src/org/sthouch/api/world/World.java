package org.sthouch.api.world;

import java.util.List;

import org.sthouch.api.player.Player;

/**
 * <b>Gerenciamento de Mundos por Mundo específico</b>
 * @author Pedro
 *
 */
public interface World {

	/**
	 * <p>Retorna se o mundo existe ou não.</p>
	 */
	public boolean hasWorld();

	/**
	 * <p>Retorna o nome do Mundo.</p>
	 * @return String
	 */
	public String getName();

	/**
	 * <p>Retorna uma Lista de Jogadores que estão no momento, dentro do Mundo.</p>
	 * @return List
	 */
	public List<Player> getPlayersIn();

	/**
	 * <p>Retorna se o PvP está ou não ativado no Mundo.</p>
	 * @return Boolean
	 */
	public boolean withPvPEnabled();

	/**
	 * <p>Define se o PvP está ou não ativado no Mundo.</p>
	 * @param enabled
	 * @return boolean
	 */
	public void setPvPEnabled(boolean enabled);

	/**
	 * <p>Retorna se a Invencibilidade está ou não ativada no Mundo.</p>
	 * @return boolean
	 */
	public boolean withInvincibleAllowed();

	/**
	 * <p>Define se a Invencibilidade está ou não ativada no Mundo.</p>
	 * @param enabled
	 */
	public void setInvincibleEnabled(boolean enabled);

	/**
	 * <p>Retorna o Tipo do mundo, referenciado a classe WorldType.</p>
	 * @return WorldType
	 */
	public WorldType getType();

}