public class Driver{
	public static void main(String[] args){
		int[] a = new int[10000];
		Sorts.fillRandom(a);
		Sorts.mergeSort(a);
	//	Sorts.printArray(a); 
	//	System.out.println( Sorts.checkOrder(a));

	}
}