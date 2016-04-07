import java.util.NoSuchElementException;
public class MyDeque<T> {
	private T[] data;
	int size;
	int start;
	int end;

	@SuppressWarnings("unchecked")
	public MyDeque(){
		data = (T[]) new Object[10];
		start = 0;
		end = 0;
		size = 0;
	}

	public String toString(){
		String ret = "[";
		for (int i = 0 ; i < size - 1 ; i++) {
			int current = start + i;
			if (current > data.length - 1) {
				current = current - data.length;
			}
			ret += data[current].toString() + ", ";
		}
		return ret + data[end].toString() + "]";
	}

	public void printData(){
		String s = "[ ";
		// if (size == 0) {
		// 	return "[ ]";
		// }
		for (int i = 0; i < data.length - 1; i++) {
			if (data[i] == null) {
				s += " , ";
			}else{
				s += data[i].toString() + " , ";
			}
		}
		if (data[data.length - 1] == null) {
			s += "";
		}else{
			s += data[data.length - 1].toString();
		}
		System.out.println(s + " ]"); 
	}

	public void addFirst(T value){ 
		if (size == 0) {
			data[start] = value;
		}else{
			if (size == data.length) {
				resize();
			}
			if (start == 0) {
				start = data.length - 1;
			}else{
				start --;
			}
			data[start] = value;
		}
		size ++;
	}

	public void addLast(T value){
		if (size == 0) {
			data[start] = value;
		}else{
			if (size == data.length) {
				resize();
			}
			if (end == data.length - 1) {
				end = 0;
			}else{
				end ++;
			}
			data[end] = value;
		}
		size ++;
	}

	public T removeFirst(){
		if (size < 1) {
			throw new NoSuchElementException();
		}
		T ret = data[start];
		data[start] = null;
		if (start == data.length - 1) {
			start = 0;
		}else{
			start++;
		}
		size --;
		return ret;
	}  
	
	public T removeLast(){
		if (size < 1) {
			throw new NoSuchElementException();
		}
		T ret = data[end];
		data[end] = null;
		if (end == 0) {
			end = data.length - 1;
		}else{
			end --;
		}
		size --;
		return ret;
	} 

	public T getFirst(){
		if (size < 1) {
			throw new NoSuchElementException();
		}
		return data[start];
	}

	public T getLast(){
		if (size < 1) {
			throw new NoSuchElementException();
		}
		return data[end];
	}

	@SuppressWarnings("unchecked")
	private void resize(){
		T[] temp = (T[]) new Object[data.length * 2];
		if (end < start) {
			for (int i = 0; i <= end; i++) {
				temp[i] = data[i];
			}
			for (int i = end + 1; i < data.length; i++) {
				temp[i + data.length] = data[i];
			}
			start = start + data.length;
		}else{
			for (int i = 0; i < data.length; i ++) {
				temp[i] = data[i];
			}
		}
		data = temp;
	}


}