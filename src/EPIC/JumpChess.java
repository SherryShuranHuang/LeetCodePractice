package EPIC;
/*
Jump Chess
There¡¯s a N*N board, two players join the jump game. The chess could 
go vertically and horizontally. If the adjacent chess is opponent player¡¯s 
and the spot beside that is empty, then the chess could jump to that spot. 
One chess could not been jumped twice. Given the position of the spot 
on the board, write the program to count the longest length that chess could go.
*/

public class JumpChess {
	private static int[][] board = {
		{0, 1, 2, 0, 0},
		{0, 0, 0, 2, 0},
		{0, 0, 0, 0, 2},
		{0, 1, 0, 2, 0},
		{0, 0, 1, 0, 1}
	};
	private static int[][] len = new int[5][5];
	
	public static void main(String[] args) {
		System.out.println(logestPath(0,1));
	}
	
	public static int logestPath(int row, int col){
		if(row<0||row>board.length-1||col<0||col>board[0].length-1) return 0;
		// grid of size N*N which can have values 0,1,2
		//assume that the only way the chess can jump is to jump across opponent player
		int me = board[row][col];
		int oppo = me==1?2:1;
		boolean[][] jumped = new boolean[5][5];
		return  gogo(row, col, me, oppo,jumped);
	}
	
	public static int gogo (int i, int j, int me, int oppo, boolean[][] jumped) {
		if (i < 0 || i >= board.length || j < 0 || j >=board[0].length) {
			return 0;
		}
//		if (len[i][j] > 0) {
//			return len[i][j];
//		}
		// left
		int leftJump = 0;
		if (j - 2 >= 0 
		 && board[i][j - 2] == 0 && board[i][j - 1] ==oppo && !jumped[i][j - 2]) {
			jumped[i][j - 2] = true;
			leftJump = 1 + gogo(i, j - 2, me, oppo, jumped);
			jumped[i][j - 2] = false;
		}
		
		// right
		int rightJump = 0;
		if (j + 2 <= board[0].length - 1
		&& board[i][j + 2] == 0 && board[i][j + 1] ==oppo && !jumped[i][j + 2]) {
			jumped[i][j + 2] = true;
			rightJump = 1 + gogo(i, j + 2, me, oppo, jumped);
			jumped[i][j + 2] = false;
		}
		
		// up
		int upJump = 0;
		if (i - 2 >= 0
		&& board[i - 2][j] == 0 && board[i - 1][j] ==oppo && !jumped[i - 2][j]) {
			jumped[i - 2][j] = true;
			rightJump = 1 + gogo(i - 2, j, me, oppo, jumped);
			jumped[i - 2][j] = false;
		}
		
		// bot
		int botJump = 0;
		if (i + 2 <= board.length - 1
		&& board[i + 2][j] == 0 && board[i + 1][j] ==oppo && !jumped[i + 2][j]) {
			jumped[i + 2][j] = true;
			rightJump = 1 + gogo(i + 2, j, me, oppo, jumped);
			jumped[i + 2][j] = false;
			
		}
//		len[i][j] = Math.max(Math.max(leftJump, rightJump), Math.max(upJump, botJump));
//		return len[i][j];
		return Math.max(Math.max(leftJump, rightJump), Math.max(upJump, botJump));
	}
	
	
//	public static void doTests() {
//		int me = 1;
//		int oppo = 2;
//		int maxJump = 0;
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[0].length; j++) {
//				if (board[i][j] == me) {
//					maxJump = Math.max(maxJump, gogo(i, j, me, oppo,));
//				}
//			}
//		}
//		System.out.println(maxJump);
//	}
	
}
