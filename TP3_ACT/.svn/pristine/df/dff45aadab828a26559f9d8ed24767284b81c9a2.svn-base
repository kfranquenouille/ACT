
public class Reduction {
	
	public int distanceMin(int[] poids, int[] gris, int debut, int fin, int meilleurGris){
		int distanceMin = 0;
		for (int i = debut; i<=fin; i++){
			distanceMin += Math.pow((gris[i]-meilleurGris), 2.0) * poids[i]; 
		}
		return distanceMin;
	}

	public int meilleurGris(int[] poids, int[] gris, int debut, int fin) {
		int tmp = 0, tmp2 = 0;
		for(int i=debut; i<=fin; i++) {
			tmp += poids[i] * gris[i];
			tmp2 += poids[i];
		}
		return tmp / tmp2;
	}
	
	public int[] reduction(final int[] poids, final int[] palette, final int k){
		int[][] reduction = new int[palette.length][palette.length];
		for(int i = 0; i< palette.length; i++){
			for (int j = i+1; j< palette.length; j++){
				reduction[i][j] = distanceMin(poids, palette, i, j, meilleurGris(poids, palette, i, j));
				System.out.print(reduction[i][j]+"-");
			}
			System.out.println();
		}
		
		
		return null;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] poids  = {5,5,1,1,2,1,10};
		int[] gris  = {0,20,100,132,164,180,255};
		Reduction r = new Reduction();
		
		System.out.println("meilleurGris :" + r.meilleurGris(poids, gris, 2, 5));
		System.out.println("distance min de 0 à 1 :" + r.distanceMin(poids, gris, 0, 1, r.meilleurGris(poids, gris, 0, 1)));
		r.reduction(poids, gris, 3);
	}

}
