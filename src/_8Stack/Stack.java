package LabPrac._8Stack;

public class Stack<T>{
    private java.util.ArrayList<T> elements;

    public Stack(){
        elements = new java.util.ArrayList<>();
    }

    public void push(T item){
        elements.add(item);
    }

    public T pop(){
        if(isEmpty()){
            System.out.println("Stack underflow");
            return null;
        }
        return elements.remove(elements.size()-1);
    }

    public void clear(){
        elements.clear();
    }

    public boolean isEmpty(){
        return elements.isEmpty();
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
        }else{
            System.out.println("Stack contents are: ");
            for(int i = elements.size()-1 ; i >= 0 ; i--){
                System.out.println(elements.get(i));
            }
        }
    }
}

class Demo{
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);

        System.out.println("Integer Stack:");
        integerStack.display();

        integerStack.pop();
        System.out.println("after popping one element: ");
        integerStack.display();

        integerStack.clear();
        System.out.println("After clearing empty stack: ");
        integerStack.display();


        Stack<String> stringStack = new Stack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        stringStack.push("Java");
        stringStack.push("Python");
        stringStack.display();
        System.out.println("Popping");
        stringStack.pop();
        stringStack.pop();
        stringStack.display();
        System.out.println("After clearing stack: ");
        stringStack.clear();
        stringStack.display();
        System.out.println("----End of program----");

    }
}