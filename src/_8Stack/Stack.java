package _8Stack;
import java.util.*;
public class Stack<T> {
    ArrayList<T> elements;

    public Stack(){
        elements = new ArrayList<>();
    }
    public void push(T element){
        elements.add(element);
        System.out.println("element pushed into stack");
    }
    public void pop(){
        if (elements.isEmpty()){
            System.out.println("stack is empty");
            return;
        }
        System.out.println("element popped from the stack" + elements.removeLast());
    }
    public void display(){
        if(elements.isEmpty()){
            System.out.println("stack is empty");
            return;
        }
        System.out.println("stack elements:");
        for (int i = elements.size() - 1 ; i >= 0 ; i--){
            System.out.println(elements.get(i));
        }
    }
}

class Demo{
    public static void main(String[] args) {
        Stack<Float> intStack = new Stack<>();
        intStack.push(1.2f);
        intStack.push(2.4f);
        intStack.display();
        intStack.pop();
        intStack.display();

        Stack<String> strStack = new Stack<>();

        strStack.push("Hello");
        strStack.push("World");
        strStack.display();
        strStack.pop();
        strStack.display();

    }
}