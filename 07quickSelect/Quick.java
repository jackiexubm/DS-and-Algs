public class Quick{

	private static int partition(int[]data, int left, int right){
		return 0;
	}
	//choose a random partition element  at a location from left to right inclusive.
	//partition the array such that the randomly chosen element divides all values smaller and larger than it.
//smaller elements on the left side of the partition, larger on the right side
//return the index of the partition element.
//    this allows your quickselect method to decide where to go next.


	public static int quickselect(int[]data, int k){
		return 0;
	}
	//return the kth smallest value.
// when k = 0 return the smallest.
// 0 <= k < data.length

	private static int quickselect(int[]data, int k, int left, int right){
		return 0;
	}
	//return the kth smallest value in the given left/right range
// left <= k <= right
//start by calling the helper as follows:
//    quickselect(data,k,0,data.length-1)

	public static void printArray(int[] data){
		if (data.length == 0) {
			System.out.print("\n[]");
		}else{
			System.out.print("\n[ ");
			int i = 0;
			while(i < data.length - 1){
				System.out.print(data[i] + ", ");
				i++;
			}
			System.out.println(data[i] + " ]");
		}
	}

	public static void swap(int[] data, int pos1, int pos2){
		int holder = data[pos2];
		data[pos2] = data[pos1];
		data[pos1] = holder;
	}

	public static void main(String[]args){
		int[] a = new int[10];
		printArray(a);
	}

}