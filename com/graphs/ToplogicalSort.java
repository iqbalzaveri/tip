import java.util.LinkedList;

/*
Given a list of courses and their dependencies, print the order in which the courses needs to be taken
In a Linux system, components needs to installed, but certain components depends other components to be installed first
return a list of components in the order they should be installed
 */
public class ToplogicalSort {
    static class Graph {
        int V; // no of nodes or vertices

        //array of linked list with each index as a vertex or node pointing to its relations
        //it can also be a hashmap with key as a vertex pointing to relations in value
        LinkedList<Integer>[] adjList;

        public Graph(int V) {
            this.V = V;
            adjList = new LinkedList[V];
        }

        public void addEdge(int v, Integer c) {
            LinkedList<Integer> list = adjList[v];
            if (list == null) {
                list = new LinkedList<Integer>();
            }
            list.add(c);
            adjList[v] = list;
        }

        public void topologicalSort() {
            //Using DFS
            boolean[] isVisited = new boolean[V];
            for(int i=0; i< adjList.length; i++) { //for each node in the Graph
                if(!isVisited[i]) {
                    dfs(i, isVisited);
                }
            }
        }

        void dfs(Integer v, boolean[] isVisited) {
            isVisited[v]= true;


            LinkedList<Integer> list = adjList[v]; //get neighbors of v or all vertices connected to v
            if (list != null) {
                for (Integer c : list) {
                    if (c != null && !isVisited[c]) {
                        dfs(c, isVisited);
                    }
                }
            }
            System.out.println(v);
        }
    }

    public static void main(String[] args) {  //driver
        Graph graph = new Graph(6);

        graph.addEdge(0, 1);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        graph.addEdge(3, 4);

        graph.addEdge(2, null);
        graph.addEdge(4, null);

        graph.addEdge(5, null);

        graph.topologicalSort();
    }
}
