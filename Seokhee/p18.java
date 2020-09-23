import java.util.*;
public class p18 {

	public static void main(String[] args) {
		int[][] map = new int[101][101];
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int a=x1;a<x1+x2;a++) {
				for(int b=y1;b<y1+y2;b++) {
					map[a][b] = i;
				}
			}
		}
		
		int[] pNum = new int[n+1];

		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				pNum[map[i][j]]++;
					
			}
		}
		
		for(int i=1;i<=n;i++) {
			System.out.println(pNum[i]);
		}

	}

}
