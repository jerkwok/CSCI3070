import java.util.*;
import java.lang.*;

public class test {

	public static boolean foo(){
		System.out.println("foo");
		return true;
	}

	public static boolean bar(){
		System.out.println("bar");
		return false;
	}

	public static boolean fish(){
		return (foo() || bar());	
	}

	public static void main(String[] args){
		boolean var = fish();
		System.out.println(var);
	}
}