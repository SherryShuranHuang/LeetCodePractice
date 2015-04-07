package EPIC;
/*Colorful Numbers:
 * A number can be broken into different sub-sequence parts. 
 * Suppose a number 3245 can bebroken into parts 
 * like 3 2 4 5 32 24 45 324 245. And this number is a colorfulnumber, 
 * since product of every digit of a sub-sequence are different. 
 * That is,3 2 4 5 (3*2)=6 (2*4)=8 (4*5)=20 (3*2*4)= 24 (2*4*5)= 40. 
 * But 326 is not a colorful number as it generates 3 2 6 (3*2)=6 (2*6)=12. 
 * You have to write a function that tells if the given number 
 * is a colorful number or not.
 */
import java.util.HashSet;

public class ColorfulNumber {
	public boolean isColorfulNum(int num){
		if(num<10) return true;
		HashSet<Integer> set = new HashSet<Integer>();
		int len = 0;
		int x = num;
		//get the length of the number
		while(x>0){
			x/=10;
			len++;
		}
		//convert the number to an array of digits
		int[] digits = new int[len];
		for(int i=len-1;i>=0;i--){				
			digits[i]=num%10;
			num = num/10;
		}
		//check if is a valid colorful number
		for(int i=0;i<len;i++){
			for(int j=i;j<len && j-i<len-1;j++){
				int curProduct = digits[i];
				if(i!=j)
					curProduct = getProduct(digits,i,j);
				if(set.contains(curProduct))
					return false;
				set.add(curProduct);
			}
		}
		return true;
	}
	//compute the product from the l digit to r digit
	private int getProduct(int[] digits, int l, int r){
		if(l>r) return 0;
		int res =1;
		for(int i = l;i<=r;i++){
			res *= digits[i];
		}
		return res;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColorfulNumber test = new ColorfulNumber();
		if(test.isColorfulNum(3245))
			System.out.println("yes");
		else{
			System.out.println("no");
		}
		
		if(test.isColorfulNum(326))
			System.out.println("yes");
		else{
			System.out.println("no");
		}
	}

}
