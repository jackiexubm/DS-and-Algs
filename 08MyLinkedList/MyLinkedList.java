import java.util.Objects;

public class MyLinkedList{
	LNode start;
	int size;

	public MyLinkedList(){
		
		size = 0;
	}

	public int get(int index){
		LNode current = start;
		while (index > 0) {
			if (current.next == null) {
				throw new IndexOutOfBoundsException();
			}else{
				current = current.next;
			}
			index --;
		}
		return current.value;
	}

	public int set(int index,int newValue){
				LNode current = start;
		while (index > 0) {
			if (current.next == null) {
				throw new IndexOutOfBoundsException();
			}else{
				current = current.next;
			}
			index --;
		}
		int ret = current.value;
		current.value = newValue;
		return ret;
	}

	public int size(){
		int length = 0;
		LNode current = start;
		while(current.next != null){
			current = current.next;
			length ++;
		}
		return length + 1;
	}

	public boolean add(int value){
		if (start == null) {
			start = new LNode(value);
		}else {
			LNode current = start;
			while(current.next != null){
				current = current.next;
			}
			current.next = new LNode(value);
		}
		return true;
	}

	public String toString(){
		LNode current = start;
		String s = "[ ";
		while (current.next != null) {
			s += current.value + ", ";
			current = current.next;
		}
		s += current.value + " ]";
		return s;
	}

	private class LNode{

		public int value;
		public LNode next;

		public LNode(int n){
			this.value = n;
		}

		// public LNode getNext(){
		// 	return next;
		// }

		// public void setNext(LNode node){
		// 	next = node;
		// }

		// public int getValue(){
		// 	return value;
		// }

		// public void setValue(int n){
		// 	value = n;
		// }

	}

}
