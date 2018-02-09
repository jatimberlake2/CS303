import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.print.attribute.IntegerSyntax;

public class Lab6H2 {

	public static void main(String[] args) {
		try 
		{		
			Scanner derp = new Scanner(new File("NovelSortInput.txt"));
			ArrayList<Record2> records = readInNums(derp);
			printArrayList(records);
			System.out.println();
			
			Record2[] recordsArray = new Record2[records.size()];
			for (int i = 0; i < records.size(); i++)
				recordsArray[i] = records.get(i);
			
			//ArrayList<Record2> sortedTimes = RadixSort(records);
			//ArrayList<Record2> sortedTemp = new ArrayList<Record2>();
			//insertMergeSort(sortedTimes, sortedTemp, 0, sortedTimes.size()-1, 4);
			//printArrayList(sortedTimes);
			
			System.out.println("\n\n");
			Record2[] sortedTimes = RadixSort(recordsArray);
			Record2[] sortedTemp = new Record2[sortedTimes.length];
			insertMergeSort(sortedTimes, sortedTemp, 0, sortedTimes.length-1, 4);
			printArray(sortedTimes);
			
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}

	}
	
	private static void printArray(Record2[] records)
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
	private static ArrayList<Record2> readInNums(Scanner derp)
	{
		ArrayList<Record2> list = new ArrayList<Record2>();
		while(derp.hasNextLine()){
		   String line = derp.nextLine();
		   String[] recordParts = line.split(" ");
		   String[] timeParts = recordParts[1].split(":");
		   list.add(new Record2(recordParts[0], Integer.parseInt(timeParts[0]),Integer.parseInt(timeParts[1]),Integer.parseInt(timeParts[2])));
		}
		return list;
	}
	private static void printArrayList(ArrayList<Record2> records)
	{
		for (int i = 0; i < records.size(); i++)
		{
			String hrsPrint = "" + records.get(i).getHours();
			String minPrint = "" + records.get(i).getMinutes();
			String secPrint = "" + records.get(i).getSeconds();
			if (records.get(i).getHours() < 10)
				hrsPrint = "0" + records.get(i).getHours();
			if (records.get(i).getMinutes()< 10)
				minPrint = "0" + records.get(i).getMinutes();
			if (records.get(i).getSeconds() < 10)
				secPrint = "0" + records.get(i).getSeconds();
			System.out.println(records.get(i).getCity() + " " + hrsPrint + ":" + minPrint + ":" + secPrint);
		}
	
	}
	private static Record2[] RadixSort(Record2[] a) {	
		
		//Using counting sort, first pass through is sorting by seconds.
        Record2[] b = new Record2[a.length];
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
        Record2[] b2 = new Record2[a.length];
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
        Record2[] b3 = new Record2[a.length];
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
	private static void insertMergeSort( Record2[] A, Record2[] temp, int p, int r, int cutoff )
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
	private static void merge( Record2[] A, Record2[] temp, int p, int q, int r)
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
	private static void insertionSort(Record2[] list, int p, int r)
	{		
		for (int j = p; j <= r; j++)
		{
			Record2 key = list[j];
			int i = j - 1;
			while (i >= 0 && list[i].getCity().compareTo(key.getCity()) > 0 )
			{
				list[i+1] = list[i];
				i--;
			}
			list[i+1] = key;
		}

	}
/*
	private static ArrayList<Record2> RadixSort(ArrayList<Record2> a) {	
		
		//Using counting sort, first pass through is sorting by seconds.
        ArrayList<Record2> b = new ArrayList<Record2>();
        for (int z = 0; z < a.size(); z++)
        	b.add(new Record2());
        int k = 59;	//only values from 0 to 59 able to be represented in seconds field
	   	int[] c = new int[k+1];
		for (int j = 0; j < a.size(); j++){
			c[a.get(j).getSeconds()]++;
		}
		for (int i = 1; i <= k; i++){
			c[i] = c[i] + c[i - 1];
		}
		for (int j = a.size() - 1; j >= 0; j--){
			b.set(c[a.get(j).getSeconds()] - 1, a.get(j));
			c[a.get(j).getSeconds()]--;
		}
		
		//Using counting sort, second pass through is sorting by minutes.
		ArrayList<Record2> b2 = new ArrayList<Record2>();
        for (int z = 0; z < a.size(); z++)
        	b2.add(new Record2());
        //only values from 0 to 59 able to be represented in minutes field, so k need not be changed
	   	c = new int[k+1];
		for (int j = 0; j < a.size(); j++){
			c[b.get(j).getMinutes()]++;
		}
		for (int i = 1; i <= k; i++){
			c[i] = c[i] + c[i - 1];
		}
		for (int j = a.size() - 1; j >= 0; j--){
			b2.set(c[b.get(j).getMinutes()] - 1, b.get(j));
			c[b.get(j).getMinutes()]--;
		}
		
		//Using counting sort, third pass through is sorting by hours.
		ArrayList<Record2> b3 = new ArrayList<Record2>();
        for (int z = 0; z < a.size(); z++)
        	b3.add(new Record2());
        k = 23; //only values from 0 to 23 can be represented in hours
	   	c = new int[k+1];
		for (int j = 0; j < a.size(); j++){
			c[b2.get(j).getHours()]++;
		}
		for (int i = 1; i <= k; i++){
			c[i] = c[i] + c[i - 1];
		}
		for (int j = a.size() - 1; j >= 0; j--){
			b3.set(c[b2.get(j).getHours() - 1], b2.get(j));
			c[b2.get(j).getHours()]--;
		}
		
		return b3;
    }
	private static void insertMergeSort( ArrayList<Record2> A, ArrayList<Record2> temp, int p, int r, int cutoff )
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
	
	private static void merge( ArrayList<Record2> A, ArrayList<Record2> temp, int p, int q, int r)
	{
		// merge A[p..q] with A[q+1..r]
		int i = p;
		int j = q + 1;
		
		// copy A[p..r] to temp[p..r]
		for (int k = p; k <= r; k++)
			temp.add(A.get(k));
		
		//merge back to A[p..r]
		for (int k = p; k <= r; k++)
		{
			if (i > q)	// left half empty, copy from the right
			{
				A.set(k, temp.get(i));
				j++;
			}
			else if (j > r)	// right half empty, copy from the left
			{
				A.set(k, temp.get(i));
				i++;
			}
			else if (temp.get(j).getCity().compareTo(temp.get(i).getCity()) < 0)	// copy from the right
			{
				A.set(k, temp.get(j));
				j++;
			}
			else
			{
				A.set(k, temp.get(i));	// copy from the left
				i++;
			}
			
		}
	}

	private static void insertionSort(ArrayList<Record2> list, int p, int r)
	{		
		for (int j = p; j <= r; j++)
		{
			Record2 key = list.get(j);
			int i = j - 1;
			while (i >= 0 && list.get(i).getCity().compareTo(key.getCity()) > 0 )
			{
				list.set(i+1, list.get(i));
				i--;
			}
			list.set(i+1, key);
		}

	}
*/

}

class Record2 {
	private int seconds, minutes, hours;
	private String city;
	
	public Record2()
	{
		city = "";
		hours = 0;
		minutes = 0;
		seconds = 0;
	}
	public Record2(String place, int hrs, int min, int sec)
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
