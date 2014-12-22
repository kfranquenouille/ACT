public class PblPartition extends PblDec {
	
	private int [] in;
	private int somme;
	private int nbSousEnsemble;
	
	public PblPartition(int[] in, int somme, int nbSousEnsemble) {
		super();
		this.in = in;
		this.somme = somme;
		this.nbSousEnsemble = nbSousEnsemble;
	}

	/**
	 * associe à l’instance de PblPartition une instance équivalente de PblBinPAck 
	 * doit être de complexité polynomiale
	 * @return
	 */
	public PblBinPack redPolyTo(){
		return new PblBinPack(in.length, in, somme, nbSousEnsemble);
	}

	@Override
	public boolean aUneSolution() {
		return redPolyTo().aUneSolution();
	}
}