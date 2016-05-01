package ca.hernanrossi.LinkedLists;

/**
 * Created by herna on 4/21/2016.
 */
public class TwoPointEight {
    TwoPointEight(){}

    public LinkedListNode run(LinkedListNode head) {
        LinkedListNode node = head;
        LinkedListNode node2 = head.getNext();
        int count =0;
        int n=0;
        while(node != node2) {
            System.out.println(node2.getData() );
            //System.out.println(node.getData());
            if(count == 0){
                n=1;
                count++;
            }else{
                n=2;
            }
            for( int i =0; i < n; i++){
                if (node2 == null){
                    return null;
                }
                node2 = node2.getNext();
            }

            node = node.getNext();

        }
        System.out.println(node2.getData() );
        System.out.println(node.getData());
        return node;
    }
}
