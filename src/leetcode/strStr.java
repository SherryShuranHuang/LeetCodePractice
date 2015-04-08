package leetcode;

public class strStr {
    public static int strStr(String haystack, String needle) {
        if(haystack==null || needle == null||haystack.length()<needle.length()) return -1;
        if(needle.length()==0) return 0;
        boolean flag = true;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            flag=true;
            for(int j=0;j<needle.length();j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    flag = false;
                    break;
                }
               
            }
             if(flag)
             return i;
        }
      return -1;  
    }
    public static int lengthOfLastWord(String s) {
        if(s==null||s.length()==0) return 0;
        //if(s.charAt(s.length()-1)==' ') return 0;
        
        int res =0;
        s = s.trim();
        for(int i=s.length()-1;i>=0;i--){
           if(s.charAt(i)!=' '){
               res++;
           }
           else break;
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "mississippi"; String b= "issip";
		//System.out.println(strStr(a,b));
		System.out.println(lengthOfLastWord("a "));
	}

}
