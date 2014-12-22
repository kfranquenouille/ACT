package app;

/**
 * 
 * classe abstraite du parcoureur de solution pour BinPacking
 *
 */
public abstract class SolutionWalkerBinPack implements SolutionWalker {

	PartialSolution ps;
	EnumerationObjets e;

	@Override
	public boolean Terminated() {
		return this.ps.complete();
	}

	@Override
	public void NextPartialSolution() {
		//implémenter selon le critère glouton!
		int i = e.NextElement();	
		ps.addNextFit(i);
		ps.addFirstFit(i);
		ps.addBestFit(i);
	}

	@Override
	public PartialSolution Current() {
		return this.ps;
	}
	
	@Override
	public void run() {
		// tant qu'il y a des objets à parcourir
		while(! this.Terminated()) {
     		this.NextPartialSolution();	
		}
		this.Current().display();
	}

	public void setPartialSolution(PartialSolution ps) {
		this.ps = ps;
	}

	public void setEnumeration(EnumerationObjets e) {
		this.e = e;
	}
}