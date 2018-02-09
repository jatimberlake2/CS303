import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab6H {
	public static void main(String[] args) {
		try 
		{		
			Scanner derp = new Scanner(new File("NovelSortInput.txt"));
			ArrayList<Record> records = readInNums(derp);			
			Record[] recordsArray = new Record[records.size()];
			for (int i = 0; i < records.size(); i++)
				recordsArray[i] = records.get(i);
			printArray(recordsArray);
			System.out.println("\n\n");
			Record[] sortedTimes = RadixSort(recordsArray);
			Record[] sortedTemp = new Record[sortedTimes.length];
			insertMergeSort(sortedTimes, sortedTemp, 0, sortedTimes.length-1, 4);
			printArray(sortedTimes);
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void printArray(Record[] records)
	{

		for (int i = 0; i < records.length; i++)
		{		
			String hrsPrint = "" + records[i].getHours();
			String minPrint = "" + records[i].getMinutes();
			String secPrint = "" + records[i].getSeconds();
			if (records[i].getHours()< 10)
				hrsPrint = "0" + records[i].getHours();
			if (records[i].getMinutes()< 10)
				minPrint = "0" + records[i].getMinutes();
			if (records[i].getSeconds()< 10)
				secPrint = "0" + records[i].getSeconds();
			System.out.println(records[i].getCity() + " " + hrsPrint + ":" + minPrint + ":" + secPrint);

		}
	}
	private static ArrayList<Record> readInNums(Scanner derp)
	{
		ArrayList<Record> list = new ArrayList<Record>();
		while(derp.hasNextLine()){
		   String line = derp.nextLine();
		   String[] recordParts = line.split(" ");
		   String[] timeParts = recordParts[1].split(":");
		   list.add(new Record(recordParts[0], Integer.parseInt(timeParts[0]),Integer.parseInt(timeParts[1]),Integer.parseInt(timeParts[2])));
		}
		return list;
	}
	private static Record[] RadixSort(Record[] a) {	
		
		//Using counting sort, first pass through is sorting by seconds.
        Record[] b = new Record[a.length];
        int k = 59;	//only values from 0 to 59 able to be represented in seconds field
	   	int[] c = new int[k+1];
		for (int j = 0; j < a.length; j++){
			c[a[j].getSeconds()]++;
		}
		for (int i = 1; i <= k; i++){
			c[i] = c[i] + c[i - 1];
		}
		for (int j = a.length - 1; j >= 0; j--){
			b[c[a[j].getSeconds()] - 1] = a[j];
			c[a[j].getSeconds()]--;
		}
		
		//Using counting sort, second pass through is sorting by minutes.
        Record[] b2 = new Record[a.length];
        //only values from 0 to 59 able to be represented in minutes field, so k need not be changed
	   	c = new int[k+1];
		for (int j = 0; j < a.length; j++){
			c[b[j].getMinutes()]++;
		}
		for (int i = 1; i <= k; i++){
			c[i] = c[i] + c[i - 1];
		}
		for (int j = a.length - 1; j >= 0; j--){
			b2[c[b[j].getMinutes()] - 1] = b[j];
			c[b[j].getMinutes()]--;
		}
		
		//Using counting sort, third pass through is sorting by hours.
        Record[] b3 = new Record[a.length];
        k = 23; //only values from 0 to 23 can be represented in hours
	   	c = new int[k+1];
		for (int j = 0; j < a.length; j++){
			c[b2[j].getHours()]++;
		}
		for (int i = 1; i <= k; i++){
			c[i] = c[i] + c[i - 1];
		}
		for (int j = a.length - 1; j >= 0; j--){
			b3[c[b2[j].getHours()] - 1] = b2[j];
			c[b2[j].getHours()]--;
		}
		
		return b3;
    }
	private static void insertMergeSort( Record[] A, Record[] temp, int p, int r, int cutoff )
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
	private static void merge( Record[] A, Record[] temp, int p, int q, int r)
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
			else if (temp[j].getCity().compareTo(temp[i].getCity()) < 0)	// copy from the right
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
	private static void insertionSort(Record[] list, int p, int r)
	{		
		for (int j = p; j <= r; j++)
		{
			Record key = list[j];
			int i = j - 1;
			while (i >= 0 && list[i].getCity().compareTo(key.getCity()) > 0 )
			{
				list[i+1] = list[i];
				i--;
			}
			list[i+1] = key;
		}

	}
}

class Record {
	private int seconds, minutes, hours;
	private String city;
	public Record()
	{
		city = "";
		hours = 0;
		minutes = 0;
		seconds = 0;
	}
	public Record(String place, int hrs, int min, int sec)
	{
		city = place;
		hours = hrs;
		minutes = min;
		seconds = sec;
	}
	public String getCity()
	{
		return city;
	}
	public int getHours()
	{
		return hours;
	}
	public int getMinutes()
	{
		return minutes;
	}
	public int getSeconds()
	{
		return seconds;
	}
}
