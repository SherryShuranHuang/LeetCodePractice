package leetcode;

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {//≥¨ ±¡À
        if(divisor==0) return Integer.MAX_VALUE;
        if(dividend ==0||dividend<divisor) return 0;
        
        boolean negflag= false;
        if(dividend <0 || divisor<0){
            negflag = true;
            if(dividend <0&& divisor <0){
                negflag = false;
                if(dividend == Integer.MIN_VALUE && divisor == -1)
                    return Integer.MAX_VALUE;
            }
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
        int res=0;
        // count=0;
        while(dividend>=divisor){
            dividend-=divisor;
            res++;
        }
        
       return negflag?-res:res; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res = divide(Integer.MAX_VALUE,2);
		System.out.println(res);

	}

}
