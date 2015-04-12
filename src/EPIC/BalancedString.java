package EPIC;

import java.util.LinkedList;

/*
Balanced String
Given a string that has{},[],() and characters. 
Check if the string is balanced. 
E.g. {a[(b)]} is balanced. {a[(b])} is unbalanced.
*/

public class BalancedString {
	public static void main(String[] args){
		if(isBalanced("{a[(b)]}  "))
			System.out.println("yes");
		else
			System.out.println("nah");
		
		if(isBalanced("{a[(b])}  "))
			System.out.println("yes");
		else
			System.out.println("nah");
	
	}
	public static boolean isBalanced(String str){
		if(str.length()==0||str==null){
			throw new IllegalArgumentException("Input should not be null");
		}
		LinkedList<Character> stack = new LinkedList<Character>();
		
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			switch(c){
				case '(':
				case '{':
				case '[': stack.push(c);
						  break;
				case ')': if(stack.isEmpty()|| stack.pop()!='(')
								return false;
						  break;
				case '}': if(stack.isEmpty()|| stack.pop()!='{')
								return false;
						  break;
				case ']': if(stack.isEmpty()|| stack.pop()!='[')
								return false;
						  break;
				default:
					break;
		
			}
		}
		return true;
	}
}