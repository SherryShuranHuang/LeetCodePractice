package leetcode;

public class intToRoman {
	 public String intToRoman(int num) {
	        if(num<1 || num>3999)  
	            return "";
	        int div = 1000;
	        int[] numarray = new int[4];
	        for(int i = 0; i<4;i++){
	            numarray[i]=num/div;
	            num = num%div;
	            div = div/10;
	        }
	        StringBuilder res = new StringBuilder();
	        res.append(convert(numarray[0],'M',' ',' '));
	        res.append(convert(numarray[1],'C','D','M'));
	        res.append(convert(numarray[2],'X','L','C'));
	        res.append(convert(numarray[3],'I','V','X'));
	        
	        return res.toString();
	    }
	    private String convert(int digit,char one, char five, char ten){
	        StringBuilder res = new StringBuilder();
	        switch(digit){
	            case 9:
	                res.append(one);
	                res.append(ten);
	                break;
	            case 8:
	            case 7:
	            case 6:
	            case 5:
	                res.append(five);
	                for(int i=0;i<digit;i++){
	                    res.append(one);
	                }
	                break;
	            case 3:
	            case 2:
	            case 1:
	                for(int i = 0;i<digit;i++){
	                    res.append(one);
	                }
	                break;
	            default:
	                break;
	        }
	        return res.toString();
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
