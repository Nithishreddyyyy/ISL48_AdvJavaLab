package LabPrac._2Queue;

public class Queue {
    int [] queue;
    int cap,front,rear;

    public Queue(int cap){
        if(cap <= 0){
            throw new IllegalArgumentException("Queue capacity must be greater than 0");
        }
        this.cap = cap;
        this.queue = new int[cap];
        this.front = 0;
        this.rear = -1;
    }

    public void Enqueue(int item){
        if(isFull()){
            throw new QueueOverFlowException("Queue is full");
        }
        queue[++rear] = item;
        System.out.println("enqueued" + item);
    }

    public void Dequeue(){
        if(isEmpty()){
            throw new QueueUnderFlowException("Queue is Empty");
        }
        int item = queue[front++];
        System.out.println("dequeued" + item);
    }

    public void display(){
        if(isEmpty()){
            throw new QueueUnderFlowException("Queue is empty");
        }
        System.out.println("Queue elements are:");
        for(int i = front ; i <= rear ; i++){
            System.out.println(queue[i]+"\t");
        }
        System.out.println("end of queue");
    }

    public boolean isEmpty(){
        return front > rear;
    }
    public boolean isFull(){
        return rear == cap - 1;
    }

    public static void main(String[] args) {
        System.out.println("--- Queue operations ---");
        Queue Q = new Queue(5);

        try{
            Q.Enqueue(1);
            Q.Enqueue(2);
            Q.display();
            Q.Dequeue();
            Q.display();
        }catch(Exception e){
            System.err.println("Error: " + e);
        }
    }
}
