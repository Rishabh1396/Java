
public class DecToBin{
	public static void main(String[] str){
		int binNum[]=new int[100];
		int decNum=15,i=0; 
		while (decNum > 0){ 
			binNum[i]=decNum%2; 
			decNum=decNum/2; 
			i++;
		}
		for(int j=i-1;j>=0;j--){
			System.out.print(binNum[j]);
		} 
	}
}