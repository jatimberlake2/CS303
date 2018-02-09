import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Lab12 {

	public static void main(String[] args) throws IOException {
		
		int test = 0;
		
		BufferedReader reader = new BufferedReader(new FileReader(new File("tinyGraph.txt")));
		WeightedGraph wg = new WeightedGraph(reader);
		//System.out.println(wg.tostring());
		Vertex v = wg.vertList[test];
		long primStart = System.nanoTime();
		wg.MSTPrim(v);
		long primEnd = System.nanoTime();
		System.out.println("Total time elapsed for tiny graph : " + (primEnd - primStart) + " nanoseconds");

		reader = new BufferedReader(new FileReader(new File("mediumGraph.txt")));
		wg = new WeightedGraph(reader);
		//System.out.println(wg.tostring());
		v = wg.vertList[test];
		primStart = System.nanoTime();
		wg.MSTPrim(v);
		primEnd = System.nanoTime();
		System.out.println("Total time elapsed for medium graph : " + (primEnd - primStart) + " nanoseconds");
		
		reader = new BufferedReader(new FileReader(new File("LargeGraph.txt")));
		wg = new WeightedGraph(reader);
		//System.out.println(wg.tostring());
		v = wg.vertList[test];
		primStart = System.nanoTime();
		wg.MSTPrim(v);
		primEnd = System.nanoTime();
		System.out.println("Total time elapsed for large graph : " + (primEnd - primStart) + " nanoseconds");
		
		reader = new BufferedReader(new FileReader(new File("XtraLargeDG.txt")));
		wg = new WeightedGraph(reader);
		//System.out.println(wg.tostring());
		v = wg.vertList[test];
		primStart = System.nanoTime();
		wg.MSTPrim(v);
		primEnd = System.nanoTime();
		System.out.println("Total time elapsed for extra large graph : " + (primEnd - primStart) + " nanoseconds");
		
		/*
		for (int i = 0; i < wg.V; i++)
		{
			System.out.println("Path from " + test + " to " + i + " : ");
			wg.printPath(test, i);
			System.out.print("END\n");
		}
		*/
		
	}

}
