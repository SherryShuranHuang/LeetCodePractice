package EPIC;
/*
Replace AEIOU
Replace a,e,i,o,u with A,E,I,O,U.
At most four eligible letters from the rear of the string are replaced.
The first three eligible letters in the string are always exempted from replacement.
*/

public class ReplaceAEIOU {
	public static void main(String[] args){
		System.out.println(replaceAEIOU("amemimokukikekakekikoaaa"));
	}
	
	public static String replaceAEIOU(String str){
		if(str==null||str.length()==0) return null;
		int count=0;
		int range = (int)'a'-'A';
		StringBuilder res = new StringBuilder();
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){	
				if(count<3 || count>6){
					res.append(c);
				}
				else{//if(count>=3 && count < 7 )
					res.append((char)(c-range));
				}
				count++;
			}
			else{
				res.append(c);
			}
		}
		return res.toString();
	}

}
