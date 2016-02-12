public class Driver{
    public static void main(String[] args){
	KnightBoard a = new KnightBoard(6,7);
	System.out.println(a.solve());
	a.printSolution();
    }
}
