import java.util.InputMismatchException;
import java.util.Scanner;

import org.omg.CORBA.DynAnyPackage.TypeMismatch;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner ref=new Scanner(System.in);
			System.out.println("Enter number :-");
			int n1=ref.nextInt();
			System.out.println("Enter Number :-");
			int n2=ref.nextInt();
			System.out.println(n1/n2);
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Enter Numbers only");
		}
		catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println("Enter second number other than 0");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Enter second number other than 0");
		}
		System.out.println("This line is outside of try catch block");

	}

}
