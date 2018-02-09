import java.util.ArrayList;
import java.util.Random;

public class Lab6 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();	
		Random num = new Random();
		 for (int i = 0; i < 100; i++)
				list.add(num.nextInt(9) + 1);
		 for (int i = 0; i < list.size(); i++)
				System.out.print(list.get(i) + " ");
			System.out.println();
			novelSort(list, 0, list.size()-1);
			for (int i = 0; i < list.size(); i++)
				System.out.print(list.get(i) + " ");
	}
	
	private static void novelSort(ArrayList<Integer> list, int start, int end)
	{
		if (start <= end)
		{
			int smallest = list.get(start);
			int largest = list.get(end);
			for (int i = start; i < end; i++)
			{
				if (list.get(i) < smallest)
				{
					smallest = list.get(i);
					swap(list, i, start);
				}
			}
			for (int i = start; i < end; i++)
			{
				if (list.get(i) > largest)
				{
					largest = list.get(i);
					swap(list, i, end);
				}	
			}
			//start++;
			//end--;
			novelSort(list, start + 1, end -1);
		}
	}
	
	private static void swap(ArrayList<Integer> A, int i, int j)
	{
		int temp = A.get(i);
		A.set(i, A.get(j));
		A.set(j, temp);
	}

}
