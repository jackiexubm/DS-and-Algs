import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class Bronze {

	public static void main(String[] args){
		int[][] pasture;
		int rows;
		int cols;
		int lakeElevation;
		int[] stompRow;
		int[] stompCol;
		int[] stompDepth;

		if(args.length < 1){
			System.out.println("Please enter a filename with the extension after java Bronze");
		}else{
			try
			{
				String filename = args[0];
				File file = new File(filename);
				Scanner scanner = new Scanner(file);
				rows = Integer.parseInt(scanner.next());
				cols = Integer.parseInt(scanner.next());
				lakeElevation = Integer.parseInt(scanner.next());
				int stomps = Integer.parseInt(scanner.next());
				pasture = new int[rows][cols];
				for (int row = 0; row < rows; row ++) {
					for (int col = 0; col < cols; col++) {
						pasture[row][col] = Integer.parseInt(scanner.next());	
					}
				}
				stompRow = new int[stomps];
				stompCol = new int[stomps];
				stompDepth = new int[stomps];
				for (int i = 0; i < stomps; i++) {
					stompRow[i] = Integer.parseInt(scanner.next());
					stompCol[i] = Integer.parseInt(scanner.next());					
					stompDepth[i] = Integer.parseInt(scanner.next());
				}

				pasture = stomp(pasture,stompRow,stompCol,stompDepth);
				System.out.println(getVolume(pasture,lakeElevation));

			}
			catch (FileNotFoundException ex)
			{
				System.out.println("FileNotFoundException");
			}
		}
	}


	public static int[][] stomp(int[][] pasture, int[] stompRow, int[] stompCol, int[] stompDepth){
		for(int i = 0; i < stompRow.length; i++){
			int highest = 0;
			for(int row = stompRow[i] - 1; row < stompRow[i] + 2 && row < pasture.length; row++){
				for(int col = stompCol[i] - 1; col < stompCol[i] + 2 && col < pasture[0].length; col++){
					if(pasture[row][col] > highest){
						highest = pasture[row][col];
					}
				}
			}
			int newHighest = highest - stompDepth[i];
			for(int row = stompRow[i] - 1; row < stompRow[i] + 2 && row < pasture.length; row++){
				for(int col = stompCol[i] - 1; col < stompCol[i] + 2 && col < pasture[0].length; col++){
					if(pasture[row][col] > newHighest){
						pasture[row][col] = newHighest;
					}
				}
			}
		}
		return pasture;
	}


	public static int getVolume(int[][] pasture, int elevation){
		int[][] pastureDepth = new int[pasture.length][pasture[0].length];
		for(int row = 0; row < pasture.length; row++){
			for(int col = 0; col < pasture[0].length; col++){
				int depth = elevation - pasture[row][col];
				if(depth < 0){
					pastureDepth[row][col] = 0;
				}else{
					pastureDepth[row][col] = depth;
				}
			}
		}
		int aggregatedDepth = 0;
		for(int row = 0; row < pasture.length; row++){
			for(int col = 0; col < pasture[0].length; col++){
				aggregatedDepth += pastureDepth[row][col];
			}
		}
		return 5184 * aggregatedDepth;
	}


	public static void printPasture(int[][] board){
		String ret  = "";
		for (int x = 0; x < board.length; x ++){
			for (int y = 0; y < board[0].length; y ++){
				if (board[x][y] >= 1000){
					ret = ret + " " + board[x][y] + " ";
				}else if (board[x][y] >= 100){
					ret = ret + " " + board[x][y] + "  ";
				}else if (board[x][y] >= 10){
					ret = ret + " " + board[x][y] + "   ";
				}else{
					ret = ret + " " +  board[x][y] + "    ";
				}
			}
			ret += "\n";
		}
		System.out.println(ret);
	}
}