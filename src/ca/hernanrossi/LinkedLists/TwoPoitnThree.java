package ca.hernanrossi.LinkedLists;

/**
 * Created by herna on 4/19/2016.
 */
public class TwoPoitnThree {
    TwoPoitnThree(){}

    public boolean run(LinkedListNode node){
        if(node == null || node.getNext() == null){
            return false;
        }
        LinkedListNode next = node.getNext();
        node.setData(next.getData());
        node.setNext(next.getNext());
        return true;
    }
}
