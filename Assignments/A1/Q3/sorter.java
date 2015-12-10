package Q3;

import java.util.*;
import java.lang.*;
import java.io.*;

public class sorter {

	static int numStrings = 100000000;
	static int splits = 100;
	static String mstrings [] = new String[numStrings/splits];

	/*-----------------------------
	---------------------Merge Sort
	-----------------------------*/

	//Merge function
	private static void Merge(int start, int mid, int end){
		String L[] = Arrays.copyOfRange(mstrings, start, mid+1);
		String R[] = Arrays.copyOfRange(mstrings, mid+1, end+1);

		int i = 0;
		int j = 0;

		for (int k = start; k < end+1; k++){
			if (i>L.length-1){
				mstrings[k] = R[j];
				j++;
			}else if(j>R.length-1){
				mstrings[k] = L[i];
				i++;
			}else if (L[i].compareTo(R[j]) < 0){
				mstrings[k] = L[i];
				i++;
			} else {
				mstrings[k] = R[j];
				j++;
			}
		}
	}

	//Merge sort function
	public static void MergeSort(int start, int end){
		if (start<end){
			int mid = start+(end-start)/2;
			MergeSort(start, mid);
			MergeSort(mid+1, end);
			Merge(start, mid, end);
		}
	}

	/*-----------------------------
	--------------End of Merge Sort
	-----------------------------*/


	private static void split(BufferedReader inWriter, int num){
		//reads one tenth of the total strings, stores them in memory
		//sorts them, and writes to a file. 
		try{
			PrintWriter outWriter = new PrintWriter(num+".dat");

			//read
			for (int i = 0;i<(numStrings/splits) ;i++ ) {
				String currString = inWriter.readLine();
				mstrings[i] = currString;
			}

			//sort
			MergeSort(0, mstrings.length-1);

			//write
			for (int i = 0;i<(numStrings/splits) ;i++ ) {
				outWriter.write(mstrings[i]+"\n");
			}

			outWriter.close();
		} catch (IOException e) {
			
		}
	}


	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		//split the strings into [splits] sorted files
		try{
			BufferedReader reader = new BufferedReader(new FileReader("hundredmillionstrings.txt"));	
			for (int i = 0; i<splits ;i++ ) {
				split(reader,i);
				// System.out.println("split complete:"+i);
			}
			reader.close();
		}catch (IOException e) {
			
		}

		//merge the ten files into one sorted file via mergesort.
		try{
			PrintWriter outWriter = new PrintWriter("sorted.txt");
			BufferedReader reader[] = new BufferedReader[splits];
			String strings[] = new String[splits];
			int count = 0;

			//init bufferedreaders and memory local strings
			for (int i = 0; i < splits ; i++ ) {
				reader[i] = new BufferedReader(new FileReader(i+".dat"));
				strings[i] = reader[i].readLine();
			}

			//write largest into sorted file
			for (int j = 0;j < numStrings; j++ ) {
				String largest = "a";
				String currString = new String();
				int largestLoc = 0;

				//get top from each dat file.
				for (int i = 0; i < splits ; i++ ) {
					if (strings[i] != null){
						if (largest.compareTo(strings[i]) > 0){
							largest = strings[i];
							largestLoc = i;
						}
					}
				}

				//print out largest
				if ((largest != null) && (largest != "a")){
					outWriter.write(largest+"\n");
					strings[largestLoc] = reader[largestLoc].readLine();
				}
			}

			//close all the readers
			for (int i = 0; i < splits ; i++ ) {
				reader[i].close();
			}

			outWriter.close();

		}catch (IOException e) {
			
		}

		//print runtime
		long endTime = System.currentTimeMillis();
		try{
			PrintWriter runWriter = new PrintWriter("runtime.txt");
			long duration = (endTime - startTime);
			runWriter.write(Long.toString(duration));
			System.out.println(duration);
		}catch (Exception e) {
			
		}

	}
}