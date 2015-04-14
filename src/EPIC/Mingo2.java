package EPIC;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mingo2 {

	public static void main(String[] args){
		initial();
		//mingo();
	}
	
	public static void initial(){
		Random rand = new Random();
		Random pos = new Random();
		int count=0;
		int[][] map = new int[10][10];
		List<Integer> res = new ArrayList<Integer>();
		
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++)
				map[i][j]=-1;
		}
		
		while(count<100){
			int value = rand.nextInt(1000);
			int row = pos.nextInt(10);
			int col = pos.nextInt(10);
			if(map[row][col]==-1){
				map[row][col]=value;
				count++;
			}
			else if(map[row][col]!=-1){
				continue;
			}
			if(count>=10)
				checkMingo(map, row, col, res);
		}
		
		System.out.println("Total :"+res.size()+" Mingos!");
		System.out.println("Mingo numbers: ");
		System.out.println(res);
		System.out.println("Map: ");
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if(map[i][j]<10){
					System.out.print(map[i][j]+"   ");
				}
				else if(map[i][j]<100){
					System.out.print(map[i][j]+"  ");
				}
				else if(map[i][j]<1000){
					System.out.print(map[i][j]+" ");
				}
			}
			System.out.println();
		}
	
	}
	public static void checkMingo(int[][] map, int row, int col, List<Integer> res){
		boolean isMingo = true;
		for(int i=0;i<10;i++){
			if(map[i][col]==-1||map[row][i]==-1){
				isMingo = false;
				break;
			}
		}
		
		boolean diagnalCheck = false;
		
		if(row == col){
			diagnalCheck = true;
			
			boolean isMingoD1 = true;
			int x = row, y=col;
			while(x<10 && y<10){
				if(map[x][y]==-1){
					isMingoD1 = false;
					break;
				}
				x++;y++;	
			}
			boolean isMingoD2=true;
			x = row; 
			y = col;
			while(isMingoD1 && x>=0 &&y>=0){
				if(map[x][y]==-1){
					isMingoD2 = false;
					break;
				}
				x--;y--;	
			}
		
			diagnalCheck = isMingoD1 && isMingoD2;
		}
		if(isMingo || diagnalCheck)
			res.add(map[row][col]);
	
	}

//	public static void mingo(){
//		Random rand = new Random();
//		Random pos = new Random();
//		int count = 0;
//		int[][] map = new int[10][10];
//		for(int i=0;i<10;i++){
//			for(int j=0;j<10;j++){
//				map[i][j] = -1;
//			}
//		}
//		List<Integer> res = new ArrayList<Integer>();
//		while(count<100){
//			int random = rand.nextInt(1000);
//			int row = pos.nextInt(10);
//			int col = pos.nextInt(10);
//			if(map[row][col] != -1){
//				continue;
//			}
//			if(map[row][col] == -1){
//				map[row][col] = random;
//				count++;
//			}
//			
//			//check if mingo
//			if(count>=10){
//				boolean ifMingo = true;
//				for(int i=0;i<10;i++){
//					if(map[row][i]==-1 || map[i][col] == -1){
//						ifMingo = false;
//					}
//				}
//				boolean diagnalCheck = false;
//				if(row == col){	
//					diagnalCheck = true;
//					int x=row, y=col;
//					boolean ifMingoD1 = true;
//					while(x>=0 && y>=0 && x<10 && y<10){
//						if(map[x][y] == -1){
//							ifMingoD1 = false;
//						}
//						x++;
//						y++;
//					}
//					x=row;
//					y=col;
//					boolean ifMingoD2 = true;
//					while(x>=0 && y>=0 && x<10 && y<10){
//						if(map[x][y] == -1){
//							ifMingoD2 = false;
//						}
//						x--;
//						y--;
//					}
//					diagnalCheck = ifMingoD1 && ifMingoD2;
//				}
//				if(ifMingo||diagnalCheck){
//					res.add(random);
//				}
//			}
//		}
//		
//		
//		System.out.println("Total :"+res.size()+" Mingos!");
//		System.out.println("Mingos: ");
//		System.out.println(res);
//		System.out.println("Map: ");
//		for(int i=0;i<10;i++){
//			for(int j=0;j<10;j++){
//				System.out.print(map[i][j]+",");
//			}
//			System.out.println();
//		}
//	}

}
