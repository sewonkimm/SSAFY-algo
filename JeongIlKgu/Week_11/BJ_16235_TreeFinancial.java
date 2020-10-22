/*
 * BJ 16235 나무 재테크
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16235_TreeFinancial {
	
	static class tree implements Comparable<tree>{ // 나무의 정보
		int r, c, n;

		public tree(int r, int c, int n) {
			this.r = r;
			this.c = c;
			this.n = n;
		}

		@Override
		public int compareTo(tree o) {
			return this.n - o.n;
		}
	} 
	// delta
	static int[] dirR = {-1,-1,-1,0,0,1,1,1};
	static int[] dirC = {-1,0,1,-1,1,-1,0,1};
	static int[][] A, B; // S2D2가 저장하고 있는 양분, 현재 양분
	static int N, M, K; // 땅 크기, 나무 개수, 년 수
	static PriorityQueue<tree> pq = new PriorityQueue<tree>();
	static Queue<tree> q = new LinkedList<tree>();
	static Queue<tree> q2 = new LinkedList<tree>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());	
		
		A = new int[N+1][N+1];
		B = new int[N+1][N+1]; // 초기 양분은 5로 초기화
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				B[i][j] = 5;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			pq.offer(new tree(r, c, n));
		}
		
		while(K > 0) {
			// 1. 봄: 나무가 자신의 나이만큼 양분을 먹고 나이+1
			//    한 칸에 나무가 여러 그루라면 어린 나무부터 양분 섭취
			//    나이만큼 양분을 못 먹는다면 죽는다.
			while(!pq.isEmpty()) {
				tree t = pq.poll();
				if(t.n > B[t.r][t.c]) {
					q.offer(t);
				}else {
					B[t.r][t.c] -= (t.n++);
					q2.offer(t);
				}
			}
			while(!q2.isEmpty()) {
				pq.offer(q2.poll());
			}
			// 2. 여름 : 봄에 죽은 나무가 양분으로 변함. 나무의 나이/2가 양분으로 추가
			while(!q.isEmpty()) {
				tree t = q.poll();
				B[t.r][t.c] += (t.n/2); 
			}
			// 3. 가을 : 5의 배수의 나이를 갖는 나무는 번식한다. 인접한 8칸에 나이가 1인 나무 생성
			// 여름에 썼던 큐 재탕!
			while(!pq.isEmpty()) {
				tree t = pq.poll();
				if(t.n % 5 == 0) {
					for (int i = 0; i < 8; i++) {
						int nr = t.r + dirR[i];
						int nc = t.c + dirC[i];
						
						if(nr>=1 && nc>=1 && nr<=N && nc<=N) q.offer(new tree(nr, nc, 1));
					}
				}
				q.offer(t);
			}
			// 나무를 우선 순위 큐에 삽입
			while(!q.isEmpty()) {
				pq.offer(q.poll());
			}
			// 4. 겨울 : S2D2가 땅을 돌면서 양분을 추가한다. 추가되는 양분의 양은 A[r][c]이다.
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					B[i][j] += A[i][j];
				}
			}
			// 모든 계절이 지나면 1년 감소
			K--;
		}
		
		System.out.println(pq.size());
	}

}
