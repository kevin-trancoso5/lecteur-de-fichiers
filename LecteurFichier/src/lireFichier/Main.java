package lireFichier;

import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		String file = null;
		LecteurFichier lecteur = null;
		while (file == null) {
			lecteur = chooseExt(); //Choix de l'extension
			file = chooseFile(lecteur); //Choix du fichier
		}
		menu(lecteur, file); //Menu principal

	}

	static LecteurFichier chooseExt() {
		System.out.println("Quel sera le format de votre fichier?\n1.Txt\n2.HTML\n3.Markdown");
		int choiceExt = in.nextInt();
		LecteurFichier lecteur;
		switch (choiceExt) {
			case 1: {
				lecteur = new LecteurTxt();
				break;
			}
			case 2: {
				lecteur = new LecteurHTML();
				break;
			}
			case 3: {
				lecteur = new LecteurMD();
				break;
			}
			default: {
				lecteur = new LecteurTxt();
				break;
			}
		}
		return lecteur;
	}

	static String chooseFile(LecteurFichier lecteur) {
		System.out.println("\nEcrire le nom de fichier avec l'extension");
		String file = in.next();
		if (lecteur.verifFichier(file) && lecteur.verifExtension(file)) {
			return file;
		}
		return null;
	}

	static void menu(LecteurFichier lecteur, String file) {
		int choiceAct = 5;
		while (choiceAct > 0 && choiceAct < 6) {
			System.out.println("\nQue souhaitez vous faire avec " + file + "?");
			System.out.println(
					"1.Lire ce fichier\n2.Lire ce fichier à l'envers\n3.Lire le palindrome du fichier\n4.Comparer à un autre fichier\n5.Changer de fichier\n6.Quitter");
			choiceAct = in.nextInt();
			switch (choiceAct) {
				case 1:
					lecteur.lireFichier(file);
					break;
				case 2:
					lecteur.lireFichierReverse(file);
					break;
				case 3:
					lecteur.lireFichierPalindrome(file);
					break;
				case 4: {
					System.out.println("Veuillez sélectionner un deuxième fichier");
					String file2 = null;
					LecteurFichier lecteur2 = null;
					while (file2 == null) {
						lecteur2 = chooseExt();
						file2 = chooseFile(lecteur2);
					}
					lecteur.compareFichier(file, file2);
					break;
				}
				case 5: {
					file = null;
					lecteur = null;
					while (file == null) {
						lecteur = chooseExt();
						file = chooseFile(lecteur);
					}
					menu(lecteur, file);
					break;
				}
				case 6: {
					System.exit(0);
					break;
				}
				default: {
					break;
				}
			}
		}
	}

}
