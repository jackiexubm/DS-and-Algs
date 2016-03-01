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
	double solutions = 0;
	double[][] pasture;

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
		pasture = new double[rows][cols];
		String map = "";
		for (int i = 0; i < rows; i++) {
			map += scanner.next();
		}
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {

				char tempChar = map.charAt(0);
				if (tempChar == '*') {
					pasture[row][col] = -1;					
				}else{
					pasture[row][col] = 0;
				}
				map = map.substring(1);
			}
		}
		startRow = Integer.parseInt(scanner.next()) - 1;
		startCol = Integer.parseInt(scanner.next()) - 1;
		endRow = Integer.parseInt(scanner.next()) - 1;
		endCol = Integer.parseInt(scanner.next()) - 1;
		pasture[startRow][startCol] = 1;

	}

	public boolean solve(){
		while(secs > 0){
			double[][] newPasture = new double[rows][cols];
			for(int row = 0; row < rows; row++){
				for(int col = 0; col < cols; col++){
					if(pasture[row][col] >= 0){
						double sumNine = 0;
						if(col - 1 >= 0 && pasture[row][col - 1] > 0){
							sumNine = sumNine + pasture[row][col - 1];
						}
						if(col + 1 < cols && pasture[row][col + 1] > 0){
							sumNine = sumNine + pasture[row][col + 1];
						}
						if(row - 1 >= 0 && pasture[row - 1][col] > 0){
							sumNine = sumNine + pasture[row - 1][col];
						}
						if(row + 1 < rows && pasture[row + 1][col] > 0){
							sumNine = sumNine + pasture[row + 1][col];
						}
						newPasture[row][col] = sumNine;
					}else{
						newPasture[row][col] = -1;
					}
				}
			}
			pasture = newPasture;
			printPasture();
			secs = secs - 1;
		}
		
		solutions = pasture[endRow][endCol];
		return true;
	}

		public void printPasture(){
		String ret  = "";
		for (int x = 0; x < pasture.length; x ++){
			for (int y = 0; y < pasture[0].length; y ++){
				if (pasture[x][y] >= 1000){
					ret = ret + " " + pasture[x][y] + " ";
				}else if (pasture[x][y] >= 100){
					ret = ret + " " + pasture[x][y] + "  ";
				}else if (pasture[x][y] >= 10){
					ret = ret + " " + pasture[x][y] + "   ";
				}else{
					ret = ret + " " +  pasture[x][y] + "    ";
				}
			}
			ret += "\n";
		}
		System.out.println(ret);
	}

	public static void main(String[] args) {
		Silver test = new Silver();
		test.printPasture();
		test.solve();
		System.out.println(test.solutions);
	}
}