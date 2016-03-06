import java.util.Random;
public class Sorts{

	private static String debug = "false";
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

	public static void fillRandom(int[] data){
		Random rand = new Random();
		for(int i = 0; i < data.length; i ++){
			data[i] = rand.nextInt(Integer.MAX_VALUE) - (2 * rand.nextInt(Integer.MAX_VALUE));
		}
	}

	public static boolean checkOrder(int[] data){
		for(int i = 0; i < data.length - 1; i ++){
			if (data[i] > data[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static void insertionSort(int[] data){
		if (data.length == 0){
		}else{
			if(debug.equals("true")){
				printArray(data);	
				System.out.print("\nStart insertionSort");
			}  
			for(int i = 1; i < data.length; i++){		
				boolean notDone = true;    
				for(int j = i - 1; j >= 0 && notDone; j--){
					if(data[i] > data[j]){				
						int intsert = data[i];				
						for(int k = i; k > j + 1; k--){	   	
							data[k] = data[k-1]; 
						}
						data[j + 1] = intsert;				
						notDone = false;					
					}else if (j == 0) {					
						int intsert = data[i];				 
						for(int k = i; k > 0; k--){		
							data[k] = data[k-1]; 			 
						}
						data[0] = intsert;					
					}
				}
				if(debug.equals("true")){
					System.out.print("\nResult:");
					printArray(data);	    
				}
			}
		}
	}

	public static void swap(int[] data, int pos1, int pos2){
		int holder = data[pos2];
		data[pos2] = data[pos1];
		data[pos1] = holder;
	}

	public static void selectionSort(int[] data){
		if(debug.equals("true")){
			System.out.print("\nStart selectionSort:");
		}
		for (int i = 0; i < data.length; i ++){
			int lowestPosition = i;
			int lowest = data[i];
			for(int i2 = i; i2 < data.length - 1; i2 ++){
				if(data[i2 + 1] < lowest){
					lowest = data[i2 + 1];
					lowestPosition = i2 + 1;
				}
			}
			swap(data,i,lowestPosition);
		}
		if(debug.equals("true")){
			System.out.print("\nResult:");
			printArray(data);
		}
	}

	public static void bubbleSort(int[] data){
		if(debug.equals("true")){
			System.out.print("\nStart bubbleSort:");
		}

		for (int i = 0; i < data.length - 1; i ++){
			int swapped = 0;   
			for (int i2 = 0; i2 < data.length - 1 - i; i2 ++){
				if(data[i2] > data[i2 + 1]){
					swap(data,i2,i2 + 1);
					swapped ++;
				}
			}
			if(swapped < 1){
				if(debug.equals("true")){
					System.out.print("\nResult:");
					printArray(data);
				}
				return;
			}
		}
		if(debug.equals("true")){
			System.out.print("\nResult:");
			printArray(data);
		}	
	}



	public static void mergeSort(int[] data){
		mergeSortHelper(data, 0, mergeHalf(data.length), mergeHalf(data.length) + 1, data.length - 1);
	}

	public static void mergeSortHelper(int[] data, int s1, int e1, int s2, int e2){
		if(e1 == s1 && s2 == e2){
			merge(data,s1,e1,s2,e2);
		}else if (s2 == e2) {
			mergeSortHelper(data,s1, s1 + mergeHalf(e1 - s1),s1 + mergeHalf(e1 - s1) + 1, e1);
			mergeSortHelper(data,s2, e2, s2, e2);
			merge(data,s1,e1,s2,e2);
		}else if (s1 == e1) {
			mergeSortHelper(data,s1, e1, s2, e2);
			mergeSortHelper(data,s2, s2 + mergeHalf(e2 - s2),s2 + mergeHalf(e2 - s2) + 1, e2);
			merge(data,s1,e1,s2,e2);
		}else{
			mergeSortHelper(data,s1, s1 + mergeHalf(e1 - s1),s1 + mergeHalf(e1 - s1) + 1, e1);
			mergeSortHelper(data,s2, s2 + mergeHalf(e2 - s2),s2 + mergeHalf(e2 - s2) + 1, e2);
			merge(data,s1,e1,s2,e2);
		}
	}

	public static void merge(int[] data, int s1, int e1, int s2, int e2){
		int[] newData = new int[e2 - s2 + (e1 - s1) + 2];
		int start = s1;

		if(e1 == e2){
			return;
		}

		if(s2 < s1){
			start = s2;
		}

		for (int i = 0; i < newData.length; i++) {
			if(s1 > e1){
				newData[i] = data[s2];
				s2++;
			}else if(s2 > e2){
				newData[i] = data[s1];
				s1++;
			}else if(data[s1] <= data[s2]){
				newData[i] = data[s1];
				s1++;
			}else if(data[s2] < data[s1]){
				
				newData[i] = data[s2];
				s2++;
			}
		}

		for (int i = 0; i < newData.length ; i++) {
			data[i + start] = newData[i];
		}
	}

	public static int mergeHalf(int n){
		if (n % 2 == 0){
			return n / 2;
		}
		return (n - 1) / 2;
	}

}













