
public class LargestAndSmallestNumberFormed {

	public static void main(String[] args) {
		int num = 58709107;
		int[] freq = new int[10]; 
		int[] freq1 = new int[10]; 
        while (num > 0) { 
            int d = num % 10;
            freq[d]++; 
            freq1[d]++; 
            num = num / 10;
        } 
        int smallest= 0,largest=0; 
        for (int i = 1 ; i <= 9 ; i++){ 
            if (freq[i] != 0) 
            { 
                smallest= i; 
                freq[i]--; 
                break; 
            } 
        } 
        for (int i = 0 ; i <= 9 ; i++) {
            while (freq[i]-- != 0) 
                smallest= smallest * 10 + i;
        }
        for (int i = 9 ; i >= 0 ; i--)  { 
            if (freq1[i] != 0) { 
                largest= i; 
                freq1[i]--; 
                break; 
            } 
        } 
        for (int i = 9 ; i >= 0 ; i--){ 
            while (freq1[i]-- != 0) 
                largest= largest* 10 + i;
        }
        System.out.println("Smallest Number: "+smallest+"\nLargest Number: "+largest);
	}
}
