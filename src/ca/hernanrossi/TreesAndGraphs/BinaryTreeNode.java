package ca.hernanrossi.TreesAndGraphs;

/**********************************************************************************************************************
 * Created by Hernan Rossi
 *********************************************************************************************************************/
public class BinaryTreeNode<T> {
    private T data;
    private BinaryTreeNode leftChild = null;
    private BinaryTreeNode rightChild = null;

    /*******************************************************************************************************************
     *                                      Constructor
     * @param data              Construct this node instance
     ******************************************************************************************************************/
    BinaryTreeNode(T data){
        this.data = data;
    }

    /******************************************************************************************************************
     *                                      setLeftChild()
     * @param left              set the left child node of this node
     ******************************************************************************************************************/
    public void setLeftChild(BinaryTreeNode left){
        this.leftChild = left;
    }

    /******************************************************************************************************************
     *                                     getLeftChild()
     * @return              Return this nodes left child
     ******************************************************************************************************************/
    public BinaryTreeNode getLeftChild() {
        return this.leftChild;
    }

    /*******************************************************************************************************************
     *                                      setRightChild()
     * @param right             Set this nodes right child
     ******************************************************************************************************************/
    public void setRightChild(BinaryTreeNode right) {
        this.rightChild = right;
    }

    /******************************************************************************************************************
     *                                      getRightChild()
     * @return              Return this nodes right child BinaryTreeNode
     ******************************************************************************************************************/
    public BinaryTreeNode getRightChild() {
        return this.rightChild;
    }

    /*******************************************************************************************************************
     *                                      setData()
     * @param data              Set this nodes data T
     ******************************************************************************************************************/
    public void setData(T data) {
        this.data = data;
    }

    /*******************************************************************************************************************
     *                                      getData()
     * @return              Return this nodes data T to the calling method
     *****************************************************************************************************************/
    public T getData(){
        return this.data;
    }
    /*******************************************************************************************************************
     *                                      toString()
     *               Return this nodes data T to the calling method
     *****************************************************************************************************************/
    public String toString(){
        if(this.data instanceof Integer){
            Integer out = (Integer) this.data;
            String result = String.valueOf(out);
            return result;
        }else {
            return this.data.toString();
        }
    }

}
