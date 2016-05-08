import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{
	private T[] data;
	private boolean isMax;

	//constructors

	public MyHeap(boolean boo){
		data = (T[]) new Comparable[10];
		isMax = boo;
	}

	public MyHeap(T[] arr, boolean boo){
		data = (T[]) new Comparable[arr.length];
		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
		}
		isMax = boo;
	}

	public MyHeap(T[] arr){
		data = (T[]) new Comparable[arr.length];
		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
		}
		isMax = true;
	}

	public MyHeap(){
		data = (T[]) new Comparable[10];
		isMax = true;
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

	}

	// public T delete(){
	// }

	public void add(T x){

	}

	public String toString(){
		String s = "";
		for (int i = 0 ; i < data.length ; i++) {
			s += data[i].toString() + " ";
		}
		return s;
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

	private int getLeft(int index){
		return 2 * index + 1;
	}

	private int getRight(int index){
		return 2 * index + 2;
	}

	private int getParent(int index){
		return (index - 1) / 2;
	}

}