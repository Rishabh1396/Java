
public class NumberOccurence {

	public static void main(String[] args) {
		int num=125697695,temp=num,rem=0;
		int occurence[]=new int[10];
		while(temp>0){
			rem=temp%10;
			occurence[rem]++;
			temp/=10;
		}
		for(int i=0;i<10;i++)
		System.out.println(i+": "+occurence[rem]);
	}

}
