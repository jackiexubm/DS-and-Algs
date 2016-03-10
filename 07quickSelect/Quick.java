import java.util.Random;
public class Quick{

	public static String name(){
		return "6,Xu,Jackie"; // or "6,Last,First" 
	}

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

	public static int quickselect(int[] data, int k){
		if (k < 0 || k > data.length  - 1) {
			throw new IllegalArgumentException("Not in index range of data set.");
		}
		return quickselect(data, k , 0 , data.length - 1);
	}

	private static int quickselect(int[] data, int k, int left, int right){
		int n = partition(data, left, right);
		if (n == k) {
			return data[n];
		}else if (k < n) {
			return quickselect(data, k, left, n - 1);
		}else{
			return quickselect(data, k , n + 1, right);
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
		
	}


	public static void main(String[]args){
		int[] a = {4,0,6,8,2,3,1,7,5,9};
		printArray(a);
		System.out.println(quickselect(a,9)); 
		printArray(a);
	}

}