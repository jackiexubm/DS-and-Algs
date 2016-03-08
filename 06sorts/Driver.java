import java.util.Arrays;
public class Driver{
	public static void main(String[] args){
		int[] a = new int[1000000];
		Sorts.fillRandom(a);
		//		Arrays.sort(a);
		Sorts.mergeSort(a);
	//	Sorts.printArray(a); 
	//	System.out.println( Sorts.checkOrder(a));

	}
}
