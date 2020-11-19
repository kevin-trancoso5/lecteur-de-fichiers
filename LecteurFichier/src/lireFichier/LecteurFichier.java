package lireFichier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public abstract class LecteurFichier implements Readable {

	@Override
	public abstract boolean verifExtension(String filename);

	@Override
	public boolean verifFichier(String filename) {
		File f = new File(filename);
		try {
			FileInputStream in = new FileInputStream(f);
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("Fichier non-existant\n");
			return false;
		}
	};

	@Override
	public void lireFichier(String filename) {
		File f = new File(filename);
		ArrayList<String> lines = getLines(f);
		for (int i = 0; i < lines.size(); i++) {
			System.out.println(lines.get(i));
		}
	};

	@Override
	public void lireFichierReverse(String filename) {
		File f = new File(filename);
		ArrayList<String> lines = getLines(f);
		for (int i = lines.size() - 1; i >= 0; i--) {
			System.out.println(lines.get(i));
		}
	};

	@Override
	public void lireFichierPalindrome(String filename) {
		File f = new File(filename);
		ArrayList<String> lines = getLines(f);
		for (int i = lines.size() - 1; i >= 0; i--) {
			StringBuilder sb = (new StringBuilder(lines.get(i)).reverse());
			System.out.println(sb);
		}
	};

	@Override
	public void compareFichier(String filename1, String filename2) {
		boolean diffFound = false;
		File f = new File(filename1);
		File f2 = new File(filename2);
		ArrayList<String> lines1 = getLines(f);
		ArrayList<String> lines2 = getLines(f2);
		// PAS LE MEME NOMBRE DE LIGNES
		if (lines1.size() > lines2.size()) {
			System.out.println("Le fichier " + filename1 + " possède " + (lines1.size() - lines2.size())
					+ " lignes de plus que le fichier " + filename2);
			diffFound = true;
		} else if (lines2.size() > lines1.size()) {
			System.out.println("Le fichier " + filename2 + " possède " + (lines2.size() - lines1.size())
					+ " lignes de plus que le fichier " + filename1);
			diffFound = true;
		}
		// -ONT LE MEME NOMBRE DE LIGNES
		else {
			for (int i = 0; i < lines1.size(); i++) {
				if (lines1.get(i).length() > lines2.get(i).length()) {
					System.out.println("La ligne " + (i + 1) + " est plus longue de "
							+ (lines1.get(i).length() - lines2.get(i).length()) + " caractères sur le fichier "
							+ filename1);
					diffFound = true;
				} else if (lines2.get(i).length() > lines1.get(i).length()) {
					System.out.println("La ligne " + (i + 1) + " est plus longue de "
							+ (lines2.get(i).length() - lines1.get(i).length()) + " caractères sur le fichier "
							+ filename2);
					diffFound = true;
				} else {
					for (int j = 0; j < lines1.get(i).length(); j++) {
						if (lines1.get(i).charAt(j) != lines2.get(i).charAt(j)) {
							System.out.println("Le caractère ligne: " + (i + 1) + " position: " + (j + 1)
									+ " est différent sur les deux fichiers.");
							System.out.println(filename1 + ": " + lines1.get(i).charAt(j) + " | " + filename2 + ": "
									+ lines2.get(i).charAt(j));
							diffFound = true;
						}
					}
				}
			}
		}
		if (!diffFound) {
			System.out.println("Ces fichiers sont identiques");
		}
	};

	public ArrayList<String> getLines(File f) {
		FileInputStream in = null;
		ArrayList<String> lines = new ArrayList<String>();
		try {
			in = new FileInputStream(f);
			int content = 0;
			String result = "";
			do {
				try {
					content = in.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (content != -1) {
					if (content != 10 && content != 13) {
						result += (char) content;
					}
					if (content == 13) {
						lines.add(result);
						result = "";
					}
				}
			} while (content != -1);
			lines.add(result);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return lines;
	}

}
