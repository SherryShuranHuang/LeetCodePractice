package EPIC;
/*
 * SMS
	You are given a telephone keyboard
	0-0, 1-1, 2-ABC2, 3-DEF3, 4-GHI4, 5-JKL5, 6-MNO6,
	7-PQRS7, 8-TUV8, 9-WXYZ9, *-space, #-char separator 
	if you type "2", you will get 'A', that is "2"-'A', 
	"22"-'B' ,"222"-'C', "2222"-'2'
	However, the digits can repeated many times
	"22222"-you get 'A' again 
	You can use "#" to separate characters, for example
	"2#22", you get "AB". 
	However, you may also have consecutive different digits without separator:"23"-'AD'. 
	If you type "*", it means space.
	You a given a sequence of digits, translate it into a text message
*/

public class SMS {
	public static String[] keys = {"0","1","ABC2","DEF3","GHI4","JKL5",
									"MNO6","PQRS7","TUV8","WXYZ9"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(msg("222"));   // C
		System.out.println(msg("22222")); // A
		System.out.println(msg("23"));    // AD
		System.out.println(msg("2#22"));  // AB
		System.out.println(msg("22*22")); // B B
		System.out.println(msg("2b"));	  // Failed	
	}

	public static String msg(String str){
		if(str==null||str.length()==0) return "";
		int count = 0;
		StringBuilder res = new StringBuilder();
		
		for(int i=0;i<str.length();i++){
			count=0;
			char c = str.charAt(i);
			if(c=='#') {
				continue;
			}else if(c=='*') {
				res.append(" ");
				continue;
			}else if(c<='9'&&c>='0') {
				while(i+1<str.length() && str.charAt(i+1)==c){
					count++;
					i++;
				}
				count = count%keys[c-'0'].length();
				res.append(keys[c-'0'].charAt(count));
			} else {
				throw new IllegalArgumentException("Input should be"
						 + "1~9 or * or #.");
			}
		}
			
		return res.toString();
	}
//	private String getDigit(char c, int count){
//		String res = null;
//		switch(c){
//			case '0': return keys[0];
//			case '1': return keys[1];
//			case '2': return keys[2].charAt(count-1)+"";
//			case '3': return keys[3].charAt(count-1)+"";
//			case '4': return keys[4].charAt(count-1)+"";
//			case '5': return keys[5].charAt(count-1)+"";
//			case '6': return keys[6].charAt(count-1)+"";
//			case '7': return keys[7].charAt(count-1)+"";
//			case '8': return keys[8].charAt(count-1)+"";
//			case '9': return keys[9].charAt(count-1)+"";
//			case '*': return " ";
//			case '#': return "";
//			default:
//				break;			
//		}	
//		return res;
//	}
}
