package com.myapp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Graph {
	   
    // A utility function to add an edge in an 
    // undirected graph 
    public void addEdge(ArrayList<ArrayList<Integer> > adj, int u, int v, boolean sym) 
    {     	
        adj.get(u).add(v);
        if (sym) {
        	adj.get(v).add(u);
        }
    } 
  
    // A utility function to print the adjacency list 
    // representation of graph 
    public void printGraph(ArrayList<ArrayList<Integer> > adj) 
    { 
        for (int i = 1; i < adj.size(); i++) { 	//int i = 0
            System.out.println("\nAdjacency list of vertex " + i); 
            System.out.print("head"); 
            for (int j = 0; j < adj.get(i).size(); j++) { 	//int j = 0;
                System.out.print(" -> "+adj.get(i).get(j)); 
            } 
            System.out.println(); 
        } 
    }
    
    public void printGraphArr(ArrayList<ArrayList<Integer> > adj) 
    { 
    	System.out.println(); 
        for (int i = 1; i < adj.size(); i++) { 	//int i = 0
            //System.out.println("\nAdjacency list of vertex " + i); 
            for (int j = 0; j < adj.get(i).size(); j++) { 	//int j = 0;
                System.out.print(" "+adj.get(i).get(j)); 
            } 
            System.out.println(); 
        } 
    }
    // max profit city
    List<Integer> profitCity(ArrayList<ArrayList<Integer> > city, int comp) {
    	List<Integer> prof = new ArrayList<Integer>();
    	for (int i=comp-1;i<city.size(); i++) {
    		for (int j = 0; j < city.get(i).size(); j++) { 
                System.out.print(" -> "+city.get(i).get(j));
                if (!prof.contains(city.get(i).get(j)))
                	prof.add(city.get(i).get(j));
            } 
    	}
    	return prof;
    }
    
    // Depth-first search (deep first)
    List<Integer> depthFirstSearch(ArrayList<ArrayList<Integer> > city, int n){
    	List<Integer> far = new ArrayList<Integer>(n);
    	for (int ind=1; ind<=n; ind++) {
			Stack<Integer> stack=new Stack<Integer>();
			// initial add to stack, it may has multiple edges
			List<Integer> indnei=city.get(ind).stream().collect(Collectors.toList());
			for (int i = 0; i < indnei.size(); i++) {
					stack.add(indnei.get(i));	 // add all edges from the 1st one	
			}
			System.out.println(" processing: "+ind+", stack.size()"+stack.size());
			boolean leaf [] = new boolean[n+1];
			int visit[] = new int[n+1];
			visit[ind]=1; // visited first
			//int imax=0, pmax=0;
			//HashSet<Integer> iset = new HashSet();
			//HashSet<Integer> pset = new HashSet();
			while (!stack.isEmpty())
			{
				int element=stack.pop();
				System.out.print("pop up from stack element:"+element);
				List<Integer> neighbours=city.get(element).stream().collect(Collectors.toList());
				System.out.print(", neighbours:");neighbours.forEach(System.out::print);System.out.println();
				
				if(visit[element]==0) {
					System.out.println(element + " is visited.");
					int tmpm=0;
					for (int in=0;in<neighbours.size(); in++) {
						if (visit[neighbours.get(in)]>0) {
							visit[element]=visit[neighbours.get(in)]+1; //visited neighbour's largest length +1
							System.out.println("foud visited neighbour:"+ neighbours.get(in)+", len:"+visit[neighbours.get(in)]+", update element visit:"+visit[element]);							
						}
					}
				} 

				if (neighbours.size()==1 && visit[neighbours.get(0)]>0) {				
					leaf[element]=true;
					System.out.println("reached one path end at element:"+element);
				}
				for (int i = 0; i < neighbours.size(); i++) {
					Integer next=neighbours.get(i);
					if(next!=null && visit[next]==0)
					{
						stack.add(next);
					}
				}
			}
			System.out.println(" leaf node:");
			int tmax=0;
			for (int j=0;j<leaf.length; j++) {
				if (leaf[j]) {
					if (visit[j]>tmax) {
						tmax = visit[j];
					}
					//System.out.println(" "+j+", visited len:"+visit[j]+", tmax:"+tmax);
				}
			}
			far.add(tmax - 1);
			
    	}
    	return far;
    }
}
