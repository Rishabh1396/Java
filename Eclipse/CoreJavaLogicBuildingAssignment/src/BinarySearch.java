
public class BinarySearch {
	private int arr[]={21,54,87,32,58,67,90,100,76,60};
	private int previous=arr.length/2;
	public static void main(String[] args) {
		BinarySearch binarySearch=new BinarySearch();
		binarySearch.sort();
		int res=binarySearch.bSearch(32,(binarySearch.arr.length)/2,0,binarySearch.arr.length-1);
		if(res==1)
			System.out.println("The number is present");
		else
			System.out.println("The number is not present");
	}
	void sort(){
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if(arr[i]>arr[j]){
					int temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
				}
			}
		}
	}
	int bSearch(int num,int mid,int low,int high){
		int ret=0;
		if(arr[mid]==num){
			ret=1;
		}
		if(arr[high]<num){
			ret=0;
		}
		if(arr[low]>num){
			ret=0;
		}
		/*if(previous==mid){
			return 0;
		}*/
		else{
			if(num<arr[mid]){
				high=mid;
				ret=bSearch(num,(low+high)/2,low,high);
				previous=mid;
			}
			if(num>arr[mid]){
				low=mid;
				ret=bSearch(num,(low+high)/2,low,high);
				previous=mid;
			}
			
		}
		return ret;
		
	}

}
