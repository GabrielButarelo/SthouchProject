/*
 * 
  * Este arquivo pertence (e faz parte) ao/do Sthouch Project, que está Licenciado com a MIT Licence (MIT).
  * 
  * Copyright (C) 2014 <http://www.sthouch.org/ e contribuidores (Contribuidores do Projeto)>
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

package org.sthouch.api.player;

import org.sthouch.api.server.Location;
import org.sthouch.api.world.World;

/**
 * <p>Essa interface é onde fica todas as informações de um jogador, como por exemplo seu nick, level, vida e etc.</p>
 * <p>Podemos pegar valores e setar valores.</p>
 * 
 * @author AtomGamers
 * @author Herobrinedobem
 * @version 1.2
 * 
 */
public interface Player {

	/**
	 * <p>Pega o nickname de um determinado Jogador.</p>
	 */
	public String getName();

	/**
	 * <p>Retorna a Localização do Jogador.</p>
	 * @return Location
	 */
	public Location getPlayerLocation();
	
	/**
	 *<p>Manda uma mensagem no chat para um determinado Jogador.</p>
	 * 
	 * @param message 
	 */
	public void sendMessage(String message);
	
	/**
	 *<p>Teletransporta um determinado jogador para uma localização.</p>
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 */
	@Deprecated
	public void teleportTo(World world, Integer x, Integer y, Integer z);

	/**
	 *<p>Teletransporta um determinado jogador para uma localização.</p>
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param yaw
	 * @param pitch
	 */
	@Deprecated
	public void teleportTo(World world, Integer x, Integer y, Integer z, Float yaw, Float pitch);

	/**
	 *<p>Teletransporta um determinado jogador para uma localização.</p>
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 */
	public void teleportTo(Location location);
	
	/**
	 *<p>Pega a quantidade atual de vida de um determinado jogador.</p>
	 */
	public Integer getHealth();
	
	/**
	 *<p>Seta a quantidade de vida para um determinado jogador.</p>
	 * 
	 * @param health
	 */
	public void setHealth(Integer health);
	
	/**
	 *<p>Pega a quantidade de "fome" atual de um determinado jogador.</p>
	 */
	public Integer getFoodLevel();
	
	/**
	 *<p>Seta a quantidade de "fome" de um determinado jogador.</p>
	 * 
	 * @param foodLevel
	 */
	public void setFoodLevel(Integer foodLevel);

}