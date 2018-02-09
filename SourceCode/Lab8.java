import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Lab8 {

	public static void main(String[] args) {
		/*
		RBTree rtree = new RBTree();
		Random rand = new Random();
		System.out.println("Random list of integers: ");
		for (int i = 0; i < 100; i++)
		{
			int  n = rand.nextInt(10);
			System.out.print(n + " ");
			RBNode current = new RBNode((long) n, "test");
			rtree.RBInsert(current);

		}
		System.out.println("\n\nSorted list using the Red Black Tree: ");
		rtree.inOrderTreeWalk(rtree.root);
		*/
		try {
			RBTree tree = new RBTree();
			Scanner derp;
			derp = new Scanner(new File("UPC-random.csv"));
			long runningTimeTotal = 0;
			while (derp.hasNextLine())
			{
				String[] elements = derp.nextLine().split(",");
				RBNode UPCrecord = new RBNode(Long.parseLong(elements[0]), elements[2]);
				long startRBTreeBuild = System.nanoTime();
				tree.RBInsert(UPCrecord);	
				long endRBTreeBuild = System.nanoTime();
				runningTimeTotal = runningTimeTotal + (endRBTreeBuild - startRBTreeBuild);
			}
			System.out.println("Total time elapsed for building tree : " + runningTimeTotal + " nanoseconds");
			derp = new Scanner(new File("input.dat"));	
			ArrayList<RBNode> searchList = new ArrayList<RBNode>();
			runningTimeTotal = 0;
			
			while (derp.hasNextLine())
			{
				String[] elements = derp.nextLine().split(",");
				long keyVal = Long.parseLong(elements[0]);
				long startRBTreeSearch = System.nanoTime();
				tree.treeSearch(tree.root, keyVal);
				long endRBTreeSearch = System.nanoTime();
				runningTimeTotal = runningTimeTotal + (endRBTreeSearch - startRBTreeSearch);
				searchList.add(new RBNode(Long.parseLong(elements[0]), elements[2]));
			}
			System.out.println("\nTotal time elapsed for searching : " + runningTimeTotal + " nanoseconds\n");
			for (RBNode result : searchList)
				System.out.println(result.data);
			derp.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
	}
		
	}
	
}
	
class RBNode {
		long key;
		RBNode left, right, parent;
		String data;
		boolean isRed;
		
		public RBNode (long thing, String words) {
			key = thing;
			data = words;
			left = null;
			right = null;
			parent = null;
			isRed= false;
		}
}		

class RBTree{
		RBNode root;		
		RBTree(){
			root = null;
		}		
		void inOrderTreeWalk(RBNode x) 
		{
			if (x != null)
			{
				inOrderTreeWalk(x.left);
				System.out.print(x.key + " ");
				inOrderTreeWalk(x.right);
			}
		}
		RBNode treeSearch(RBNode x, long k)
		{
			if (x == null || k == x.key)
				return x;
			if (k < x.key)
				return treeSearch(x.left, k);
			else
				return treeSearch(x.right,k);
		}
		void leftRotate(RBNode x)
		{
			RBNode y = x.right;
			x.right = y.left;
			if (y.left != null)
				y.left.parent = x;
			y.parent = x.parent;
			if (x.parent == null)
				root = y;
			else if (x == x.parent.left) 
					x.parent.left = y;
			else
				x.parent.right = y;
			y.left = x;
			x.parent = y;
		}
		void rightRotate(RBNode x)
		{
			RBNode y = x.left;
			x.left = y.right;
			if (y.right != null)
				y.right.parent = x;
			y.parent = x.parent;
			if (x.parent == null)
				root = y;
			else if (x == x.parent.right) 
					x.parent.right = y;
			else 
				x.parent.left = y;
			y.right = x;
			x.parent = y;
		}
		void RBInsert(RBNode z)
		{
			RBNode y = null;
			RBNode x = root;
			while (x != null)
			{
				y = x;
				if (z.key < x.key)
					x = x.left;
				else
					x = x.right;
			}
			z.parent = y;
			if (y == null)
				root = z;
			else if (z.key < y.key)
				y.left = z;
			else
				y.right = z;
			z.left = null;
			z.right = null;
			z.isRed = true;
			RBInsertFixup(z);
		}
		void RBInsertFixup(RBNode z)
		{
			RBNode y = null;
			while (z.parent != null && z.parent.isRed)
			{ 
				if (z.parent == z.parent.parent.left)
				{
					y = z.parent.parent.right;
					if (y != null && y.isRed)
					{
						z.parent.isRed = false;
						y.isRed = false;
						z.parent.parent.isRed = true;
						z = z.parent.parent;	
					}
					else if (z == z.parent.right)
					{
						z = z.parent;
						leftRotate(z);
					}
					else
					{
						z.parent.isRed = false;
						z.parent.parent.isRed = true;
						rightRotate(z.parent.parent);
					}
				}
				else
				{
					y = z.parent.parent.right;
					if (y != null && y.isRed)
					{
						z.parent.isRed = false;
						y.isRed = false;
						z.parent.parent.isRed = true;
						z = z.parent.parent;	
					}
					else if (z.key == z.parent.right.key)
					{
						z = z.parent;
						rightRotate(z);
					}
					else
					{
						z.parent.isRed = false;
						z.parent.parent.isRed = true;
						leftRotate(z.parent.parent);
					}
				}
			}
			root.isRed = false;
		}		

}