package ca.hernanrossi.TreesAndGraphs;

/***********************************************************************************************************************
 * Created by Hernan Rossi
 * Problem description:
 *  Implement a function to check if a binary tree is a binary search tree
 * My Solution:
 *  recurse the tree while tracking the range of values that the current node must lie withing to meet the
 *  criteria for the tree to be categorized as a binary search tree where every value in the left subtree
 *  must be less or equal to the root of that subtree and every value in the right subtree must be greater
 *  than the root of that subtree.
 **********************************************************************************************************************/
public class ValidateBST {
    private BinaryTreeNode root;

    /*******************************************************************************************************************
     *                                      ValidateBST()
     ******************************************************************************************************************/
    ValidateBST(){
        // Default constructor does not instantiate any variables
    }

    /*******************************************************************************************************************
     *                                      validate()
     * @param root
     * @return
     *              Take the root of a binary tree and start a recursive in search of the tree while tracking the
     *                  appropriate min/max value depending on which child of the current node we are traveling down
     *                  if we are checking the left child than it must be less than all values that have come before it
     *                  and if we are checking the right child then it must be greater than all values that have come
     *                  before it, we narrow the range of values that the current node must fall between when we make the
     *                  individual branch check where the initial recursive step is done with the max and min values that
     *                  an integer can have but as we recurse the tree these values can be narrowed significantly
     ******************************************************************************************************************/
    public boolean validate(BinaryTreeNode root){
        this.root = root;
        int result = run(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
        return (result < 0 ? false : true);
    }

    /******************************************************************************************************************
     *                                      run()
     * @param node
     * @param min
     * @param max
     * @return
     *              Do the recursive traversal of the binary tree, if any node breakes the rules of a binary search tree
     *                  return a value of -1, else return of value of 0. If after the entire tree has be traversed if the
     *                  result is < 0 then there was at least one node in the tree that break the binary search tree
     *                  requirements
     ******************************************************************************************************************/
    private int run(BinaryTreeNode node,int min, int max){
        if(node == null){
            return 0;
        }
        int node_value = (int) node.getData();
        if(node_value >= max || node_value < min){
            return -1;
        }
        int left_result = run(node.getLeftChild(), min,node_value );
        int right_result = run(node.getRightChild(), node_value, max);
        return left_result +right_result;
    }
}
