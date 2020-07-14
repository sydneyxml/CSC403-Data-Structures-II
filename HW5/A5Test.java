package assignment5;

import java.util.Arrays;

import algs4.*;


/*
 * <Ximan Liu>
 * <A5Test>
 */


public class A5Test {
	
	public static void main(String[] args) {
		
		A5LPHashST<String, Integer> lphash = new A5LPHashST<>();
		A5SCHashST<String, Integer> schash = new A5SCHashST<>();
		
		StdIn.fromFile("data/tinyTale.txt");
		
		String[] words = StdIn.readAllStrings();
		
		for (String word: words) {
			Integer count = lphash.get(word);
			if (count == null) {
				lphash.put(word, 1);
			}
			else {
				lphash.put(word, count+1);
			}
		}
		
		for (String word: words) {
			Integer count = schash.get(word);
			if (count == null) {
				schash.put(word, 1);
			}
			else {
				schash.put(word, count+1);
			}
		}
		
		StdOut.println("LPHash: ");
		for (String key: lphash.keys()) {
			StdOut.println(key+": "+ lphash.get(key));
		}
		
		StdOut.println();
		
		StdOut.println("SChash: ");
		for (String key: schash.keys()) {
			StdOut.println(key+": "+schash.get(key));
		}	
	}
}
