package EPIC;
/*
Swapping String
Given two strings, you need to transpose the first string 
to the second string by means of only swaps between 2 consecutive 
characters in the first string. This must be performed 
by doing a series of these swaps in order to get the second string.
*/
public class SwappingString {

	public static void main(String[] args){
		String s1 = "TEHUNOOL";
		String s2 = "ONLEHTUO";
		String s3 = "abcde";
		String s4 = "edcbf";
		
//		if (transpose(s1, s2)) {
//			System.out.println("Yah!");
//		} else {
//			System.out.println("Failed!");
//		}
		
		if (transpose(s4, s3)) {
			System.out.println("Yah!");
		} else {
			System.out.println("Failed!");
		}
	}
	public static boolean transpose(String str1, String str2){
		if(str1.length()!=str2.length()) return false;
		char[] stra1 = str1.toCharArray();
		char[] stra2 = str2.toCharArray();
		
		int i=0;
		int count = 0;
		while(i<stra1.length){
			if(stra1[i]==stra2[i]){
				i++;
				count = 0;
			
			}else{
				for(int j=i;j<stra1.length-1;j++){
					char temp = stra1[j];
					stra1[j] = stra1[j+1];
					stra1[j+1] = temp;
					count++;
					
					if(count==stra1.length*(stra1.length-1))
						//说明两层循环了一遍s1都没有找到s2里面的字符
						return false;
				}
				
			}
		}
		return true;
	}
}
