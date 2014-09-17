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

package org.sthouch.api.server;

import java.util.List;

import org.sthouch.api.player.Player;
import org.sthouch.api.plugin.Plugin;
import org.sthouch.api.world.World;

/**
 * <p>Interface de gerênciamento básico do Servidor.</p>
 * @author Pedro
 *
 */
public interface Server {

	/**
	 * <p>Marcar o nome do Servidor.</p>
	 * @author Pedro
	 * @param name
	 */
	public void setServerName(String name);

	/**
	 * <p>Marcar a Motd do Servidor.</p>
	 * @author Pedro
	 * @param motd
	 */
	public void setServerMotd(String motd);

	/**
	 * <p>Marcar se a chuva está ou não permitida.</p>
	 * @author Pedro
	 * @param allowed
	 */
	public void setStormAllowed(boolean allowed);

	/**
	 * <p>Efetuar Download de uma versão do Sthouch.</p>
	 * @author Pedro
	 * @param version
	 */
	public void downloadSthouch(String version);

	/**
	 * <p>Efetuar Download da ultima versão do Sthouch.</p>
	 * @author Pedro
	 */
	public void downloadLastSthouch();

	/**
	 * <p>Enviar uma Mensagem no Broadcast.</p>
	 * @author Pedro
	 * @param message
	 */
	public void broadcast(String message);

	/**
	 * <p>Banir um Jogador pelo nome dele.</p>
	 * @author Pedro
	 * @param player
	 * @param reason
	 */
	public void banPlayer(String player, String reason);

	/**
	 * <p>Banir um Jogador pela variável Player.</p>
	 * @author Pedro
	 * @param player
	 * @param reason
	 */
	public void banPlayer(Player player, String reason);

	/**
	 * <p>Desbanir um Jogador pelo nome dele.</p>
	 * @author Pedro
	 * @param player
	 */
	public void unbanPlayer(String player);

	/**
	 * <p>Desbanir um Jogador pela variável Player.</p>
	 * @author Pedro
	 * @param player
	 */
	public void unbanPlayer(Player player);

	/**
	 * <p>Retorna a Variável Player pega pelo nome do Jogador.</p>
	 * @author Pedro
	 * @param player
	 * @return Player
	 */
	public Player getPlayerByName(String player);

    /**
     * <p>Retorna a Variável World pega pelo Nome dele.</p>
     * @author Pedro
     * @param world
     * @return
     */
	public World getWorldByName(String world);

	/**
	 * <p>Retorna a Lista de Jogadores banidos pelo Sistema.</p>
	 * @author Pedro
	 * @return List
	 */
	public List<Player> getBannedPlayers();

	/**
	 * <p>Retorna uma Lista de Jogadores que são Operadores (OP).</p>
	 * @author Pedro
	 * @return List
	 */
	public List<Player> getOperators();

    /**
     * <p>Retorna uma Lista de Jogadores que estão na Whitelist.</p>
     * @author Pedro
     * @return List
     */
	public List<Player> getPlayersInWhiteList();

	/**
	 * <p>Retorna a Lista de Jogadores Online no momento.</p>
	 * @author Pedro
	 * @return List
	 */
	public List<Player> getOnlinePlayers();

	/**
	 * <p>Retorna a Lista de Mundos existentes.</p>
	 * @author Pedro
	 * @return List
	 */
	public List<World> getWorlds();

	/**
	 * <p>Verifica se o Jogador está banido, pelo nome dele.</p>
	 * @author Pedro
	 * @param player
	 * @return boolean
	 */
	public Boolean isBanned(String player);

	/**
	 * <p>Verifica se o Jogador está banido, pela variável Player.</p>
	 * @author Pedro
	 * @param player
	 * @return boolean
	 */
	public Boolean isBanned(Player player);

	/**
	 * <p>Verifica se há novos updates do Sthouch a serem baixados.</p>
	 * @author Pedro
	 * @return boolean
	 */
	public Boolean hasSthouchUpdates();

	/**
	 * <p>Retorna se a Chuva é ou não permitida.</p>
	 * @author Pedro
	 * @return boolean
	 */
	public Boolean stormAllowed();

	/**
	 * <p>Retorna com a versão que o Servidor está usando do Sthouch.</p>
	 * @author Pedro
	 * @return String
	 */
	public String getSthouchVersion();

	/**
	 * <p>Retorna o Nome do Servidor.</p>
	 * @author Pedro
	 * @return String
	 */
	public String getServerName();

	/**
	 * <p>Retorna o IP do Servidor.</p>
	 * @author Pedro
	 * @return String
	 */
	public String getServerAddress();

	/**
	 * <p>Retorna o Motd do Servidor.</p>
	 * @author Pedro
	 * @return String
	 */
	public String getServerMotd();

	/**
	 * <p>Utilize isto para fazer enviar Log's ao Console.</p>
	 * @author Pedro
	 * @return Logger
	 */
	public Console getConsole();

	/**
	 * @author Pedro
	 * @param name
	 * @return Plugin pego pelo nome
	 */
	public Plugin getPlugin(String name);

}