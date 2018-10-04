
public class QuickSort {
	int arr[]={21,54,87,32,58,67,90,100,76,60};

	public static void main(String[] args) {
		QuickSort q=new QuickSort();
		q.qSort(0,q.arr.length-1);
		for (int i = 0; i < q.arr.length; i++) {
			System.out.println(q.arr[i]);
		}

	}
	void qSort(int low,int high){
		int pivot=this.arr[low];
		int pidx=low;
		if(high-low<=1){}
		else{
			for (int i = low; i <= high; i++) {
				if(this.arr[i]<pivot){
					int temp=this.arr[i];
					for (int j = i; j > pidx; j--) {
						this.arr[j]=this.arr[j-1];
					}
					this.arr[pidx]=temp;
					pidx++;
				}
			}
			this.qSort(low,pidx-1);
			this.qSort(pidx+1,high);
		}
	}
}
