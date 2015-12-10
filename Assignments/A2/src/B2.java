//B2 Uses DFS to find all instructors connected to Ken Pu

package src;

import java.util.*;
import java.lang.*;
import java.io.*;

public class B2{
	static proflist profs = new proflist();

	static private void DFS(String s){
		Map<String,String> colour = new HashMap<String,String>(); 
		Map<String,Integer> dist = new HashMap<String,Integer>(); 
		ArrayList<String> results = new ArrayList<String>();

		//set all the colours to white
		for (Map.Entry<String, ArrayList<String>> entry : profs.adjList.entrySet()){
			colour.put(entry.getKey(),"WHITE");
		}

		DFS_Visit(s,colour,results);

		System.out.println("DFS Results:");
		for (int i = 0;i < results.size() ;i++ ) {
			System.out.println(results.get(i));
		}
	}

	static private void DFS_Visit(String s,Map<String,String> colour, ArrayList<String> results){
		//set node colour to gray
		colour.put(s,"GRAY");

		//add node to the results
		results.add(s);

		//visit all the nodes in the adjlist of s
		for (int i = 0;i < profs.adjList.get(s).size();i++){
			if (colour.get(profs.adjList.get(s).get(i)) == "WHITE"){
				DFS_Visit(profs.adjList.get(s).get(i),colour,results);
			}
		}
		//set node colour to gray
		colour.put(s,"BLACK");
	}

	public static void main(String[] args) {
		DFS("Ken Pu");
	}
}