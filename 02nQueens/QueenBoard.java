public class QueenBoard{
    private int[][]board;
    
    public QueenBoard(int size){
	board = new int[size][size];
    }

    /**
     *precondition: board is filled with 0's only.
     *postcondition: 
     *-return false, and board is still filled
     *with 0's for a board that cannot be solved.
     *-return true, and board is filled with the 
     *final configuration of the board after adding 
     *all n queens.
     */
    public boolean solve()
    {
	return solveH(0);
    }

    public String toStringDebug(){
	String ret  = "";
	for (int x = 0; x < board.length; x ++){
	    for (int y = 0; y < board.length; y ++){
		if (board[x][y] >= 0){
		    ret = ret + " " + board[x][y] + " ";
		}else{
		    ret = ret + board[x][y] + " ";
		}
	    }
	    ret += "\n";
	}
	return ret;
    }    
    
    /**
     *Helper method fr solve. 
     */
    private boolean solveH(int col){
	if (col == board.length - 1 ){
	    printSolution();
	    for(int i = 0; i < board.length; i++){
		for (int i2 = 0; i2 < board.length; i2 ++){
		    removeQueen(i2, col);
		}                                                                                                                            
		if(addQueen(i,col)){
		    return true;
		}
	    }
	    return false;
	};
	System.out.println(toStringDebug());
	for (int i = 0; i < board.length; i++){
	    for (int i2 = 0; i2 < board.length; i2 ++){
		removeQueen(i2, col);
	    }
	    if(addQueen(i,col)){
		solveH(col + 1);
	    }
	}
	for (int i = 0; i < board.length; i ++){
	    for (int i2 = 0; i2 < board.length; i2 ++){
		board[i][i2] = 0;
	    }
	}
	return false;
    }
    
    public void printSolution(){
	/**Print the board like toString, except
	   all negative numbers, and 0's are replaced with '_'
	   and all 1's are replaced with 'Q'
	*/
	String ret  = "";
	for (int x = 0; x < board.length; x ++){
	    for (int y = 0; y < board.length; y ++){
		if (board[x][y] > 0){
		    ret =  ret + " Q ";
		}else{
		    ret = ret + " _ ";
		}
	    }
	    ret += "\n";
	}
	System.out.println(ret);  
    }

    /********Do Not Edit Below This Line**********************************/

    private boolean addQueen(int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] = 1;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]--;
	    if(row - offset >= 0){
		board[row-offset][col+offset]--;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	//	for (int i = 1; i < board.length; i ++){
	//   if (row + i < board.length){
	//	board[row + i][col] --;
	//    }
	//	}
	return true;
    }

    private boolean removeQueen(int row, int col){
	if(board[row][col] != 1){
	    return false;
	}
	board[row][col] = 0;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]++;
	    if(row - offset >= 0){
		board[row-offset][col+offset]++;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	//	for (int i = 1; i < board.length; i ++){
	//  if (row + i < board.length){
	//	board[row + i][col] ++;
	//  }
	//	}
	return true;
    }

    public String  toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		ans+= board[r][c]+"\t";
	    }
	    ans+="\n";
	}
	return ans;
    }
    /*
    public static void main(String[]args){
    QueenBoard b = new QueenBoard(5);
        System.out.println(b);
	b.addQueen(3,0);
	b.addQueen(0,1);
        System.out.println(b);
	b.removeQueen(3,0);
        System.out.println(b);
    }
    */
    
}
