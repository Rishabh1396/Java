
public class InsertionSort {

	public static void main(String[] args) {
		int arr[]={21,54,87,32,58,67,90,100,76,60};
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j <i; j++) {
				if(arr[i]<arr[j]){
					int temp=arr[i];
					for (int k = i; k >j; k--) {
						arr[k]=arr[k-1];
					}
					arr[j]=temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
