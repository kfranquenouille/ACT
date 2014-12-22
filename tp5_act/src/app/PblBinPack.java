package app;

import java.io.File;
import java.util.Scanner;

public class PblBinPack extends Pbl {

	public int nbobjets; 	// nb d’objets
	public Integer poids[]; 	// poids des objets
	public int cap; 		// capacité d’un sac

	public PblBinPack(String fileName) {

		try {
			Scanner scanner = new Scanner(new File(fileName));
			int i=0;

			nbobjets = Integer.parseInt(scanner.nextLine().trim());
			cap = Integer.parseInt(scanner.nextLine().trim());
			poids = new Integer[nbobjets];
			
			// on lit le fichier
			while (scanner.hasNextLine()) {
				poids[i++] = Integer.parseInt(scanner.nextLine().trim());
			}
			
			System.out.println("nbObj = " + nbobjets + ", Capacité = "
					+ cap + ".");
			
			scanner.close();
		} 
		catch(NumberFormatException e) {			
			System.out.println("Error : " + e.getMessage()
					+ " Attention syntax fichier incorrect");
		}
		catch(Exception e) {
			System.out.println("fail : Problème de fichiers : " + e.getMessage());
		}
	}

	public int getCap() {
		return cap;
	}

	public int getNbobjets() {
		return nbobjets;
	}

	public Integer[] getPoids() {
		return poids;
	}
}