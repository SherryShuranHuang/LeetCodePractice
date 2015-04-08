package leetcode;

public class Numberof1BitsUnsigned {
	public int hammingWeight( int n) {
        int res = 0;
        if(n==0) return 0;
        if(n>Integer.MAX_VALUE) return 1;
        else{
            res+= n&1;
            n=n>>1;
        }
        //return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
