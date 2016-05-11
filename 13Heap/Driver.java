public class Driver{
	public static void main(String[] args) {
		Integer[] b = {new Integer(1),new Integer(3),new Integer(6),new Integer(5),new Integer(9),new Integer(8), new Integer(-2)};
		MyHeap<Integer> a = new MyHeap<Integer>(b,false);
		System.out.println(a);
		a.add(5);
		System.out.println();
		a.add(18);
		a.add(20);
		a.add(3);
		a.add(4);

		System.out.println(a);
	}
}