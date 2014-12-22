public class Interval {
    private int first;
    private int second;

    public Interval(int first, int second) {
    	this.first = first;
    	this.second = second;
    }

    public int getFst() {
    	return first;
    }

    public void setFst(int first) {
    	this.first = first;
    }

    public int getSnd() {
    	return second;
    }

    public void setSnd(int second) {
    	this.second = second;
    }
    
   /* public int hashCode() {
    	int hashFirst = first != null ? first.hashCode() : 0;
    	int hashSecond = second != null ? second.hashCode() : 0;

    	return (hashFirst + hashSecond) * hashSecond + hashFirst;
    }*/

    /*public boolean equals(Object other) {
    	if (other instanceof Intervalle) {
    		Intervalle<A, B> otherPair = (Intervalle<A, B>) other;
    		return 
    		((  this.first == otherPair.first ||
    			( this.first != null && otherPair.first != null &&
    			  this.first.equals(otherPair.first))) &&
    		 (	this.second == otherPair.second ||
    			( this.second != null && otherPair.second != null &&
    			  this.second.equals(otherPair.second))) );
    	}

    	return false;
    }*/

    /*public String toString()
    { 
           return "(" + first + ", " + second + ")"; 
    }*/
}
