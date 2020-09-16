/*
 * 상근이의 여행
 * 1. BFS => 배열을 이용
 * 주어지는 나라-1개의 비행기로 모든 곳을 방문한다면 완료
 * 
 * 2. 사실 주어진 나라의 수(N)에서 1을 뺀 것이 해답이기 때문에 값을 읽고 그냥 N-1 출력해도 성공
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_9372_TravelOfSanggun {
	
	// 국가의 수, 비행기의 종류
	static int N, M;
//	static boolean[] isVisited;
//	static int[][] airplane;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 0; t < T; t++) {
			// 입력
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
//			isVisited = new boolean[N+1];
//			airplane = new int[N+1][N+1];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
//				int r = Integer.parseInt(st.nextToken());
//				int c = Integer.parseInt(st.nextToken());
//				airplane[r][c] = airplane[c][r] = 1;
			}
			
//			int answer = 0;
//			// BFS
//			Queue<Integer> q = new LinkedList<Integer>();
//			q.offer(1);
//			isVisited[1] = true;
//			
//			while(!q.isEmpty()) {
//				int n = q.poll();
//				answer++; // 나라의 개
//				
//				for (int i = 1; i <= N; i++) {
//					if(airplane[n][i] == 1 && !isVisited[i]) {
//						q.offer(i);
//						isVisited[i] = true;
//					}
//				}
//			}
			
//			System.out.println(answer-1);
			System.out.println(N-1);
		}
	}

}
