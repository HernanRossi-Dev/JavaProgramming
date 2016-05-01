package ca.hernanrossi.TreesAndGraphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**********************************************************************************************************************
 * Created by Hernan Rossi
 *********************************************************************************************************************/
public class DirectedGraph<T> {
    private LinkedList<Node> graph;
    private LinkedList<Integer> labels;
    private int nodes =1;

    DirectedGraph(){
        graph = new LinkedList<>();
        labels = new LinkedList<>();
    }   //  Default constructor for the class

   /*******************************************************************************************************************
     *                                      addNode()
     * @param data
     * @param adjacent              Add a new node to the graph with a unique integer identifier
     ******************************************************************************************************************/
    public void addNode(T data, int[] adjacent){
        Node node = new Node(data, adjacent, nodes);
        this.labels.add(nodes);
        nodes++;
        this.graph.add(node);
    }

    /*******************************************************************************************************************
     *                                      depthFirstSearch()
     *
     * @param labelOne
     * @param labelTwo              Perform a depth first search on the directed graph for a given node to look for a
     *                                  path from labelOne to labelTwo given the two nodes labels as integers
     *****************************************************************************************************************/
     public boolean depthFirstSearch(int labelOne, int labelTwo){
         boolean result = false;
         int[] adjacency = new int[graph.size()+1]; // List to track whether or not a node has been visited: 0 not, 1 has
         Iterator<Node> iterator = graph.iterator();
         if(!labels.contains(labelOne) && !labels.contains(labelTwo)){ // There was an error locating the root and target nodes in the graph
             System.out.print("Error");
             return false;
         } else {
             LinkedList<Integer> path =  perfomsDFS(labelOne, labelTwo, adjacency);
             if(path == null){
                 return false;
             }
             Iterator<Integer> iter = path.iterator();
             while(iter.hasNext()){
                 int label = iter.next();
                 System.out.print(label + " ");
             }
             return (path !=null ? true : false);
         }
     }
    /*****************************************************************************************************************
     *                                       performDFS()
     * @param root
     * @param target
     * @param graphAdjacency
     * @return              perform the recursive traversal for the graph to try and find a path from labelOne to labelTwo
     ******************************************************************************************************************/
     private LinkedList<Integer> perfomsDFS(int root, int target, int[] graphAdjacency){
         LinkedList<Integer> path = new LinkedList<Integer>();
         if(graphAdjacency[root] == 1){
             System.out.println(root + " already visited ");
             return null;
         }
         graphAdjacency[root] = 1;
         if(root == target){
             path.add(root);
             return path;
         }else{
             Node node = findNode(root);
             int[] nodeAdjacency = node.getAdjacent();
             System.out.println(Arrays.toString(nodeAdjacency) + " is the adjacency list");
             for(int n : nodeAdjacency){
                 System.out.println(n + " currently being visited ");
                  // Node visited
                 LinkedList<Integer> result = perfomsDFS(n, target, graphAdjacency);
                 if(result != null) {
                     System.out.println(result + " not null ");
                     path.add(root);
                     path.addAll(result);
                     return path;
                 }
             }
         }
         return path;
     }
    /******************************************************************************************************************
     *                                          findNode()
     * @param label
     * @return              Helper method to find a node in the graph from the given label index
     ******************************************************************************************************************/
    private Node findNode(int label){
        Iterator<Node> iterator = graph.iterator();
        while(iterator.hasNext()){
            Node node = iterator.next();
            int temp =  node.getLabel();
            if( temp == label){
                return node;
            }
        }
        return null;
    }
    /*******************************************************************************************************************
     *                                          Node<T> class
     * @param <T>               A private inner class to create a node to add to the directed graph by the outer
     *                              wrapper class
     ******************************************************************************************************************/
    private class Node<T>{
        private int label;  // The identifier for the specific node instance
        private int[] adjacent;  // int[] array that will have the int values of the node this node points to
        private T data;     // The T type variable for this node's data
        /***************************************************************************************************************
         *                                      Node()
         *              Construct a node with the given data, adjacency list with the integer values of the nodes this
         *                  node points and this specific node integer label given by the directed graph wrapper class
         **************************************************************************************************************/
        Node(T data,int[] adjacent, int label){
            this.label = label;
            this.adjacent = adjacent;
            this.data = data;
        }
        /***************************************************************************************************************
         *                                      getLabel()
         * @return              Return the unique integer identifier label of the specific graph node
         **************************************************************************************************************/
        int getLabel(){         // Return the integer label of this specific node in the graph
            return this.label;
        }
        T getData(){            // Return the data of this node;
            return this.data;
        }
        int[] getAdjacent(){    // Return an adjacency list of this node in
            return this.adjacent;
        }
        void setData(T data){    // Set the data for this specific node
            this.data = data;
        }
    }
}
