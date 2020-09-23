import java.util.Scanner;

public class p11 {

	public static void main(String[] args) {
		boolean[][] map = new boolean[101][101];
		Scanner sc = new Scanner(System.in);

		
		for(int i=0;i<4;i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int a=x1;a<x2;a++) {
				for(int b=y1;b<y2;b++) {
					map[a][b] = true;
				}
			}
		}
		
		int cnt=0;
		
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				if(map[i][j] == true)
					cnt++;
					
			}
		}

		System.out.println(cnt);


	}	

}
