import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Lab11DepthFirstPaths {

	public static void main(String[] args) throws IOException {
		 BufferedReader reader = new BufferedReader(new FileReader(new File("tinyDG.txt")));
		 UndirectedGraph ug = new UndirectedGraph(reader);
		 //System.out.println(ug.tostring());
		 ug.DFS();
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
		 System.out.println(ug.tList.size());
		 for (int i = 0; i < ug.vertList.length; i++)
		 {
			 System.out.println("0 to " + i   + " : ");
			 ug.printPath(0, i);
			 System.out.print("END, time : " + ug.vertList[i].getFTime() + " steps\n\n");
		 }
		 

	}

}
