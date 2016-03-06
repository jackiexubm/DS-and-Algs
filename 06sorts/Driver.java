public class Driver{
	public static void main(String[] args){
		int[] a = new int[1000];
		Sorts.fillRandom(a);
		Sorts.mergeSort(a);
	//	Sorts.printArray(a); 
	//	System.out.println( Sorts.checkOrder(a));

	}
}