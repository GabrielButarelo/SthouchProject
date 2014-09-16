/*
 * 
  * Este arquivo pertence (e faz parte) ao/do Sthouch Project, que est� Licenciado com a MIT Licence (MIT).
  * 
  * Copyright (C) 2014 <http://www.sthouch.org/ e contribuidores (Contribuidores do Projeto)>
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

package org.sthouch.api.player;

import org.sthouch.api.server.Location;
import org.sthouch.api.world.World;

/**
 * <p>Essa interface � onde fica todas as informa��es de um jogador, como por exemplo seu nick, level, vida e etc.</p>
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
	 * <p>Retorna a Localiza��o do Jogador.</p>
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
	 *<p>Teletransporta um determinado jogador para uma localiza��o.</p>
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 */
	@Deprecated
	public void teleportTo(World world, Integer x, Integer y, Integer z);

	/**
	 *<p>Teletransporta um determinado jogador para uma localiza��o.</p>
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
	 *<p>Teletransporta um determinado jogador para uma localiza��o.</p>
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