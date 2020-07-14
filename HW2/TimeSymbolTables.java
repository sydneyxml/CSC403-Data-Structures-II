package assignment2;
import algs4.*;
/*
 * <Ximan Liu>
 * <TimeSymbolTables>
 */


public class TimeSymbolTables {
	
	public static void main(String[] args) {
		StdIn.fromFile("data/tale.txt");
		String[] words = StdIn.readAllStrings();	
		
		SequentialSearchST<String, Integer> chart1 = new SequentialSearchST<>();
		BinarySearchST<String, Integer> chart2 = new BinarySearchST<>();
		BST<String, Integer> chart3 = new BST<>();
		
		
		int count1 = 0;
		Stopwatch watch1 = new Stopwatch();
		for (int i = 0; i < words.length; i++) {
			if (chart1.contains(words[i])) {
				count1 = chart1.get(words[i]) + 1;
				chart1.put(words[i], count1);
			}
			else {
				chart1.put(words[i], 1);
			}
		}
		double SequentialSearchSTtime = watch1.elapsedTime();
		StdOut.println("Time for SequentialSearchST is " + SequentialSearchSTtime);
		
		
		int count2 = 0;
		Stopwatch watch2 = new Stopwatch();
		for (int i = 0; i < words.length; i++) {
			if (chart2.contains(words[i])) {
				count2 = chart2.get(words[i]) + 1;
				chart2.put(words[i], count2);
			}
			else {
				chart2.put(words[i], 1);
			}
		}
		double BinarySearchSTtime = watch2.elapsedTime();
		StdOut.println("Time for BinarySearchST is " + BinarySearchSTtime);
		
		
		int count3 = 0;
		Stopwatch watch3 = new Stopwatch();
		for (int i = 0; i < words.length; i++) {
			if (chart3.contains(words[i])) {
				count3 = chart3.get(words[i]) + 1;
				chart3.put(words[i], count3);
			}
			else {
				chart3.put(words[i], 1);
			}
		}
		double BSTtime = watch3.elapsedTime();
		StdOut.println("Time for BST is " + BSTtime);
		
	}	
}

