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
		data = (T[]) new Comparable[arr.length];
		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
		}
		size = arr.length;
		isMax = boo;
	}

	public MyHeap(T[] arr){
		data = (T[]) new Comparable[arr.length];
		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
		}
		size = arr.length;
		isMax = true;
	}

	public MyHeap(){
		data = (T[]) new Comparable[10];
		isMax = true;
		size = 0;
	}

	//methods

	// pushDown
 	//      precondition: datas[k]'s children are valid heaps
	//      postconditions:-the element at index k has been 
 	//                     shifted to the correct spot.
 	//                     -data[k] and is a valid heap

	private void pushDown(int k){

	}

   	// pushUp
   	//    precondition: data is a heap with at most one item
   	//    out of place (element at k)
   	//    postconditions:-the element at index k has been 
   	//                   shifted to the correct spot.
   	//                   -data is a valid heap

	private void pushUp(int k){
		if (isMax == true) {
			if (k == 1) {
				return;
			}
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

	}

	public String toString(){
		String s = "[";
		for (int i = 0 ; i < size - 1; i++) {
			s += data[i].toString() + ",";
		}
		return  s + data[size - 1] + "]";
	}

	private void heapify(){

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
		return (index - 1) / 2;
	}

}