package app;

/**
 * classe du parcoureur de solution pour bin_packing selon un critère glouton XX
 * 
 * et avec choix de l’énumération
 */
public class SolutionWalkerBinPackXX extends SolutionWalkerBinPack {

	/**
	 * on peut passer en en parametre: deux énumérations ici:
	 * online et par poids décroissants
	 * on peut aussi simplement construire le probleme avec objets tries au depart.... 
	 * 
	 * @param pbl Le problème
	 * @param en Le type d'énumération
	 */
	public SolutionWalkerBinPackXX(EnumerationObjets en) {
		this.setEnumeration(en);
	}

	public static void main (String args[]) {
		PblBinPack pb;
		EnumerationObjets enum1;
		EnumerationObjets enum2;
		SolutionWalkerBinPack solBinPack;
		SolutionWalkerBinPack solPartition;
		try {
			pb = new PblBinPack(args[0]);			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.print("Il manque le nom de fichier");
			return;
		}
		
		if(args.length < 2) {
			enum1 = new EnumerationOnline(pb.getPoids(),pb.getNbobjets());
			enum2 = new EnumerationOnline(pb.getPoids(),pb.getNbobjets());
		} else {
			if(args[1].equals("-on")) {
				enum1 = new EnumerationOnline(pb.getPoids(),pb.getNbobjets());
				enum2 = new EnumerationOnline(pb.getPoids(),pb.getNbobjets());
			}
			if(args[1].equals("-off")) {
				enum1 = new EnumerationTriee(pb.getPoids(), pb.getNbobjets());
				enum2 = new EnumerationOnline(pb.getPoids(),pb.getNbobjets());
			} else {
				System.out.print("Argument invalide");
				return;
			}			
		}
		// Problème de BinPack
		solBinPack = new SolutionWalkerBinPackXX(enum1);
		solBinPack.setPartialSolution(new PartialSolutionBinPack(pb, enum1));
		
		// Prolème de Partition
		solPartition = new SolutionWalkerBinPackXX(enum2);
		solPartition.setPartialSolution(new PartialSolutionPartition(pb, enum2));
		
		// On démarre les deux problèmes
		solBinPack.run();
		solPartition.run();
	}
}