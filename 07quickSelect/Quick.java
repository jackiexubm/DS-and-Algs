import java.util.Random;
public class Quick{

	private static int partition(int[] data, int left, int right){
		Random rand = new Random();
		int pos = left + rand.nextInt(right - left + 1);
		int[] parted = new int[right - left + 1];
		int l = 0;
		int r = parted.length - 1;
		int equals = 0;
		for (int i = left; i <= right; i++) {
			if (data[i] < data[pos]) {
				parted[l] = data[i];
				l++;
			}else if (data[i] > data[pos]){
				parted[r] = data[i];
				r--;
			}else{
				equals++;
			}
		}
		for (int i = 0; i < equals; i++) {
			parted[i + l] = data[pos];
		}
		for (int i = 0; i < parted.length; i++) {
			data[left + i] = parted[i];
		}
		return l + left;
	}

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

	// public static void swap(int[] data, int pos1, int pos2){
	// 	int holder = data[pos2];
	// 	data[pos2] = data[pos1];
	// 	data[pos1] = holder;
	// }

	public static void main(String[]args){
		int[] a = {9,8,7,6,5,4,3,2,1};
		printArray(a);
		System.out.println(partition(a,5,8));
		printArray(a);
	}

}