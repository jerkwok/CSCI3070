package Q2;

import java.util.*;
import java.lang.*;


public class stringArray {
	String strings[] = new String[1000000];
	static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static Random random = new Random();

	/*-----------------------------
	---------------------Merge Sort
	-----------------------------*/

	//Merge function
	private void Merge(int start, int mid, int end){
		String L[] = Arrays.copyOfRange(strings, start, mid+1);
		String R[] = Arrays.copyOfRange(strings, mid+1, end+1);

		int i = 0;
		int j = 0;

		for (int k = start; k < end+1; k++){
			if (i>L.length-1){
				strings[k] = R[j];
				j++;
			}else if(j>R.length-1){
				strings[k] = L[i];
				i++;
			}else if (L[i].compareTo(R[j]) < 0){
				strings[k] = L[i];
				i++;
			} else {
				strings[k] = R[j];
				j++;
			}
		}

		// for (int r = start; r < strings.length; r++){
		// 	System.out.println("strings:" + strings[r]);
		// }
	}

	//Merge sort function
	public void MergeSort(int start, int end){
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

	/*-----------------------------
	---------------------Quick Sort
	-----------------------------*/

	private int Partition(int p, int r){
		String pivot = strings[r];
		int i = p - 1;

		for (int j = p; j < r; j++){
			if (strings[j].compareTo(pivot) < 1){
				i++;
				String temp = strings[i];
				strings[i] = strings[j];
				strings[j] = temp;
			}
		}

		String temp = strings[i+1];
		strings[i+1] = strings[r];
		strings[r] = temp;

		return i+1;
	}

	public void Quicksort(int start, int end){
		if (start < end){
			int mid = Partition(start, end);
			Quicksort(start, mid-1);
			Quicksort(mid+1, end);
		}
	}
	/*-----------------------------
	--------------End of Quick Sort
	-----------------------------*/

	/*-----------------------------
	----------------------Heap Sort
	-----------------------------*/

	private void MaxHeapify(int i, int n){
		int left = (2*i)+1;
		int right = left+1;
		int largest = 0;
		
		if(left <= n){
			if(strings[left].compareTo(strings[i]) > 0){
				largest = left;
			}else{
				largest = i;
			}
		}else{
			largest = i;
		}

		if(right <=n){
			if(strings[right].compareTo(strings[largest]) > 0){
				largest = right;
			}
		}

		if(largest!=i){
			String temp = strings[i];
			strings[i] = strings[largest];
			strings[largest] = temp;
			MaxHeapify(largest, n);
		}
	}

	private void BuildMaxHeap(int n){
		for(int i = (n/2)+1;i >= 0; i--){
			MaxHeapify(i, n);
		}
	}

	public void HeapSort(int n){
		BuildMaxHeap(n);
		for(int i = n; i >= 2; i--){
			String temp = strings[i];
			strings[i] = strings[0];
			strings[0] = temp;
			MaxHeapify(0,i-1);
		}
	}

	/*-----------------------------
	---------------End of Heap Sort
	-----------------------------*/

	public void jumble(){
		for (int x = 0; x < strings.length;x++) {
			strings[x] = randomString(100);
		}
	}

	static String randomString(int length){
	   String myString = new String("");
	   for( int i = 0; i < length; i++ ) 
	      myString = myString + chars.charAt(random.nextInt(chars.length()));

	   return myString;
	}
}