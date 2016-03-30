
public class MyStack<T>{
	private MyLinkedList<T> data;

	public MyStack(){
		data = new MyLinkedList<T>();
	}
	
	 /**
     * Adds the given item to the top of the stack.
     */
    void push(T item){
        data.add(0,item);
    }

    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T pop(){
        if (data.size() < 1) throw new IndexOutOfBoundsException();
        return data.remove(0);
    }

    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T peek(){
        return data.get(0);
    }

    /**
     * Returns the number of items currently in the stack.
     */
    int size(){
        return data.size();
    }

    /**
     * Returns whether the stack is empty or not.
     */
    boolean isEmpty(){
        if (data.size() == 0) return true;
        return false; 
    }
}