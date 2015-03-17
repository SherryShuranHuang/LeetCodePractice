package Tripadvisor;

public class CheckBinaryOnes {

	public static int checkBinaryOnes(int num){
		if(num==0) return 0;
		int res=0;
		
		while(num!=0){
			res+= num & 1;
			num = num >>1;
		}
		
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkBinaryOnes(-1));
	}

}
