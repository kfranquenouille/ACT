interface Certificat {
	
	/**
	 * retourne True SSi le certificat est valide pour le problème
	 * doit être de complexité polynomiale par rapport à la taille du certificat
	 * et du problème
	 * algo de vérification A de la définition NP du cours !
	 * @return
	 */
	public boolean correct();

	/**
	 * transforme le certificat en son successeur pour l’ordre
	 * pour l’énumération on utilisera un ordre total sur les certificats
	 * par ex. le constructeur initialisera au plus petit élément
	 */
	public void suivant();

	/**
	 * Le dernier certificat est tous les objets dans le dernier sac
	 * 
	 * @return True Ssi le certificat n’a pas de successeur pour l’ordre
	 */
	public boolean estDernier();

	/**
	 * modifie aléatoirement la valeur du certificat
	 * chaque valeur doit pouvoir être générée par au moins une exécution
	 */
	public void alea();

	/**
	 * affiche un certificat
	 */
	public void affiche();

	/**
	 * réinitialise le certificat au plus petit pour l’ordre
	 * C'est à dire, tous les objets dans le 1er sac
	 */
	public void reset();

	/**
	 * permet la saisie d’un certificat
	 */
	public void saisie();
}