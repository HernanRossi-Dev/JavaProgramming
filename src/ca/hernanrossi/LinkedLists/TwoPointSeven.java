package ca.hernanrossi.LinkedLists;

/**
 * Created by herna on 4/21/2016.
 */
public class TwoPointSeven {
    TwoPointSeven(){}

    public LinkedListNode run(LinkedListNode head_one, LinkedListNode head_two){
        LinkedListNode node = head_one;
        int one_length = 0;
        while(node!= null) {
            one_length++;
            node=node.getNext();
        }
        node = head_two;
        int two_length = 0;
        while(node!= null) {
            two_length++;
            node=node.getNext();
        }
        if(one_length == two_length){
            // List are the same length compare items one at a time till a common one is found
            LinkedListNode node2 = head_two;
            node = head_one;
            while(node != node2) {
                node = node.getNext();
                node2 = node2.getNext();
            }
            return node;
        }else if(one_length > two_length) {
            // The first list is longer than the second list
            int difference = one_length - two_length;
            node = head_one;
            for(int i = 0 ; i < difference; i++){
                node = node.getNext();
            }
            LinkedListNode node2 = head_two;
            while(node != node2) {
                node = node.getNext();
                node2 = node2.getNext();
            }
        }else{
            int difference = two_length -one_length;
            LinkedListNode node2 = head_two;
            node = head_one;
            for(int i = 0 ; i < difference; i++){
                node2 = node2.getNext();
            }
            while(node != node2) {
                node = node.getNext();
                node2 = node2.getNext();
            }
        }
        return node;
    }
}
