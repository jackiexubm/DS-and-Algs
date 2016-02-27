import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class Silver{
	Scanner scanner;
	int rows;
	int cols;
	int secs;
	int startRow;
	int startCol;
	int endRow;
	int endCol;
	int solutions = 0;
	char[][] pasture;

	public Silver(){
		try{
			File f = new File("ctravel.in");
			scanner = new Scanner(f);
		}catch(FileNotFoundException e){
			System.out.println("ctravel.in not found in this directory");
		}
		rows = Integer.parseInt(scanner.next());
		cols = Integer.parseInt(scanner.next());
		secs = Integer.parseInt(scanner.next());
		pasture = new char[rows][cols];
		String map = "";
		for (int i = 0; i < rows; i++) {
			map += scanner.next();
		}
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				pasture[row][col] = map.charAt(0);
				map = map.substring(1);
			}
		}
		startRow = Integer.parseInt(scanner.next()) - 1;
		startCol = Integer.parseInt(scanner.next()) - 1;
		endRow = Integer.parseInt(scanner.next()) - 1;
		endCol = Integer.parseInt(scanner.next()) - 1;
	}

	public boolean solve(int row, int col, int sec){
		if(sec == 0){
			if(row == endRow && col == endCol) return true;
			return false;
		}
		if(row < 0 || row > pasture.length - 1|| col < 0 || col > pasture[0].length - 1 || endRow - row + (endCol - col) > sec){
			return false;
		}
		if(pasture[row][col] == '*'){
			return false;
		}

		else{
			if(solve(row,col + 1, sec - 1)){
				solutions = solutions + 1;
			}else
			if(solve(row + 1,col, sec - 1)){
				solutions = solutions + 1;
			}else
			if(solve(row,col - 1, sec - 1)){
				solutions = solutions + 1;
			}else
			if(solve(row - 1,col, sec - 1)){
				solutions = solutions + 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Silver test = new Silver();
		test.solve(test.startRow,test.startCol,test.secs);
		System.out.println(test.solutions);
	}
}