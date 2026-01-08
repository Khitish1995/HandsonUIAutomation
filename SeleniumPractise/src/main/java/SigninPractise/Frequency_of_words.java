package SigninPractise;

import java.util.ArrayList;
import java.util.Arrays;

public class Frequency_of_words {
	
	String sentence = "aaa aaa eee ttt eee rrr ttt eee eee rrr rrr ttt ddd fff ddd";
	
	ArrayList<String> wordsList = new ArrayList<String>(Arrays.asList(sentence.split(" ")));
	
	public void countWords() {
		ArrayList<String> countedWords = new ArrayList<String>();
		
		for (String word : wordsList) {
			if (!countedWords.contains(word)) {
				int count = 0;
				for (String w : wordsList) {
					if (word.equals(w)) {
						count++;
					}
				}
				countedWords.add(word);
				System.out.println(word + ": " + count);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Frequency_of_words a = new Frequency_of_words();
		a.countWords();
	
	}

}
