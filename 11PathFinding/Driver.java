public class Driver{
	public static void main(String[] args) {
		BetterMaze a = new BetterMaze("data1.dat");
		
		a.solveBFS();
		System.out.println(a);
	}
}