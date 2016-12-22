import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class l4CodeEx {
	static String line;
	static ArrayList<String> wordArrayList = new ArrayList<>();

	public static void main(String[] args) {
		String userString = JOptionPane.showInputDialog("Enter a word.");
		String sorted = toAnagramForm(userString);

		// Read a word from the file
		// pass word into 'toAnagramForm()'
		// compare word to userString in anagram form
		// if match display on JOptionPane window
		try (BufferedReader bR = new BufferedReader(new FileReader(new File("src/words.txt")))) {

			while ((line = bR.readLine()) != null) {
				if (!line.equalsIgnoreCase(userString) && sorted.equals(toAnagramForm(line))) {
					wordArrayList.add(line);

				}

			}
			if (wordArrayList.isEmpty()) {
				JOptionPane.showMessageDialog(null, "There are no anagrams for this word");

			} else {
				JOptionPane.showMessageDialog(null, wordArrayList);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String toAnagramForm(String wordToBeAnagramed) {
		String lowerCase = wordToBeAnagramed.toLowerCase();
		char[] unsortedArray = lowerCase.toCharArray();

		Arrays.sort(unsortedArray);

		return new String(unsortedArray);

	}

}
