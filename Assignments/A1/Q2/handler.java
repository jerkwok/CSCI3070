package Q2;

import java.util.*;
import java.lang.*;
import java.io.*;

public class handler {

	public static void main(String[] args) {
		try{
			FileWriter writer = new FileWriter("merge.txt", true);

			long startTime = System.currentTimeMillis();
			stringArray myArray = new stringArray();

			myArray.jumble();
			long endTime = System.currentTimeMillis();

			startTime = System.currentTimeMillis();
			myArray.MergeSort(0, myArray.strings.length-1);
			endTime = System.currentTimeMillis();
			long mergeduration = (endTime - startTime);
			writer.write(String.valueOf((int)mergeduration));
			writer.write("\n");
			writer.close();

			writer = new FileWriter("quick.txt", true);
			myArray.jumble();
			
			startTime = System.currentTimeMillis();
			myArray.Quicksort(0,myArray.strings.length-1);
			endTime = System.currentTimeMillis();
			long quickduration = (endTime - startTime);
			writer.write(String.valueOf((int)quickduration));
			writer.write("\n");
			writer.close();

			myArray.jumble();

			writer = new FileWriter("heap.txt", true);
			startTime = System.currentTimeMillis();
			myArray.HeapSort(myArray.strings.length-1);
			endTime = System.currentTimeMillis();
			long heapduration = (endTime - startTime);
			writer.write(String.valueOf((int)heapduration));			
			writer.write("\n");
			writer.close();
		}catch (IOException e) {
			
		}
	}
}