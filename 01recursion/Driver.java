public class Driver{
    public static void main(String[]args){
	Recursion a = new Recursion();
	int i;
	if(args.length > 0){
	    i = Integer.parseInt(args[0]);
	}else{
	    i = 10000;
	}

    double ans = a.sqrt(i);
	System.out.println(ans);
    }
    
}
