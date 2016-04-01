public class MyDeque<T> {
	private T[] data;

	public MyDeque(){
		Object[] dat = new Object[10];
		data = (T)dat;
	}

	public String toString(){
		String s = "[";
		for (int i = 0; i < data.length ; i++) {
			s += data[i].toString();
		}
		return s + "]";
	}

	// public void addFirst(T value){

	// }

	// public void addLast(T value){

	// }

	// public T removeFirst(){

	// }  
	
	// public T removeLast(){

	// } 

	// public T getFirst(){

	// }

	// public T getLast(){

	// }

	public static void main(String[] args) {
		MyDeque a = new MyDeque();
		System.out.println(a);
	}
}