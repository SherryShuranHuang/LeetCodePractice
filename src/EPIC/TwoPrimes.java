package EPIC;

import java.util.HashSet;
import java.util.Set;
/*
 * Two Primes
Goldbach's conjecture : Every even integer greater than 2 
can be expressed as the sum of two primes. Write a function 
which takes a number as input, verify if is an even number 
greater than 2 and also print at least one pair of prime numbers.
*/

public class TwoPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoPrimes test = new TwoPrimes();
		test.isValid(2);// 2? 4? 9? 
//		if(test.isPrime(27))
//			System.out.println("yes");
		//test.printPrimePair(658);
	}
	public void isValid(int num){
		if(num%2!=0){
			System.out.println("Not an even number");
			return;
		}
		for(int i=2;i<=num/2;i++){// we only need to go through the former half
			if(isPrime(i)&&isPrime(num-i)){
				System.out.println("For even number " + num + ", we have "
						+ "pair " + i + " and " + (num - i));
			}
		}
	}
	private boolean isPrime(int n){
		//if(n==2) return true;
		for(int i=2;i<=(int)Math.sqrt(n);i++){
			if(n%i==0)
				return false;
		}
		return true;
	}
	
	
	/**Solution 2
	 * create an array of prime numbers, initialize all true,
	 * then set the non-prime index's element to be false
	 * then add the true elements in to PrimeSet
	 * 
	 * @param no
	 */
	public void printPrimePair(int no){
		//find all the primes eratosthenes algo
		Boolean [] isPrime = new Boolean[no+1];
		for(int i=0;i<no;i++){
			isPrime[i]= true;
		}
		Set<Integer> primeSet = new HashSet<Integer>();
		for(int i=2;i*i<no;i++){
			if(isPrime[i]){
				for(int j=i;j*i<no;j++){
					isPrime[j*i] = false;
				}
			}
		}
		for(int i=2;i<no;i++){
			if(isPrime[i])
				primeSet.add(i);
		}
		
		for(Integer i:primeSet){
			if(i<=no/2 && primeSet.contains(no-i)){
				System.out.println("the pair :"+i+" "+(no-i));
				//break;  //break if only one pair is needed
			}
		}
	}

}
