import java.util.Objects;

public class MyLinkedList<T> {
    private LNode start;
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
        }
        else {
            LNode current = start;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new LNode(value);
        }
        size++;
        return true;
    }

    public String toString() {
        String s = "[ ";
        LNode current = start;
        if (start != null) {
            while (current.next != null) {
                s += current.value.toString() + ", ";
                current = current.next;
            }
            s += current.value;
        }
        return s + " ]";
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

}
