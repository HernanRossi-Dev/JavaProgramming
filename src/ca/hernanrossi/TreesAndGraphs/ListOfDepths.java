package ca.hernanrossi.TreesAndGraphs;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**********************************************************************************************************************
 * Created by Hernan Rossi
 * Problem Description:
 *              Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth(e.g.
 *                  if you have a tree with depth D, you'll have D linked lists:
 *Solution method:
 *              Traversing the binary tree in a depth first search manner and creating a new linked lilst for every
 *                  2^n nodes ( a new linked list for every level in the tree) then well will have a linked list for
 *                  every level in the tree.
 *********************************************************************************************************************/
public class ListOfDepths {
    private BinaryTreeNode root;
    private LinkedList<LinkedList<BinaryTreeNode>> listOFLevels;
    LinkedList<BinaryTreeNode> BFSQueue = new LinkedList<>();
    int nodeCount=0;

    /*******************************************************************************************************************
     *                                      Constructor()
     * @param root
     *              Construct the initial instance of the ListOfDepths object
     ******************************************************************************************************************/
    ListOfDepths(BinaryTreeNode root){
        this.root = root;
        this.listOFLevels = new LinkedList();
    }

    /******************************************************************************************************************
     *                                      CreateLevelLists()
     * @return
     *              Take the root of the tree and create a new linked list for every level of the tree that is connected
     *                  to the root if the root is a null reference return a null value;
     ******************************************************************************************************************/
    public LinkedList<LinkedList<BinaryTreeNode>> createLevelLists(){
        if(root == null){
            return null;
        }
        // Create  a single element linked list for the root node and add it to the first item
        LinkedList<BinaryTreeNode> nodeList = new LinkedList<>();
        BFSQueue.addFirst(root);
        BinaryTreeNode current;
        int levelCount =0;
        // Count the nodes even if they are null so that the levels can be tracked
        while(!BFSQueue.isEmpty()) {
            current = BFSQueue.removeLast();
            if(current ==null){
                nodeCount++;
                continue;
            }
            nodeCount++;
            System.out.println(nodeCount);
            // Check to see if it has children and add them to the queue
            getChildren(current);
            // If the current node is in a new level create a new list
            if(nodeCount == Math.pow(2, levelCount)){
                levelCount++;
                nodeList = new LinkedList<>();
                nodeList.add(current);
                listOFLevels.add(nodeList);
            }else{
                nodeList.add(current);
            }
        }
        System.out.println("");
        return listOFLevels;
    }

    /******************************************************************************************************************
     *                                      getChildren()
     * @param current
     *              Check the left and right children node of the current node and if they are not null add them to the
     *                  front of the BFS queue
     ******************************************************************************************************************/
    private void getChildren(BinaryTreeNode current){
        BinaryTreeNode leftChild = current.getLeftChild();
        BFSQueue.addFirst(leftChild);
        BinaryTreeNode rightChild = current.getRightChild();
        BFSQueue.addFirst(rightChild);
    }


}
