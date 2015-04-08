package EPIC;

import java.util.ArrayList;
import java.util.List;

//Desirable Number
//A number is called 'desirable' if all the digits are strictly ascending 
//eg: 159 as 1<5<9. You know that your rival has a strictly numeric password 
//that is 'desirable'. Your close ally has given you the number of digits (N)
//in your rival's password. takes in'N' as input and prints out 
//all possible 'desirable' numbers that can be formed with N digits.

public class DesirableNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesirableNumber test = new DesirableNumber();
		List<String> res = test.getDesiableNum(3);//recursive
		//List<String> res = test.getDesiableNum2(3);//iterative
		System.out.println(res);
		
	}
	//recursive
	public List<String> getDesiableNum(int N){
		List<String> res = new ArrayList<String>();
		if(N<1) return res;
		getDesiableNum(N,0,new StringBuilder(),res);
		return res;
	}
	
	private void getDesiableNum(int n, int start, StringBuilder item, List<String> res){
		if(n==0){
			res.add(new String(item));
			return;
		}
		for(int i=start;i<10;i++){
			item.append(i);
			getDesiableNum(n-1, i+1,item,res);
			item.deleteCharAt(item.length()-1);
		}
	}
	
	//iterative
	public List<String> getDesiableNum2(int N){
		List<String> res = new ArrayList<String>();
		if(N<1) return res;
		res.add("");
		for(int i=0;i<N;i++){
			List<String> item = new ArrayList<String>();
			for(String s: res){
				if(s.length()==0){//when the res list is empty
					for(char c = '0';c<='9';c++)
						item.add(s+c);
				}else{
					char last = s.charAt(s.length()-1);
					for(char c =(char)(last+1);c<='9';c++)
						item.add(s+c);
				}
			}
			res = item;
		}
		return res;
	}

}
