package assignment6;
import algs4.*;
import java.util.Random;

/*
 * <Ximan Liu>
 * <ExpectedConnectivity>
 */

public class ExpectedConnectivity {
	
	public static void main(String[] args) {
		int total = 0;
		for (int i = 0; i < 1024; i++) {
			Random rand = new Random();
			A6Graph graph = new A6Graph(64);
			A6ConnectedComponents graph2 = new A6ConnectedComponents(graph);
			int sum = 0;
			while(graph2.count() != 1) {
				int first = (int)(Math.random() * (63 + 1));
				int second = (int)(Math.random() * (63 + 1));
				Iterable<Integer> adj = graph.adj(first);
				Boolean inAdj = false;
				for (Integer j: adj) 
					if (second == j)
						inAdj = true;
						
				if (!inAdj && first != second) {
					sum++;
					graph.addEdge(first, second);
				}
				graph2 = new A6ConnectedComponents(graph);
			}
			total += sum;			
		}
		System.out.println("The average number of edges is " + total/1024);
	}
}
