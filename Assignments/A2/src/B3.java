//B3 Finds connected components

package src;

import java.util.*;
import java.lang.*;
import java.io.*;

public class B3{
	static proflist profs = new proflist();
	//array tracks visitedness for CC
	static ArrayList<String> visited = new ArrayList<String>();
	static Map<Integer,ArrayList<String>> components = new HashMap<Integer,ArrayList<String>>(); 
	static Map<String,Integer> dist = new HashMap<String,Integer>(); 

	static int componentnum = 0;

	static private void findcomponents(){
		for (Map.Entry<String, ArrayList<String>> entry : profs.adjList.entrySet()){
			dist.put(entry.getKey(),0);
		}

		//iterate over each element in proflist.
		for (Map.Entry<String, ArrayList<String>> entry : profs.adjList.entrySet()){
			//if the prof isn't part of a component yet
			if(dist.get(entry.getKey()) == 0){	
				BFS(entry.getKey());
			}
		}

		printcomponentsize();
	}

	static private void printcomponentsize(){
		System.out.println("Components and their Sizes:");
		for (Map.Entry<Integer, ArrayList<String>> entry : components.entrySet()){
				System.out.println(entry.getKey() + " " + entry.getValue().size());
		}
	}

	static private void BFS(String s){
		ArrayList<String> results = new ArrayList<String>();
		Queue<String> myQueue = new LinkedList<String>();
		myQueue.add(s);
		components.put(componentnum, new ArrayList<String>());

		//while there are still things in the queue
		while (!myQueue.isEmpty()){
			//pop off the first string in the queue
			String currProf = myQueue.remove();
			//for each string in the adjList of the popped string
			for (int i = 0;i < profs.adjList.get(currProf).size();i++){
				//if the dist for that string is -1
				if(dist.get(profs.adjList.get(currProf).get(i)) == 0){	
					//the dist for that string is dist of popped string + 1
					dist.put(profs.adjList.get(currProf).get(i), dist.get(currProf) + 1);
					//put the string into the queue
					myQueue.add(profs.adjList.get(currProf).get(i));
					//add the string into the results array.
					components.get(componentnum).add(profs.adjList.get(currProf).get(i));
					// System.out.println(currProf + "visited set to 1");
					visited.add(currProf);
				}
			}
		}
		componentnum++;
	}

	public static void main(String[] args) {

		findcomponents();
	}
}