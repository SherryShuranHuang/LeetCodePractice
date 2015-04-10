package EPIC;
/*
Mountain Point
Given a M * N matrix, if the element in the matrix is 
larger than other 8 elements who stay around it, 
then named that element be mountain point. Print all the mountain points.
*/
public class MountainPoint {

	public static void main(String[] args) {
		
		int grid [][] = {
			{1,2,3,4,5,0},
			{2,100,2,6,0,3},
			{2,2,6,4,99,3},
			{7,4,3,4,4,3}
		};
		PrintMountainPoint(grid);
	}
	//Assumption: the points on the boundaries are not considered mountain points
	public static void PrintMountainPoint(int[][] matrix) {
		// start from the second element in the second row
		for (int i = 1; i < matrix.length - 1; i++) {
			for (int j = 1; j < matrix[0].length - 1; j++) {
				if (matrix[i][j] > matrix[i - 1][j - 1]
						&& matrix[i][j] > matrix[i - 1][j]
						&& matrix[i][j] > matrix[i - 1][j + 1]
						&& matrix[i][j] > matrix[i][j - 1]
						&& matrix[i][j] > matrix[i][j + 1]
						&& matrix[i][j] > matrix[i + 1][j - 1]
						&& matrix[i][j] > matrix[i + 1][j]
						&& matrix[i][j] > matrix[i + 1][j + 1]) {
					System.out.println("(" + i + "," + j + ")");
//					j++; // skip the next column
				}
			}
		}
	}

}
