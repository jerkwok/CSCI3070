import java.util.Arrays;

class InsertionSort
{
	public static void main(String[] args){
		int[] A;
	
		A = new int[10];
	
		A[0] = 22;
		A[1] = 10;
		A[2] = 8;
		A[3] = 15;
		A[4] = 42;
		A[5] = 20;
		A[6] = 100;
		A[7] = 11;
		A[8] = 18;
		A[9] = 1;

		for (int j = 1;j<A.length;j++){	
			int key = A[j];
			
			int i = j-1;
			while(i >= 0 && A[i] > key) {
				A[i+1]=A[i];
				i--;
			}
			A[i+1]=key;	
		}

		for (int x = 0;x < A.length;x++){
			System.out.println("Element at index " + x + " " + A[x]);
		}
	}
}
