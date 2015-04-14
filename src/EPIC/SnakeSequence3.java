package EPIC;
/** 
 * if only the maximum length is needed
 * 
 */
public class SnakeSequence3 {

	public static void main(String[] args) {
		int[][] matrix1 = {
				{1, 3, 2, 6, 8},
			    {-9, 7, 1, -1, 2},
			    {1, 5, 0, 1, 9}	
		};
		int[][] matrix2 = {
				{1, 1, 2, 3, 1}, 
				{1, 1, 3, 4, 5},
				{1, 1, 4, 1, 6}
		};
		System.out.println("The maximum length of snake sequences is: "+findSnake(matrix2));
//		SnakeSequence2 test = new SnakeSequence2();
//		System.out.println(test.findSnake(matrix2));
		
	}
	
	public static int findSnake(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int maxLen = 0;
		int[] dp = new int[matrix[0].length];
		for (int i = 0; i < matrix[0].length; i++) {
			dp[i] = 1;
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j <matrix[0].length; j++) {
				if (i > 0 && Math.abs(matrix[i - 1][j] - matrix[i][j]) == 1) {
					//dp[j] = dp[j] + 1;
					dp[j] = Math.max(dp[j],dp[j] + 1);
				}
				if (j > 0 && Math.abs(matrix[i][j - 1] - matrix[i][j]) == 1) {
					//dp[j] = dp[j-1] + 1; 
					dp[j] = Math.max(dp[j], dp[j-1] + 1); 
				}
				maxLen = Math.max(maxLen, dp[j]);
			}
		}
		return maxLen;
	}
}
