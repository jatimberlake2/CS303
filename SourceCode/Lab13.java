import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lab13 {

	public static void main(String[] args) throws IOException {
int test = 0;
		
		BufferedReader reader = new BufferedReader(new FileReader(new File("tinyGraph.txt")));
		WeightedGraph wg = new WeightedGraph(reader);
		System.out.println(wg.tostring());
		long dijkstraStart = System.nanoTime();
		ArrayList<Vertex> S = wg.dijskstra(test);
		long dijkstraEnd = System.nanoTime();
		System.out.println("Single-source shortest path from " + test + " to all other nodes in ascending order :");
		
		
		for (Vertex v : S)
			System.out.println(v.getKey() + " : "  + v.getWKey());
		System.out.println();
		for (int i = 0; i < wg.V; i++)
		{
			System.out.println("Path from " + test + " to " + i + " : ");
			wg.printPath(test, i);
			System.out.print("END\n");
		}
		
		System.out.println("\nTotal time elapsed for tiny graph : " + (dijkstraEnd - dijkstraStart) + " nanoseconds");

		reader = new BufferedReader(new FileReader(new File("mediumGraph.txt")));
		wg = new WeightedGraph(reader);
		//System.out.println(wg.tostring());
		dijkstraStart = System.nanoTime();
		S = wg.dijskstra(test);
		dijkstraEnd = System.nanoTime();
		System.out.println("Total time elapsed for medium graph : " + (dijkstraEnd - dijkstraStart) + " nanoseconds");
		
		reader = new BufferedReader(new FileReader(new File("LargeGraph.txt")));
		wg = new WeightedGraph(reader);
		//System.out.println(wg.tostring());
		dijkstraStart = System.nanoTime();
		S = wg.dijskstra(test);
		dijkstraEnd = System.nanoTime();
		System.out.println("Total time elapsed for large graph : " + (dijkstraEnd - dijkstraStart) + " nanoseconds");
		
		reader = new BufferedReader(new FileReader(new File("XtraLargeDG.txt")));
		wg = new WeightedGraph(reader);
		//System.out.println(wg.tostring());
		dijkstraStart = System.nanoTime();
		S = wg.dijskstra(test);
		dijkstraEnd = System.nanoTime();
		System.out.println("Total time elapsed for extra large graph : " + (dijkstraEnd - dijkstraStart) + " nanoseconds");
		

	}

}
