package org.sthouch.api.server;

import org.sthouch.api.world.World;

/**
 * <p>Classe de gerênciamento de Localizações, crie instâncias para usá-las, compará-las, etc..</p>
 * @author Pedro
 *
 */
public class Location {

	private int x=0;
	private int y=0;
	private int z=0;

	private float yaw=0;
	private float pitch=0;

	private World world=null;

	public Location(World world, int x, int y, int z) {
		this.x=x;
		this.y=y;
		this.z=z;
		this.world=world;
	}

	public Location(World world, int x, int y, int z, float yaw, float pitch) {
		this.x=x;
		this.y=y;
		this.z=z;
		this.world=world;
		this.yaw=yaw;
		this.pitch=pitch;
	}

	/**
	 * <p>Retorna o Mundo onde o Jogador está.</ç>
	 * @return World
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * <p>Retorna a Coordenada X de onde o Jogador está..</ç>
	 * @return Integer
	 */
	public Integer getX() {
		return x;
	}

	/**
	 * <p>Retorna a Coordenada Y (Altura) de onde o Jogador está..</ç>
	 * @return Integer
	 */
	public Integer getY() {
		return y;
	}

	/**
	 * <p>Retorna a Coordenada Z de onde o Jogador está..</ç>
	 * @return Integer
	 */
	public Integer getZ() {
		return z;
	}

	public Float getYaw() {
		return yaw;
	}

	public Float getPitch() {
		return pitch;
	}

}