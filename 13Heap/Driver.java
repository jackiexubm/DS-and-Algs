public class Driver{
	public static void main(String[] args) {
		Integer[] b = {new Integer(1),new Integer(3),new Integer(6),new Integer(5),new Integer(9),new Integer(8), new Integer(-2)};
		MyHeap<Integer> a = new MyHeap<Integer>(b,false);
		System.out.println(a);
		a.pushDown(7);
		System.out.println(a);
	}
}