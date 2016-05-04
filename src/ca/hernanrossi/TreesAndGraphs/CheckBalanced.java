package ca.hernanrossi.TreesAndGraphs;

/**********************************************************************************************************************
 * Created by Hernan Rossi
 *********************************************************************************************************************/
public class CheckBalanced {
    private BinaryTreeNode root;
    CheckBalanced(){

    }

    public boolean run(BinaryTreeNode root){
        this.root = root;
        return recurseTreeLevels(root) != -1;
    }

    private int recurseTreeLevels(BinaryTreeNode node){
        if(node == null){
            return 0;
        }
        int result =1;
        // Check left sub tree count
        int leftCount = recurseTreeLevels(node.getLeftChild());
        int rightCount = recurseTreeLevels(node.getRightChild());
        int balanced = leftCount - rightCount;
        if(leftCount == -1 || rightCount ==-1){
            return -1;
        }else if(balanced > 1 || balanced < -1) {
            return -1;
        }
        return (leftCount > rightCount ? result+leftCount : result+rightCount);
    }

}
