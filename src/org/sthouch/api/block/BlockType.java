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

package org.sthouch.api.block;

/**
 * 
 * @author Pedro
 *
 */
public enum BlockType {

	AIR(0),
	NULL(0),

	STONE(1),

	GRASS(2),
	DIRT(3),

	COBBLESTONE(4),

	WOODEN_OAK(5, 0),
	WOODEN_SPRUCE(5, 1),
	WOODEN_BIRCH(5, 2),
	WOODEN_JUNGLE(5, 3),

	SAPPLING_OAK(6, 0),
	SAPPLING_SPRUCE(6, 1),
	SAPPLING_BIRCH(6, 2),
	SAPPLING_JUNGLE(6, 3),

	BEDROCK(7),

	WATER(8),
	WATER_BLOCK(9),

	LAVA(10),
	LAVA_BLOCK(11),

	SAND(12),
	GRAVEL(13),

	GOLD_ORE(14),
	IRON_ORE(15),
	COAL_ORE(16),

	LOG_OAK(17, 0),
	LOG_SPRUCE(17, 0),
	LOG_BIRCH(17, 0),
	LOG_JUNGLE(17, 0),

	LEAVES_OAK(18, 0),
	LEAVES_SPRUCE(18, 1),
	LEAVES_BIRCH(18, 2),
	LEAVES_JUNGLE(18, 3),

	SPONGE(19),

	GLASS(20),

	LAPIS_LAZULI_ORE(21),
	LAPIS_LAZULI_BLOCK(22),

	DISPENSER(23),

	WEB(30),

	WOOL(35),
	WOOL_WHITE(35, 0),
	WOOL_ORANGE(35, 1),
	WOOL_MAGENTA(35, 2),
	WOOL_LIGHT_BLUE(35, 3),
	WOOL_YELLOW(35, 4),
	WOOL_LIGHT_GREEN(35, 5),
	WOOL_PINK(35, 6),
	WOOL_DARK_GRAY(35, 7),
	WOOL_GRAY(35, 8),
	WOOL_CYAN(35, 9),
	WOOL_PURPLE(35, 10),
	WOOL_BLUE(35, 11),
	WOOL_BROWN(35, 12),
	WOOL_DARK_GREEN(35, 13),
	WOOL_RED(35, 14),
	WOOL_BLACK(35, 15),

	GOLD_BLOCK(41),
	IRON_BLOCK(42),

	MOBSPAWNER_BLOCK(52, 0),

	TNT(45),
	BOOKSELF(46),
	MOSS_STONE(47),
	OBSIDIAN(48),
	TORCH(49),
	FIRE(51),
	CHEST(54),
	WORKBENCH(58),
	FURNACE(61),

	SNOW_BLOCK(80),
	SNOW_CARPET(78),
	ICE(79),

	SUGAR_CANE(86),

	JUKEBOX(84),
	NETHER_RACK(87),
	SOUL_SAND(88),

	GLOWSTONE(89),

	NETHER_PORTAL_BLOCK(90),

	STONE_BRICK(98, 0),

	MELON_BLOCK(103),

	MICELIUM(110),
	NETHER_BLOCK(112),

	ENCHANTMENT_TABLE(116),
	BRUWING_STAND(117),

	NETHER_PORTAL(119),

	REDSTONE_LAMP(123),
	REDSTONE_LAMP_OFF(123),
	REDSTONE_LAMP_ON(124),

	ENDER_CHEST(130),

	EMERALD_BLOCK(133),

	ANVIL(145),

	REDSTONE_BLOCK(152),
	QUARTZ_ORE(153),
	DROPPER(154);

	private int id = 0;
	private int data = 0;

	private BlockType() {};

	private BlockType(final int id, final int data){
		this.id = id;
		this.data = data;
	};

	private BlockType(final int id){
		this.id = id;
		this.data = 0;
	};

	public void setNewData(int data) {
		this.data=data;
	};

	public int getBlockId() {
		return id;
	};

	public int getBlockData() {
		return data;
	};

}