package EPIC;

import java.util.ArrayList;
import java.util.List;

/*
Matrix Position
Given an NxN matrix with unique integers: 
Find and print positions of all numbers such that 
it is the biggest in its row and also the smallest 
in its column . e.g. : In 3 x 3 with elements
1 2 3 
4 5 6 
7 8 9 
the number is 3 and position (1,3)
 */
public class MatrixPosition {
//	public class Pair<K,V>{
//		K row;
//		V col;
//		public Pair(K i, V j){
//			row = i;
//			col = j;
//		}
//	}
	public static void main(String[] args){
		int[][] board = {{1,20,3},
						{4,14,11},
						{7,15,10}
		};
		System.out.println(findElement(board).get(0)[0]+"," + findElement(board).get(0)[1]);
	}

	public static List<Integer[]> findElement(int[][] board){
		if(board==null||board.length==0||board[0].length==0)
			return null;

		List<Integer[]> res = new ArrayList<Integer[]>();

		for(int i=0;i<board.length;i++){
			int max = -1;
			Integer[] pos = new Integer[2];
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]>max){
					max = board[i][j];
					pos[0]=i;
					pos[1]=j;
				}
			}
			if(isColMin(board,pos[0],pos[1])){
				res.add(pos); 
			}

		}
		return res;
	}

	private static boolean isColMin(int[][] board, int row, int col){
		int min= Integer.MAX_VALUE;
		int r=0;

		for(int i=0;i<board.length;i++){
			if(board[i][col]<min){
				min=board[i][col];
				r=i;
			}
		}
		return r==row;
	}
}
