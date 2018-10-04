
public class HCFAndLCM {

	public static void main(String[] args) {
		int number1=25, number2=50;
		int temp1=number1, temp2=number2,temp3,hcf,lcm;
		while(temp2 != 0){
			temp3 = temp2;
			temp2 = temp1%temp2;
			temp1 = temp3;
		}
		hcf = temp1;
		lcm = (number1*number2)/hcf;
		System.out.println("HCF and LCM of "+number1+" and "+number2+" : "+hcf+" , "+lcm);
	}
}
