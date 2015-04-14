package leetcode;

//�ϲ����ִ�������11222101Ӧ�úϲ�Ϊ 12101����һ�����ִ���������պϲ����
public class CompressNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compressNum(11221001));
	}
	
	public static int compressNum(int num){
		boolean neg = num<0;
		num = Math.abs(num);
		
		int digit = 0;
		int res = 0;
		int pre = -1;
		int div=1;
		while(num/10>=div){
			div*=10;
		}
		while(num>0){
			digit = num/div;
			if(digit!=pre){
				res = res*10+digit;
				pre = digit;
			}
			num = num%div;
			div/=10;
		}
		return res;
	}

}
