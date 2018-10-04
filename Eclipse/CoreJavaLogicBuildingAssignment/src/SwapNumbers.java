
public class SwapNumbers {

	public static void main(String[] args) {
		int num1=5;
		int num2=3;
		num1-=num2;
		num2+=num1;
		num1=num2-num1;
		System.out.println("First Number:"+num1);
		System.out.println("Second Number:"+num2);

	}

}
