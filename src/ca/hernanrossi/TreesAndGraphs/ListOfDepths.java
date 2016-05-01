package ca.hernanrossi.TreesAndGraphs;

import java.util.LinkedList;

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
    private int levelCount;

    /*******************************************************************************************************************
     *                                      Constructor()
     * @param root
     *              Construct the initial instance of the ListOfDepths object
     ******************************************************************************************************************/
    ListOfDepths(BinaryTreeNode root){
        this.root = root;
        this.listOFLevels = new LinkedList();
        this.levelCount =0;
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
        int nodeCount=0;
        LinkedList<BinaryTreeNode> nodeList = new LinkedList<>();




        return listOFLevels;
    }


}
