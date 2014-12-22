import java.util.Arrays;


public class ACT_TP2 {
	
	/**
	 * Permet de normaliser une liste par rapport à une autre
	 * 
	 * @param model sur lequel on se base
	 * @param liste qu'on souhaite normaliser
	 * @return la liste normalisée de liste par rapport au model
	 * @throws Exception dans le cas où les 2 listes sont de tailles différentes
	 */
	public int[] normalize (final int[] model, final int[] liste) throws Exception{
		if (model.length != liste.length){
			throw new Exception("Les tailles sont différentes");
		} else {
			int[] temporaire = new int[model.length];
			int[] resultat = new int [liste.length];
			
			for (int i=0; i<temporaire.length; i++){
				temporaire[model[i]] = i;
			}
			
			for (int i=0; i<resultat.length; i++){
				resultat[i] = temporaire[liste[i]];
			}
			return resultat;
		}
	}
	
	/**
	 * Calcul le nombre d'inversions dans une liste normalisée
	 * 
	 * @param liste normalisée
	 * @return le nombre d'inversions
	 */
	public int nombreInversions(final int[] liste){
		int compteur=0;
		for (int i=0; i<liste.length; i++){
			for (int j=i+1; j<liste.length; j++){
				if(liste[i] > liste[j]) {
					compteur++;
				}
			}
		}
		return compteur;
	}
	
	public int nombreInversionsAmeliore(final int[] liste){
		int nombreInversions = 0;
		
		if (liste.length < 2){
			return 0;
		}else if (liste.length == 2){
			if (liste[0] < liste[1]){
				return 1;
			} else {
				return 0;
			}
		}
		
		int[] moitieBasse = Arrays.copyOfRange(liste, 0, liste.length/2);
		int[] moitieHaute = Arrays.copyOfRange(liste, liste.length/2, liste.length);
		
		nombreInversions += nombreInversionsAmeliore(moitieBasse);
		nombreInversions += nombreInversionsAmeliore(moitieHaute);
		
		int parcoursTab1 = 0;
		int parcoursTab2 = 0;
		
		for(int i=0; i<liste.length; i++) {
			if(parcoursTab2 >= moitieHaute.length) {
				liste[i] = moitieBasse[parcoursTab1++];
				nombreInversions += moitieHaute.length-parcoursTab2;
			}
			else if(parcoursTab1 >= moitieBasse.length) {
				liste[i] = moitieHaute[parcoursTab2++];
			}
			else if(moitieBasse[parcoursTab1] < moitieHaute[parcoursTab2]) {
				liste[i] = moitieBasse[parcoursTab1++];
			}
			else {
				liste[i] = moitieHaute[parcoursTab2++];
				
				if(parcoursTab1 < moitieBasse.length) {
					nombreInversions += moitieBasse.length-parcoursTab1;
				}
			}
		}
		
		return nombreInversions;
	}
	
	public static void main(String[] args) {
		
		final int[] A = {0, 3, 5, 1, 4, 2};
		final int[] B = {2, 4, 3, 1, 5, 0};
		final int[] C = {0, 5, 1, 3, 4, 2};
		
		ACT_TP2 tp = new ACT_TP2();
		
		try {
			int[] resultatAtoB = tp.normalize(A, B);
			System.out.println("--------- Normalisation de B par rapport à A ---------");
			for (int i=0; i<resultatAtoB.length; i++){
				System.out.print(resultatAtoB[i]+" ");
			}
			int[] resultatAtoC = tp.normalize(A, C);
			System.out.println("\n--------- Normalisation de C par rapport à A ---------");
			for (int i=0; i<resultatAtoC.length; i++){
				System.out.print(resultatAtoC[i]+" ");
			}
			
			System.out.println("\n--------- Nombre d'inversions de B par rapport à A ---------");
			System.out.println(tp.nombreInversions(resultatAtoB));
			
			System.out.println("\n--------- Nombre d'inversions de B par rapport à A ---------");
			System.out.println(tp.nombreInversionsAmeliore(resultatAtoB));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
