package app;

/**
 * 
 * classe d’enumeration online
 *
 */
public class EnumerationOnline implements EnumerationObjets {

	Integer obj[];
	int iterator;
	int length;

	public EnumerationOnline(Integer tab[], int nbObj){
		this.obj = tab;
		this.length = nbObj;
		this.iterator = 0;	
	}
	
	public boolean hasMoreElements() {
		return iterator < length;
	}
	
	public int NextElement() {
		int i = obj[iterator];
		iterator++;
		return i;
	}
	
	public int sum(){
		int sum=0;
		for(int i=0;i<length;i++){
			sum+=obj[i];
		}
		return sum;
	}
}