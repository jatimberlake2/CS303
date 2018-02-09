import java.util.Arrays;

public class Lab1 {

	public static void main(String[] args) {
		//Generate list of random integers within range of N
		int[] nums = initializeList(9);

		//Print out the first list.
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		
		System.out.println();
		
		//Linear Search
		int result = linearSearch(nums, 4);
		if (result == -1) 
			System.out.println("Not here!");
		else
			System.out.println("The value was found at index " + result + " in the array (0 based counting).");
		
		System.out.println();
		
		//Generate a second list of random integers within range of N
		int[] nums2 = initializeList(9);

		//Print out the second list.
		Arrays.sort(nums2);
		for (int i = 0; i < nums2.length; i++) {
			System.out.print(nums2[i] + " ");
		}
		
		System.out.println();
		
		//Binary Search
		int result2 = binarySearch(nums2, 0, nums2.length-1, 7);
		if (result2 == -1)
			System.out.println("Not here!");
		else
			System.out.println("The value was found at index " + result2 + " in the array (0 based counting).");
				
	}
	
	public static int[] initializeList(int N) {
		int[] numbers = new int[N];       
	    for(int i = 0; i < numbers.length; i++) {
	      numbers[i] = (int)(Math.random()*N + 1);
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
