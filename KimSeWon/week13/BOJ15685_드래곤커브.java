import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	/*
	 * 1. 90도 회전 (현재+1)%4
	 * 0 > 1
	 * 1 > 2
	 * 2 > 3
	 * 3 > 0
	 * 
	 * 2. 현재 세대 거꾸로 돌면서 90도 회전한 정보를 이어 붙인다
	 * 3. 입력받은 세대만큼 1, 2 반복
	 * 
	 * 사각형 꼭지점 탐색
	 * 4. 찾은 드래곤커브를 2차원 배열에 표시
	 * 5. 2차원 배열 탐색 (점마다 4꼭지점 탐색) (기준: 좌상단 꼭짓점임) 
	 * 
	 * */
	
	// x: col, y: row
	static boolean[][] map;
	static int[][] dir = { {1,0}, {0, -1}, {-1, 0} , {0, 1} };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		
		int[][] info = new int[N][4];	// 0: col , 1: row, 2:direction, 3:generation
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
			info[i][2] = Integer.parseInt(st.nextToken());
			info[i][3] = Integer.parseInt(st.nextToken());
		}
		
		// 드래곤 커브 만들기
		ArrayList<ArrayList<Integer> > list = new ArrayList<ArrayList<Integer> >(N); 
		map = new boolean[101][101];	// 드래곤커브를 2차원 배열에 표시할 것임
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<Integer>());
			list.get(i).add(info[i][2]);	// 시작점 추가
			map[info[i][0]][info[i][1]] = true;
			
			int x = info[i][0] + dir[info[i][2]][0];
			int y = info[i][1] + dir[info[i][2]][1];
			map[x][y] = true;
			
			for (int g = 0; g < info[i][3]; g++) {
				int size = list.get(i).size();	// 현재 세대 사이즈
				
				// 거꾸로 돌면서 정보 이어붙이기
				for (int idx = size-1; idx >= 0; idx--) {
					int newDir = (list.get(i).get(idx)+1)%4;
					list.get(i).add(newDir);
					
					// 드래곤 커브 좌표 표시
					x += dir[newDir][0];
					y += dir[newDir][1];
					map[x][y] = true;
					
				}
			}
		}
		
		int cnt = 0;
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				if(map[r][c] && check(r, c)) cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	private static boolean check(int r, int c) {
		// 기준: 좌상단 꼭짓점
		int[][] d = { {1, 0}, {0, 1}, {1,1} };
		for(int i=0; i<3; i++){
			int nr = r + d[i][0];
			int nc = c + d[i][1];
			
			if(!map[nr][nc]) return false;
		}
		
		return true;
	}

}
