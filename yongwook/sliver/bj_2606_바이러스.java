package sliver;

import java.util.Scanner;

public class bj_2606_바이러스 {
	static int computer, couple,result;
	static int map[][];
	static boolean visit[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		 computer = sc.nextInt();
		 couple = sc.nextInt();
		
		 map= new int[computer+1][computer+1];
		 visit= new boolean[computer+1];
		for (int i = 0; i < couple; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			map[x][y] = map[y][x] = 1;
		} 
		
		dfs(1);
		System.out.println(result);
		
	}
	public static void dfs(int x) {
		visit[x] = true;
		
		for (int i = 1; i <= computer; i++) {
			if(map[x][i] == 1 && visit[i] == false) {
				result++;
				dfs(i);
			}
		}
	}
}
