
public class Stack {
	int stackArr[]=new int[10];
	static int pointer=0;
	public static void main(String[] args) {
		Stack s=new Stack();
		s.push(2);
		s.push(3);
		s.pop();
		System.out.println(pointer);
	}
	void push(int num){
		this.stackArr[pointer]=num;
		pointer++;
	}
	void pop(){
		this.stackArr[pointer]=0;
		pointer--;
	}
}
