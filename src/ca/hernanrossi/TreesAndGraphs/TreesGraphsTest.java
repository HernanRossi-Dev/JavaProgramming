package ca.hernanrossi.TreesAndGraphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**********************************************************************************************************************
 * Created by Hernan Rossi
 *********************************************************************************************************************/
public class TreesGraphsTest {
    public static void main(String[] args) {
        //testMinimalTree();
        //testListOfDepths();
        testCheckBalanced();
    }

    /******************************************************************************************************************
     *
     */
    public static void testCheckBalanced(){
        BinaryTreeNode<Integer> rootNonBalanced  = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> twoOne  = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> twoTwo  = new BinaryTreeNode<>(9);
        rootNonBalanced.setLeftChild(twoOne);
        rootNonBalanced.setRightChild(twoTwo);
        BinaryTreeNode<Integer> threeOne  = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> threeTwo  = new BinaryTreeNode<>(7);
        twoOne.setLeftChild(threeOne);
        twoOne.setRightChild(threeTwo);
        BinaryTreeNode<Integer> threeFour  = new BinaryTreeNode<>(11);
        twoTwo.setRightChild(threeFour);
        BinaryTreeNode<Integer> fourOne  = new BinaryTreeNode<>(4);
        threeOne.setLeftChild(fourOne);
        BinaryTreeNode<Integer> fourEight  = new BinaryTreeNode<>(12);
        threeFour.setRightChild(fourEight);
        BinaryTreeNode<Integer> fiveOne  = new BinaryTreeNode<>(3);
        fourOne.setLeftChild(fiveOne);

        CheckBalanced test = new CheckBalanced();
        boolean result = test.run(rootNonBalanced);
        System.out.println("The result of checking the balance of the tree is: " + result);
        result = test.run(threeOne);
        System.out.println("The result of checking the balance of the tree is: " + result);
        result = test.run(fourOne);
        System.out.println("The result of checking the balance of the tree is: " + result);
        BinaryTreeNode<Integer> rootBalanced = createThreeLevelCompleteTree();
        result = test.run(rootBalanced);
        System.out.println("The result of checking the balance of the tree is: " + result);

    }


    public static BinaryTreeNode createThreeLevelCompleteTree(){
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        // Create a new binary tree with arbitrary nodes
        for(int i = 0; i < 3; i++){
            for(int j =0; j< Math.pow(2,i); j++) {
                BinaryTreeNode<Integer> current = queue.removeLast();
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(((int) Math.pow(2, i+1)) + 2*j);
                current.setLeftChild(leftChild);
                queue.addFirst(leftChild);
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(((int) Math.pow(2, i+1)) + (2*j)+1);
                current.setRightChild(rightChild);
                queue.addFirst(rightChild);
            }
        }
        return root;
    }
    /******************************************************************************************************************
     *
     */
    public static void testListOfDepths(){
        BinaryTreeNode<Integer> root = createThreeLevelCompleteTree();
        ListOfDepths listOfDepths = new ListOfDepths(root);
        LinkedList<LinkedList<BinaryTreeNode>> result = listOfDepths.createLevelLists();
        // Print out the levels of the tree
        Iterator<LinkedList<BinaryTreeNode>>  iterator = result.iterator();
        while(iterator.hasNext()){
            LinkedList<BinaryTreeNode> currentLevel = iterator.next();
            Iterator<BinaryTreeNode> levelIterator = currentLevel.iterator();
            while(levelIterator.hasNext()){
                BinaryTreeNode currentNode = levelIterator.next();
                System.out.print(currentNode.getData() + " ");
            }
            System.out.println("");
        }
    }


    public static void testMinimalTree(){
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
