import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lab10 {

	public static void main(String[] args) throws IOException {

	/*	 BufferedReader reader = new BufferedReader(new FileReader(new File("tinyDG.txt")));
		 DirectedGraph dg = new DirectedGraph(reader);
		 System.out.println(dg.tostring());
		 System.out.println("");	*/ 
		BufferedReader reader = new BufferedReader(new FileReader(new File("tinyDG.txt")));

		 //System.out.println(ug.tostring());
		 //System.out.println("All possible paths to 6 from anywhere else in the graph: \n");
		 long startBFS = System.nanoTime();	
		 UndirectedGraph ug = new UndirectedGraph(reader);
		 ug.BFS(ug.adj[0].get(0));
		 long endBFS = System.nanoTime();
		 long tinyTime = endBFS - startBFS;
		 System.out.println("Total time elapsed for tiny adjacency list : " + tinyTime + " nanoseconds.");
		reader = new BufferedReader(new FileReader(new File("mediumG.txt")));
		startBFS = System.nanoTime();
		ug = new UndirectedGraph(reader);
		ug.BFS(ug.adj[0].get(0));
		endBFS = System.nanoTime();
		long medTime = endBFS - startBFS;
		System.out.println("Total time elapsed for medium adjacency list : " + medTime + " nanoseconds.");
		reader = new BufferedReader(new FileReader(new File("largeG.txt")));
		startBFS = System.nanoTime();
		ug = new UndirectedGraph(reader);
		ug.BFS(ug.adj[0].get(0));
		endBFS = System.nanoTime();
		long largeTime = endBFS - startBFS;
		System.out.println("Total time elapsed for large adjacency list : " + largeTime + " nanoseconds.");

		//Do over with adjacency matrices.
		reader = new BufferedReader(new FileReader(new File("tinyDG.txt")));
		startBFS = System.nanoTime();
		MatrixGraph mg = new MatrixGraph(reader);
		mg.BFS(mg.vertList[0].get(0));
		endBFS = System.nanoTime();
		tinyTime = endBFS - startBFS;
		System.out.println("\nTotal time elapsed for tiny adjacency matrix : " + tinyTime + " nanoseconds.");
		reader = new BufferedReader(new FileReader(new File("mediumG.txt")));
		startBFS = System.nanoTime();
		mg = new MatrixGraph(reader);
		mg.BFS(mg.vertList[0].get(0));
		endBFS = System.nanoTime();
		medTime = endBFS - startBFS;
		System.out.println("Total time elapsed for medium adjacency matrix : " + medTime + " nanoseconds.");
	/*	reader = new BufferedReader(new FileReader(new File("largeG.txt")));
		startBFS = System.nanoTime();
		mg = new MatrixGraph(reader);
		mg.BFS(mg.vertList[0].get(0));
		//  Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
		//		at MatrixGraph.<init>(MatrixGraph.java:25)
		//		at Lab10.main(Lab10.java:56)
		endBFS = System.nanoTime();
		largeTime = endBFS - startBFS;
		System.out.println("Total time elapsed for large adjacency matrix : " + largeTime + " nanoseconds.");
	*/
	}

}