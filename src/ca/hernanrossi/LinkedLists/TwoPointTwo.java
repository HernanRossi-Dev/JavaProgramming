package ca.hernanrossi.LinkedLists;

/**
 * Created by herna on 4/18/2016.
 */
public class TwoPointTwo {
    TwoPointTwo(){
    }
    public LinkedListNode run(LinkedListNode head, int n) {
        LinkedListNode node = head;
        LinkedListNode prev = null;
        int count = 0;
        while(node!=null) {
            prev = node;
            node = node.getNext();
            count++;
        }
        if(n > count){
            return head;
        }else if(n == count) {
            return head;
        }else if(n==0){
            return prev;
        }else {
            node = head;
            count = count - n;
            for(int i = 1; i< count  ; i++) {
                node = node.getNext();
            }
            return node;
        }
    }
}
