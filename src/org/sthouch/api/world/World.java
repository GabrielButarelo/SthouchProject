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