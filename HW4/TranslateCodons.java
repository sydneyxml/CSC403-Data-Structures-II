package assignment4;
import algs4.*;
import algs4.StdIn;

/*
 * <Ximan Liu>
 * <TranslateCodons>
 */

public class TranslateCodons {
	public static void main(String args[]) {
		BST<String, String> translation = new BST<>();
		
		StdIn.fromFile("data/translation.txt");
		while(!StdIn.isEmpty()) {
			String string1 = StdIn.readLine();
			String[] array = string1.split("\\s+");
			translation.put(array[0], array[1]);
		}
		
		StdIn.fromFile("data/smallsequences.txt");
		while(!StdIn.isEmpty()) {
			String string2 = StdIn.readLine();
			String species;
			String dna;
			String codon;
			String[] array2 = string2.split("\\s+");
			species = array2[0] + " " + array2[1];
			dna = array2[array2.length-1];
			System.out.println(species);
			String firstLine = "";
			String secondLine = "";
			
			for(int i = 0; i < dna.length(); i+=3) {
				codon = dna.substring(i, i+3);
				firstLine = firstLine + codon + " ";
				secondLine = secondLine + translation.get(codon) + "-";
			}
			secondLine = secondLine.substring(0, secondLine.length() - 1);
			System.out.println(firstLine);
			System.out.println(secondLine);
			System.out.println();
		}			
	}
}
