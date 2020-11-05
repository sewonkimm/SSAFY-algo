package sliver;

import java.util.Scanner;

public class bj_7568_덩치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		int tc = sc.nextInt();
		int height[] = new int[tc];
		int weight[] = new int[tc];
		int rank[] = new int[tc] ;
		int temp = 1;
		
		for (int i = 0; i < tc; i++) {
			height[i]= sc.nextInt();
			weight[i] = sc.nextInt();
		}
		
		for (int i = 0; i < tc; i++) {
			for (int j = 0; j < tc; j++) {
				if(i!=j) {
					if(weight[i]<weight[j] && height[i]<height[j]) {
						temp++;
					}
				}
			}
			rank[i] = temp;
			temp = 1;
		}
		
		for (int i = 0; i < rank.length; i++) {
			System.out.print(rank[i]);
			if(i!=(rank.length-1))
			System.out.print(" ");
		}
		
	}
}
