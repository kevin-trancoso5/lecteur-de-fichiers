package lireFichier;

public class LecteurMD extends LecteurFichier {

	public boolean verifExtension(String filename) {
		if (filename.endsWith(".md"))
			return true;
		System.out.println("Erreur: Le fichier n'a pas l'extension attendue.\n");
		return false;
	}
}