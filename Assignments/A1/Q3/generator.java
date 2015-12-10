package Q3;

import java.util.*;
import java.lang.*;
import java.io.*;

public class generator {
	static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static Random random = new Random();
	static int length = 100;

	public static void main(String[] args) {
		try{
			FileWriter writer = new FileWriter("hundredmillionstrings.txt");

			int numStrings = 100000000;

			for (int i = 0; i < numStrings;i++) {
				String string = new String();
				for( int j = 0; j < length; j++ ) {
			      string = string + chars.charAt(random.nextInt(chars.length()));
				}
				writer.write(string + "\n");
			}

			writer.close();
		} catch (IOException e) {
			
		}
	}
}