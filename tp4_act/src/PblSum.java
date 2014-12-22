public class PblSum extends PblDec {

	private int [] in;
	private int c;
	private int nbSousEnsemble;
	
	public PblSum(int[] in, int c, int nbSousEnsemble) {
		super();
		this.in = in;
		this.c = c;
		this.nbSousEnsemble = nbSousEnsemble;
	}
	
	/**
	 * associe à l’instance de PblPartition une instance équivalente de PblBinPAck 
	 * doit être de complexité polynomiale
	 * @return
	 */
	public PblPartition redPolyTo(){
		return new PblPartition(in, c, nbSousEnsemble);
	}

	@Override
	public boolean aUneSolution() {
		return redPolyTo().aUneSolution();
	}

}