package finalexam;
import algs4.*;

/*
 * <Ximan Liu>
 * <CityDistances>
 */

public class CityDistances {
	
	public static void main(String[] args) {
		
		StdIn.fromFile("data/fecities.txt");
		String[] all = StdIn.readAllStrings();
		
		BST<String,Integer> fecities = new BST<>();
		for(int i = 0; i < all.length; i++) {
			fecities.put(all[i], i);	    	
		 }
		
		StdIn.fromFile("data/femajorcities.txt");
		Graph main = new Graph(all.length);
		
		String[] majorCities = StdIn.readAllStrings();
		StdIn.fromFile("data/feconnections.txt");
		 
		while(StdIn.hasNextLine()) {
		    String Connection = StdIn.readLine();
			String[] cities = Connection.split("\\s+");
			
			int i = fecities.get(cities[0]);
			int j = fecities.get(cities[1]);
			
			main.addEdge(i, j);
		 }
		
		StdOut.printf("%20s", "");
		
		for (String majorCity: majorCities) {
			StdOut.printf("%-12s", majorCity);
		 }
		
		StdOut.println();
		
		for(int i = 0; i < main.V(); i++) {
			StdOut.printf("%-18s",all[i]);
			
			BreadthFirstPaths bfp = new BreadthFirstPaths(main,i);
			
			for(String majors : majorCities) {
			    if (bfp.hasPathTo(fecities.get(majors))) {
			    	System.out.format( "    %3d     ", bfp.distTo(fecities.get(majors)));
			    }
			}
			System.out.println();
		}
	}
}

