package assignment6;
import algs4.*;

/*
 * <Ximan Liu>
 * <CountBridges>
 */

public class CountBridges {
	public static void main(String[] args) {
		
		args = new String[] { "data/a5bridges.txt" };
		In in = new In(args[0]);
		A6Graph G = new A6Graph(in);
		A6Graph copy = new A6Graph(G);
			
		int bridge=0;
		StdIn.fromFile("data/a5bridges.txt");
		StdIn.readLine();
		StdIn.readLine();
		while(!StdIn.isEmpty()) {
			String lineint = StdIn.readLine();
			String [] graph = lineint.split("\\s+");
			int v1 = Integer.parseInt(graph[0]);
			int v2 = Integer.parseInt(graph[1]);
			copy.deleteEdge(v1,v2);
			A6ConnectedComponents cc = new A6ConnectedComponents(copy);
			if(cc.count()>1) {
				bridge++;
			}
			copy.addEdge(v1,v2);
		}
		System.out.println("The number of bridges is " + bridge);		
	}
}
