import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab2H {
	public static void main(String[] args) {
		try 
		{		
			//Read the values from the "input_100.txt" file provided for the lab and store the values in an array of search keys
			Scanner derp = new Scanner(new File("input_100.txt"));
			int[] input = readInNums(derp, 100);
			System.out.println("Sorting 100 values");
			long startInsertSort= System.currentTimeMillis();
			insertionSort(input);
			long endInsertSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endInsertSort - startInsertSort)+ " milliseconds");
			System.out.println();
			
			//1000 values
			derp = new Scanner(new File("input_1000.txt"));
			input = readInNums(derp, 1000);
			System.out.println("Sorting 1,000 values");
			startInsertSort= System.currentTimeMillis();
			insertionSort(input);
			endInsertSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endInsertSort - startInsertSort)+ " milliseconds");
			System.out.println();
			
			//5000 values
			derp = new Scanner(new File("input_5000.txt"));
			input = readInNums(derp, 5000);
			System.out.println("Sorting 5,000 values");
			startInsertSort= System.currentTimeMillis();
			insertionSort(input);
			endInsertSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endInsertSort - startInsertSort)+ " milliseconds");
			System.out.println();
			
			//10000 values
			derp = new Scanner(new File("input_10000.txt"));
			input = readInNums(derp, 10000);
			System.out.println("Sorting 10,000 values");
			startInsertSort= System.currentTimeMillis();
			insertionSort(input);
			endInsertSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endInsertSort - startInsertSort)+ " milliseconds");
			System.out.println();
			
			//50000 values
			derp = new Scanner(new File("input_50000.txt"));
			input = readInNums(derp, 50000);
			System.out.println("Sorting 50,000 values");
			startInsertSort= System.currentTimeMillis();
			insertionSort(input);
			endInsertSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endInsertSort - startInsertSort)+ " milliseconds");
			System.out.println();
			
			//100000 values
			derp = new Scanner(new File("input_100000.txt"));
			input = readInNums(derp, 100000);
			System.out.println("Sorting 100,000 values");
			startInsertSort= System.currentTimeMillis();
			insertionSort(input);
			endInsertSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endInsertSort - startInsertSort)+ " milliseconds");
			System.out.println();
			
			//500000 values
			derp = new Scanner(new File("input_500000.txt"));
			input = readInNums(derp, 500000);
			System.out.println("Sorting 500,000 values");
			startInsertSort= System.currentTimeMillis();
			insertionSort(input);
			endInsertSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endInsertSort - startInsertSort)+ " milliseconds");
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
	private static void insertionSort(int[] list)
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
		//return list;
	}
}
