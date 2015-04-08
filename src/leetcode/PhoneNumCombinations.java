package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PhoneNumCombinations {
    public static List<String> letterCombinations(String digits) {
        
        List<String> res = new ArrayList<String>();
        res.add("");
        if(digits==null||digits.length()==0) return res;
        
        HashMap<String, String> map = new HashMap<String,String>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        map.put("0","_");
        
        for(int i=0;i<digits.length();i++){
            String letters = map.get(Character.toString(digits.charAt(i)));
            ArrayList<String> newres=new ArrayList<String>();
            for(int j=0;j<res.size();j++){
                for(int k=0;k<letters.length();k++){
                    newres.add(res.get(j)+Character.toString(letters.charAt(k)));
                }
            }
            res = newres;
        } 
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "23";
		List<String> res = new ArrayList<String>();
		res = letterCombinations(input);
	}

}
