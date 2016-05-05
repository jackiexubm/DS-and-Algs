public class MyHeap<T extends Comparable<T>>{
	private Node root;
	private boolean isMax;

	private class Node{
		private Node parent;
		private Node left;
		private Node right;

		public Node(Node rent){
			parent = rent;
		}

		public Node getLeft(){
			return left;
		}

		public Node getRight(){
			return right;
		}

		public Node getParent(){
			return parent;
		}

		public void setLeft(Node l){
			left = l;
		}

		public void setRight(Node r){
			right = r;
		}

		public void setParent(Node p){
			parent = p;
		}
	}

	@SuppressWarnings("unchecked")
	public MyHeap(boolean max){
		data = (T[]) new Object[10];
		this.isMax = max;
	}

	public MyHeap(T[] data, boolean max){
		data = (T[]) new Object[10];
		this.isMax = max;
	}

	@SuppressWarnings("unchecked")
	public MyHeap(){
		data = (T[]) new Object[10];
		isMax = true;
	}

	public T peek(){
		return data[1];
	}

	// public T remove();

	// public void add(T var);

	public String toString(){
		String s = "";
		for (int i = 0 ; i < data.length ; i++) {
			s += data[i].toString() + " ";
		}
		return s;
	}

	private void heapify(){

	}

}