
public class ArrayConversion {

	public static void main(String[] args) {
		int arr[]={1,2,3,4,5,6,7,8,9,10};
		int arr2[]=new int[10];
		int j=0;
		for (int i = 0; i < 10; i=i+2) {
			arr2[i+1]=arr[j];
			arr2[i]=arr[9-j];
			j++;
			System.out.print(arr2[i]+" "+arr2[i+1]+" ");
		}
	}
}
