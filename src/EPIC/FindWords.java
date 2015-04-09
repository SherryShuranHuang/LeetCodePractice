package EPIC;
/*
Finding Words
Write a program for a word search. If there is an NxN grid 
with one letter in each cell. Let the user enter a word and 
the letters of the word are said to be found in the grid either 
the letters match vertically, horizontally or diagonally in the grid. 
If the word is found, print the coordinates of the letters as output.
*/
public class FindWords {
	public static boolean wordSearch(String word, char[][] board){
		if(word==null||board==null||board.length==0||board[0].length==0) return false;
		if(word.length()==0) return true;
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]==word.charAt(0)){
					boolean res = findVertical(word,board,i+1,j,1)
								||findHorizontal(word,board,i,j+1,1)
								||findDiagnal(word,board,i+1,j+1,1);
					if(res){
						return true;
					}
				}
			}
		}
		return false;
	}
	private static boolean findVertical(String word, char[][] board,int i, int j, int index){
		if(index==word.length()) return true;
		if(i>=board.length ||j>=board[0].length || word.charAt(index)!= board[i][j])
			return false;
		return findVertical(word, board,i+1,j,index+1);
	}
	private static boolean findHorizontal(String word, char[][] board,int i, int j, int index){
		if(index==word.length()) return true;
		if(i>=board.length ||j>=board[0].length || word.charAt(index)!= board[i][j])
			return false;
		return findHorizontal(word, board,i,j+1,index+1);
	}
	private static boolean findDiagnal(String word, char[][] board,int i, int j, int index){
		if(index==word.length()) return true;
		if(i>=board.length ||j>=board[0].length || word.charAt(index)!= board[i][j])
			return false;
		return findDiagnal(word, board,i+1,j+1,index+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {
				{ 'a', 'b', 'c', 'd' }, 
				{ 'e', 'f', 'g', 'h' },
				{ 'i', 'j', 'k', 'l' }, 
				{ 'm', 'n', 'o', 'p' } 
			};
			
			if (wordSearch("bgl", board)) {
				System.out.println("Found!");
			} else {
				System.out.println("Failed!");
			}
	}

}
