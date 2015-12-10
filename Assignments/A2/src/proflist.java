package src;

import java.util.*;
import java.lang.*;
import java.io.*;

public class proflist {
	Map<String, ArrayList<String>> adjList = new TreeMap<String,ArrayList<String>>();
	ArrayList<ArrayList<Boolean>> adjMatrix = new ArrayList<ArrayList<Boolean>>();
	ArrayList<String> vertices = new ArrayList<String>();
	
	public proflist(){
		try{
			BufferedReader reader = new BufferedReader(new FileReader("instructor-pair.txt"));
			String currLine = reader.readLine();

			ArrayList<String> prof1 = new ArrayList<String>();
			ArrayList<String> prof2 = new ArrayList<String>();

			//currLine is the next pair of professors
			while(currLine != null){
				if (currLine != null){
					//split the professor names
					String[] parts = currLine.split("\\s{2,}");

					//removes the last char space that some names have
					if (parts[1].charAt(parts[1].length() - 1) == ' '){
						parts[1] = parts[1].substring(0,parts[1].length()-1);
					}

					//check if the adjList contains the first professor
					if (adjList.containsKey(parts[0])){
						prof2 = adjList.get(parts[0]);
						prof2.add(parts[1]);

						adjList.put(parts[0],prof2);
					}else{
						//if the prof doesn't exist in our list already add it in.
						prof2 = new ArrayList<String>();
						prof2.add(parts[1]);
						adjList.put(parts[0],prof2);
					}

					//do this again for the other prof, making it bidirectional
					if (adjList.containsKey(parts[1])){
						prof2 = adjList.get(parts[1]);
						prof2.add(parts[0]);
						adjList.put(parts[1],prof2);
					}else{
						//if the prof doesn't exist in our list already add it in.
						prof2 = new ArrayList<String>();
						prof2.add(parts[0]);
						adjList.put(parts[1],prof2);
					}

				}
				currLine = reader.readLine();
			}

			reader.close();

			//fill our vertices array
			for (Map.Entry<String, ArrayList<String>> currProf : adjList.entrySet()){
				//sort the adjList alphabetically
				Collections.sort(currProf.getValue());
				vertices.add(currProf.getKey());
			}


		}catch (IOException e) {
			System.out.println("file not found");
		}
	}
}
