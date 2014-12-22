import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solve {
	
	public static String getCommandLine() {
		return "solve <file> <mode>\n"+
				"Mode : \n" +
				"\t-v : verification mode\n"+
				"\t-nd : non-deterministe mode\n"+
				"\t-exh : ehaustif mode";
	}
	
	public static void main(String args[]) {
		
		if(args.length != 2) {
			System.out.println(getCommandLine());
			return;
		}
		
		Solve s = new Solve();
		PblBinPack pb = s.readFile(args[0]);
		
		System.out.println(pb.toString()+"\n\n");
		
		if(args[1].equals("-v")) {
			CertificatBinPack certificat = new CertificatBinPack(pb);
			certificat.saisie();
			System.out.println(certificat.correct() ? "Certificat Valide" : "Certificat invalide");
		}
		else if(args[1].equals("-nd")) {
			CertificatBinPack certificat = new CertificatBinPack(pb);
			certificat.alea();
			System.out.println(certificat.correct() ? "Certificat Valide" : "Certificat invalide");
		}
		else if(args[1].equals("-exh")) {
			System.out.println(pb.aUneSolution() ? "Probleme solvable" : "Probleme insolvable");
			
		}
		else {
			System.out.println(getCommandLine());
			return;
		}
	}
	
	public PblBinPack readFile(String filename) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			
			//read n
			int n = Integer.parseInt(reader.readLine());
			
			int[] obj = new int[n];
			
			for(int i=0; i<n; i++) {
				obj[i] = Integer.parseInt(reader.readLine());
			}
			
			int nSac = Integer.parseInt(reader.readLine());
			int cSac = Integer.parseInt(reader.readLine());
			
			reader.close();
			
			return new PblBinPack(n, obj, cSac, nSac);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}