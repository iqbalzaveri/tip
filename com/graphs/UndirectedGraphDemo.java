package com.graphs;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class UndirectedGraph {
    LinkedList<Integer>[] adjList; //adjacency list

    public UndirectedGraph(int v) {
      adjList = new LinkedList[v];
    }

    public void addEdge(int v, int c) {
      addEdgeHelper(v,c);
      addEdgeHelper(c,v);
    }

  public void addEdgeHelper(int v, int c) {
    LinkedList<Integer> list = adjList[v];
    if(list == null) {
      list = new LinkedList<Integer>();
    }
    list.add(c); //can add check if c already exists.
    adjList[v] = list;
  }
  

    void printGraphUsingBFS() {
      boolean[] isVisited = new boolean[adjList.length];
      Deque<Integer> queue = new ArrayDeque<>();

      for(int i=0; i<adjList.length; i++) {

        if(!isVisited[i]) {
          queue.offer(i);
          isVisited[i] = true; //mark it as visited
        }

        while (!queue.isEmpty()) {
          //process node
          Integer v = queue.poll();
          System.out.println(v + " ");


          //get all neighbors
          LinkedList<Integer> list = adjList[v];
          if(list != null) {
            for(Integer c : list) {
              if(c != null && !isVisited[c]) {
                queue.offer(c);
                isVisited[c] = true; //mark it as visited
              }
            }
          }

        } // enf of while loop
      } //for loop
    }

  public void printGraphUsingDFS() {
    boolean[] isVisited = new boolean[adjList.length];
    for(int i=0; i<adjList.length; i++) {
      if(!isVisited[i]) {
        dfs(i, isVisited);
      }
    }

  }

  public void dfs(int i, boolean[] isVisited) {
    isVisited[i] = true;
    System.out.print(i + " ");

    LinkedList<Integer> list = adjList[i];
    if(list != null) {
      for(Integer v : list) {
        if(v != null && !isVisited[v]) {
          dfs(v, isVisited);
        }
      }
    }
  }

  public boolean isCycle() {
    boolean[] isVisited = new boolean[adjList.length];
    boolean[] isAlive = new boolean[adjList.length];
    for(int i=0; i<adjList.length; i++) {
      if(!isVisited[i]) {
         if(isDFSCycle(i, isVisited, isAlive)) {
           return true;
         }
      }
    }
    return false;
  }

  public boolean isDFSCycle(int i, boolean[] isVisited, boolean[] isAlive) {
    isVisited[i] = true; //mark node i as visited
    isAlive[i] = true; //mark node i as alive

    LinkedList<Integer> list = adjList[i];
    if(list != null) {
      for(Integer v : list) {
        if(!isVisited[v]) {
          if(isDFSCycle(v, isVisited, isAlive)) { //if cycle found
            return true;
          }
        } else if(isAlive[v]) { //visited and alive
          return  true;
        } //end for loop
      }
    }

    isAlive[i] = false; //backtrack, node is longer active
    return false; //no cycle found
  }

  public void printNumberOfConnectComponents() {
    boolean[] isVisited = new boolean[adjList.length];
    int count = 0;
    for(int i=0; i<adjList.length; i++) {
      if(!isVisited[i]) {
        dfs(i, isVisited);
        count++;
      }
    }

    System.out.println("Number of connect components: " + count);
  }
}

public class UndirectedGraphDemo {
    public static void main(String[] args) {
      UndirectedGraph graph = new UndirectedGraph(5);

      graph.addEdge(0,3);
      graph.addEdge(0,4);
      graph.addEdge(1,2);

      graph.printGraphUsingBFS();
      
      graph.printNumberOfConnectComponents();


    }
}
