import java.util.Random;
import java.util.Scanner;

public class CertificatBinPack implements Certificat {
	
	/**
	 * le problème associé au certificat
	 */
	private PblBinPack pb;
	
	/**
	 * data contient les objets 
	 * Chaque case contient le numéro du sac auquel l'objet est rangé
	 * Le 1er sac est le sac 0
	 * Le 1er objet est l'objet 0
	 */
	private int[] data;

	public CertificatBinPack(PblBinPack pb) {
		this.pb = pb;
		data = new int[this.pb.getNbObjet()];
		reset();
	}

	@Override
	public boolean correct() {
		int[] sacs = new int[pb.getNbSac()];
		for(int i=0; i<sacs.length; i++) {
			sacs[i] = 0;
		}
		
		
		for(int i=0; i<data.length; i++) {
			if(this.data[i] < 0 || this.data[i] >= pb.getNbSac())
				return false;
			
			sacs[this.data[i]] += pb.getPoids(i);
		}
		
		for(int i=0; i<sacs.length; i++) {
			if(sacs[i] > pb.getCapSac())
				return false;
		}

		return true;
	}

	@Override
	public void suivant() {
		for(int i=0; i<data.length; i++) {
			if(data[i] < pb.getNbSac()-1) {
				data[i]++;
				return;
			}
			else {
				if(data[i+1] < pb.getNbSac()-1) {
					for(int j=0; j<=i; j++) {
						data[i] = 0;
					}
					data[i+1]++;
					return;
				}
			}
		}
	}

	@Override
	public boolean estDernier() {
		for(int i=0; i<data.length; i++) {
			if(data[i] < pb.getNbSac()-1)
				return false;
		}
		return true;
	}

	@Override
	public void alea() {
		Random r = new Random();
		for(int i=0; i<data.length; i++) {
			data[i] = r.nextInt(pb.getNbSac());
			System.out.println("objet "+(i)+" dans sac "+data[i]);
		}
	}

	@Override
	public void affiche() {
		System.out.print("Cerfiticat ");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}

	@Override
	public void reset() {
		for(int i=0; i<data.length; i++)
			data[i] = 0;
	}

	@Override
	public void saisie() {
		Scanner sc = new Scanner(System.in);
		int[] data = new int[pb.getNbObjet()];
		for(int i=0; i<data.length; i++) {
			System.out.println("Sac objet "+(i+1)+" : ");
			try {
				this.data[i] = sc.nextInt();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
	}
}