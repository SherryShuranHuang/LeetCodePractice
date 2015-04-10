package EPIC;
/*
Replace String
From a given string, replace all instances 
of 'a' with 'one' and 'A' with 'ONE'.
Example Input: " A boy is playing in a garden"
Example Output: " ONE boy is playing in one garden"
-- Not that 'A' and 'a' are to be replaced only 
when they are single characters, not as part of another word.
*/
public class ReplaceString {
	public static void main(String[] args){
		String input =  " A boy is playing in a gArden";
		System.out.println(replaceString(input));
	}
	
	public static String replaceString(String str){
		StringBuilder res = new StringBuilder();
		if(str==null) return res.toString();
		str = " "+str+" ";// so that we do not need to consider the boundary case, costs some space though
		for(int i=1;i<str.length()-1;i++){
			char c = str.charAt(i);
			if(c=='a' && str.charAt(i-1)==' ' && str.charAt(i+1)==' '){
				res.append("one");
			}
			else if(c=='A' && str.charAt(i-1)==' ' && str.charAt(i+1)==' '){
				res.append("ONE");
			}		
			else res.append(c);	
		}
		String re = res.toString();
		return re.substring(1,re.length());// delete the space we added before
	}
}
