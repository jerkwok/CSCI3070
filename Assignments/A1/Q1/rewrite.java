import java.util.*;
import java.lang.*;

public class rewrite {
	
	public static boolean nonrecursivef(int mylist[]){
		for (int x = 0; x < mylist.length; x++){
			if (mylist[x] == 0){
				return true;
			} 
		}
		return false;
	}

	public static void main(String[] args) {
		int list1[] = {1,2,3,4,5,6,7,8,9};
		int list2[] = {1,2,3,4,5,6,7,8,9,0};
		System.out.println(nonrecursivef(list1));
		System.out.println(nonrecursivef(list2));
	}
}