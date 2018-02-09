import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Lab1H {
	public static void main(String[] args) {	
		try {
			//Read the values from the "input_1000.txt" file provided for the lab and store the values in an array of search keys
			Scanner derp = new Scanner(new File("input_1000.txt"));
			int[] searchKeys = readInNums(derp);
			
			//The outer loop is for switching between the 1000 inputs from the list provided.
			for (int i = 0; i < searchKeys.length; i++)
			{
				int searchKey = searchKeys[i];
				for (int j = 4; j <= 25; j++)
				{
					//The inner loop to generate powers of 2 from 4 to 25, to generate tests for different sizes with each search key.
					int N = (int)Math.pow(2,j);
					System.out.println("---> Currently testing number of entries  : "+ N + " <--- ");			

					System.out.println("Search key: "+ searchKey);
					//Generate list of random integers within range of N
					int[] nums = initializeList(N);
		
					//Linear Search
					long startLSearch = System.currentTimeMillis();
					int result = linearSearch(nums, searchKey);
					System.out.print("Linear Search: ");
					if (result == -1) 
						System.out.println("Not here!");
					else
						System.out.println("The value was found at index " + result + " in the array (0 based counting).");
					long endLSearch = System.currentTimeMillis();
					System.out.println("Elapsed time : " + (endLSearch - startLSearch)+ " milliseconds");
			
					//Binary Search
					long startBSearch = System.currentTimeMillis();
					Arrays.sort(nums);
					int result2 = binarySearch(nums, 0, nums.length-1, searchKey);
					System.out.print("Binary Search: ");
					if (result2 == -1)
						System.out.println("Not here!");
					else
						System.out.println("The value was found at index " + result2 + " in the array (0 based counting).");
					long endBSearch = System.currentTimeMillis();
					System.out.println("Elapsed time : " + (endBSearch - startBSearch)+ " milliseconds");
					System.out.println();	
				}
			}				
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();	
		}	
	}
	
	public static int[] readInNums(Scanner derp)
	{
		int [] list = new int [1000];
		int i = 0;
		while(derp.hasNextInt()){
		   list[i++] = derp.nextInt();
		}
		return list;
	}
	
	public static int[] initializeList(int num) {
		int[] numbers = new int[num];       
	    for(int i = 0; i < numbers.length; i++) {
	      numbers[i] = (int)(Math.random()*num + 1);
	    }
	    return numbers;
	}
	
	public static int linearSearch(int[] list, int v) {
		for (int j = 0; j < list.length; j++) {
			if (list[j] == v)
				return j;
		}
		return -1;	
	}
	
	public static int binarySearch(int[] list, int left, int right, int v) 
	{
		if (right >= left) 
		{
			int mid = left + (right - left)/2;
			if  (v < list[mid]) 
				return binarySearch(list, left, mid-1, v);
			if (v > list[mid])
				return binarySearch(list,mid+1, right, v);
			if (v == list[mid])
				return mid;
		}
		return -1;
	}	 
}
