/*
    다익스트라 알고리즘
    - 집에서 X로 가는 최단거리, X에서 집으로 가는 최단거리를 구해서
    - 두 개의 합의 최댓값을 출력한다.
 */

import java.util.*;

public class BOJ1238_파티 {

	static public class Vertex implements Comparable<Vertex> {
		int no, totalDistance;

		public Vertex(int no, int totalDistance) {
			this.no = no;
			this.totalDistance = totalDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.totalDistance - o.totalDistance;
		}
	}

	static int N, M, X;
	static int[][] matrixToParty, matrixToHome;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		X = sc.nextInt(); // 시작점
		int student = Integer.MIN_VALUE; // 가장 오래 걸리는 학생의 소요시간

		matrixToParty = new int[N+1][N+1];
		matrixToHome = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			int s, e, w;
			s = sc.nextInt(); // start
			e = sc.nextInt(); // end
			w = sc.nextInt(); // weight
			
			matrixToParty[s][e] = w;
			matrixToHome[e][s] = w;
		}

		boolean[] visited = new boolean[N + 1];
		int[] distanceToHome = new int[N + 1]; // X부터 각자 마을로 가는 최단거리
		Arrays.fill(distanceToHome, Integer.MAX_VALUE);
		distanceToHome = dijkstra(X, distanceToHome, visited, matrixToHome);
		
		Arrays.fill(visited, false);
		int[] distanceToParty = new int[N + 1]; // 각자 마을에서 X로 가는 최단거리
		Arrays.fill(distanceToParty, Integer.MAX_VALUE);
		distanceToParty = dijkstra(X, distanceToParty, visited, matrixToParty);

		
		for (int i = 1; i <= N; i++) {
			student = Math.max(student, distanceToParty[i] + distanceToHome[i]);
		}

		System.out.println(student);
		sc.close();
	}

	private static int[] dijkstra(int start, int[] distance, boolean[] visited, int[][] matrix) {
		distance[start] = 0;
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		pq.offer(new Vertex(start, distance[start]));

		while (!pq.isEmpty()) {
			Vertex current = pq.poll();

			visited[current.no] = true; // 정점 방문

			// 현재 정점에 연결되어있는 모든 정점으로 가는 최소비용 갱신
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && matrix[current.no][i] != 0) {
					distance[i] = Math.min(distance[i], current.totalDistance + matrix[current.no][i]);
					pq.offer(new Vertex(i, distance[i]));
				}
			}
		}

		return distance;
	}

}
