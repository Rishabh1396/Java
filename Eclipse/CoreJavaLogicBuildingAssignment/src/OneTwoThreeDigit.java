
public class OneTwoThreeDigit {

	public static void main(String[] args) {
		int arr[]={2,435,6765,6577,7876,243,32,4};
		int count[]={0,0,0,0};
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]<10)
				count[0]++;
			else if(arr[i]>=10 && arr[i]<100)
				count[1]++;
			else if(arr[i]>=100 && arr[i]<1000)
				count[2]++;
			else count[3]++;
		}
		System.out.println("One digit : "+count[0]+"\nTwo digit : "+count[1]+"\nThree digit : "+count[2]+"\nMore than three digit : "+count[3]);
	}

}
