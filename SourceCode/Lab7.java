import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab7 {

	public static void main(String[] args) {
		try {
			BST tree = new BST();
			Scanner derp;
			derp = new Scanner(new File("UPC.csv"));
			long runningTimeTotal = 0;
			while (derp.hasNextLine())
			{
				String[] elements = derp.nextLine().split(",");
				Node UPCrecord = new Node(Long.parseLong(elements[0]), elements[2]);
				long startBSTBuild = System.nanoTime();
				tree.treeInsert(UPCrecord);	
				long endBSTBuild = System.nanoTime();
				runningTimeTotal = runningTimeTotal + (endBSTBuild - startBSTBuild);
			}
			System.out.println("Total time elapsed for building tree : " + runningTimeTotal + " nanoseconds");
			derp = new Scanner(new File("input.dat"));	
			ArrayList<Node> searchList = new ArrayList<Node>();
			runningTimeTotal = 0;
			
			while (derp.hasNextLine())
			{
				String[] elements = derp.nextLine().split(",");
				long keyVal = Long.parseLong(elements[0]);
				long startBSTSearch = System.nanoTime();
				tree.treeSearch(tree.root, keyVal);
				long endBSTSearch = System.nanoTime();
				runningTimeTotal = runningTimeTotal + (endBSTSearch - startBSTSearch);
				searchList.add(new Node(Long.parseLong(elements[0]), elements[2]));
			}
			System.out.println("\nTotal time elapsed for searching : " + runningTimeTotal + " nanoseconds\n");
			for (Node result : searchList)
				System.out.println(result.data);
			derp.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
	
class Node {
		long key;
		Node left, right;
		String data;
		
		public Node (long thing, String words) {
			key = thing;
			data = words;
			left = null;
			right = null;
		}
}		

class BST {
		Node root;
		
		BST(){
			root = null;
		}		
		void treeInsert(Node z)
		{
			Node y = null;
			Node x = root;
			while (x != null)
			{
				y = x;
				if (z.key < x.key)
					x = x.left;
				else
					x = x.right;
			}
				//z.p = y;
				if ( y == null)
					root = z;
				else if (z.key < y.key)
					y.left = z;
				else 
					y.right = z;
		}
		void inOrderTreeWalk(Node x) 
		{
			if (x != null)
			{
				inOrderTreeWalk(x.left);
				System.out.print(x.key + " ");
				inOrderTreeWalk(x.right);
			}
		}
		Node treeSearch(Node x, long k)
		{
			if (x == null || k == x.key)
				return x;
			if (k < x.key)
				return treeSearch(x.left, k);
			else
				return treeSearch(x.right,k);
		}
}