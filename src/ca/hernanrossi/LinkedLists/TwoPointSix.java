package ca.hernanrossi.LinkedLists;

import java.util.Stack;

/**
 * Created by herna on 4/20/2016.
 */
public class TwoPointSix {
    TwoPointSix(){

    }
    public boolean run(LinkedListNode head){
        LinkedListNode node = head;
        Stack stack = new Stack();
        int length=0;
        while(node!=null){
            node = node.getNext();
            length++;
        }
        node = head;
        if(length%2 != 0) {

            for(int i =0; i < (length -1)/2; i++ ){
                stack.push(node.getData());
                node=node.getNext();
            }
            node=node.getNext();
            while (!stack.empty()){
                if((int)stack.pop() != node.getData()) {
                    return false;
                }
                node = node.getNext();
            }
        }else{

            for(int i =0; i < length /2; i++ ){
                stack.push(node.getData());
                node=node.getNext();
            }
            while (!stack.empty()){
                if((int)stack.pop() != node.getData()) {
                    return false;
                }
                node = node.getNext();
            }
        }
        return true;
    }
}
