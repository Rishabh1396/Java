
public class Queue {
	int queueArr[]=new int[10];
	static int inPointer=0;
	static int outPointer=0;
	public static void main(String[] args) {
		Queue q=new Queue();
		q.add(2);
		q.add(3);
		q.remove();
		System.out.println(inPointer);
		System.out.println(outPointer);
	}
	void add(int num){
		this.queueArr[inPointer]=num;
		inPointer++;
	}
	void remove(){
		this.queueArr[outPointer]=0;
		outPointer++;
	}

}
