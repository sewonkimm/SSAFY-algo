import java.util.*;

public class p4 {

	public static void main(String[] args) {
		boolean[][] map = new boolean[100][100];
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int a=x;a<x+10;a++) {
				for(int b=y;b<y+10;b++) {
					map[a][b] = true;
				}
			}
		}
		
		int cnt = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j] == true)
					cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}

}