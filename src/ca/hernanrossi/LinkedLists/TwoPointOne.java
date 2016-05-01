package ca.hernanrossi.LinkedLists;

import java.util.HashSet;

/**
 * Created by herna on 4/18/2016.
 */
public class TwoPointOne {
    TwoPointOne() {
    }

    public void run(LinkedListNode head) {
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode node = head;
        while(node != null) {
            if(set.contains(node.getData())){
                LinkedListNode prev = node.getPrev();
                LinkedListNode next = node.getNext();
                if(prev!=null){
                    prev.setNext(next);
                }
                if(next!= null) {
                    next.setPrev(prev);
                }
            }else{
                set.add(node.getData());
            }
            node = node.getNext();
        }
    }

}
