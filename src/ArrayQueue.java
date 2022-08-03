public class ArrayQueue<T> implements QueueADT<T>{

    private final int DEFAULT_CAPACITY = 5;
    private int count;
    private T[] queue;

    public ArrayQueue(){
        this.count = 0;
        queue = (T[])(new Object[DEFAULT_CAPACITY]);
    }

    public ArrayQueue(int initialCapacity){
        this.count = 0;
        queue = (T[])(new Object[initialCapacity]);
    }

    @Override
    public void enqueue(T element) {
        if(queue.length==count){
            T[] newArray = (T[])(new Object[queue.length +5]);

            for (int j = 0; j < queue.length; j++) {
                newArray[j] = queue[j];
            }
            this.queue = newArray;
        }
        queue[count] = element;
        count++;

    }

    @Override
    public T dequeue() {
        T tempVar;
        tempVar = queue[0];
        for(int i = 0; i<queue.length-1;i++){
            queue[i] = queue[i+1];

        }
        count--;
        return tempVar;


    }

    @Override
    public T first() {

        return queue[0];
    }

    @Override
    public boolean isEmpty() {
        if(count ==0)
            return true;
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    public String toString(){
        String s = "";
        for(int i=0; i < queue.length;i++){
            s +=queue[i]+" ";

        }
        return s;
    }

    public static void main(String[] args){

        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();


        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(5);
//      System.out.println(queue);
        queue.enqueue(7);
        queue.enqueue(8);
        System.out.println(queue.size());
        System.out.println(queue);


        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.size());
        queue.enqueue(11);
        System.out.println(queue);
        System.out.println(queue.size());

        queue.enqueue(15);
        queue.enqueue(16);
        queue.enqueue(17);
        queue.enqueue(18);
        queue.enqueue(20);
        queue.enqueue(21);
        queue.enqueue(22);
        queue.enqueue(24);
        queue.enqueue(25);
        queue.enqueue(26);
        queue.enqueue(27);


        String testString = queue.toString();
        System.out.println("testing toString:  " +testString);
        //queue.enqueue(2);
        //queue.enqueue(3);
        //queue.enqueue(4);
        //System.out.println(queue + "");
        //System.out.println(queue.size());
        //System.out.println(queue.isEmpty());
        //System.out.println(queue.first());
        //System.out.println("Dequeue gives us value: " + queue.dequeue());
        //queue.dequeue();
        //queue.enqueue(10);
        //System.out.println(queue);
    }

}
