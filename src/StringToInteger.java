
public class StringToInteger {
//    public static int atoi(String str) {
//        if(str ==null) return 0;
//        int res = 0;
//        boolean posflag=false;
//        boolean negflag=false;
//        
//        StringBuffer subNum = new StringBuffer();
//        for(int i=0;i<str.length();i++){
//            if(str.charAt(i)=='+'){
//                posflag = true;
//            }
//            else if(str.charAt(i)=='-')
//                negflag = true;
//            else if((str.charAt(i)-'0'<=9) && (str.charAt(i)-'0'>=0 )){
//                do{
//                    subNum.append(str.charAt(i));
//                    i++;
//                }while(i<str.length() && (str.charAt(i)-'0'<=9) && (str.charAt(i)-'0'>=0 ));
//                
//                break;
//            }
//        }
//        String strNum= subNum.toString();
//        int len = strNum.length();
//        //int div = Math.pow(10,len);
//        int digit = 0;
//        
//        for(int i=0;i<strNum.length();i++){
//        	digit = (int) strNum.charAt(i)-'0';
//        	if(digit<=Integer.MIN_VALUE*(-1) - res*10)
//        		res = res*10 + digit;
//        	else
//        		res = Integer.MIN_VALUE*(-1);
//        }
//        if(posflag && negflag) return 0;
//        else if(negflag) return -res;
//        else if(res == Integer.MIN_VALUE*(-1)) return res-1;
//        else return res;
////        for(int i=0;i<strNum.length();i++){
////            digit = (int) strNum.charAt(i)-'0';
////            res = res*10 + digit;
////        }
////    if(posflag && negflag) return res;
////    else if(negflag) return -res;
////    else return res;
//    }
	
    public static int atoi(String str) {
        if(str ==null || str.length()==0) return 0;
        int res = 0;
       // boolean posflag=false;
        boolean negflag=false;
        str = str.trim();
        
        int i = 0;
        if(str.charAt(0)=='+' || str.charAt(0)=='-'){
            i++;
            if(str.charAt(0)=='-')
                negflag = true;
        }
        
        while(i<str.length()){
            if((str.charAt(i)>'9') || (str.charAt(i)<'0' ))
                break;
            int digit = (int)(str.charAt(i)-'0');
            if(negflag && res>-((Integer.MIN_VALUE+digit)/10))
                return Integer.MIN_VALUE;
            else if(!negflag && res>(Integer.MAX_VALUE-digit)/10)
                return Integer.MAX_VALUE;
            res = res*10 + digit;
            i++;
        }  
        return negflag?-res:res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "+-1";
		System.out.println(atoi(str));
		String test = "c*a*b";
		System.out.println(test.length());
	}

}
