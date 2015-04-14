package leetcode;

//合并数字串，比如11222101应该合并为 12101。给一个数字串，输出最终合并结果
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
