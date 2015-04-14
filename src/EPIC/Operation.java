package EPIC;

import java.util.Stack;


public class Operation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<String> OpStack = new Stack();
		Stack<Integer> NumStack = new Stack();
		int result = 0;
		System.out.println("Enter an expression with numbers and operators *-+");
		System.out.println("Operates left to right");
		String test ="3+4*6-9";

		StringBuffer sb = new StringBuffer(test);

		char[] chars = (sb.reverse()).toString().toCharArray();

		for(int i=0; i<chars.length ;i++)
		{
			if(chars[i]=='*' || chars[i]=='-' || chars[i]=='+')
			{
				OpStack.push(Character.toString(chars[i]));
			}

			else
			{
				NumStack.push(Integer.parseInt(Character.toString(chars[i])));
			}
		}

		while(!OpStack.isEmpty() )
		{
			String op = OpStack.pop();
			char c = op.charAt(0);

			int a = NumStack.pop();
			int b = NumStack.pop();

			if(c == '*')

				result = a*b;


			if(c== '+')

				result = (a+b);

			if(c == '-')

				result = (a-b); 

			NumStack.push(result);
		}
		System.out.println(result);
	}
}