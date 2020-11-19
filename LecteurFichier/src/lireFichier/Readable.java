package lireFichier;


public interface Readable {
	
	boolean verifFichier(String filename);
	
	boolean verifExtension(String filename);
	
	void lireFichier(String filename);
	
	void lireFichierReverse(String filename);

	void lireFichierPalindrome(String filename);
	
	void compareFichier(String filename1, String filaname2);
	
}
