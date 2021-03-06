package app;

import java.util.ArrayList;
import java.util.List;

/**
 * classe des solutions partielles pour BinPacking
 * 
 * attention: pour représenter une solution partielle privilégiez la simplicité!
 * 
 * doit contenir des méthodes pour prolonger une solution: affecter un sac à un
 * objet, ...
 */
public class PartialSolutionBinPack implements PartialSolution {

	// Bin Pack pb
	PblBinPack pb;
	EnumerationObjets e;
	List<Integer> nxt, frst, bst;
	int[] currents = { 0, 0, 0 };
	// poids max des sacs
	int max;

	public PartialSolutionBinPack(PblBinPack pb, EnumerationObjets e) {
		this.pb = pb;
		this.e = e;

		// BinPackPb
		this.nxt = new ArrayList<Integer>();
		this.frst = new ArrayList<Integer>();
		this.bst = new ArrayList<Integer>();

		this.max = pb.getCap();
	}

	@Override
	public boolean complete() {
		return !e.hasMoreElements();
	}

	@Override
	public void display() {
		System.out.println("BinPack :");
		System.out.println(" next  : " + this.nxt.size() + "\n first : "
				+ this.frst.size() + "\n best  : " + this.bst.size());
	}

	@Override
	public void addNextFit(int obj) {
		if (this.nxt.size() == 0) {
			this.nxt.add(0);
			currents[0] = nxt.size() - 1;
		}
		if ((this.nxt.get(currents[0])) + obj > max) {
			this.nxt.add(0);
			currents[0] = nxt.size() - 1;

		}
		int tmp = this.nxt.get(currents[0]) + obj;
		this.nxt.remove(currents[0]);
		this.nxt.add(currents[0], tmp);
	}

	@Override
	public void addFirstFit(int obj) {
		boolean done = false;
		int bag = 0;

		if (this.frst.size() == 0) {
			this.frst.add(0);
			currents[1] = frst.size() - 1;
		}

		if ((this.frst.get(currents[1])) + obj > max) {
			for (int i = 0; i < frst.size(); i++) {

				if ((this.frst.get(i)) + obj <= max && !done) {
					done = true;
					bag = i;

				}

			}
			if(!done) {
				this.frst.add(0);
				currents[1] = frst.size() - 1;
			} else {
				currents[1] = bag;
			}
		}
		int tmp = this.frst.get(currents[1]) + obj;
		this.frst.remove(currents[1]);
		this.frst.add(currents[1], tmp);
		currents[1] = frst.size() - 1;
	}

	@Override
	public void addBestFit(int obj) {
		boolean done = false;
		int bag = 0;
		int gap = -1;

		if (this.bst.size() == 0) {
			this.bst.add(0);
			currents[2] = bst.size() - 1;
		}

		if ((this.bst.get(currents[2])) + obj > max) {
			for (int i = 0; i < bst.size(); i++) {
				if ((this.bst.get(i)) + obj <= max) {
					if (gap == -1) {
						done = true;
						gap = max - ((this.bst.get(i)) + obj);
						bag = i;
					}
					if (gap > max - ((this.bst.get(i)) + obj)) {

						gap = max - ((this.bst.get(i)) + obj);
						bag = i;
					}
				}
			}
			if (!done) {
				this.bst.add(0);
				currents[2] = bst.size() - 1;
			} else {
				currents[2] = bag;
			}
		}
		int tmp = this.bst.get(currents[2]) + obj;
		this.bst.remove(currents[2]);
		this.bst.add(currents[2], tmp);
		currents[2] = bst.size() - 1;
	}
}