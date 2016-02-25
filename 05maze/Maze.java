import java.util.*;
import java.io.*;

public class Maze{

	private char[][]maze;
	private int startx,starty;
	private boolean animate;

    /*Constructor loads a maze text file.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (only 1 per file)
      'S' - the location of the start(only 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found, print an error and exit the program.
    */
      public Maze(String filename, boolean ani){
      	try{
      		File f = new File(filename);
      		Scanner scanner = new Scanner(f);
      		LineNumberReader  lnr = new LineNumberReader(new FileReader(f));
      		int rows = 0;						//given a value to avoid initialization error, since it is initialized in a try block
      		try{
      			lnr.skip(Long.MAX_VALUE);
      			rows = lnr.getLineNumber() + 1;
      			lnr.close();
      		}catch(IOException ex){
      			System.out.print("not gona happen");
      		}
      		Scanner scanner2 = new Scanner(new File(filename));
      		int cols = scanner2.nextLine().length(); 
      		maze = new char[rows][cols];
      		String content = "";
      		while(scanner.hasNextLine()){
      			content += scanner.nextLine();
      		}
      		for (int row = 0; row < rows; row++) {
      			for (int col = 0; col < cols; col++) {
      				if (content.charAt(0) == 'S') {
      					startx = row ;
      					starty = col ;
      					System.out.println(startx);
      					System.out.println(starty);

      				}
      				maze[row][col] = content.charAt(0);
      				if (content.length() > 1){
      					content = content.substring(1);
      				}
      			}
      		}
      	}
      	catch(FileNotFoundException ex){
      		System.out.println("data1.dat file not found in this directory");
      	}
      	animate = ani;
      }


    /*Main Solve Function

      Things to note:
       When no S is contained in maze, print an error and return false.
    */
       public boolean solve(){
       	if(startx < 0){
       		System.out.println("No starting point 'S' found in maze.");
       		return false;
       	}else{
       		maze[startx][starty] = ' ';
       		return solve(startx,starty);
       	}
       }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.
      The S is replaced with '@' but the 'E' is not.

      Postcondition:
        Returns true when the maze is solved,
        Returns false when the maze has no solution.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'

    */
        private boolean solve(int row, int col){
        	Date s = new Date();
        	if(animate){
        		System.out.println(this);
        		wait(200);
        	}

        //COMPLETE SOLVE
        	if (maze[row][col] == 'E') {
        		return true;
        	}else{
        		System.out.print(s);
        		maze[row][col] = '@';
        		if(maze[row][col + 1] != '#' && maze[row][col + 1] != '.' && maze[row][col + 1] != '@' && solve(row,col + 1)){
        			System.out.print("down");
        			return true;
        		}else
        		if(maze[row + 1][col] != '#' && maze[row + 1][col] != '.' && maze[row + 1][col] != '@' && solve(row + 1,col)){
        			System.out.print("right");
        			return true;
        		}else
        		if(maze[row][col - 1] != '#' && maze[row][col - 1] != '.' && maze[row][col - 1] != '@' && solve(row,col - 1)){
        			System.out.print("up");
        			return true;
        		}else
        		if(maze[row - 1][col] != '#' && maze[row - 1][col] != '.' && maze[row - 1][col] != '@' && solve(row - 1,col)){
        			System.out.print("left");
        			return true;
        		}else{
        			System.out.print("back");
        			maze[row][col] = '.';
        		}
        	}
        	return false;
        }


    //FREE STUFF!!! *you should be aware of this*

        public void clearTerminal(){
        	System.out.println(CLEAR_SCREEN);
        }

        public String toString(){
        	int maxx = maze.length;
        	int maxy = maze[0].length;
        	String ans = "";
        	if(animate){
        		ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";
        	}
        	for(int i = 0; i < maxx * maxy; i++){
        		if(i % maxx == 0 && i != 0){
        			ans += "\n";
        		}
        		char c =  maze[i % maxx][i / maxx];
        		if(c == '#'){
        			ans += color(38,47)+c;
        		}else{
        			ans += color(32,40)+c;
        		}
        	}
        	return HIDE_CURSOR + go(0,0) + ans + "\n" + SHOW_CURSOR + color(37,40);
        }

    //MORE FREE STUFF!!! *you can ignore all of this*
    //Terminal keycodes to clear the terminal, or hide/show the cursor
        private static final String CLEAR_SCREEN =  "\033[2J";
        private static final String HIDE_CURSOR =  "\033[?25l";
        private static final String SHOW_CURSOR =  "\033[?25h";
    //terminal specific character to move the cursor
        private String go(int x,int y){
        	return ("\033[" + x + ";" + y + "H");
        }

        private String color(int foreground,int background){
        	return ("\033[0;" + foreground + ";" + background + "m");
        }

        private void wait(int millis){
        	try {
        		Thread.sleep(millis);
        	}
        	catch (InterruptedException e) {
        	}
        }


    //END FREE STUFF

        public void printMaze(){
        	String ret  = "";
        	for (int row = 0; row < maze.length; row ++){
        		for (int col = 0; col < maze[0].length; col ++){
        			ret += maze[row][col];
        		}
        		ret += "\n";
        	}
        	System.out.println(ret);
        }    
    }