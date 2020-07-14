package assignment3;
import algs4.StdIn;

/*
 * <Ximan Liu>
 * <A3Test>
 */

public class A3Test {
	
	public static void main(String[] args) {
		
		StdIn.fromFile("data/tinyTale.txt");
		String[] words = StdIn.readAllStrings();
		
		A3BST<String, Integer> wordST = new A3BST<>();
		
		int count = 0;
		for (int i = 0; i < words.length; i++) {
			if (wordST.contains(words[i])) {
				wordST.put(words[i], wordST.get(words[i])+1);
			}
			else {
				wordST.put(words[i], 1);
				count++;
			}
		}
		
		System.out.println("Number of unique word: " + count);
		System.out.println("Number of nodes with two children: " + wordST.countTwins());
		System.out.println("Number of words occur once: " + wordST.lessThanValueCount(2));
		System.out.println("Number of words occur at most five times: " + wordST.lessThanValueCount(6));
		
	}
}
