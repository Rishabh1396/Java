import java.math.*;
public class Armstrong {

	public static void main(String[] args) {
		int a=153;
		int d=a;
		int b=0,c=0,order=0;
		while(d>0){
			d/=10;
			order++;
		}
		d=a;
		for (int i = 0; i <order; i++) {
			c=d%10;
			b=b+(int)Math.pow(c, order);
			d/=10;
		}
		if(a==b)
			System.out.println("Number is an Armstrong no.");
		else
			System.out.println("Number is not a Armstrong no.");

	}

}
