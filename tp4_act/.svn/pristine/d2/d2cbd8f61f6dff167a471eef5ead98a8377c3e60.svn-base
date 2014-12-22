import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class SolvePartition {
	
	public static String getCommandLine() {
		return "solve <file>\n";
	}
	
	public static void main(String args[]) {
		
		if(args.length < 1) {
			System.out.println(getCommandLine());
			return;
		}
		
		PblPartition probleme = readFile(args[0]);
		
		if(probleme.aUneSolution()) {
			System.out.println("Il existe une solution !");
		}
		else  {
			System.out.println("Il n'y a pas de solution !");
		}
		
	}
	
	public static PblPartition readFile(String filename) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			
			//read n
			int n = Integer.parseInt(reader.readLine());
			
			int[] obj = new int[n];
			for(int i=0; i<n; i++) {
				obj[i] = Integer.parseInt(reader.readLine());
			}
			
			reader.close();
			
			int total = 0;
			for(int i=0; i<obj.length; i++)
				total += obj[i];
			
			return new PblPartition(obj, total/2, n);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
