import java.util.*;


public class MyLinkedList<T> implements Iterable<T> {
    private LNode start;
    private LNode end;
    int size;

    public MyLinkedList() {
        size = 0;
    }

    public T get(int index) {
        LNode current = start;
        while (index > 0) {
            if (current.next == null) throw new IndexOutOfBoundsException();
            else {
                current = current.next;
            }
            index--;
        }
        return current.value;
    }

    public T set(int index, T newValue) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        LNode current = start;
        while (index > 0) {
            if (current.next == null) {
                throw new IndexOutOfBoundsException();
            } else {
                current = current.next;
            }
            index--;
        }
        T ret = current.value;
        current.value = newValue;
        return ret;
    }

    public int size() {
        if (start == null) return 0;
        int length = 0;
        LNode current = start;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        return length + 1;
    }

    public boolean add(T value) {
        if (start == null) {
            start = new LNode(value);
            end = start;
        }
        else {
            end.next = new LNode(value);
            end = end.next;
        }
        size++;
        return true;
    }

    public boolean add(int index, T value){
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }else if (index == size) {
            this.add(value);
            return true;
        }else if (index == 0) {
            LNode temp = new LNode(value);
            temp.next = start;
            start = temp;
            size++;
            return true;
        }else{
            LNode current = start;
            while(index > 0){
                current = current.next;
                index--;
            }
            LNode temp = new LNode(value);
            temp.next = current.next;
            current.next = temp;
            size++;
            return true;
        }
    }

    public T remove(int index){
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }else if (index == 0) {
            LNode ret = start;
            start = start.next;
            size--;
            return ret.value;
        }else{
            LNode current = start;
            while(index > 1){
                current = current.next;
                index--;
            }
            LNode ret = current;
            if (current.next.next == null) {
                end = current;
            }
            current.next = current.next.next;   
            size--;
            return ret.value;
        }
    }

    public String toString() {
        String s = "[";
        LNode current = start;
        if (start != null) {
            while (current.next != null) {
                s += current.value.toString() + ", ";
                current = current.next;
            }
            s += current.value;
        }
        return s + "]";
    }

    public String toString(boolean boo) {
        String s = "[";
        LNode current = start;
        if (start != null) {
            while (current.next != null) {
                s += current.value.toString() + ", ";
                current = current.next;
            }
            s += current.value;
        }
        s += "]";
        if (boo) {
            s += "     Head = " + start.value + "   Tail = " + end.value;
        }
        return s;
    }

    public Iterator<T> iterator(){
        return new myLinkedListIterator();
    }

    public class myLinkedListIterator implements Iterator<T>{
        private LNode current;

        public myLinkedListIterator(){
        	current = start;
        }
    
        public boolean hasNext(){
            return current.next != null; 
        }

        public T next(){
        	//T temp = current.value;
        	current = current.next;
            if (current == null) {
                throw new NoSuchElementException();
            }
            return current.value;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    private class LNode {

        public T value;
        public LNode next;

        public LNode(T n) {          // constructor does not have diamond <>
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

    public static void main(String[] args) {
    	MyLinkedList<Integer> n = new MyLinkedList<Integer>();
    	for (int i = 0; i < 20; i = i + 2) {
    		n.add(i);
    	}
    	for (Integer i : n) {
    		System.out.println(i);
    	}

    	Iterator<Integer> it = n.iterator();       // iterators allow multiple iterations simultaneous
    	Iterator<Integer> it2 = n.iterator();
    	it2.next();
    	while(it2.hasNext()){
    		System.out.println(it.next() + " vs " + it2.next());
    	}


 		System.out.println(n);
    }

}
