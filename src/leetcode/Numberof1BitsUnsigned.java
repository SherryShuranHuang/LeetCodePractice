package leetcode;

public class Numberof1BitsUnsigned {
	public int hammingWeight( int n) {
        int res = 0;
        if(n==0) return 0;
        while(n!=0){
        	n = n&(n-1);////�൱�ڰѴӵ�λ����λ��ĵ�һ��1���0��ѭ���Ĵ�����1��0�Ĵ���������1�ĸ���
        	res++;
        }
        return res;
    }

}
