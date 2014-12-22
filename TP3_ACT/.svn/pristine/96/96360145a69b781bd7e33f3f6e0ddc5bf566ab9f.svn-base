import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reduction {
	
	private int[] palette;
	private int[] poids;
	private List<Interval> intervals;
	private Map<Integer, Integer> palette_tmp;
	private String new_pgm_datas = null;
	private String[][] init_pgm_values = null;
	
	public Reduction(int[] poids, int[] palette) {
		this.palette = palette;
		this.poids = poids;
		this.intervals = new ArrayList<Interval>();
		this.palette_tmp = new HashMap<Integer, Integer>();
	}

	public Reduction() {
		this.intervals = new ArrayList<Interval>();
		this.palette_tmp = new HashMap<Integer, Integer>();
	}

	/**
	 * Renvoi le meileur gris pour un intervalle donné
	 * @param debut
	 * @param fin
	 * @return
	 */
	public int meilleurGris(int debut, int fin) {
		int tmp = 0, tmp2 = 0;
		for(int i=debut; i<=fin; i++) {
			tmp += poids[i] * palette[i];
			tmp2 += poids[i];
		}
		return tmp / tmp2;
	}
	
	/**
	 * Renvoi la distance minimale pour une réduction de n à 1 couleur
	 * @param debut
	 * @param fin
	 * @return
	 */
	public int distanceMin(int debut, int fin){
		int meilleurGris = meilleurGris(debut, fin);
		int distanceMin = 0;
		for (int i = debut; i<=fin; i++){
			distanceMin += Math.pow((palette[i]-meilleurGris), 2.0) * poids[i]; 
		}
		return distanceMin;
	}
	
	/**
	 * Fonction récursive qui renvoie la distance minimale pour une réduction de n à k couleurs
	 * @param debut
	 * @param k
	 * @return
	 */
	public int decomposeRec(int debut, int k) {
		int distance = 0, distanceRet = -1;
		if (k == 1) {
			return distanceMin(debut, palette.length-1);
		}
		for (int i = debut ; i < palette.length-1 ; i++) {
			distance = distanceMin(debut, i) + decomposeRec(i+1, k-1);
			if (distanceRet == -1 || distance < distanceRet) {
				distanceRet = distance;
			}
		}
		return distanceRet;
	}
	
	/**
	 * Fonction itérative respectant le principe de la programmation dynamique
	 * @param debut
	 * @param k
	 * @return
	 */
	public int decomposeIt(int debut, int k) {
		int[][] res = new int[k][palette.length];
		
		// Initialisation du tableau pour les cas de base
		for (int i = 0; i < palette.length; i++) {
			res[0][i] = distanceMin(i, palette.length-1);
		}
		for (int i = 1; i < k; i++) {
			for (int j = 0; j < palette.length; j++) {
				res[i][j] = -1;
			}
		}
		// Remplissage du tableau 
		if(k > 1) {
			for (int q=1; q<k; q++) {
				for (int i=debut; i<=palette.length-(q+1); i++) {
					int distance = 0;
					for (int j=i; j<=palette.length-(q+1); j++) {
						distance = distanceMin(i, j) + res[q-1][j+1];
						if(res[q][i] == -1 || distance < res[q][i]) {
							res[q][i] = distance;
							/*
							 *  Ajout des intervalles correspondant
							 */
							if((i == debut) && (q == (k-1))) {
								this.intervals.clear();
								int fst = debut;
								int snd = 0;
								for (int p=(k-1); p>0; p--) {
									for (int r=fst; r<res[p-1].length; r++) {
										if(res[p][fst] < res[p-1][r]) {
											snd++;
										} else {
											this.intervals.add(new Interval(fst,snd-1));
											break;
										}
									}
									fst = snd;
								}
								this.intervals.add(new Interval(snd,this.palette.length-1));
							}
						}
					}
				}				
			}			
		}	
		return res[k-1][debut];
	}
	
	/**
	 * Charge une image PGM et rempli la palette et les poids
	 * @param nomFichier
	 */
	public void loadPGMFile(final String nomFichier) {
		try {
			// Déclaration de variables
			BufferedReader lecteur = new BufferedReader(new FileReader(nomFichier));
			BufferedReader parcours = new BufferedReader(new FileReader(nomFichier));
			String line;	
			int i = 1;
			int j = 0;			
			String[] datas;
			Integer val = 0;
			int nbLignes = 0;
			
			// Identification nombre de lignes du fichier PGM
			while ((line = parcours.readLine()) != null) {
				nbLignes++;
			}
			parcours.close();
			
			// Lecture du fichier PGM
			while ((line = lecteur.readLine()) != null) {
				if (i == 1){
					new_pgm_datas = line + "\n";
				} else if (i == 2){
					init_pgm_values = new String[nbLignes-3][];
					new_pgm_datas += line + "\n";
				} else if (i == 3) {
					new_pgm_datas += line + "\n";
				} else {
					datas = line.split(" ");
					init_pgm_values[j] = new String[datas.length];
					init_pgm_values[j++] = datas;
					
					
					for(String data : datas) {
						int key = Integer.parseInt(data);
						if (!this.palette_tmp.containsKey(key)) {
							this.palette_tmp.put(key, 1);
						} else {
							val = this.palette_tmp.get(key);
							this.palette_tmp.remove(key);
							this.palette_tmp.put(key, val + 1);
						}
					}
					
					
				}
				i++;
			}
			
			// On tri les gris de la palette
			List<Integer> l = new ArrayList<Integer>(this.palette_tmp.keySet());
			Collections.sort(l);
			
			int[] palette_init = new int[l.size()];
			int[] poids_init = new int[l.size()];
			
			for(int p=0; p<l.size(); p++) {
				palette_init[p] = l.get(p);
				poids_init[p] = this.palette_tmp.get(l.get(p));
			}
			
			// Création de la palette et des poids
			this.setPalette(palette_init);
			this.setPoids(poids_init);
			
			lecteur.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	/**
	 * Réduction de la palette et création des intervales
	 * @param debut
	 * @param nbColor
	 */
	public void reducePalette(final int debut, final int nbColor) {
		// Réduction de la palette et identification des intervales
		this.decomposeIt(debut, nbColor);
		
		int cpt = 1;
		System.out.println("Liste des intervales :");
		for(Interval intervalle : this.getIntervals()) {
			System.out.println(cpt++ + " : " + intervalle.getFst() + " à " + intervalle.getSnd());
		}
	}
	
	/**
	 * Crée l'image de sortie
	 * @param resultat
	 * @param debut
	 * @param nbColor
	 */
	public void makePicture(final String resultat) {
		try {
			BufferedWriter ecriture = new BufferedWriter(new FileWriter(resultat));
			int value = 0;
			int fst_interval_value = 0;
			int snd_interval_value = 0;
			
			int[] new_palette = new int[this.getIntervals().size()];
			
			for(int i=0; i<this.getIntervals().size(); i++) {
				new_palette[i] = this.meilleurGris(this.getIntervals().get(i).getFst(), this.getIntervals().get(i).getSnd());
			}
			
			for (int i=0 ; i<init_pgm_values.length; i++) {
				for (int j=0; j<init_pgm_values[i].length; j++) {
					value = Integer.parseInt(init_pgm_values[i][j]);
					for (int k=0; k<this.getIntervals().size(); k++) {
						fst_interval_value = this.palette[this.getIntervals().get(k).getFst()];
						snd_interval_value = this.palette[this.getIntervals().get(k).getSnd()];
						if (value >= fst_interval_value && value <= snd_interval_value) {
							new_pgm_datas += ""+new_palette[k]+" ";
							break;
						}
					}
				}
				new_pgm_datas += "\n";
			}
			
			ecriture.write(new_pgm_datas);
			ecriture.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public List<Interval> getIntervals() {
		return intervals;
	}

	public int[] getPalette() {
		return palette;
	}

	public void setPalette(int[] palette) {
		this.palette = palette;
	}

	public int[] getPoids() {
		return poids;
	}

	public void setPoids(int[] poids) {
		this.poids = poids;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long fstTime = System.currentTimeMillis();
		
		if(args.length < 3) {
			System.out.println("Utilisation du programme : \n\tjava -jar reduction.jar <fichier_d_entree> <fichier_de_sortie> <nb_de_couleur> [<debut>]");
			System.out.println("Exemple : java -jar reduction.jar baboon_gray.pgm sortie.pgm 3");
			System.exit(0);
		}
		
		String fichier_entree = args[0];
		String fichier_sortie = args[1];
		int nbColor = Integer.parseInt(args[2]);
		int debut = 0;
		
		if(args.length > 3) {
			debut = Integer.parseInt(args[3]);
		}
		
		Reduction r = new Reduction();
		
		// Chargement du fichier PGM et initialisation de la palette et des poids
		r.loadPGMFile(fichier_entree);
		
		// Réduction de la palette
		r.reducePalette(debut, nbColor);
		
		System.out.println("\nCela peut prendre quelques minutes, veuillez patienter...");
		
		// Ecriture de la nouvelle image
		r.makePicture(fichier_sortie);
		
		long sndTime = System.currentTimeMillis();
		
		int secondes = (int) (sndTime - fstTime) / 1000;
		int minute = secondes / 60;
		secondes = secondes % 60;
		
		System.out.println("\nProgramme exécuté en " + minute + " mn " + secondes + " s");
	}

}
