public class Driver{
    public static void main(String[] args){
		MyLinkedList a = new MyLinkedList();
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(6);
		a.add(7);
		a.add(8);
		a.set(8,7);
		System.out.println(a);
		System.out.println(a.size());
		System.out.println(a.get(3));
    }
}
