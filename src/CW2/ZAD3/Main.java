package CW2.ZAD3;

public
class Main {

    public static void main(String[] args) {
        MyQueue<Integer> intQueue = new MyQueue<Integer>();
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        intQueue.enqueue(3);
        System.out.println(intQueue.dequeue());
        System.out.println(intQueue.dequeue());

        MyQueue<String> stringQueue = new MyQueue<String>();
        stringQueue.enqueue("Ala");
        stringQueue.enqueue("ma");
        stringQueue.enqueue("kota");
        System.out.println(stringQueue.dequeue());
        System.out.println(stringQueue.dequeue());
        System.out.println(stringQueue.dequeue());
        System.out.println(stringQueue.dequeue());
    }
}
