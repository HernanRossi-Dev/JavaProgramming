package ca.hernanrossi.TreesAndGraphs;

import java.util.ArrayList;

/**********************************************************************************************************************
 * Created by Hernan Rossi
 *********************************************************************************************************************/
public class MinimalTree<T> {
    static int interation = 0;
    private BinaryTreeNode root;
    private ArrayList<T> array;
    MinimalTree(ArrayList<T> array){
        this.array = array;

    }

    public BinaryTreeNode createMinimalTree(){
        BinaryTreeNode<T> root = createSubTree(0, array.size()-1 );
        System.out.println( " ");
        return root;
    }

    private BinaryTreeNode createSubTree(int leftStart, int rightEnd){
        if(  rightEnd < leftStart){
            return null;
        }
        T data = array.get((rightEnd+leftStart) / 2);
        BinaryTreeNode<T> root = new BinaryTreeNode(data);
        root.setLeftChild(createSubTree(leftStart, ((leftStart + rightEnd) / 2) - 1));
        root.setRightChild(createSubTree((((leftStart + rightEnd) / 2) + 1), rightEnd));
        return root;
    }

}
