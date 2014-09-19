package org.sthouch.api.server;

/**
 * <p></b>Aqui � onde fica os tipos de dificuldade disponiveis para o servidor.</b></p>
 * @author GabrielButarelo
 */
public enum GameDifficultyType {

	/**
	 * <p>Modo pacifico, jogador recupera vida muito rapido e n�o nasce monstros.</p>
	 * @author GabrielButarelo
	 */
	PEACEFUL(0), 
	
	/**
	 * <p>Modo facil, jogador recupera vida rapidamente ainda mas come�a a nascer pequenas quantidades de monstros pelo mapa.</p>
	 * @author GabrielButarelo
	 */
	EASY(1), 
	
	/**
	 * <p>Modo normal, jogador recupera vida normalmente e coem�a a aparecer monstros em quantidades maiores.</p>
	 * @author GabrielButarelo
	 */
	NORMAL(2), 
	
	/**
	 * <p>Modo dificil, jogador recupera vida muito lentamente e come�a a nascer muitos monstros.</p>
	 * @author GabrielButarelo
	 */
	HARD(3);
	
	@SuppressWarnings("unused")
	private final int GAME_DIFFICULTY;

	private GameDifficultyType(final int GAME_DIFFICULTY){
		this.GAME_DIFFICULTY = GAME_DIFFICULTY;
	}
	
}
