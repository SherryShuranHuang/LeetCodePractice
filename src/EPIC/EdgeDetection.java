package EPIC;

import java.util.ArrayList;
import java.util.List;

/*
Edge Detection
Two-dimensional array representation of an image can also 
be represented by a one-dimensional array of W*H size, 
where W represent row and H represent column size and 
each cell represent pixel value of that image. You are 
also given a threshold X. For edge detection, you have 
to compute difference of a pixel value with each of its 
adjacent pixel and find maximum of all differences. 
And finally compare if that maximum difference is greater than 
threshold X. if so, then that pixel is an edge pixel and have to display it.
*/
public class EdgeDetection {
	public static void main(String[] args) {
		int[] img = {
				0, 1, 3, 0,
				1, 1, 5, 1,
				0, 0, 0, 0,
				0, 2, 0, 0
			};
			int width = 4;
			int threshold = 3;
			int count = 0;
			for (int a : processEdges(img, width, threshold)) {
				System.out.print(a + " ");
				if (++count % width == 0) {
					System.out.println();
				}
			}
	}
	
	public static int[] processEdges(int image[], int width, int threshold) {
		if(image == null || image.length == 0) {
			return null;
		}
		int[] res = image;
		int numRows = image.length / width;
		int xMin, xMax, yMin, yMax, index, value;
		for (int row = 0; row < numRows; row++) {
			int rowCount = row * width;
			for (int col = 0; col < width; col++) {
				index = rowCount + col;
				value = image[index];
				xMin = (col == 0) ? 0 : col - 1;
				xMax = (col == width - 1) ? col : col + 1;
				yMin = (row == 0) ? 0 : row - 1;
				yMax = (row == numRows - 1) ? row : row + 1;
				if (!exceed(image, width, xMin, xMax, yMin, yMax, threshold, value)) {
					res[index]=0;
				}
			}
		}	
		return res;
	}
	
	public static boolean exceed(int[] image, int width, 
								 int xMin, int xMax, int yMin, int yMax, 
								 int threshold, int value) {
		int diff = 0;
		for (int row = yMin; row <= yMax; row++) {
			for (int col = xMin; col <= xMax; col++) {
				int index = row * width + col;
				diff = Math.abs(value - image[index]);
				if (diff >= threshold) {
					return true;
				}
			}
		}
		return false;
	}
	
}
