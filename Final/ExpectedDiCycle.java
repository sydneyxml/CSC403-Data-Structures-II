package finalexam;
import algs4.*;

/*
 * <Ximan Liu>
 * <ExpectedDiCycle>
 */

public class ExpectedDiCycle {
	
	public static void main(String[] args) {
		
		int eCount = 0;
		
		for(int vCount = 32; vCount <= 4096; vCount *= 2) {
			
			for(int dagCount = 0; dagCount < 1024; dagCount++) {
				
				Digraph graph = new Digraph(vCount); 
				DirectedCycle DC = new DirectedCycle(graph);
				
				int sum = 0; 
				 
				while (!DC.hasCycle()) {
					
					int firstV = (int)(Math.random() * vCount);
					int secondV = (int)(Math.random() * vCount);
					
					Iterable<Integer> adj = graph.adj(firstV);
					
					Boolean isAdj = false;
					
					for (Integer j : adj)	
						if (secondV == j) isAdj = true;
						if (!isAdj && firstV != secondV) {
					 		sum++;
					 		graph.addEdge(firstV, secondV);
					 		DC = new DirectedCycle(graph);
						}
				}
				eCount += sum;
		 	}
			double avrg = (1.0 * eCount)/1024;
			System.out.println("Vertices in graph: " + vCount + "	" + " Average # of edges to cycle: "+ avrg);
		}
	}
}
	
