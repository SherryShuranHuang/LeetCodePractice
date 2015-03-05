
public class Palindrome {
	public static String longestPalindrome(String s) {//http://blog.csdn.net/linhuanmars/article/details/20888595
        if(s.length()==0 || s==null){
            return null;
        }
        if(s.length() ==1) return s;
        int max = 0;
        String res = "";
        for(int i=0;i<2*s.length()-1;i++){
            int l = i/2;
            int r = i/2;
            if(i%2 == 1){
                r++;
            }
            String is = PalindromeLen(s,l,r);
//            if(is != null){
            	if(max < is.length()){
            		max = is.length();
            		res = is;
//            	}
            }
            
        }
        return res;
    }
    
    private static String PalindromeLen(String str, int l, int r){
        
        // int l = left;
        // int r = right;
        while(l>=0 && r<str.length()&& str.charAt(l)==str.charAt(r)){
           // if(str.charAt(l)==str.charAt(r)){
            	l--;
            	r++;
           // }
        }
        return str.substring(l+1,r);
    }
	public static boolean isPalindrome(String str){
        if(str == null || str.length() == 1||str.length()==0) 
        	return true;
        int l = 0;
        int r = str.length()-1;
 //       while(l<r){
        if(str.charAt(l)== str.charAt(r)){
        	String sub = str.substring(++l,r);
            isPalindrome(sub);
        }
        else
        	return false;

        
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abb";
//		if(isPalindrome(str)){
//			System.out.println("yes");
//		}
		
		String s = longestPalindrome(str);
		
		System.out.println(s);
	}

}
