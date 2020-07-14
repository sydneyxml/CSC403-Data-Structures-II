package assignment1;
import algs4.*;

/*
 * <Ximan Liu>
 * <CountIndividualWords>
 */

public class CountIndividualWords {
	public static void main(String[] args) {
		
		BST<String, Boolean> values = new BST<>();
		
		StdIn.fromFile("data/tale.txt");
		//StdIn.fromFile("data/tinyTale.txt");	// test
		
		String[] words = StdIn.readAllStrings();
		
		int count = 0;
		
		for (String word: words) {
			if (!values.contains(word)) {
				values.put(word, true);
			}
		}
		StdOut.println("There are " + values.size() + " words in the text.");
		
	}
	

}
