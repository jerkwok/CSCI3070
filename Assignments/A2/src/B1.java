//B1 Uses BFS to find all instructors connected to Ken Pu

package src;

import java.util.*;
import java.lang.*;
import java.io.*;

public class B1{
	//proflist loads the profs from the file, and contains the adjlists of the profs (in alpha order)
	static proflist profs = new proflist();
	static private void BFS(String s){
		//dist holds all the 
		Map<String,Integer> dist = new HashMap<String,Integer>();

		//results array will store all connections to s 
		ArrayList<String> results = new ArrayList<String>();

		for (Map.Entry<String, ArrayList<String>> entry : profs.adjList.entrySet()){
			dist.put(entry.getKey(),-1);
		}

		Queue<String> myQueue = new LinkedList<String>();
		myQueue.add(s);

		//while there are still things in the queue
		while (!myQueue.isEmpty()){
			//pop off the first string in the queue
			String currProf = myQueue.remove();
			//for each string in the adjList of the popped string
			for (int i = 0;i < profs.adjList.get(currProf).size();i++){
				//if the dist for that string is -1
				if(dist.get(profs.adjList.get(currProf).get(i)) == -1){	
					//the dist for that string is dist of popped string + 1
					dist.put(profs.adjList.get(currProf).get(i), dist.get(currProf) + 1);
					//put the string into the queue
					myQueue.add(profs.adjList.get(currProf).get(i));
					//add the string into the results array.
					results.add(profs.adjList.get(currProf).get(i));
				}
			}
		}

		//print the results
		System.out.println("BFS Results:");
		for (int i = 0;i < results.size() ;i++ ) {
			System.out.println(results.get(i));
		}
	}

	public static void main(String[] args) {
		BFS("Ken Pu");
	}
}