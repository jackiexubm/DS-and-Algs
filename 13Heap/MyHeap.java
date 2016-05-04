public class MyHeap<T extends Comparable<T>>{
	private T[] data;

	@SuppressWarnings("unchecked")
	public MyHeap(boolean isMax){
		data = (T[]) new Object[10];
	}

	public T peek();

	public T remove();

	public void add(T var);

	public String toString(); 

}