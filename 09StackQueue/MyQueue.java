public class MyQueue<T>{
    private MyLinkedList<T> data;

    public MyQueue(){
        data = new MyLinkedList<T>();
    }

	/**
     * Adds the given item to the rear of the queue.
     */
    void enqueue(T item){
        data.add(data.size() - 1, item);
    }

    /**
     * Removes the front item from the queue and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T dequeue(){
        if (data.size() == 0) throw new NoSuchElementException();
        return data.remove(0);
    }

    /**
     * Returns the front item from the queue without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T peek(){
        return data.get(0);
    }

    /**
     * Returns the number of items currently in the queue.
     */
    int size(){
        return data.size();
    }

    /**
     * Returns whether the queue is empty or not.
     */
    boolean isEmpty(){
        if (data.size() == 0) return true;
        return false; 
    }
}