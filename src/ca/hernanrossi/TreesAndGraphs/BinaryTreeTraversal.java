package ca.hernanrossi.TreesAndGraphs;

/**********************************************************************************************************************
 * Created by Hernan Rossi
 *********************************************************************************************************************/
public class BinaryTreeTraversal<T> {
    BinaryTreeTraversal(){
    }

    public void preOrderTraversal(BinaryTreeNode<T> root) {
        if(root!=null) {

            // Visit root node first
            System.out.println(root.getData()+ " ");

            // Visit left child
            System.out.print("LeftChild ");
            preOrderTraversal(root.getLeftChild());

            // Visit right child last
            System.out.print("RightChild ");
            preOrderTraversal(root.getRightChild());
        }
    }

    public void inOrderTraversal(BinaryTreeNode<T> root) {
        if(root!=null) {
            // Visit left child first
            System.out.print("LeftChild ");
            inOrderTraversal(root.getLeftChild());
            // Visit root node
            System.out.println(root.getData()+ " ");
            // Visit right child last
            System.out.print("RightChild ");
            inOrderTraversal(root.getRightChild());
        }
    }


    public void postOrderTraversal(BinaryTreeNode<T> root) {
        if(root!=null) {
            // Visit left child first
            postOrderTraversal(root.getLeftChild());

            // Visit right child
            postOrderTraversal(root.getRightChild());

            // Visit root node last
            System.out.print(root.getData()+ " ");

        }
    }
}
