import java.util.Objects;

public class MyLinkedList<T> {
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
        if (index > size) {
            return false;
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
            while(index > 1){
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
