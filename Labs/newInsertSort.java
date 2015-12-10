import java.util.Arrays;


public class newInsertSort {

	public static void main(String[] args) {
		
		//create and populate array
		int nums[] = new int[10];
		populateArray(nums);
		
		//output populated array
		System.out.println("Before Sorting:");
		printArray(nums);
		
		//sort the beast
		insertionSort(nums);
		
		//output the sorted array
		System.out.println("After Sorting);");
		printArray(nums);

	} //end main
	
	
	private static void insertionSort( int [ ] a){
	     int j; //index of key
	     int key; //value of key
	     int i; //index value being compared to the key

	     for (j = 1; j< a.length; j++){
	     	key = a[j];
	     	i = j-1;

	     	while(i > =0 && a[i] > key){
	     		a[i+1]=a[i];
	     		i--;
	     	}

	     	a[i+1]=key;
	     }

	           
	     
	} //end insertionSort
	
	
	
	private static void populateArray(int [] b) {
		for (int i = 0; i < b.length; i++) 
			b[i] = (int) (Math.random() * 100);
		
	} //end populateArray
	
	private static void printArray(int [] b) {
		System.out.println(Arrays.toString(b));
	} //end printArray
	

}