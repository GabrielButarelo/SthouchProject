package org.sthouch.api.server;

/**
 * <p></b>Aqui é onde fica os tipos de dificuldade disponiveis para o servidor.</b></p>
 * @author GabrielButarelo
 */
public enum GameDifficultyType {

	/**
	 * <p>Modo pacifico, jogador recupera vida muito rapido e não nasce monstros.</p>
	 * @author GabrielButarelo
	 */
	PEACEFUL(0), 
	
	/**
	 * <p>Modo facil, jogador recupera vida rapidamente ainda mas começa a nascer pequenas quantidades de monstros pelo mapa.</p>
	 * @author GabrielButarelo
	 */
	EASY(1), 
	
	/**
	 * <p>Modo normal, jogador recupera vida normalmente e coemça a aparecer monstros em quantidades maiores.</p>
	 * @author GabrielButarelo
	 */
	NORMAL(2), 
	
	/**
	 * <p>Modo dificil, jogador recupera vida muito lentamente e começa a nascer muitos monstros.</p>
	 * @author GabrielButarelo
	 */
	HARD(3);
	
	@SuppressWarnings("unused")
	private final int GAME_DIFFICULTY;

	private GameDifficultyType(final int GAME_DIFFICULTY){
		this.GAME_DIFFICULTY = GAME_DIFFICULTY;
	}
	
}
