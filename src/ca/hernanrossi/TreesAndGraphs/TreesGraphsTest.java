package ca.hernanrossi.TreesAndGraphs;

import java.util.ArrayList;

/**********************************************************************************************************************
 * Created by Hernan Rossi
 *********************************************************************************************************************/
public class TreesGraphsTest {
    public static void main(String[] args){
        ArrayList<Integer> ordered = new ArrayList<>();
        for(int i =0 ; i <= 10; i++){
            ordered.add(i);
        }
        MinimalTree<Integer> test = new MinimalTree(ordered);
        BinaryTreeNode<Integer> root = test.createMinimalTree();
        BinaryTreeTraversal<Integer> traversal = new BinaryTreeTraversal<>();
        System.out.println("In order");
        traversal.inOrderTraversal(root);
        System.out.println("");
        System.out.println("pre order");
        traversal.preOrderTraversal(root);
        System.out.println("");
        System.out.println("post order");
        traversal.postOrderTraversal(root);
        System.out.println("");


        //testDirectedGraphDFS();
    }



    public static void testDirectedGraphDFS(){
        DirectedGraph<Integer> graph = new DirectedGraph();
        graph.addNode(1, new int[] {2, 11, 10});
        graph.addNode(2, new int[] {12, 3});
        graph.addNode(3, new int[] {15, 7});
        graph.addNode(4, new int[] {5});
        graph.addNode(5, new int[] {6, 4});
        graph.addNode(6, new int[] {11});
        graph.addNode(7, new int[] {5, 8});
        graph.addNode(8, new int[] {6, 9});
        graph.addNode(9, new int[] {11});
        graph.addNode(10, new int[] {9});
        graph.addNode(11, new int[] {13,14});
        graph.addNode(12, new int[] {4, 3 ,7 ,11});
        graph.addNode(13, new int[] {1, 14});
        graph.addNode(14, new int[] {9, 8});
        graph.addNode(15, new int[] {2});
        int root = 1;
        int target = 6;
        boolean result = graph.depthFirstSearch(root, target);
        System.out.print("Testing depth first search for path between two nodes: ");
        if(result == false) {
            System.out.print("Path not found between "+ root + " and " + target);
        } else{
            System.out.print("Path found between "+ root + " and " + target);
        }

    }
}
