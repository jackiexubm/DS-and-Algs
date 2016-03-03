public class Recursion implements hw01{

	public Recursion(){};

	public String name(){
		return "Xu,Jackie";
	}
	
	public double sqrt(double n){
		return helper(n,n); 
	}

	public double helper(double original, double guess){
		if(original < 0){
			throw new IllegalArgumentException(); 
		}
		if(original ==0){
			return 0;
		}
		if((original - guess * guess)/original >= -.00000000000001 && (original - guess * guess)/original <= .00000000000001){
			return guess;
		}
		return helper(original, (original / guess + guess) / 2);
	}
}
