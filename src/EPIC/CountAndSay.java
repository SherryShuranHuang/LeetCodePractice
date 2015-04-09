package EPIC;
/*
Count And Say
First, let user input a number, say 1. 
Then, the function will generate the next 10 numbers 
which satisfy this condition: 
1, 11,21,1211,111221,312211... 
explanation: first number 1, second number is one 1, so 11. 
Third number is two1(previous number), so 21. 
next number one 2 one 1, so 1211 and so on...
*/
public class CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateCountnSay(3));
	}
	
	public static String generateCountnSay(int n){
		String res = "1";
		if(n<=0) return "";
		int count = 1;
		StringBuilder sb = null;
		for(int i=1;i<n;i++){
			sb = new StringBuilder();
			count=1;
			for(int j=1;j<res.length();j++){
				if(res.charAt(j)==res.charAt(j-1)){
					count++;
				}else {
					sb.append(count);
					sb.append(res.charAt(j-1));
					count=1;
				}				
			}
			sb.append(count);
			sb.append(res.charAt(res.length()-1));
			res = sb.toString();
		}
		return res;
	}

}
