import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class pipeTest {

	static int n;
	static int[][] map;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
		StringTokenizer st;
		String s;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//��ͷ� ������ 
		
		recursive(1,0,1);
		//1,-1,0 //���� ���� �밢�� 
		System.out.println(cnt);
	}
	static void recursive(int now, int nx, int ny) {
		if(nx == n-1 && ny == n-1) {
			cnt++;
			return;
		}
		//������ ����
		if(now == 1) { //���ι���
			if(ny+1<n) {
				if(map[nx][ny+1] != 1) {
					recursive(1,nx,ny+1);
				}
			}
			if(ny+1<n && nx+1<n) {
				if(map[nx+1][ny+1] != 1 && map[nx][ny+1] != 1 && map[nx+1][ny] != 1) {
					recursive(0,nx+1,ny+1);
				}
			}
		}
		else if(now == -1) { //���ι���
			if(nx+1<n) {
				if(map[nx+1][ny] != 1) {
					recursive(-1,nx+1,ny);
				}
			}
			if(ny+1<n && nx+1<n) {
				if(map[nx+1][ny+1] != 1 && map[nx][ny+1] != 1 && map[nx+1][ny] != 1) {
					recursive(0,nx+1,ny+1);
				}
			}
		}
		else if(now == 0) { //�밢������
			if(nx+1<n) {
				if(map[nx+1][ny] != 1) {
					recursive(-1,nx+1,ny);
				}
			}
			if(ny+1<n) {
				if(map[nx][ny+1] != 1) {
					recursive(1,nx,ny+1);
				}
			}
			if(ny+1<n && nx+1<n) {
				if(map[nx+1][ny+1] != 1 && map[nx][ny+1] != 1 && map[nx+1][ny] != 1) {
					recursive(0,nx+1,ny+1);
				}
			}
		}		
	}

}









