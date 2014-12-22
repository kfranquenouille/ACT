package app;

/**
 * L’objet "constructeur de solutions partielles"
 * 
 * construit une solution de facon incrémentale
 * 
 * peut etre vu comme un "walker" dans un arbre de solutions partielles
 * 
 * à la création il est à la racine;
 * 
 * à chaque pas, passe à un noeud voisin selon un critère dépendant de l’heuristique choisie
 * 
 * la balade est terminée quand la solution est complète
 * 
 *  interface du parcoureur de solutions
 */
public interface SolutionWalker {
	
	/**
	 * la solution courante est complete
	 * @return
	 */
	public boolean Terminated();
	
	/**
	 * passe a UNE solution suivante
	 */
	public void NextPartialSolution();
	
	/**
	 * la solution courante
	 * @return
	 */
	public PartialSolution Current();
	
	/**
	 * Démarre toutes les heuristiques
	 */
	public void run();
}