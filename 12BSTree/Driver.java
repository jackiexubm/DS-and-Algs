public class Driver{
	public static void main(String[] args) {
		BSTree<Integer> a = new BSTree<Integer>();
		a.add(5);
		a.add(6);
		a.add(7);
		a.add(4);
		a.add(3);
		System.out.println(a);
		//System.out.println(a.getHeight());
		System.out.println(a.contains(3));
	}
}