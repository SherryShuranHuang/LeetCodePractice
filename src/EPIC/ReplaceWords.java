package EPIC;
/*
Replace Words
Given a string. Replace the words whose length>=4 and is even, 
with a space between the two equal halves of the word. 
Consider only alphabets for finding the evenness of the word 
I/P "A person can't walk in this street" 
O/P "A per son ca n't wa lk in th is str eet"
*/
public class ReplaceWords {
	
	public static void main(String[] args){
		System.out.println(replaceWords("A person can't walk in this street   "));
	}
	public static String replaceWords(String str){
		if(str==null||str.length()==0)
			return "";
		int i=0;
		StringBuilder res = new StringBuilder();
		int count=0;
		while(i<str.length()){
			int j=i;
			while(j<str.length()){
				if(str.charAt(j)!=' '){
					if((str.charAt(j) >= 'A' && str.charAt(j)<='Z')
					  ||(str.charAt(j) >='a' && str.charAt(j)<='z')){
					  count++;
					}
					j++;
					continue;
				}
				j++;
				break;
			}
			if(count >=4 && count%2==0){
				res.append(str.substring(i,i+count/2));
				res.append(" ");
				res.append(str.substring(i+count/2,j));
			}else{
				res.append(str.substring(i,j));
			}
			count=0;
			i=j;
		}
		return res.toString();
	}
}
