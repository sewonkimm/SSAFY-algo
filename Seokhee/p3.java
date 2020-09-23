import java.io.*;
import java.util.*;
public class p3 {

	public static void main(String[] args) throws IOException {
		//5*5 빙고를 입력받고 한개씩 체크하면서 빙고 3개 완성하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] bingo = new int[5][5];
		boolean[][] bingo2 = new boolean[5][5];
		StringTokenizer st;
		for(int i=0;i<5;i++) { //빙고판
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		int bin = 0;
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				int n = Integer.parseInt(st.nextToken());
				cnt++;
				
				loop: //해당 숫자 체크해서 true
				for(int k=0;k<5;k++) {
					for(int l=0;l<5;l++) {
						if(bingo[k][l] == n) {
							bingo2[k][l] = true;
							break loop;
						}
					}
				}
				
				//check
				for(int a=0;a<5;a++) { //가로세로 5개
					if(bingo2[a][0] && bingo2[a][1] && bingo2[a][2] && bingo2[a][3] && bingo2[a][4])
						bin++;
					if(bingo2[0][a] && bingo2[1][a] && bingo2[2][a] && bingo2[3][a] && bingo2[4][a])
						bin++;
				}
				
				//대각 1
				if(bingo2[0][0] && bingo2[1][1] && bingo2[2][2] && bingo2[3][3] && bingo2[4][4])
					bin++;
				//대각 2
				if(bingo2[4][0] && bingo2[3][1] && bingo2[2][2] && bingo2[1][3] && bingo2[0][4])
					bin++;
				
				//이런식으로 체크하면 빙고가 3개 넘어설수도 있어서 부등호로 체크
				if(bin >= 3) {
					System.out.println(cnt);
					return;
				}

				bin = 0;
			}
		}
		
	}

}
