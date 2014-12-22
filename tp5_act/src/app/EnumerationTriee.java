package app;

import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * classe d’enumeration triee selon les poids décroissants
 * 
 * on utilisera par exemple une implémentation de la classe Comparator de java.util
 *
 */
public class EnumerationTriee implements EnumerationObjets {

	Integer obj[];
	int iterator;
	int length;

	public EnumerationTriee(Integer tab [], int nbObj){
		this.obj=tab;
		this.length = nbObj;
		this.iterator = 0;

		// Trier le tableau en ordre inverse
  		Arrays.sort(obj,Collections.reverseOrder());
 	 }

	public boolean hasMoreElements() {
		return iterator < length;
	}
	
	public int NextElement() {
		int i =obj[iterator];
		iterator++;
		return i;
	}
	
	public int sum() {
		int sum=0;
		for(int i=0;i<length;i++){
			sum+=obj[i];
		}
		return sum;
	}
}