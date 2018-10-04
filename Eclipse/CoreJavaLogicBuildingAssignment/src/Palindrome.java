
public class Palindrome {

	public static void main(String[] args) {
		int num=121;
		int d=num;
		int rev=0,mod=0;
		while(d>0){
			rev*=10;
			mod=d%10;
			rev=rev+mod;
			d/=10;
		}
		if(num==rev)
			System.out.println("Number is a Palindrome no.");
		else
			System.out.println("Number is not a Palindrome no.");

	}

}
