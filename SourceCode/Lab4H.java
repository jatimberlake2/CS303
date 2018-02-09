import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab4H {

	public static void main(String[] args) {
		try 
		{		
			System.out.println("Sorting 100 values");
			//Read the values from the "input_100.txt" file provided for the lab
			Scanner derp = new Scanner(new File("input_100.txt"));
			int[] input = readInNums(derp, 100);
			heapH h = new heapH(input, input.length);
			long startHeapSort= System.currentTimeMillis();
			h.heapSort();
			long endHeapSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endHeapSort - startHeapSort)+ " milliseconds");
			System.out.println();	
			//printArray(input);

			System.out.println("Sorting 1,000 values");
			derp = new Scanner(new File("input_1000.txt"));
			input = readInNums(derp, 1000);
			h = new heapH(input, input.length);
			startHeapSort= System.currentTimeMillis();
			h.heapSort();
			endHeapSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endHeapSort - startHeapSort)+ " milliseconds");
			System.out.println();
			//printArray(input);
			
			//5000 values
			derp = new Scanner(new File("input_5000.txt"));
			input = readInNums(derp, 5000);
			System.out.println("Sorting 5,000 values");
			h = new heapH(input, input.length);
			startHeapSort= System.currentTimeMillis();
			h.heapSort();
			endHeapSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endHeapSort - startHeapSort)+ " milliseconds");
			System.out.println();
			
			//10000 values
			derp = new Scanner(new File("input_10000.txt"));
			input = readInNums(derp, 10000);
			System.out.println("Sorting 10,000 values");
			h = new heapH(input, input.length);
			startHeapSort= System.currentTimeMillis();
			h.heapSort();
			endHeapSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endHeapSort - startHeapSort)+ " milliseconds");
			System.out.println();
			
			//50000 values
			derp = new Scanner(new File("input_50000.txt"));
			input = readInNums(derp, 50000);
			System.out.println("Sorting 50,000 values");
			h = new heapH(input, input.length);
			startHeapSort= System.currentTimeMillis();
			h.heapSort();
			endHeapSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endHeapSort - startHeapSort)+ " milliseconds");
			System.out.println();
			
			//100000 values
			derp = new Scanner(new File("input_100000.txt"));
			input = readInNums(derp, 100000);
			System.out.println("Sorting 100,000 values");
			h = new heapH(input, input.length);
			startHeapSort= System.currentTimeMillis();
			h.heapSort();
			endHeapSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endHeapSort - startHeapSort)+ " milliseconds");
			System.out.println();
			
			//50000 values
			derp = new Scanner(new File("input_500000.txt"));
			input = readInNums(derp, 500000);
			System.out.println("Sorting 500,000 values");
			h = new heapH(input, input.length);
			startHeapSort= System.currentTimeMillis();
			h.heapSort();
			endHeapSort = System.currentTimeMillis();
			System.out.println("Elapsed time : " + (endHeapSort - startHeapSort)+ " milliseconds");
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
}

	class heapH {
		private int[] A;
		private int size;
		
		public heapH(){
			A = null;
			size = 0;
		}
		
		public heapH(int[] list, int num){
			A = list;
			size = num;
		}
		
		public void heapSort(){
			buildMaxHeap();
			for (int i = A.length-1; i >= 0; i--){
				int temp = A[i];
				A[i] = A[0];
				A[0] = temp;
				size--;
				maxHeapify(0);
			}
		}
		private void buildMaxHeap(){
			size = A.length;
			for (int i = size/2; i >= 0; i--){
				maxHeapify(i);
			}
		}
		
		private void maxHeapify(int i){
			int largest = -1, temp;
			int l = left(i);
			int r = right(i);
			//System.out.println(l + " " + r);
			if (l < size && A[l] > A[i])
				largest = l;
			else
				largest = i;
			//System.out.println(largest);
			if (r < size && A[r] > A[largest])
				largest = r;
			if (largest != i){
				temp = A[i];
				A[i] = A[largest];
				A[largest] = temp;
				maxHeapify(largest);
			}	
		}
		
		private int left(int i){
			return 2*i+1;
		}
		
		private int right(int i){
			return 2*i + 2;
		}
		
	}


