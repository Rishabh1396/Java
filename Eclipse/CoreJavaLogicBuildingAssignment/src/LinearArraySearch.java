
public class LinearArraySearch {

	public static void main(String[] args) {
		int arr[]={1,2,3,4,5,6,7,8,9,10};
		int n=8;							//Number to be searched
		int flag=0;
		for(int i=0;i<10;i++){
			if(arr[i]==n){
				System.out.println("Number is present.");
				flag=1;
				break;
			}
			flag=0;
		}
		if(flag==0){
			System.out.println("Number is NOT present.");
		}
	}

}
