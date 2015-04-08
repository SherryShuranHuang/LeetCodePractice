package leetcode;

public class reverseWords {
//	public static String reverseWords(String s) {
//        if(s==null||s.length()==0) return "";
//        s=s.trim();
//        String[] list = s.split("\\s");
//        StringBuilder res = new StringBuilder();
//        for(int i=list.length-1;i>=0;i--){
//            if(i==0&&list[i]!=null){
//                res.append(list[i]);
//            }
//            else if(list[i]!=null)
//                res.append(list[i]);
//                res.append(" ");
//            }
//        
//        if(res.toString().trim().length()!=0)
//            return res.toString();
//        else return "";
//    }
	public static String reverseWords(String s) {  
	    s = s.trim();  
	    return helper(s,0).toString();  
	}  
	private static StringBuilder helper(String s, int index)  
	{  
	    if(index>=s.length())  
	        return new StringBuilder();   
	    StringBuilder cur = new StringBuilder();  
	    int lastIndex = index;  
	    while(index < s.length() && s.charAt(index)!=' ')  
	    {  
	        cur.append(s.charAt(index++));  
	    }  
	    while(index < s.length() && s.charAt(index)==' ')  
	        index++;  
	    if(lastIndex == 0)  
	        return helper(s,index).append(cur);  
	    return helper(s,index).append(cur).append(' ');  
	}  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="   b    a";
		String res= reverseWords(s);
	}

}
