
public class NumberOfDigitsArray {
	
	public static void main(String[] args) {
		int numArr[] = {2, 3, 4, 10, 40,465,123,7896}; 
        int singleDigit=0,doubleDigit=0,threeDigit=0,greaterThanThree=0;
        for(int i=0;i<8;i++){
        	 if(numArr[i]>=0 && numArr[i]<10)
        		 singleDigit++;
        	 if(numArr[i]>=10 && numArr[i]<100)
        		 doubleDigit++;
        	 if(numArr[i]>=100 && numArr[i]<1000)
        		 threeDigit++;
        	 else 
        		 greaterThanThree++;
        }
       System.out.println("Single digit numbers : "+singleDigit+"\nDouble digit numbers : "+doubleDigit+"\nThree digits numbers : "+threeDigit+
    		   "\nMore than three digits numbers : "+greaterThanThree);
	}
}
