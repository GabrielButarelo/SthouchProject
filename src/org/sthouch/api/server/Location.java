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

import org.sthouch.api.world.World;

/**
 * <p>Classe de ger�nciamento de Localiza��es, crie inst�ncias para us�-las, compar�-las, etc..</p>
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

	/**
	 * @autor Pedro
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 */
	public Location(World world, int x, int y, int z) {
		this.x=x;
		this.y=y;
		this.z=z;
		this.world=world;
	}

	/**
	 * @autor Pedro
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param yaw
	 * @param pitch
	 */
	public Location(World world, int x, int y, int z, float yaw, float pitch) {
		this.x=x;
		this.y=y;
		this.z=z;
		this.world=world;
		this.yaw=yaw;
		this.pitch=pitch;
	}

	/**
	 * <p>Retorna uma Ist�ncia de Localiza��o com as vari�veis inseridas.</p>
	 * @autor Pedro
	 * @return Location
	 */
	public Location getLocation() {
		if (yaw != 0 && pitch != 0) {
			return new Location(world,x,y,z,yaw,pitch);
		} else {
			return new Location(world,x,y,z);
		}
	}

	/**
	 * <p>Retorna o Mundo onde o Jogador est�.</�>
	 * @autor Pedro
	 * @return World
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * <p>Retorna a Coordenada X de onde o Jogador est�..</�>
	 * @autor Pedro
	 * @return Integer
	 */
	public Integer getX() {
		return x;
	}

	/**
	 * <p>Retorna a Coordenada Y (Altura) de onde o Jogador est�..</�>
	 * @autor Pedro
	 * @return Integer
	 */
	public Integer getY() {
		return y;
	}

	/**
	 * <p>Retorna a Coordenada Z de onde o Jogador est�..</�>
	 * @autor Pedro
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