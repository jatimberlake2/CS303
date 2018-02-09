import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab9  {
	public static void main(String[] args) {
		try {	
			// for standard hash put()
			HashMap upctable = new HashMap(710600);
			Scanner derp;
			derp = new Scanner(new File("UPC.csv"));
			long runningTimeTotal = 0;
			while (derp.hasNextLine())
			{
				String[] elements = derp.nextLine().split(",");
				long startHashBuild = System.nanoTime();
				upctable.put(Long.parseLong(elements[0]), elements[2]);
				long endHashBuild = System.nanoTime();
				runningTimeTotal = runningTimeTotal + (endHashBuild - startHashBuild);
			}
			System.out.println("Total time elapsed for building HashMap : " + runningTimeTotal + " nanoseconds");
			derp = new Scanner(new File("input.dat"));	
			ArrayList<HashEntry> searchList = new ArrayList<HashEntry>();
			runningTimeTotal = 0;
			while (derp.hasNextLine())
			{
				String[] elements = derp.nextLine().split(",");
				searchList.add(new HashEntry(Long.parseLong(elements[0]), elements[2]));
			}
			for (int i = 0; i < searchList.size(); i++)
			{
				long startHashSearch = System.nanoTime();
				upctable.get(searchList.get(i).getKey());
				long endHashSearch = System.nanoTime();
				runningTimeTotal = runningTimeTotal + (endHashSearch - startHashSearch);
			}
			System.out.println("Total time elapsed for searching with get() : " + runningTimeTotal + " nanoseconds\n");
			
			// for linearProbe()
			upctable = new HashMap(710600);
			derp = new Scanner(new File("UPC.csv"));
			runningTimeTotal = 0;
			while (derp.hasNextLine())
			{
				String[] elements = derp.nextLine().split(",");
				long startHashBuild = System.nanoTime();
				upctable.linearProbe(Long.parseLong(elements[0]), elements[2]);
				long endHashBuild = System.nanoTime();
				runningTimeTotal = runningTimeTotal + (endHashBuild - startHashBuild);
			}
			System.out.println("Total time elapsed for building HashMap with linear probing : " + runningTimeTotal + " nanoseconds");
			runningTimeTotal = 0;
			for (int i = 0; i < searchList.size(); i++)
			{
				long startHashSearch = System.nanoTime();
				upctable.get(searchList.get(i).getKey());
				long endHashSearch = System.nanoTime();
				runningTimeTotal = runningTimeTotal + (endHashSearch - startHashSearch);
			}
			System.out.println("Total time elapsed for searching with getLinearProbe() : " + runningTimeTotal + " nanoseconds\n");

			// for quadraticProbe()
			upctable = new HashMap(710600);
			derp = new Scanner(new File("UPC.csv"));
			runningTimeTotal = 0;
			while (derp.hasNextLine())
			{
				String[] elements = derp.nextLine().split(",");
				long startHashBuild = System.nanoTime();
				upctable.quadraticProbe(Long.parseLong(elements[0]), elements[2]);
				long endHashBuild = System.nanoTime();
				runningTimeTotal = runningTimeTotal + (endHashBuild - startHashBuild);
			}
			System.out.println("Total time elapsed for building HashMap with quadratic probing : " + runningTimeTotal + " nanoseconds");
			runningTimeTotal = 0;
			for (int i = 0; i < searchList.size(); i++)
			{
				long startHashSearch = System.nanoTime();
				upctable.getQuadraticProbe(searchList.get(i).getKey());
				long endHashSearch = System.nanoTime();
				runningTimeTotal = runningTimeTotal + (endHashSearch - startHashSearch);
			}
			System.out.println("Total time elapsed for searching with getQuadraticProbe() : " + runningTimeTotal + " nanoseconds\n");

			derp.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}


