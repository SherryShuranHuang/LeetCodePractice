package EPIC;

import java.util.ArrayList;
import java.util.List;

/*
 Coin Change
Something cost $10.25 and the customer pays with a $20 bill, 
the program will print out the most efficient "change-breakdown" 
which is 1 five, 4 ones, and 3quarters. Find the minimum number 
of coins required to make change for a given sum 
(given unlimited number of N different denominations coin)
*/
public class CoinChange {

	
	public static void main(String[] args) {
		doTest();
	}
	public static void doTest(){
		double[] coins = {5.0, 1.0, 0.25, 0.1, 0.05, 0.01};
		double paid = 20;
		double cost = 10.5;
		List<Double> res = new ArrayList<Double>();
		res = coinChange(coins, paid , cost);
		System.out.println(res);
	}
	public static List<Double> coinChange(double[] coins, double paid, double cost){
		List<Double> res = new ArrayList<Double>();
		double target = paid-cost;
		if(target<=0) return res;
		coinChange(coins, target, 0,res);
		return res;
	}
	private static void coinChange(double[] coins, double target,int pos, List<Double> res){
		if(target==0) return;
		else if(target<0){
			res.remove(res.size()-1);
			res.add(coins[pos+1]);
			coinChange(coins,target+coins[pos]-coins[pos+1],pos+1,res);
		}else{
			res.add(coins[pos]);
			coinChange(coins,target-coins[pos],pos,res);
		}
	}
}
