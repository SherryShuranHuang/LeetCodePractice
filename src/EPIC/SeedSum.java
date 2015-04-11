package EPIC;

import java.util.ArrayList;
import java.util.List;

/*
Seeds Sum
Find the seed of a number. 
Eg : 256 = 245+2+4+5, 245 is the seed of 256. 
Find all possible seed for a given number.

Seed ������  һ�㶼�ǿ�����С��ķ�Χ��  ����seed multiply ��һ����sqrt(N) �� N/2 ֮������� ��N>4)
���ڱ���� seed sum�� ������ô���������� N=seed+seedSum��seedSum��seed����λ�ϵ�����֮��
������ 2+4+5����ôseedSum���з�Χ��  ������λ�� seedSum <= 9+9+9=27��N=256Ϊ��, 
seedSum <= 27 ���� seed = N-seedSum  Ҳ����˵ seed >= 256-27=229
Ҳ����˵  229���µ����Ͳ��ÿ�����  ��Ϊ�����ܴﵽ256  int���ֻ��10λ  Ҳ����˵���ǿ��԰�iteration����������90����
*/

public class SeedSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findSeeds(256));
	}
	
	public static List<Integer> findSeeds(int num){
		List<Integer> seeds = new ArrayList<Integer>();
		if(num==0||num==1){
			seeds.add(num);
			return seeds;
		}
		String s = String.valueOf(num);
		int len = s.length();
		int range = 9*len;
		for(int i = num-range;i<=num;i++){
			int temp = i;
			int res = i;
			while(temp>0){
				res += temp%10;
				temp = temp/10;
			}
			if(res==num)
				seeds.add(i);
		}
		return seeds;
	}

}
