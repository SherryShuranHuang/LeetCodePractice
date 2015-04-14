package EPIC;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		int[][] mat = new int[][]{{3,3,2, 1,0},
				{-9,7,3,-1,2},
				{1,5,2, 0,9}};
		findSnake(mat);
	}

	/**
	 * Using DP to find the max length and then used length map to back track all the sequences
	 * @param board
	 */
    public static void findSnake(int[][] board){
        int m = board.length, n = board[0].length;
        int[][] map = new int[m][n];
        int max = 1;
        Set<Integer[]> maxPoints = new HashSet<Integer[]>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map[i][j] = 1;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i>0 && Math.abs(board[i][j]-board[i-1][j])==1){
                    map[i][j] = Math.max(map[i][j],map[i-1][j]+1);
                }
                if(j>0 && Math.abs(board[i][j-1]-board[i][j])==1){
                    map[i][j] = Math.max(map[i][j],map[i][j-1]+1);
                }
                if(map[i][j] > max){
                	maxPoints.clear();
                	Integer[] point = {i,j};
                    maxPoints.add(point);   // store the points with maximum length
                }
                else if(map[i][j] == max){
                	Integer[] point = {i,j};
                    maxPoints.add(point);   // store the points with maximum length
                }
                max = Math.max(max,map[i][j]);
            }
        }
        //find all the sequences
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<String>();
        for(Integer[] point: maxPoints){
        	sb = new StringBuilder();
        	sb.append(board[point[0]][point[1]]);
            trace(res, board, point[0], point[1], max-1, sb);
        }
        System.out.println(res);
        System.out.println(max);
    }

    public static void trace(List<String> res, int[][] board, int x, int y, int len, StringBuilder sb){
        if(len==0){
            res.add(sb.reverse().toString());
            return;
        }
        
        if(y>=1 && Math.abs(board[x][y-1]-board[x][y]) == 1){ //leftward
            sb.append(board[x][y-1]);
            trace(res, board, x, y-1, len-1, new StringBuilder(sb)); //should always pass a new sb object
            sb.deleteCharAt(sb.length()-1);
        }
        if(x>=1 && Math.abs(board[x-1][y]-board[x][y]) == 1){//upward
            sb.append(board[x-1][y]);
            trace(res, board, x-1, y, len-1, new StringBuilder(sb));
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
