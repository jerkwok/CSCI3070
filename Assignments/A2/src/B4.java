//B4 Finds radii for each connected component.

package src;

import java.util.*;
import java.lang.*;
import java.io.*;

public class B4{
	static proflist profs = new proflist();
	static ArrayList<String> visited = new ArrayList<String>();
	static Map<Integer,ArrayList<String>> components = new HashMap<Integer,ArrayList<String>>(); 
	static Map<String,Integer> dist = new HashMap<String,Integer>(); 
	static Map<String,Integer> dist_E = new HashMap<String,Integer>(); 
	static ArrayList<Integer> eccentricityList; 

	static int componentnum = 0;

	static private void findcomponents(){
		for (Map.Entry<String, ArrayList<String>> entry : profs.adjList.entrySet()){
			dist.put(entry.getKey(),0);
		}

		//iterate over each element in proflist.
		for (Map.Entry<String, ArrayList<String>> entry : profs.adjList.entrySet()){
			//if the prof isn't part of a component yet
			if(dist.get(entry.getKey()) == 0){	
				BFS(entry.getKey(),"");
			}
		}
		printcomponentsize();
	}

	static private void findcomponentsradius(){
		int radius;
		System.out.println("Components and their Radii:");
		//for each component
		for (Map.Entry<Integer, ArrayList<String>> entry : components.entrySet()){
			//set the base value to the length of the lists
			// int compeccentricity = entry.getValue().size();
			int compeccentricity = entry.getValue().size();
			// int size =entry.getValue().size();
			int size =compeccentricity;
			radius = size;
			//iterate over each pair find the eccentricity of each pair
			for(int i = 0;i < size;i++){
				eccentricityList = new ArrayList<Integer>();
				for (int j = 0; j < size;j++){
					if (entry.getValue().get(i).equals(entry.getValue().get(j)) == false){
						eccentricity(entry.getValue().get(i),entry.getValue().get(j));
					}
				}
				Collections.sort(eccentricityList);
				int temp = eccentricityList.get(eccentricityList.size()-1);
				if ((temp < compeccentricity)){
					compeccentricity = temp;
				}
			}
			System.out.println("Radii of component " + entry.getKey() + ": " + compeccentricity);
		}
	}

	static private void eccentricity(String origin, String dest){

		//reset distances
		for (Map.Entry<String, ArrayList<String>> entry : profs.adjList.entrySet()){
			dist.put(entry.getKey(), 0);
		}

		BFS_E(origin,dest);
	}

	static private void printcomponentsize(){
		System.out.println("Components and their Sizes:");
		for (Map.Entry<Integer, ArrayList<String>> entry : components.entrySet()){
			System.out.println(entry.getKey() + ": " + entry.getValue().size());
		}
	}

	static private void BFS_E(String s, String destination){
		// eccentricityList = new ArrayList<Integer>();
		ArrayList<String> results = new ArrayList<String>();
		Queue<String> myQueue = new LinkedList<String>();
		myQueue.add(s);

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
					// System.out.println(currProf + "visited set to 1");
					visited.add(currProf);
					if (profs.adjList.get(currProf).get(i).equals(destination) == true) {
						eccentricityList.add(dist.get(profs.adjList.get(currProf).get(i)));
					}
				}
			}
		}
	}

	static private void BFS(String s, String destination){
		eccentricityList = new ArrayList<Integer>();
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
					if (profs.adjList.get(currProf).get(i).equals(destination) == true) {
						eccentricityList.add(dist.get(profs.adjList.get(currProf).get(i)));
					}
				}
			}
		}
		componentnum++;
	}

	public static void main(String[] args) {

		findcomponents();
		findcomponentsradius();
	}
}
