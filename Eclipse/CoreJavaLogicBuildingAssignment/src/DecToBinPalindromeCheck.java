
public class DecToBinPalindromeCheck {

	public static void main(String[] args) {
		String binary="";
		int decimal=15,copy=decimal;
		while (decimal > 0){ 
			binary=binary+""+decimal%2; 
			decimal=decimal/2; 
		}
		int BinNum=Integer.parseInt(binary);
		System.out.println("Binary of  "+copy+" is "+BinNum);
		int temp=BinNum,c,BinRev=0;
		while(temp!=0){
			c=temp%10;
			BinRev=BinRev*10 +c;
			temp/=10;
		}
		if(BinRev==BinNum)
			System.out.println("Binary of  "+copy+" is palindrome");
		else
			System.out.println("Binary of  "+copy+" is not palindrome");
	} 
}


