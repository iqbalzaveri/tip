import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class GraphDFSBFS {

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
           if(list == null) {
               list = new LinkedList<Integer>();
           }
           list.add(c);
           adjList[v] = list;
        }

        void printGraphUsingBFS() {
            boolean[] isVisited = new boolean[V];
            Deque<Integer> queue = new ArrayDeque<>();

            for(int i=0; i< adjList.length; i++) { //for each node in the Graph
                if (!isVisited[i]) {
                    queue.offer(i);
                    isVisited[i] = true;

                    while (!queue.isEmpty()) {
                        Integer v = queue.poll();
                        //process v
                        System.out.print(v + " ");

                        LinkedList<Integer> list = adjList[v]; //get neighbors of v or all vertices connected to v
                        if (list != null) {
                            for (Integer c : list) {
                                if (c != null) {
                                    if (!isVisited[c]) {
                                        queue.offer(c);
                                        isVisited[c] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        void printGraphUsingDFS() {
            boolean[] isVisited = new boolean[V];
            for(int i=0; i< adjList.length; i++) { //for each node in the Graph
                if(!isVisited[i]) {
                    dfs(i, isVisited);
                }
            }
        }

        void dfs(Integer v, boolean[] isVisited) {
            isVisited[v]= true;
            System.out.print(v + " "); //process v

            LinkedList<Integer> list = adjList[v]; //get neighbors of v or all vertices connected to v
            if (list != null) {
                for (Integer c : list) {
                    if (c != null && !isVisited[c]) {
                        dfs(c, isVisited);
                    }
                }
            }
        }

        boolean isCycle() {
            boolean[] isVisited = new boolean[V];
            boolean[] isAlive = new boolean[V];

            for(int i=0; i< adjList.length; i++) { //for each node in the Graph
                if(!isVisited[i]) {
                    if(dfsCycle(i, isVisited, isAlive)) {
                        return true;
                    }
                }
            }
            return false; // no cycle found
        }




        boolean dfsCycle(Integer v, boolean[] isVisited, boolean[] isAlive) {
            isVisited[v]= true;
            isAlive[v]= true;

            LinkedList<Integer> list = adjList[v]; //get neighbors of v or all vertices connected to v
            if (list != null) {
                for (Integer c : list) {
                    if (c != null && !isVisited[c]) { // not visited
                        if(dfsCycle(c, isVisited, isAlive)) {
                            return true;
                        }
                    } if (c != null && isVisited[c] && isAlive[c]) { // is is Visited & Alive also which means there is a cycle
                        return true;  //if cycle just simply return
                    }
                }
            }
            isAlive[v] = false; //backtrack because of the path

            return false; //no cycle found so return false.
        }


    } // end of class Graph



    public static void main(String[] args) {  //driver
        Graph graph = new Graph(6);

        graph.addEdge(0,1);
        graph.addEdge(0,4);

        graph.addEdge(1,2);
        graph.addEdge(1,3);

        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(2,0);

        graph.addEdge(3,null);
        graph.addEdge(4,null);

        graph.addEdge(5,2);

        System.out.println("BFS:");
        graph.printGraphUsingBFS();

        System.out.println();

        System.out.println("DFS:");
        graph.printGraphUsingDFS();

        System.out.println();
        System.out.println("is Cycle: "  + graph.isCycle());

    }
}
