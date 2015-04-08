package leetcode;

public class Numberof1BitsUnsigned {
	public int hammingWeight( int n) {
        int res = 0;
        if(n==0) return 0;
        while(n!=0){
        	n = n&(n-1);////相当于把从低位到高位起的第一个1变成0，循环的次数是1变0的次数，就是1的个数
        	res++;
        }
        return res;
    }

}
