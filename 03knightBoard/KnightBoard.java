public class KnightBoard{
    private int[][] board;
    private int rows;
    private int cols;
    
    public KnightBoard(int size){
	board = new int[size][size];
	rows = size;
	cols = size;
    }

    public KnightBoard(int cols, int rows){
	board = new int[rows][cols];
        this.rows = rows;
	this.cols = cols;
    }
    public boolean solve(){
	return solveH(1,0,0);
    }

    public boolean solveH(int moveNum, int x, int y){
	if(x < 0 || x >= rows || y < 0 || y >= cols){
	    return false;
	}
	if(board[x][y] >= 1){
	    return false;
	}
	
	if(moveNum == rows * cols){
	    board[x][y] = moveNum;
	    return true;
	}
	
	board[x][y] = moveNum;
	if (solveH(moveNum + 1, x + 1, y - 2) ||
	    solveH(moveNum + 1, x + 2, y - 1) ||
	    solveH(moveNum + 1, x + 2, y + 1) ||
	    solveH(moveNum + 1, x + 1, y + 2) ||
	    solveH(moveNum + 1, x - 1, y + 2) ||
	    solveH(moveNum + 1, x - 2, y + 1) ||
	    solveH(moveNum + 1, x - 2, y - 1) ||
	    solveH(moveNum + 1, x - 1, y - 2)){
	    return true;
	}else{
	    board[x][y] = 0;
	    return false;
	}
    }
    
    public void printSolution(){
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
