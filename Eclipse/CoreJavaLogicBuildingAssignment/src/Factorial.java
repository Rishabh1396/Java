
public class Factorial {

	public static void main(String[] args) {
			int i,fact=1,limit=5;
			for(i=2;i<=limit;i++){
					fact=fact*i;
			}
		System.out.println("Factorial of "+limit+" is: "+fact);
	}
}
