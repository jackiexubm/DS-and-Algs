import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{
	private T[] data;
	private int size;
	private boolean isMax;

	//constructors

	public MyHeap(boolean boo){
		data = (T[]) new Comparable[10];
		isMax = boo;
		size = 0;
	}

	public MyHeap(T[] arr, boolean boo){
		data = (T[]) new Comparable[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			data[i + 1] = arr[i];
		}
		size = arr.length;
		isMax = boo;
		heapify();
	}

	public MyHeap(T[] arr){
		data = (T[]) new Comparable[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			data[i + 1] = arr[i];
		}
		size = arr.length;
		isMax = true;
		heapify();
	}

	public MyHeap(){
		data = (T[]) new Comparable[10];
		isMax = true;
		size = 0;
	}

	//methods

	private void pushDown(int k){
		if (Math.log(k) / Math.log(2) == Math.log(size) / Math.log(2)) {     // log base 2 of k. this gets k's height
			return;
		}
		if (isMax == true) {
			if (getLeft(k) < size && getRight(k) < size) {   // has left and right children
				if ( data[getLeft(k)].compareTo(data[k]) > 0 || data[getRight(k)].compareTo(data[k]) > 0 ) {
					if (data[getLeft(k)].compareTo(data[getRight(k)]) > 0) {
						T temp = data[k];
						data[k] = data[getLeft(k)];
						data[getLeft(k)] = temp;
						pushDown(getLeft(k));
					}else {
						T temp = data[k];
						data[k] = data[getRight(k)];
						data[getRight(k)] = temp;
						pushDown(getRight(k));
					}
				}
			}else if (getLeft(k) <= size) {
				if (data[getLeft(k)].compareTo(data[k]) > 0) {
					T temp = data[k];
					data[k] = data[getLeft(k)];
					data[getLeft(k)] = temp;
					pushDown(getLeft(k));
				}
			}
		}else {
			if (getLeft(k) < size && getRight(k) < size) {   
				if ( data[getLeft(k)].compareTo(data[k]) < 0 || data[getRight(k)].compareTo(data[k]) < 0 ) {
					if (data[getLeft(k)].compareTo(data[getRight(k)]) < 0) {
						T temp = data[k];
						data[k] = data[getLeft(k)];
						data[getLeft(k)] = temp;
						pushDown(getLeft(k));
					}else {
						T temp = data[k];
						data[k] = data[getRight(k)];
						data[getRight(k)] = temp;
						pushDown(getRight(k));
					}
				}
			}else if (getLeft(k) <= size) {
				if (data[getLeft(k)].compareTo(data[k]) < 0) {
					T temp = data[k];
					data[k] = data[getLeft(k)];
					data[getLeft(k)] = temp;
					pushDown(getLeft(k));
				}
			}
		}
	}

	private void pushUp(int k){
		if (isMax == true) {
			if (k == 1){
				return;
			}
			System.out.println("ran");
			if (data[getParent(k)].compareTo(data[k]) < 0) {
				T temp = data[k];
				data[k] = data[getParent(k)];
				data[getParent(k)] = temp;
				pushUp(getParent(k));
			}
		}else {
			if (k == 1) {
				return;
			}
			if (data[getParent(k)].compareTo(data[k]) > 0) {
				T temp = data[k];
				data[k] = data[getParent(k)];
				data[getParent(k)] = temp;
				pushUp(getParent(k));
			}
		}
	}

	// public T delete(){
	// }

	public void add(T x){
		if (size >= data.length - 1) {
			doubleSize();
		}
		size++;
		data[size] = x;
		pushUp(size);
	}

	public void printData(){
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
		}
	}

	public String toString(){
		String s = "[";
		if (size == 0) {
			return "[]";
		}
		for (int i = 1 ; i < size; i++) {
			s += data[i].toString() + ",";
		}
		return  s + data[size] + "]";
	}

	private void heapify(){
		for (int i = size/2;i > 0; i-- ) {
			pushDown(i);
		}
	}

	private void doubleSize(){
		T[] temp = (T[]) new Comparable[data.length * 2];
		for (int i = 0; i < data.length ; i ++) {
			temp[i] = data[i];
		}
		data = temp;
	}

	private static int getLeft(int index){
		return 2 * index + 1;
	}

	private static int getRight(int index){
		return 2 * index + 2;
	}

	private static int getParent(int index){
		if (index == 2) {
			return 1;
		}
		return (index) / 2;
	}

}