public class Test{
	public static void main(String[] args) {
		FrontierQueue<Integer> a = new FrontierQueue<Integer>();
		a.add(5);
		a.add(8);
		System.out.println(a.next());
		System.out.println(a.hasNext());
		System.out.println(a.next());
		System.out.println(a.hasNext());
		System.out.println(a.next());
		System.out.println(a.data);
	}
}