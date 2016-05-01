package ca.hernanrossi.StacksQueues;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.concurrent.ExecutionException;

/**********************************************************************************************************************
 * Created by Hernan Rossi
 *********************************************************************************************************************/
public class StackOfPlates<T>{
    private int stack_size;
    private StackWithSize[] array_of_stacks;
    private int number_of_stacks = 0;
    private int max_stacks;

    /******************************************************************************************************************
     *                                      Constructor
     * @param stack_size
     * @param max_stacks
     *
     *              Give instance variable values for the maximum size of each stack and create the array to store the
     *                  stacks with the maximum number of stacks: create the first stack
     ******************************************************************************************************************/
    StackOfPlates(int stack_size, int max_stacks){
        this.stack_size = stack_size;
        this.max_stacks = max_stacks;
        StackWithSize<T> first = new StackWithSize(stack_size);
        array_of_stacks = new StackWithSize[max_stacks];
        array_of_stacks[number_of_stacks] = first;
    }

    /******************************************************************************************************************
     *                                      pop()
     * @return
     *
     *              Pop the item from the newest stack check to see if the stack is empty and move the pointer to the
     *                  previous stack in the storage array
     *****************************************************************************************************************/
    public T pop(){
        StackWithSize current = array_of_stacks[number_of_stacks];
        if(current == null){
            // There are no stacks in the structure return a value of null to the caller
            return null;
        }
        T data = (T)current.pop();
        if(current.getCurrent_size() == 0){
            // The current stack is empty  clear the array location data and go to the previous stack
            array_of_stacks[number_of_stacks] = null;
            number_of_stacks--;
            if (number_of_stacks <0){
                number_of_stacks = 0;
            }
        }
        return data;
    }

    /*****************************************************************************************************************
     *                                      pop(int index)
     * @param index
     * @return
     *
     *              Pop the item off of the stack at the specified index in the storage array
     *                  if this stack is empty after the pop than move all stacks to the right of it one to the left
     *                  removing it from the storage array
     *
     *****************************************************************************************************************/
    public T pop(int index){
        if(index >= number_of_stacks){
            throw new IndexOutOfBoundsException("Index larger than the possible number of stacks.");
        }
        StackWithSize current = array_of_stacks[index];
        if(current == null){
            // There are no stacks in the structure return a value of null to the caller
            return null;
        }
        T data = (T)current.pop();
        if(current.getCurrent_size() == 0){
            // The current stack is empty  clear the array location data and go to the previous stack
            array_of_stacks[index] = null;
            if(index < number_of_stacks){
                for(int i = index ; i < max_stacks-1; i++){
                    array_of_stacks[i] = array_of_stacks[i+1];

                }
                array_of_stacks[max_stacks-1] = null;
            }
            number_of_stacks--;
            if (number_of_stacks <0){
                number_of_stacks = 0;
            }

        }
        return data;
    }

    public boolean isEmpty(){
        if(number_of_stacks ==0){
            StackWithSize temp =  array_of_stacks[0];
            if(temp == null){
                return true;
            }
        }
        return false;
    }


    /*******************************************************************************************************************
     *                                      push(T data)
     * @param data
     * @return
     *
     *                  Push the item onto the stack increment the stacks item count variable by one if it has reached max
     *                  population create a new stack, put a reference to it into the array in the next empty location
     *                  in the stack storage array, if there is no room left in the array throw an indexOutOfBoundsException
     ******************************************************************************************************************/


    public T push(T data){
        StackWithSize current = array_of_stacks[number_of_stacks];
        if(current == null){
            StackWithSize<T> next = new StackWithSize(stack_size);
            array_of_stacks[number_of_stacks] = next;
            current = next;
        }
        if(current.getCurrent_size() == (stack_size-1)) {
            if(number_of_stacks == max_stacks){
                throw new IndexOutOfBoundsException("Max number of stacks reached no more push operations allowed until a pop.");
            }
            StackWithSize<T> next = new StackWithSize(stack_size);
            number_of_stacks++;
            if (number_of_stacks == max_stacks-1){
                return null;
            }
            array_of_stacks[number_of_stacks] = next;
            current = next;
        }
        return (T)current.push(data);
    }

    public T peek(){
        StackWithSize temp = array_of_stacks[number_of_stacks];
        if(temp == null){
            throw new EmptyStackException();

        }
        T data = (T)temp.peek();
        return data;
    }


    private class StackWithSize<T> extends Stack<T>{
        private int current_size =0;
        StackWithSize(int max_size){
            super();
        }

        @Override
        public T push(T item) {
            current_size++;
            return super.push(item);
        }

        @Override
        public synchronized T pop() {
            current_size--;
            return super.pop();
        }
        public int getCurrent_size(){
            return current_size;
        }

    }


}
