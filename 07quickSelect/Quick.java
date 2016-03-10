import java.util.Random;
import java.util.Arrays;
public class Quick{

	public static String name(){
		return "6,Xu,Jackie"; 
	}

	private static int[] partition(int[] data, int left, int right){
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
		int[] ret = new int[2];
		ret[0] = l + left;
		ret[1] = l + left + equals;
		return ret;
	}

	public static int quickselect(int[] data, int k){
		if (k < 0 || k > data.length  - 1) {
			throw new IllegalArgumentException("Not in index range of data set.");
		}
		return quickselect(data, k , 0 , data.length - 1);
	}

	private static int quickselect(int[] data, int k, int left, int right){
		int[] ret = partition(data, left, right);
		int middleLeft = ret[0];
		if (middleLeft == k) {
			return data[middleLeft];
		}else if (k < middleLeft) {
			return quickselect(data, k, left, middleLeft - 1);
		}else{
			return quickselect(data, k , middleLeft + 1, right);
		}
	}

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

	public static void quickSort(int[] data){
		quickSort(data, 0, data.length - 1);
	}

	private static void quickSort(int[] data,int left,int right){
		if (right < left) {
		}else{
			int[] ret = partition(data, left, right);
			int middleLeft = ret[0];
			int middleRight = ret[1];
			quickSort(data, left, middleLeft - 1);
			quickSort(data, middleRight + 1, right);
		}
	}


	// public static void main(String[]args){
	// 	int[] a = new int[5000000];
	// 	for (int i = 0;i < a.length ; i++) {
	// 		a[i] = (int)(Math.random() * 3);
	// 	}
	
	// }

}