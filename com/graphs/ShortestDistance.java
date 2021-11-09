import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class ShortestDistance {
    static class NodeInfo {
        Integer node;
        int count;

        NodeInfo(Integer node, int count) {
            this.node = node;
            this.count = count;
        }
    }
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
        public int shortestDist(Integer src, Integer dest) {
            boolean[] isVisited = new boolean[V];
            Deque<NodeInfo> queue = new ArrayDeque<>();

            queue.offer(new NodeInfo(src, 0));
            isVisited[src] = true;

            while (!queue.isEmpty()) {
                NodeInfo nodeInfo = queue.poll();
                if(nodeInfo.node == dest) { //we found our destination node!
                    return nodeInfo.count;
                }

                LinkedList<Integer> list = adjList[nodeInfo.node]; //get neighbors of v or all vertices connected to v
                if (list != null) {
                    for (Integer c : list) {
                        if (c != null) {
                            if (!isVisited[c]) {
                                queue.offer(new NodeInfo(c, nodeInfo.count + 1));
                                isVisited[c] = true;
                            }
                        }
                    }
                }
            }

            return -1;


        }
    }

        public static void main(String[] args) {  //driver
            Graph graph = new Graph(5);

            graph.addEdge(0, 1);
            graph.addEdge(0, 4);

            graph.addEdge(1, 2);

            graph.addEdge(2, 3);

            graph.addEdge(3, null);

            graph.addEdge(4, 3);

            System.out.println("Shortest distance : " + graph.shortestDist(0, 3));

        }
}
