import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab5H {
	public static void main(String[] args) {
		try 
		{		
			System.out.println("Sorting an already sorted list with standard quicksort");
			Scanner derp = new Scanner(new File("Input_Sorted.txt"));
			int[] input = readInNums(derp, 1024);
			long startQuickSort= System.currentTimeMillis();
			quickSort(input, 0, input.length-1);
			long endQuickSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endQuickSort - startQuickSort)+ " milliseconds");
			System.out.println();
			
			System.out.println("Sorting a reversed list with standard quicksort");
			derp = new Scanner(new File("Input_ReversedSorted.txt"));
			input = readInNums(derp, 1024);
			startQuickSort= System.currentTimeMillis();
			quickSort(input, 0, input.length-1);
			endQuickSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endQuickSort - startQuickSort)+ " milliseconds");
			System.out.println();
			
			System.out.println("Sorting a randomized list with standard quicksort");
			derp = new Scanner(new File("Input_Random.txt"));
			input = readInNums(derp, 1024);
			startQuickSort= System.currentTimeMillis();
			quickSort(input, 0, input.length-1);
			endQuickSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endQuickSort - startQuickSort)+ " milliseconds");
			System.out.println();
			

			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
																							System.out.println();
																							System.out.println();
																							System.out.println();
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
			System.out.println("Sorting a 100 values with standard quicksort");
			derp = new Scanner(new File("input_100.txt"));
			input = readInNums(derp, 100);
			startQuickSort= System.currentTimeMillis();
			quickSort(input, 0, input.length-1);
			endQuickSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endQuickSort - startQuickSort)+ " milliseconds");
			System.out.println();
			
			System.out.println("Sorting a 1,000 values with standard quicksort");
			derp = new Scanner(new File("input_1000.txt"));
			input = readInNums(derp, 1000);
			startQuickSort= System.currentTimeMillis();
			quickSort(input, 0, input.length-1);
			endQuickSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endQuickSort - startQuickSort)+ " milliseconds");
			System.out.println();
			
			System.out.println("Sorting a 5,000 values with standard quicksort");
			derp = new Scanner(new File("input_5000.txt"));
			input = readInNums(derp, 5000);
			startQuickSort= System.currentTimeMillis();
			quickSort(input, 0, input.length-1);
			endQuickSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endQuickSort - startQuickSort)+ " milliseconds");
			System.out.println();
			
			System.out.println("Sorting a 10,000 values with standard quicksort");
			derp = new Scanner(new File("input_10000.txt"));
			input = readInNums(derp, 10000);
			startQuickSort= System.currentTimeMillis();
			quickSort(input, 0, input.length-1);
			endQuickSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endQuickSort - startQuickSort)+ " milliseconds");
			System.out.println();
			
			System.out.println("Sorting a 50,000 values with standard quicksort");
			derp = new Scanner(new File("input_50000.txt"));
			input = readInNums(derp, 50000);
			startQuickSort= System.currentTimeMillis();
			quickSort(input, 0, input.length-1);
			endQuickSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endQuickSort - startQuickSort)+ " milliseconds");
			System.out.println();
			
			System.out.println("Sorting a 100,000 values with standard quicksort");
			derp = new Scanner(new File("input_100000.txt"));
			input = readInNums(derp, 100000);
			startQuickSort= System.currentTimeMillis();
			quickSort(input, 0, input.length-1);
			endQuickSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endQuickSort - startQuickSort)+ " milliseconds");
			System.out.println();
			
			System.out.println("Sorting a 500,000 values with standard quicksort");
			derp = new Scanner(new File("input_500000.txt"));
			input = readInNums(derp, 500000);
			startQuickSort= System.currentTimeMillis();
			quickSort(input, 0, input.length-1);
			endQuickSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endQuickSort - startQuickSort)+ " milliseconds");
			System.out.println();
			
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
																								System.out.println();
																								System.out.println();
																								System.out.println();
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
			System.out.println("Sorting a 100 values with median of 3 quicksort");
			derp = new Scanner(new File("input_100.txt"));
			input = readInNums(derp, 100);
			startQuickSort= System.currentTimeMillis();
			quickSortM3(input, 0, input.length-1);
			endQuickSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endQuickSort - startQuickSort)+ " milliseconds");
			System.out.println();
			
			System.out.println("Sorting a 1,000 values with median of 3 quicksort");
			derp = new Scanner(new File("input_1000.txt"));
			input = readInNums(derp, 1000);
			startQuickSort= System.currentTimeMillis();
			quickSortM3(input, 0, input.length-1);
			endQuickSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endQuickSort - startQuickSort)+ " milliseconds");
			System.out.println();
			
			System.out.println("Sorting a 5,000 values with median of 3 quicksort");
			derp = new Scanner(new File("input_5000.txt"));
			input = readInNums(derp, 5000);
			startQuickSort= System.currentTimeMillis();
			quickSortM3(input, 0, input.length-1);
			endQuickSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endQuickSort - startQuickSort)+ " milliseconds");
			System.out.println();
			
			System.out.println("Sorting a 10,000 values with median of 3 quicksort");
			derp = new Scanner(new File("input_10000.txt"));
			input = readInNums(derp, 10000);
			startQuickSort= System.currentTimeMillis();
			quickSortM3(input, 0, input.length-1);
			endQuickSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endQuickSort - startQuickSort)+ " milliseconds");
			System.out.println();
			
			System.out.println("Sorting a 50,000 values with median of 3 quicksort");
			derp = new Scanner(new File("input_50000.txt"));
			input = readInNums(derp, 50000);
			startQuickSort= System.currentTimeMillis();
			quickSortM3(input, 0, input.length-1);
			endQuickSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endQuickSort - startQuickSort)+ " milliseconds");
			System.out.println();
			
			System.out.println("Sorting a 100,000 values with median of 3 quicksort");
			derp = new Scanner(new File("input_100000.txt"));
			input = readInNums(derp, 100000);
			startQuickSort= System.currentTimeMillis();
			quickSortM3(input, 0, input.length-1);
			endQuickSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endQuickSort - startQuickSort)+ " milliseconds");
			System.out.println();
			
			System.out.println("Sorting a 500,000 values with median of 3 quicksort");
			derp = new Scanner(new File("input_500000.txt"));
			input = readInNums(derp, 500000);
			startQuickSort= System.currentTimeMillis();
			quickSortM3(input, 0, input.length-1);
			endQuickSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endQuickSort - startQuickSort)+ " milliseconds");
			System.out.println();
			
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
	private static void swap(int[] A, int i, int j)
	{
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
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
				swap(A, i, j);
			}
		}
		swap(A, i+1, r);
		return i+1;
	}
	
	private static void quickSortM3(int[] A, int p, int r)
	{
		if (p < r)
		{
			int N = r - p + 1;
			int m = median3(A, p, p+N/2, r);
			swap(A, m, r);
				
			int q = partition(A, p, r);
			quickSortM3(A, p, q-1);
			quickSortM3(A,q+1, r);
		}
	}
	
	private static int median3(int[] A, int left, int center, int right)
	{
		if (A[left] > A[center])
			swap(A, left, center);
		if (A[left] > A[right])
			swap(A, left, right);
		if(A[center] > A[right])
			swap(A, center, right);
		swap(A, center, right-1);
		return right-1;
	}
	
}
