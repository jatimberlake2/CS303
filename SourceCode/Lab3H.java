import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab3H {
	public static void main(String[] args) {
		try 
		{		
			//Read the values from the "input_100.txt" file provided for the lab and store the values in an array of search keys
			Scanner derp = new Scanner(new File("input_100.txt"));
			int[] input = readInNums(derp, 100);
			System.out.println("Sorting 100 values");
			int[] temp = new int[input.length];
			for (int k = 0; k < input.length; k++)
			{
				temp[k] = input[k];
			}
			long startMergeSort= System.currentTimeMillis();
			mergeSort(input, temp, 0, input.length-1);
			long endMergeSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endMergeSort - startMergeSort)+ " milliseconds");
			System.out.println();
			
			//1000 values
			derp = new Scanner(new File("input_1000.txt"));
			input = readInNums(derp, 1000);
			System.out.println("Sorting 1,000 values");
			temp = new int[input.length];
			for (int k = 0; k < input.length; k++)
			{
				temp[k] = input[k];
			}
			startMergeSort= System.currentTimeMillis();
			mergeSort(input, temp, 0, input.length-1);
			endMergeSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endMergeSort - startMergeSort)+ " milliseconds");
			System.out.println();
			
			//5000 values
			derp = new Scanner(new File("input_5000.txt"));
			input = readInNums(derp, 5000);
			System.out.println("Sorting 5,000 values");
			temp = new int[input.length];
			for (int k = 0; k < input.length; k++)
			{
				temp[k] = input[k];
			}
			startMergeSort= System.currentTimeMillis();
			mergeSort(input, temp, 0, input.length-1);
			endMergeSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endMergeSort - startMergeSort)+ " milliseconds");
			System.out.println();
			
			//10000 values
			derp = new Scanner(new File("input_10000.txt"));
			input = readInNums(derp, 10000);
			System.out.println("Sorting 10,000 values");
			temp = new int[input.length];
			for (int k = 0; k < input.length; k++)
			{
				temp[k] = input[k];
			}
			startMergeSort= System.currentTimeMillis();
			mergeSort(input, temp, 0, input.length-1);
			endMergeSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endMergeSort - startMergeSort)+ " milliseconds");
			System.out.println();
			
			//50000 values
			derp = new Scanner(new File("input_50000.txt"));
			input = readInNums(derp, 50000);
			System.out.println("Sorting 50,000 values");
			temp = new int[input.length];
			for (int k = 0; k < input.length; k++)
			{
				temp[k] = input[k];
			}
			startMergeSort= System.currentTimeMillis();
			mergeSort(input, temp, 0, input.length-1);
			endMergeSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endMergeSort - startMergeSort)+ " milliseconds");
			System.out.println();
			
			//100000 values
			derp = new Scanner(new File("input_100000.txt"));
			input = readInNums(derp, 100000);
			System.out.println("Sorting 100,000 values");
			temp = new int[input.length];
			for (int k = 0; k < input.length; k++)
			{
				temp[k] = input[k];
			}
			startMergeSort= System.currentTimeMillis();
			mergeSort(input, temp, 0, input.length-1);
			endMergeSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endMergeSort - startMergeSort)+ " milliseconds");
			System.out.println();
			
			//50000 values
			derp = new Scanner(new File("input_500000.txt"));
			input = readInNums(derp, 500000);
			System.out.println("Sorting 500,000 values");
			temp = new int[input.length];
			for (int k = 0; k < input.length; k++)
			{
				temp[k] = input[k];
			}
			startMergeSort= System.currentTimeMillis();
			mergeSort(input, temp, 0, input.length-1);
			endMergeSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endMergeSort - startMergeSort)+ " milliseconds");
			System.out.println();
			
			System.out.println();
			
			
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
			//100 values : insertion and merge
			derp = new Scanner(new File("input_100.txt"));
			input = readInNums(derp, 100);
			System.out.println("Sorting 100 values with insertion and merging");
			temp = new int[input.length];
			for (int k = 0; k < input.length; k++)
			{
				temp[k] = input[k];
			}
			startMergeSort= System.currentTimeMillis();
			insertMergeSort(input, temp, 0, input.length-1, 4);
			//insertionSort(input, 0, input.length - 1);
			endMergeSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endMergeSort - startMergeSort)+ " milliseconds");	
			//System.out.println("TEST");
			//printArray(input);
			//System.out.println("\nEND TEST");

			//1,000 values : insertion and merge
			derp = new Scanner(new File("input_1000.txt"));
			input = readInNums(derp, 1000);
			System.out.println("Sorting 1,000 values with insertion and merging");
			temp = new int[input.length];
			for (int k = 0; k < input.length; k++)
			{
				temp[k] = input[k];
			}
			startMergeSort= System.currentTimeMillis();
			insertMergeSort(input, temp, 0, input.length-1, 8);
			endMergeSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endMergeSort - startMergeSort)+ " milliseconds");	
	
			//5000 values : insertion and merge
			derp = new Scanner(new File("input_5000.txt"));
			input = readInNums(derp, 5000);
			System.out.println("Sorting 5,000 values with insertion and merging");
			temp = new int[input.length];
			for (int k = 0; k < input.length; k++)
			{
				temp[k] = input[k];
			}
			startMergeSort= System.currentTimeMillis();
			insertMergeSort(input, temp, 0, input.length-1, 8);
			endMergeSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endMergeSort - startMergeSort)+ " milliseconds");	

			//10,000 values : insertion and merge
			derp = new Scanner(new File("input_10000.txt"));
			input = readInNums(derp, 10000);
			System.out.println("Sorting 10,000 values with insertion and merging");
			temp = new int[input.length];
			for (int k = 0; k < input.length; k++)
			{
				temp[k] = input[k];
			}
			startMergeSort= System.currentTimeMillis();
			insertMergeSort(input, temp, 0, input.length-1, 8);
			endMergeSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endMergeSort - startMergeSort)+ " milliseconds");	
			
			//50,000 values : insertion and merge
			derp = new Scanner(new File("input_50000.txt"));
			input = readInNums(derp, 50000);
			System.out.println("Sorting 50,000 values with insertion and merging");
			temp = new int[input.length];
			for (int k = 0; k < input.length; k++)
			{
				temp[k] = input[k];
			}
			startMergeSort= System.currentTimeMillis();
			insertMergeSort(input, temp, 0, input.length-1, 8);
			endMergeSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endMergeSort - startMergeSort)+ " milliseconds");	
		
			//100,000 values : insertion and merge
			derp = new Scanner(new File("input_100000.txt"));
			input = readInNums(derp, 100000);
			System.out.println("Sorting 100,000 values with insertion and merging");
			temp = new int[input.length];
			for (int k = 0; k < input.length; k++)
			{
				temp[k] = input[k];
			}
			startMergeSort= System.currentTimeMillis();
			insertMergeSort(input, temp, 0, input.length-1, 8);
			endMergeSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endMergeSort - startMergeSort)+ " milliseconds");	
		
			//500,000 values : insertion and merge
			derp = new Scanner(new File("input_500000.txt"));
			input = readInNums(derp, 500000);
			System.out.println("Sorting 500,000 values with insertion and merging");
			temp = new int[input.length];
			for (int k = 0; k < input.length; k++)
			{
				temp[k] = input[k];
			}
			startMergeSort= System.currentTimeMillis();
			insertMergeSort(input, temp, 0, input.length-1, 8);
			endMergeSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endMergeSort - startMergeSort)+ " milliseconds");	
		
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
	private static void insertMergeSort( int[] A, int[] temp, int p, int r, int cutoff )
	{
		if ( r - p <= cutoff) 
			insertionSort(A, p, r);
		else
			{
			int q = (int) Math.floor((p+r)/2);
			insertMergeSort(A, temp, p, q, cutoff);
			insertMergeSort(A, temp, q+1, r, cutoff);
			merge(A, temp, p, q, r);
			}
	}	
	private static void insertionSort(int[] list, int p, int r)
	{		
		for (int j = p; j <= r; j++)
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
