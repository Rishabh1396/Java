
public class ThirdLargestNumber {

	public static void main(String[] args) {
		int arr[]={21,54,87,32,58,67,90,100,76,60};
		int arr2[]=new int[3];
		arr2[0]=arr[0];
		arr2[1]=-798787686;
		arr2[2]=-76598798;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>arr2[0] && arr[i]!=arr2[0] && arr[i]!=arr2[1] && arr[i]!=arr2[2]){
				arr2[2]=arr2[1];
				arr2[1]=arr2[0];
				arr2[0]=arr[i];
			}
			else if(arr[i]>arr2[1] && arr[i]!=arr2[0] && arr[i]!=arr2[1] && arr[i]!=arr2[2]){
				arr2[2]=arr2[1];
				arr2[1]=arr[i];
			}
			else if(arr[i]>arr2[2] && arr[i]!=arr2[0] && arr[i]!=arr2[1] && arr[i]!=arr2[2]){
				arr2[2]=arr[i];
			}
		}
		System.out.println("Third largest no. : "+arr2[2]);

	}

}
