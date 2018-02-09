import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab5 {
	public static void main(String[] args) {
		try 
		{		
			System.out.println("100 values");
			//Read the values from the "input_100.txt" file provided for the lab and store the values in an array of search keys
			Scanner derp = new Scanner(new File("input_100.txt"));
			int[] input = readInNums(derp, 100);
			System.out.println("Unsorted : ");
			printArray(input);

			System.out.println();
			System.out.println("Sorted : ");

			quickSort(input, 0, input.length-1);
			printArray(input);
			
			System.out.println();
			
			System.out.println();
			System.out.println("1,000 values");
			derp = new Scanner(new File("input_1000.txt"));
			int[] input2 = readInNums(derp, 1000);
			System.out.println("Unsorted : ");
			printArray(input2);

			System.out.println();
			System.out.println("Sorted : ");

			quickSort(input2, 0, input2.length-1);
			printArray(input2);
			
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}

	}
	
	private static int[] readInNums(Scanner derp, int size)
	{
		int [] list = new int [size];
		int i = 0;
		while(derp.hasNextInt()){
		   list[i++] = derp.nextInt();
		}
		return list;
	}
	private static void printArray(int[] list)
	{
		for (int i = 0; i < list.length; i++)
		{
			System.out.print(list[i] + " ");
		}
	}

	private static void quickSort(int[] A, int p, int r){
		if (p < r)
		{
			int q = partition(A, p, r);
			quickSort(A,p,q-1);
			quickSort(A,q+1,r);
		}
	}
	
	private static int partition(int[] A,int p,int r)
	{
		int x = A[r];
		int i = p - 1;
		for (int j = p; j <= r-1; j++)
		{
			if (A[j] <= x)
			{
				i++;
				//exchange A[i] with A[j]
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		//exchange A[i+1] with A[r]
		int temp = A[i+1];
		A[i+1] = A[r];
		A[r] = temp;
		return i+1;
	}



	
}
