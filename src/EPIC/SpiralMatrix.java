package EPIC;
/*
Spiral Matrix
Given a NXN matrix, starting from the upper right corner of the matrix 
start printing values in a counter-clockwise fashion. . 
E.g.: Consider N = 4 
Matrix= {a, b, c, d, 
         e, f, g, h, 
         i, j, k, l, 
         m, n, o, p} 
Your function should output: dcbaeimnoplhgfjk
*/

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] Matrix= {{'a', 'b', 'c', 'd','1'}, 
						{'e', 'f', 'g', 'h', '2'}, 
						{'i', 'j', 'k', 'l', '3'}, 
						{'m', 'n', 'o', 'p', '4'},
						{'5', '6', '7', '8', '9'}} ;
		printSpiralMatrix(Matrix);
	}
	public static void printSpiralMatrix(char[][] mat){
		if(mat==null||mat[0].length==0) return;
		int levelnum = mat.length/2;
		for(int level=0;level<levelnum;level++){
			for(int i=mat[0].length-level-1;i>level;i--)
				System.out.print(mat[level][i]);
			
			for(int i=level;i<mat.length-level-1;i++)
				System.out.print(mat[i][level]);
			
			for(int i=level;i<mat[0].length-level-1;i++)
				System.out.print(mat[mat.length-level-1][i]);
			
			for(int i= mat.length-level-1;i>level;i--)
				System.out.print(mat[i][mat[0].length-level-1]);
		}
		
		if(mat.length%2==1){
			System.out.println(mat[levelnum][levelnum]);
		}
		
	}

}
