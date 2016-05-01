package ca.hernanrossi.LinkedLists;

/**
 * Created by herna on 4/18/2016.
 */
public class LinkedListNode {
    private int data;
    private LinkedListNode next = null;
    private LinkedListNode prev = null;

    LinkedListNode() {
    }
    LinkedListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }
    public void setData(int data) {
        this.data = data;
    }

    public LinkedListNode getNext() {
        return this.next;
    }
    public LinkedListNode getPrev() {
        return this.prev;
    }
    public void setNext(LinkedListNode next ) {
        this.next = next;
    }
    public void setPrev(LinkedListNode prev ) {
        this.prev = prev;
    }



}
