package assignment6;
import algs4.*;

/*
 * <Ximan Liu>
 * <DistantVertices>
 */

public class DistantVertices {

	public static void main(String[] args) {
		
		Graph G = new Graph(new In("data/a5bridges.txt"));
		
		BreadthFirstPaths bfp = new BreadthFirstPaths(G, 0);
		
		int longestPath = 0;
		
		for (int i = 0; i < G.V(); i++) {
			if (bfp.distTo(i) > longestPath) {
				longestPath = bfp.distTo(i);
			}
		}
		
		int node = 0;
		while (node < G.V()) {
			if (bfp.distTo(node) == longestPath) {
				System.out.println("The furthest vertice is v" + node);
			}
			node++;
		}
	}
}
