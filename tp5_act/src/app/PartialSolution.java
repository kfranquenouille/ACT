package app;

/**
 *  Interface des solutions partielles 
 */
public interface PartialSolution {
	
	/**
	 * solution est complete!
	 * @return
	 */
	public boolean complete(); 
	
	/**
	 * affichage
	 */
	public void display(); 
	
	/**
	 * Heuristique qui ajoute chaque objet dans le prochain sac possible (NextFit) pour BinPack
	 * @param obj
	 */
	public void addNextFit(int obj);
	
	/**
	 * Heuristique qui ajoute chaque objet dans le premier sac possible (FirstFit) pour BinPack
	 * @param obj
	 */
	public void addFirstFit(int obj);
	
	/**
	 * Heuristique qui ajoute chaque objet dans le meilleur sac possible (BestFit) pour BinPack
	 * @param obj
	 */
	public void addBestFit(int obj);
}