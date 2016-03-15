import java.util.Arrays;
public class Driver{

    public static void main(String[]args){

	int[] d = new int [4000000];

	for(int i = 0; i < d.length; i++){
	    d[i]= (int)(Math.random()*4);
	}
       Arrays.sort(d);
 
	
    }
    
}
