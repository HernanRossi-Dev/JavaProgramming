package ca.hernanrossi.LinkedLists;

/**
 * Created by herna on 4/20/2016.
 */
public class TwoPointFive {
    TwoPointFive() {
    }

    public LinkedListNode run(LinkedListNode first, LinkedListNode second) {
        LinkedListNode sum = new LinkedListNode();
        LinkedListNode tracker = first;
        int count = 0;
        int intsum =0;
        int first_num = 0, second_num = 0;
        while(tracker != null) {
            int current = tracker.getData();
            first_num = first_num + current * (int)Math.pow(10, count);
            tracker = tracker.getNext();
            count++;
        }
        System.out.println(first_num);
        count =0;
        tracker = second;
        while(tracker != null) {
            int current = tracker.getData();
            second_num= second_num + current * (int)Math.pow(10, count);
            tracker = tracker.getNext();
            count++;
        }
        System.out.println(second_num);
        intsum = second_num + first_num;
        System.out.println(intsum);
        String output = Integer.toString(intsum);
        int length = output.length();
        System.out.println(output);
        LinkedListNode sum_head = sum;
        sum.setData(output.charAt(0) - '0');
        for( int i = 1; i< length ; i++) {
            System.out.println(sum.getData());
            LinkedListNode node = new LinkedListNode(output.charAt(i) - '0');
            sum.setNext(node);
            node.setPrev(sum);
            sum = node;
        }


        return sum_head;
    }

}
