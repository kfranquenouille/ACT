package app;

public class PartialSolutionPartition implements PartialSolution {

	// Bin Pack pb
	PblBinPack pb;
	EnumerationObjets e;

	// partition pb
	int[][] partBag;
	int[] rest = { 0, 0, 0 };
	int middleSum;

	public PartialSolutionPartition(PblBinPack pb, EnumerationObjets e) {
		this.pb = pb;
		this.e = e;

		// partition pb
		this.partBag = new int[3][2];
		this.middleSum = (this.e.sum()) / 2;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				partBag[i][j] = 0;
			}
		}
	}

	@Override
	public boolean complete() {
		return !e.hasMoreElements();
	}

	@Override
	public void display() {
		System.out.println("Partition : \n poids :" + this.middleSum);
		System.out.println(" next  : " + this.partBag[0][0] + ","
				+ this.partBag[0][1] + " - reste  : " + this.rest[0]);
		System.out.println(" first  : " + this.partBag[0][0] + ","
				+ this.partBag[0][1] + " - reste  : " + this.rest[1]);
		System.out.println(" best  : " + this.partBag[0][0] + ","
				+ this.partBag[0][1] + " - reste  : " + this.rest[2]);
	}

	@Override
	public void addNextFit(int i) {
		if ((this.partBag[0][0] + i) < this.middleSum) {
			this.partBag[0][0] += i;
		} else if ((this.partBag[0][1] + i) < this.middleSum) {
			this.partBag[0][1] += i;
		} else {
			this.rest[0] += i;
		}
	}

	@Override
	public void addFirstFit(int i) {
		if ((this.partBag[0][0] + i) < this.middleSum) {
			this.partBag[0][0] += i;
		} else if ((this.partBag[0][1] + i) < this.middleSum) {
			this.partBag[0][0] += i;
		} else {
			this.rest[1] += i;
		}
	}

	@Override
	public void addBestFit(int i) {
		if ((this.partBag[0][0] + i) < this.middleSum) {
			this.partBag[0][0] += i;
		} else if ((this.partBag[0][1] + i) < this.middleSum) {
			this.partBag[0][0] += i;

		} else {
			this.rest[2] += i;
		}
	}
}