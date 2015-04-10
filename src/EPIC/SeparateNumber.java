package EPIC;
/*
Separate the number
Print the sequences from the input given by the user 
separated by semicolon 
e.g.: 4678912356012356 
output: 4;6789;123;56;0123;56;
*/

public class SeparateNumber {

	public static void main(String[] args){
		doTest();
	}
	public static String separateTheNumber(String num){
		StringBuilder res = new StringBuilder();
		for(int i=1;i<num.length();i++){
			res.append(num.charAt(i-1));
			if(num.charAt(i)!=num.charAt(i-1)+1)
				res.append(";");
		}
		res.append(num.charAt(num.length()-1));
		res.append(";");
		return res.toString();
	}
	public static void doTest(){
		String str =  new String("4678912356012356");
		System.out.println(separateTheNumber(str));
	}
}
