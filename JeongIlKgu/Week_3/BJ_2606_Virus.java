/*
 * BJ 2606 바이러스
 * < 1. 배열을 이용한 BFS 풀이 >
 * 1) 네트워크 연결에 관련된 배열 생성
 * 2) 연결되어 있는 컴퓨터끼리 표시
 * 3) 1번부터 탐색하면서 연결되어 있는 컴퓨터는 enQueue
 * 4) isVisited배열을 통해 이미 방문한 컴퓨터는 enQueue X
 * 5) deQueue할 때마다 바이러스 걸리는 컴퓨터 수 + 1
 * ==============================================
 * < 2. Union-Find를 이용한 풀이 >
 * 1) 부모 배열을 만들고 Make, Find, Union 함수를 생성
 * 2) 연결되어 있는 네트워크를 읽어 들이면서 Union 함수 실행
 * 3) 마지막에 Find 연산을 통해 부모가 1인 컴퓨터를 모두 확인
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2606_Virus {

	// < 1. 배열을 이용한 BFS 풀이 >
	static boolean[][] network; // network 표시 배열
	static boolean[] isVisited; // 이미 방문한 컴퓨터 확인
	static int n, connect, result; // 컴퓨터 수, 연결 수, 바이러스에 걸린 컴퓨터 수
	
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(in.readLine());
		connect = Integer.parseInt(in.readLine());
		network = new boolean[n+1][n+1];
		isVisited = new boolean[n+1];
		for (int i = 0; i < connect; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 연결이 존재하는 것을 의미
			network[a][b] = network[b][a] = true;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		// 1번 컴퓨터가 웜 바이러스에 걸린 것이기 때문
		queue.offer(1);
		isVisited[1] = true;
		while(!queue.isEmpty()) {
			int virus = queue.poll(); // 연결된 네트워크를 검사할 컴퓨터
			for (int i = 1; i <= n; i++) {
				// 방문하지 않았고, 연결되어 있는 네트워크
				if(!isVisited[i] && network[virus][i]) {
					queue.offer(i);
					isVisited[i] = true;
					result++;
				}
			}
		}
		System.out.println(result);
	}
}



/*
7
6
1 2
2 3
1 5
5 2
5 6
4 7
 */