
public class reverseStr {
//    public int reverse(int x) {
//        int num=0;
//        if(x<0){
//            num = Math.abs(x); 
//        }
//            String str = Integer.toString(num);
//            //StringBuffer strb = null;
//            int head = 0;
//            int end = str.length()-1;
//            for(int i=0;i<end/2;i++){
//                int val = str.charAt(head);
//                str.charAt(head)=str.charAt(end);
//                str.charAt(end)=val;
//            }
//    
//    int result = Integer.valueOf(str);
//    return x<0?-result:result;
//    }
	
    public static int reverse(int x) {
        int num=x;
        if(num<0){
            num = Math.abs(x); 
        }
            String str = Integer.toString(num);
            //if(str == null) str = "0";
            StringBuffer strb = new StringBuffer();
            int length = str.length();
            for(int i=length-1;i>=0;i--){
            	char a = str.charAt(i);
                strb.append(a);
            }
    
    int result = Integer.valueOf(strb.toString());
    return x<0?-result:result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		num = reverse(num);
		System.out.println(num);
	}

}
