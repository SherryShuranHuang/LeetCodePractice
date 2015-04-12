package EPIC;
/*
Tic Tac Toe 
N*N matrix is given with input red or black. 
You can move horizontally, vertically or diagonally. 
If 3 consecutive same colors found, that color will 
get 1 point. So, if 4 red are vertically then point 
is 2. Find the winner.
*/

public class TicTacToe {
	public static void main(String[] args){
		char[][] matrix = { 
			{ 'r', 'r', 'r', 'b' }, 
			{ 'b', 'r', 'b', 'r' },
			{ 'b', 'r', 'r', 'b' }, 
			{ 'b', 'r', 'b', 'b' } 
		};

		if (checkPoints(matrix)) {
			System.out.println("Red wins!");
		} else {
			System.out.println("Black wins");
		}
	}
	/**
	 * return true if red wins
	 * @param board
	 * @return
	 */
	public static boolean checkPoints(char[][] board){
		if(board==null||board.length==0||board[0].length==0)
			return false;
			
		int countR = 0;
		int countB = 0;
		// Check horizontal
		for(int i = 0;i<board.length;i++){
			for(int j=0;j<board[0].length-2;j++){
				if(board[i][j]== board[i][j+1]&& board[i][j+1]== board[i][j+2])
					if(board[i][j]=='r') countR++;
					else countB++;
				
			}
		}
		// Check vertical
		for(int i = 0;i<board.length-2;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]== board[i+1][j]&& board[i+1][j]==board[i+2][j])
					if(board[i][j]=='r') countR++;
					else countB++;
				
			}
		}
		// From topLeft to downRight
		for(int i = 0;i<board.length-2;i++){
			for(int j=0;j<board[0].length-2;j++){
				if(board[i][j]==board[i+1][j+1]&& board[i+1][j+1]==board[i+2][j+2])
					if(board[i][j]=='r') countR++;
					else countB++;
				
			}
		}
		// From downLeft to topRight
		for(int i = board.length-1;i>1;i--){
			for(int j=0;j<board[0].length-2;j++){
				if(board[i][j]==board[i-1][j+1] &&board[i-1][j+1]== board[i-2][j+2])
					if(board[i][j]=='r') countR++;
					else countB++;
				
			}
		}
		return countR>countB;
		
	}

}
