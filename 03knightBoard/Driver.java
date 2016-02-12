public class Driver{
    public static void main(String[] args){
	KnightBoard a = new KnightBoard(8,8);
	System.out.println(a.solve());
	a.printSolution();
    }
}
