import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab2 {
	public static void main(String[] args) {
		try 
		{		
			//Read the values from the "input_100.txt" file provided for the lab and store the values in an array of search keys
			Scanner derp = new Scanner(new File("input_100.txt"));
			int[] input = readInNums(derp);
			System.out.println("Unsorted : ");
			printArray(input);
			System.out.println();
			System.out.println("Sorted : ");
			insertionSort(input);
			printArray(input);
			
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}

	}
	
	private static int[] readInNums(Scanner derp)
	{
		int [] list = new int [100];
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
		for (int j = 1; j <= list.length-1; j++)
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
}
