/*
 * SWEA 1251 하나로
 * 우선적으로 각각 x, y좌표를 입력받고
 * 각 섬 사이의 해저터널 길이를 비교해서 간선으로 만들어준다.
 * 이후, 오름차순 정렬을 해주고 크루스칼 알고리즘을 적용해서 해결
 * Make, Find, Union 연산을 사용한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class D4_1251_HaNaRo {

	// 섬 사이를 이어주는 해저터널을 표현
	static class Edge implements Comparable<Edge>{
		int from, to;
		long weight;

		public Edge(int from, int to, long d) {
			this.from = from;
			this.to = to;
			this.weight = d;
		}
		// 조건을 명확하게 주지 않는다면 오류!
		@Override
		public int compareTo(Edge o) {
			if(this.weight > o.weight) return 1;
			else if(this.weight == o.weight) return 0;
			else if(this.weight < o.weight) return -1;
			return 0;
		}
	}
	static int T, N; // 테스트 케이스 개수, 섬의 개수
	static double E; // 환경 부담 세율
	static int[] x, y, parent; // x좌표, y좌표
	static ArrayList<Edge> edge = new ArrayList<Edge>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine().trim());
		for (int t = 1; t <= T; t++) {
			// 입력
			N =  Integer.parseInt(in.readLine().trim());
			x = new int[N];
			y = new int[N];
			parent = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(in.readLine().trim());
			
			// x, y좌표를 사용해서 해저터널의 길이 계산 + edge 추가
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i == j) continue;
					long len = getDistance(x[i],x[j],y[i],y[j]);
					edge.add(new Edge(i, j, len));
				}
			}
			// parent 배열 생성, 오름차순 정렬
			make();
			Collections.sort(edge);
			// 크루스칼 알고리즘 실행
			long answer = 0;
			int count = 0;
			for (Edge e : edge) {
				if(union(e.from, e.to)) {
					answer += e.weight;
					if(++count == N-1) break;
				}
			}
			System.out.println("#"+t+" "+Math.round(E*answer));
			edge.clear();
		}
	}
	
	private static long getDistance(int x1, int x2, int y1, int y2) {
		return (long) (Math.pow((x1-x2), 2) + Math.pow((y1-y2),2));
	}

	private static void make() {
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}
	
	private static int find(int v) {
		if(parent[v] == v) return v;
		else return parent[v] = find(parent[v]);
	}
	
	private static boolean union(int a, int b) {
		int na = find(a);
		int nb = find(b);
		
		if(na != nb) {
			parent[nb] = na;
			return true;
		}
		
		return false;
	}
}