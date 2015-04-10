package EPIC;

import java.util.ArrayList;
import java.util.List;

/*
Snake Sequence
You are given a grid of numbers. A snake sequence is made up of 
adjacent numbers such that for each number, 
the number on the right or the number below it is +1 or -1 its value. 
For example, 
1  3 2  6 8 
-9 7 1 -1 2
1  5 0  1 9 
In this grid, (3, 2, 1, 0, 1) is a snake sequence. 
Given a grid, find the longest snake sequences and their lengths 
(so there can be multiple snake sequences with the maximum length).
*/
public class SnakeSequence {
	public static void main(String[] args){
		int[][] mat = new int[][]{{4,3,2, 1,0},
								 {-9,7,3,-1,2},
								  {1,5,2, 0,9}};
		List<List<Integer>> res = findSnake(mat);
		System.out.println(res);
		System.out.println("The maximum length of snake sequences is: "+res.get(0).size());
	}


        public static List<List<Integer>> findSnake(int[][] mat){
        	List<List<Integer>> res = new ArrayList<List<Integer>>();
                int max=0;
                int count=0;
                List<Integer> path = null;
                for(int ii=0;ii<mat.length;ii++){
                        for(int jj=0;jj<mat[0].length;jj++){
                        		path= new ArrayList<Integer>();
                                max=helper(mat, res,path,ii, jj,1,count,max);
                                path= new ArrayList<Integer>();
                                max=helper(mat,res,path,ii,jj,2,count, max);
                        }
                }
                return res;
        }
        
        public static int helper(int[][] mat, List<List<Integer>> res, List<Integer> path, int r, int c, int type, int count, int max){
                int rows = mat.length-1;
                int cols = mat[0].length-1;
                path.add(mat[r][c]);
          
                if((r==rows&&type==1)||(c==cols&&type==2)){
                        if(count==max){             
                                res.add(new ArrayList(path));
                        }else if(count>max){
                                max=count;
                                res.clear();                             
                                res.add(new ArrayList(path));
                        }
                        return max;
                }
                if(type==1){//go to below
                        if(Math.abs(mat[r][c]-mat[r+1][c])!=1) return max;
                        else{
                                max=helper(mat, res, path, r+1, c, 1, count+1, max);
                                path.remove(path.size()-1);
                                max=helper(mat, res, path, r+1, c, 2, count+1, max);
                                path.remove(path.size()-1);
                        }
                }else if(type==2){//go to right
                        if(Math.abs(mat[r][c]-mat[r][c+1])!=1) return max;
                        else{
                                max=helper(mat, res, path, r, c+1, 1, count+1, max);
                                path.remove(path.size()-1);
                                max=helper(mat, res, path, r, c+1, 2, count+1, max);
                                path.remove(path.size()-1);
                        }
                }
                return max;
        }
}
