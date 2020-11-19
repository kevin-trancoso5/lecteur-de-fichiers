package lireFichier;

public class LecteurHTML extends LecteurFichier {

	public boolean verifExtension(String filename) {
		if (filename.endsWith(".html"))
			return true;
		System.out.println("Erreur: Le fichier n'a pas l'extension attendue.\n");
		return false;
	}
}
