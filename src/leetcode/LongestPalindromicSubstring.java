package leetcode;

public class LongestPalindromicSubstring {
	public static String longestPalinSub(String str){
		if(str==null||str.length()==0) return "";
		String res = "";
		int maxLen = 0;
		
		for(int i=0;i<2*str.length()-1;i++){
			int l=i/2;
			int r=i/2;
			if(i%2==1){
				r++;
			}
			String cur = lengthOfPalindrome(str, l,r);
			if(maxLen<cur.length()){
				res= cur;
				maxLen = cur.length();
			}
		}
		
		return str;
	}
	private static String lengthOfPalindrome(String str, int l, int r){
		//if(l>r) return "";
		while(l>0 && r<str.length() && str.charAt(l)==str.charAt(r)){
			l--;
			r++;
		}
		return str.substring(l+1,r);
	}
	
	public static String longestPalinSub2(String str){
		if(str==null||str.length()==0) return "";
		boolean[][] palin = new boolean[str.length()][str.length()];
		String res = "";
		int maxLen = 0;
		for(int i=str.length()-1;i>=0;i--){
			for(int j=i;j<str.length();j++){
				if(str.charAt(i)==str.charAt(j)&&( j-i<=2 || palin[i+1][j-1])){
					//j-i<=2 this is for the condition when the length if even;
					palin[i][j] = true;
					if(maxLen < j-i+1){
						maxLen = j-i+1;
						res=str.substring(i,j+1);
					}
				}
			}
			
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
