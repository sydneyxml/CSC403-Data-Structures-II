package assignment5;
import algs4.*;


/*
 * <Ximan Liu>
 * <A5BFPaths>
 */


public class A5BFPaths {
	
	public static void main(String args[]) {
		
		String fileName = "data/a5bridges.txt";
		In in = new In(fileName);
		Graph G = new Graph(in);
		BreadthFirstPaths bfp = new BreadthFirstPaths(G, 0);
		
		for (int i = 0; i < G.V(); i++) {
			System.out.println("Distance between source and node " + i + " is " + bfp.distTo(i));
		}
	}
}
