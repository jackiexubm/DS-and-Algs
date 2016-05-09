public class Driver{
	public static void main(String[] args) {
		Integer[] b = {new Integer(5),new Integer(4),new Integer(15),new Integer(2),new Integer(9),new Integer(6)};
		MyHeap<Integer> a = new MyHeap<Integer>(b,true);
		System.out.println(a);
		
	}
}