package EPIC;
/*
Valid Password
In 1-9 keypad one key is not working. 
If someone enters a password then not working key will not be entered. 
You have been given expected password and entered password. 
Check that entered password is valid or not. Ex: entered 164, 
expected 18684 (you need to take care as when u enter18684 and 
164 only both will be taken as 164 input)
*/

public class ValidPassword {
	public static void main(String[] args){
		if (checkValidPW("1648", "18684")) {// I am not sure about this situation
			System.out.println("Valid!");
		} else {
			System.out.println("Failed!");
		}
	}
	public static boolean checkValidPW(String input, String expected){
		char faultKey='a';
		int i;
		int j;
		for(i=0,j=0;i<input.length()&&j<expected.length();i++,j++){
			if(input.charAt(i)==expected.charAt(j)){
				if(faultKey!='a'&& input.charAt(i)==faultKey)
					return false;
			}else{
				if(faultKey=='a')
					faultKey=expected.charAt(j);
				else{
					if(faultKey!=expected.charAt(j))
						return false;
				}
				i--; //----!
			}
				
		}
		while(j<expected.length()&&expected.charAt(j)==faultKey){
			j++;
		}
		return i==input.length()&&j==expected.length();
	}
}
