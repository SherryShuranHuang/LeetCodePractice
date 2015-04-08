package leetcode;
import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class LargestNum {
	public static String largestNumber(int[] num) {
        //String res = null;
        if(num == null) return null;
        if(num.length ==1) return ""+num;
        String[] array = new String[num.length];
        for(int i=0; i<num.length;i++){
        	array[i] = num[i]+"";
        }
        
        Comparator<String> comp = new Comparator<String>(){
    		// comparator is an interface, 2 ways to use it:1) write a class to implement comparator class, and new an object of it
        	// as a parameter in Arrays.sort(array,comparator) method
        	//2)implement(override) the default method when initiating the comparator, just like the way used here
    		public int compare(String str1, String str2){
    			String s1 = str1+str2;
    			String s2 = str2+str1;
    			return s2.compareTo(s1);
    		}
    	};
        
        Arrays.sort(array,comp);
        StringBuffer str = new StringBuffer();
      for (int i = 0; i < array.length; i++) {
    	  str.append(array[i]);
      	//System.out.println(array[i]);
      }

        return str.toString();
    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(Integer.MIN_VALUE);
//		System.out.println(Double.MIN_VALUE);
		
		int[] A = {9,30,15,97};
		String str = largestNumber(A);
		System.out.println(str);
	     
	}
//Comparable interface: Class whose objects to be sorted must implement this interface.
//Comparator interface: Class whose objects to be sorted do not need to implement this interface.Some third class can implement this interface to sort.
}
