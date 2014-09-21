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
	 * <p>Retorna uma Istância de Localização com as variáveis inseridas.</p>
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
	 * <p>Retorna o Mundo onde o Jogador está.</ç>
	 * @autor Pedro
	 * @return World
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * <p>Retorna a Coordenada X de onde o Jogador está..</ç>
	 * @autor Pedro
	 * @return Integer
	 */
	public Integer getX() {
		return x;
	}

	/**
	 * <p>Retorna a Coordenada Y (Altura) de onde o Jogador está..</ç>
	 * @autor Pedro
	 * @return Integer
	 */
	public Integer getY() {
		return y;
	}

	/**
	 * <p>Retorna a Coordenada Z de onde o Jogador está..</ç>
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