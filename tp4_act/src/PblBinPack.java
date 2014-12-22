import java.util.Arrays;

public class PblBinPack extends PblDec {

	private int nbObjet; //nb d’objets
	private int poids[]; //poids des objets
	private int capSac; //capacité du sac
	private int nbSac; //nb de sacs
	private CertificatBinPack certificat;

	public PblBinPack(int n, int p[], int c, int nbs) {
		super();
		this.nbObjet = n;
		this.poids = p;
		this.capSac= c;
		this.nbSac = nbs;
		certificat = new CertificatBinPack(this);
	}

	public boolean aUneSolution() {
		while ( ! certificat.estDernier() ) {
			certificat.affiche();
			if ( certificat.correct() ) {
				return true;
			}
			certificat.suivant();
		}
		return false;
	}

	/**
	 * teste au hasard une mise en sachets et retourne Vrai si elle est valide 
	 * chaque mise en sachets doit pouvoir être générée par une exécution
	 * @return
	 */
	public boolean aUneSolutionNonDéterministe() {
		certificat.alea();
		return certificat.correct();
	}

	public int getNbObjet() {
		return nbObjet;
	}

	public void setNbObjet(int nbObjet) {
		this.nbObjet = nbObjet;
	}

	public int getPoids(int i) {
		return poids[i];
	}

	public void setPoids(int[] poids) {
		this.poids = poids;
	}

	public int getCapSac() {
		return capSac;
	}

	public void setCapSac(int capSac) {
		this.capSac = capSac;
	}

	public int getNbSac() {
		return nbSac;
	}

	public void setNbSac(int nbSac) {
		this.nbSac = nbSac;
	}

	public CertificatBinPack getCertificat() {
		return certificat;
	}

	public void setCertificat(CertificatBinPack certificat) {
		this.certificat = certificat;
	}

	@Override
	public String toString() {
		return "nbObjet\t= " + nbObjet + ",\npoids\t= "
				+ Arrays.toString(poids) + ",\nnbSac\t= " + nbSac + ",\ncapSac\t= "
				+ capSac;
	}
}