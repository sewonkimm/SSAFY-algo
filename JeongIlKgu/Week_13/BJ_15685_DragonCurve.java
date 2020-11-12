/*
 * BJ 15685 드래곤 커브
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_15685_DragonCurve {

	// 드래곤 커브의 개수, 드래곤 커브의 시작 점, 시작 방향, 세대
	static int N, x, y, d, g;
	// 100x100 격자
	static boolean[][] board = new boolean[101][101];
	// delta : 우, 상, 좌, 하
	static int[] dirR = {0,-1,0,1};
	static int[] dirC = {1,0,-1,0};
	static Stack<Integer> mainStack = new Stack<Integer>();
	static Stack<Integer> tempStack = new Stack<Integer>();
	static Queue<Integer> q = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken()); // col
			y = Integer.parseInt(st.nextToken()); // row
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			
			board[y][x] = true;
			curve(y,x);
			
			// mainStack 정리
			while(!mainStack.isEmpty()) mainStack.pop();
		}
		// 정사각형 개수 확인
		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(board[i][j] && board[i][j+1] 
						&& board[i+1][j] && board[i+1][j+1]) count++;
			}
		}
		System.out.println(count);
	}

	private static void curve(int row, int col) {
		// 최초 0세대 => 끝 점을 기준으로 넣는다.
		int r = row+dirR[d];
		int c = col+dirC[d];
		board[r][c] = true;
		mainStack.push(d);
		
		while(g != 0) {
			// 한 세대에 mainStack에 있는 모든 선을 기준으로 옮긴다.
			while(!mainStack.isEmpty()) {
				int dir = mainStack.pop();
				
				int nDir = (dir+1)%4;
				r += dirR[nDir];
				c += dirC[nDir];
				
				if(r<0 || c<0 || r>100 || c>100) continue;
				
				// 기존의 선은 stack으로
				tempStack.push(dir);
				// 신규로 생성되는 선은 queue로
				board[r][c] = true;
				q.offer(nDir);	
			}
			// 다시 mainStack으로 이동 => stack 먼저
			while(!tempStack.isEmpty()) mainStack.push(tempStack.pop());
			while(!q.isEmpty()) mainStack.push(q.poll());
				
			g--;
		}
	}
}