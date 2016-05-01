package ca.hernanrossi.LinkedLists;

import java.util.Random;

/**********************************************************************************************************************
 * Created by Hernan Rossi
 *********************************************************************************************************************/
public class LinkedListTest {
    public static void main(String[] args) {

        //TwoPointOne q21 = new TwoPointOne();
        //q21.run(head);
        LinkedListNode head = new LinkedListNode(1);
        populateLinkedList(head);
        //printLinkedList(head);
        //TwoPointTwo q22 = new TwoPointTwo();
        //LinkedListNode node = q22.run(head, 6);
        //System.out.println(node.getData());
        // TwoPointFour q24 = new TwoPointFour();
        //LinkedListNode parted = q24.run(head, 5);
        //printLinkedList(parted);
        /*TwoPointFive q25 = new TwoPointFive();
        LinkedListNode one1 = new LinkedListNode(6);
        LinkedListNode one2 = new LinkedListNode(1);
        LinkedListNode one3 = new LinkedListNode(7);
        one3.setNext(one2);
        one2.setNext(one1);
        LinkedListNode two1 = new LinkedListNode(2);
        LinkedListNode two2 = new LinkedListNode(9);
        LinkedListNode two3 = new LinkedListNode(5);
        two3.setNext(two2);
        two2.setNext(two1);
        printLinkedList(one3);
        printLinkedList(two3);

        LinkedListNode sum = q25.run(one3, two3);
        printLinkedList(sum);*/

        // TwoPointSix q26 = new TwoPointSix();
        LinkedListNode one1 = new LinkedListNode(1);
        LinkedListNode one2 = new LinkedListNode(2);
        LinkedListNode one3 = new LinkedListNode(3);
        LinkedListNode one4 = new LinkedListNode(4);
        LinkedListNode one5 = new LinkedListNode(5);
        LinkedListNode one6 = new LinkedListNode(6);
        LinkedListNode one7 = new LinkedListNode(7);
        LinkedListNode one8 = new LinkedListNode(8);
        LinkedListNode one9 = new LinkedListNode(9);

        one1.setNext(one2);
        one2.setNext(one3);
        one3.setNext(one4);
        one4.setNext(one5);
        one5.setNext(one6);
        one6.setNext(one7);
        one7.setNext(one8);
        one8.setNext(one9);
        one9.setNext(one2);
        //printLinkedList(one1);
        // boolean result = q26.run(one1);
        TwoPointEight q28 = new TwoPointEight();
        LinkedListNode result = q28.run(one1);
        System.out.println(result.getData());
    }
    public static LinkedListNode populateLinkedList(LinkedListNode head){
        LinkedListNode prev = head;
        Random rng = new Random();
        for( int i =0 ; i <= 10; i++){
           /* if(i%2 == 0) {
                LinkedListNode temp = new LinkedListNode(i);
                prev.setNext(temp);
                temp.setPrev(prev);
                prev = temp;
            }*/
            LinkedListNode temp = new LinkedListNode(rng.nextInt(10));
            prev.setNext(temp);
            temp.setPrev(prev);
            prev = temp;
        }
        return head;
    }

    public static void printLinkedList(LinkedListNode head){
        LinkedListNode node = head;
        while(node!= null){
            int temp = node.getData();
            System.out.print(temp + " ");
            node = node.getNext();
        }
        System.out.print("\n");
    }


}
