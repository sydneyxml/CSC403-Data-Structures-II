package assignment1;
import algs4.*;

/*
 * <Ximan Liu>
 * <ComputeAverageRating>
 */

public class ComputeAverageRating {
	
	public static void main(String[] args) {
		
		BinarySearchST<String, Integer> ratings= new BinarySearchST<>();
		
		ratings.put("Outstanding", 6);
		ratings.put("Excellent", 5);
		ratings.put("Better", 4);
		ratings.put("Average", 3);
		ratings.put("Worse", 2);
		ratings.put("Awful", 1);
		ratings.put("Avoid", 0);
		
		StdIn.fromFile("data/a1ratings.txt");
		
		String[] letters = StdIn.readAllStrings();
		
		
		int count = 0;
		int total = 0;
		for (int i = 0; i < letters.length; i++) {
			if (ratings.get(letters[i]) == null) {
				StdOut.println(letters[i] + " does not exist");
			}
			else {
				count++;
				int rating = ratings.get(letters[i]);
				total += rating;
			}
	}
		float result = (float)total / count;
		StdOut.println("The rating is " + result);
	}
}
