package W4;

import java.util.ArrayList;
import java.util.Stack;

public class ArrayStack {
    static final int MAX = 10000;
    int top;
    Object arr[] = new Object [MAX];

    boolean isEmpty (){
        return (top < 0);
    }

    public ArrayStack() {
        top = -1;
    }

    boolean push(Object data) {
        if(top >= (MAX -1)) {
            System.out.println("Stack Overflow");
            return  false;
        } else {
            arr[++ top] = data;
            System.out.println(data + "Pushed" );
            return true;
        }
    }

    Object pop() {
        if(top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            Object x = arr[top --];
            return x;
        }
    }

    Object peek() {
        if(top < 0) {
            System.out.println("Stack underflow");
            return 0;
        } else {
            Object x = arr[top];
            return x;
        }
    }
    void print(){
        for(int i = top;i>-1;i--){
            System.out.print(" "+ arr[i]);
        }
    }
    //Driver code
    public static void main(String[] args) {
        ArrayStack s = new ArrayStack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
        System.out.println("Top element is :" + s.peek());
        System.out.print("Elements present in stack :");
        s.print();
    }
}
