package ca.hernanrossi.LinkedLists;

/**
 * Created by herna on 4/20/2016.
 */
public class TwoPointFour {
    TwoPointFour(){}

    public LinkedListNode run(LinkedListNode head, int partition) {
        LinkedListNode greater_than_track = null, greater_than_head = null,
                       less_than_track = null, less_than_head = null,
                       node = head;
        if(head == null || head.getNext() == null) {
            return head;
        }

        while(node!= null) {
            int current_value = node.getData();
            if(current_value < partition) {
                if(less_than_head == null){
                    LinkedListNode lth = new LinkedListNode(current_value);
                    less_than_head= lth;
                    less_than_track = lth;
                }else{
                    LinkedListNode temp = new LinkedListNode(current_value);
                    less_than_track.setNext(temp);
                    temp.setPrev(less_than_track);
                    less_than_track = temp;
                }
            }else{
                if(greater_than_head == null){
                    LinkedListNode gth = new LinkedListNode(current_value);
                    greater_than_head = gth;
                    greater_than_track = gth;
                }else{
                    LinkedListNode temp = new LinkedListNode(current_value);
                    greater_than_track.setNext(temp);
                    temp.setPrev(greater_than_track);
                    greater_than_track = temp;
                }
            }
            node = node.getNext();
        }
        less_than_track.setNext(greater_than_head);
        greater_than_head.setPrev(less_than_track);
        return less_than_head;
    }
}
