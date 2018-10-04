
public class Fibonacci {

	public static void main(String[] args) {
		int first=0;
		int second=1;
		System.out.print(first+","+second);
		for (int i = 0; i <10; i++) {
			System.out.print(",");
			second=first+second;
			first=second-first;
			System.out.print(second);
		}

	}

}
