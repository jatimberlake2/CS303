import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class Lab11H{

	public static void main(String[] args) throws IOException {
		 BufferedReader reader = new BufferedReader(new FileReader(new File("tinyDG.txt")));
		 DirectedGraph dg = new DirectedGraph(reader);
		 System.out.println(dg.tostring());
		 Random rand = new Random();

		 /*
		 System.out.println("Here are the lists of all vertices from 0 to random values in the range of 0 to V, using DFS :\n");
		 for (int i = 0; i < 10; i++)
		 {
			 int tester = rand.nextInt(ug.V);
			 System.out.println("0 to " + tester   + " : ");
			 ug.printPath(0, tester);
			 System.out.print("END\n\n");
		 }
		 */

/*		 for (int i = 0; i < dg.vertList.length; i++)
		 {
			 System.out.println("0 to " + i   + " : ");
			 dg.printPath(0, i);
			 System.out.print("END, time : " + dg.vertList[i].getFTime() + " steps\n\n");
		 }
		 */
		/* for (int i = 0; i < dg.tList.size(); i++)
		 {
			 System.out.println(dg.tList.get(i).getKey() + " : " + dg.tList.get(i).getFTime() + " steps");
		 }*/

		 System.out.println("Topological sort : ");
		 LinkedList<Vertex> list = dg.topologicalSort();
		 for ( Vertex i : list )
			 System.out.println(i.getKey() + " : " + i.getFTime());

	}

}
