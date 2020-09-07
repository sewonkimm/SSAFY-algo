import java.io.*;
import java.util.*;
public class algo_0907_boj14499_diceTest {

	//백준 14499번 주사위 굴리기 - 구현문제
	
	static int n,m,x,y,k;
	static int[][] map;
	static int[][] dice;
	static int[] dx = {0, 0, 0,-1, 1}; //1 2 3 4로 들어오므로 0번은 그냥 없는 셈으로 두자, 각자 방향에 맞게 설정
	static int[] dy = {0, 1,-1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m]; //4 2
		dice = new int[4][3];
		//  0          주사위를 위한 공간 12칸 중에서 저렇게 6칸만 쓸 것이다
		//0 0 0
		//  0  
		//  0  
		
		//0 2
		//3 4
		//5 6
		//7 8
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}		
		
		//동1 서2 북3 남4
		st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder("");
		//x y 0 0
		for(int i=0;i<k;i++) {
			int num = Integer.parseInt(st.nextToken());
			
			int nx = x+dx[num];
			int ny = y+dy[num];
			if(nx>=0 && ny>=0 && nx<n && ny<m) { //맵 밖으로 안나가면
				diceMove(num); //구른다
				if(map[x][y] == 0) {  //구른자리가 0이면
					map[x][y] = dice[1][1]; //다이스의 밑면을 복사해서 맵에 넘겨줌
				}
				else { //구른자리가 0이 아니면
					dice[1][1] = map[x][y]; //맵의 숫자를 다이스의 밑면에 복사
					map[x][y] = 0; //맵은 0으로 설정
				}
				if(i==k-1) sb.append(dice[3][1]); //횟수가 많아서 StringBuilder 사용
				else sb.append(dice[3][1]+"\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	private static void diceMove(int c) {
		int temp;
		
		switch(c) {
			case 1: //동 이동
				y++;
				temp = dice[1][0]; 
				dice[1][0] = dice[1][1];
				dice[1][1] = dice[1][2];
				dice[1][2] = dice[3][1];
				dice[3][1] = temp;
				break;
			case 2: //서 이동
				y--;
				temp = dice[1][2];
				dice[1][2] = dice[1][1];
				dice[1][1] = dice[1][0];
				dice[1][0] = dice[3][1];
				dice[3][1] = temp;
				break; 
			case 3: //북 이동
				x--;
				temp = dice[3][1];
				dice[3][1] = dice[2][1];
				dice[2][1] = dice[1][1];
				dice[1][1] = dice[0][1];
				dice[0][1] = temp;
				break;
			case 4: //남 이동
				x++;
				temp = dice[0][1];
				dice[0][1] = dice[1][1];
				dice[1][1] = dice[2][1];
				dice[2][1] = dice[3][1];
				dice[3][1] = temp;
				break;
			
		}
	}
	
}
