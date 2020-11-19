package lireFichier;

public class LecteurTxt extends LecteurFichier {

	public boolean verifExtension(String filename) {
		if (filename.endsWith(".txt"))
			return true;
		System.out.println("Erreur: Le fichier n'a pas l'extension attendue.\n");
		return false;
	}

}
