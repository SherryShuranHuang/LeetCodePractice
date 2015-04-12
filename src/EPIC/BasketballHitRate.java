package EPIC;

/*
Basketball Hit Rate
The hit rate of the basketball game is given by the number of 
hits divided by the number of chances. For example, you have 
73 chances but hit 15 times, then your hit rate is 15/73=0.205 
(keep the last3 digits). On average, you have 4.5 chances in each 
basketball game. Assume the total number of games is 162. 
Write a function for a basketball player. He will input the 
number of hits he has made, the number of chances he had, 
and the number of remaining games. The function should 
return the number of future hits, so that he can refresh his hit rate to 0.45
*/
		
public class BasketballHitRate {
	public static void main(String[] args){
		int h = 10;
		int c = 30;
		int r = 62;
		System.out.println(refresh(h, c, r));
		
	}
	public static double refresh(int hit, int chance, int remainG){
		double curHitRate = (double) hit/chance;

		double futureHits =  4.5*(0.45*162 - curHitRate*(162-remainG));
		
		int temp = (int) (futureHits*1000);
		futureHits = temp/1000.0;
		return futureHits;
		
	}
}
