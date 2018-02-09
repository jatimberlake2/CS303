import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab3 {
	public static void main(String[] args) {
		try 
		{		
			System.out.println("100 values");
			//Read the values from the "input_100.txt" file provided for the lab and store the values in an array of search keys
			Scanner derp = new Scanner(new File("input_100.txt"));
			int[] input = readInNums(derp, 100);
			int[] temp = new int[input.length];
			for (int k = 0; k < input.length; k++)
			{
				temp[k] = input[k];
			}
			System.out.println("Unsorted : ");
			printArray(input);

			System.out.println();
			System.out.println("Sorted : ");

			mergeSort(input, temp, 0, input.length-1);
			printArray(input);
			
			System.out.println();
			
			System.out.println();
			System.out.println("1,000 values");
			derp = new Scanner(new File("input_1000.txt"));
			int[] input2 = readInNums(derp, 1000);
			int[] temp2 = new int[input2.length];
			for (int k = 0; k < input2.length; k++)
			{
				temp2[k] = input2[k];
			}
			System.out.println("Unsorted : ");
			printArray(input2);

			System.out.println();
			System.out.println("Sorted : ");

			mergeSort(input2, temp2, 0, input2.length-1);
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
	private static int[] insertionSort(int[] list)
	{
		for (int j = 1; j < list.length; j++)
		{
			int key = list[j];
			int i = j - 1;
			while (i >= 0 && list[i] > key)
			{
				list[i+1] = list[i];
				i--;
			}
			list[i+1] = key;
		}
		return list;
	}

	private static void mergeSort( int[] A, int[] temp, int p, int r )
	{
		if (p < r)
		{
			int q = (int) Math.floor((p+r)/2);
			mergeSort(A, temp, p, q);
			mergeSort(A, temp, q+1, r);
			merge(A, temp, p, q, r);
		}

	}


	private static void merge( int[] A, int[] temp, int p, int q, int r)
	{
		// merge A[p..q] with A[q+1..r]
		int i = p;
		int j = q + 1;
		
		// copy A[p..r] to temp[p..r]
		for (int k = p; k <= r; k++)
		{
			temp[k] = A[k];
		}
		
		//merge back to A[p..r]
		for (int k = p; k <= r; k++)
		{
			if (i > q)	// left half empty, copy from the right
			{
				A[k] = temp[j];
				j++;
			}
			else if (j > r)	// right half empty, copy from the left
			{
				A[k] = temp[i];
				i++;
			}
			else if (temp[j] < temp[i])	// copy from the right
			{
				A[k] = temp[j];
				j++;
			}
			else
			{
				A[k] = temp[i];	// copy from the left
				i++;
			}
			
		}
	}
}
