import java.util.Arrays;


public class SumClosest {
    public static int threeSumClosest(int[] num, int target) {
        if(num==null || num.length<2) 
            return Integer.MIN_VALUE;
        Arrays.sort(num);
        
        int closest = num[0]+num[1]+num[2]-target;
        
        for(int i=0;i<num.length-2;i++){
            int cur = twoSumClosest(num,i+1,target);
            if(Math.abs(cur)<Math.abs(closest))
                closest = cur;
        }
        
        return closest+target;
        
    }
    private static int twoSumClosest(int[] num, int start, int target){
        int closest = num[start]+num[start+1]-target;
        int l=start;
        int r=num.length-1;
        while(l<r){
            if(num[l]+num[r]==target) return 0;
            int cur = num[l]+num[r]-target;
            if(Math.abs(cur)<Math.abs(closest))
                closest = cur;
            if(num[l]+num[r]<target)
                l++;
            else r--;
        }
        return closest;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,1,2};
		int res = threeSumClosest(a,0);
		System.out.println(res);
	}

}
