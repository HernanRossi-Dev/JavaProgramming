package ca.hernanrossi.StacksQueues;

/**********************************************************************************************************************
 * Created by Hernan Rossi
 *********************************************************************************************************************/
public class StacksQueuesTest {
    public static void main(String args[]){
        // Test Stack of plates
        StackOfPlates<Integer> test = new StackOfPlates<>(10, 10);
        for( int i = 0; i< 90; i++){
            test.push(i);
        }
        int data = test.peek();
        System.out.println(data+ " ");
        data = test.pop();
        System.out.println(data+ " ");
        test.push(data);
        int count = 0;
        while(!test.isEmpty()){

            if(count ==10){
                System.out.println();
                count=0;
                data = test.pop(0);
            }else{
                data = test.pop();
            }
            count++;
            System.out.print(data+ " ");
        }

    }
}
