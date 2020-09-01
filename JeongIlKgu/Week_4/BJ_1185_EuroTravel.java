/*
 * BJ 1185 유럽여행
 * N개의 정점에서 N-1개의 간선을 선택하는 문제 -> MST => Make, Find, Union을 사용해서 해결
 * 여기서 출발점은 이동하는 것에 비해 1번을 더 방문해야 하므로 도착비용이 가장 적은 나라를 선택
 * 단, 기존의 MST가 각 길의 가중치를 기준으로 오름차순 정렬했지만
 * 이 문제는 도착 비용이 발생하기 때문에 각 나라의 도착비용 + 길X2이 실제 발생 가중치이고
 * 이렇게 도출된 가중치를 기준으로 오름차순 정렬!
 * 이후 MST를 통해 각 가중치를 더하고 마지막에 출발 나라의 도착비용만 더해주면 끝!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_1185_EuroTravel {
	
	static class Edge implements Comparable<Edge>{
		int s, e, w; // 출발 Vertex, 도착 Vertex, 가중치

		// 저장할 때, 가중치 = 출발 나라 도착비용 + 도착 나라 도착비용 + 가중치*2
		public Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	static int N, P, answer; // 방문할 나라의 수, 나라 사이를 연결할 길의 수, 최단거리
	static int S, E, L; // 각 방문 나라 번호, 길의 비용
	static int[] country; // 나라 도착비용
	static int[] parent; // MST에서 사용될 부모를 저장하는 배열
	static ArrayList<Edge> fee; // 가중치를 다시 계산한 비용을 저장하는 배열

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		country = new int[N+1];
		parent = new int[N+1];
		int min = Integer.MAX_VALUE;
		// 나라 도착비용 입력
		for (int i = 1; i <= N; i++) {
			country[i] = Integer.parseInt(in.readLine());
			// 가장 적은 도착비용을 가진 나라 구하기
			if(min > country[i]) min = country[i];
		}
		// 비용 계산
		fee = new ArrayList<Edge>();
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			fee.add(new Edge(S, E, country[S]+country[E]+L*2));
		}
		// 오름차순 정렬
		Collections.sort(fee);
		make(); // 부모를 자기 자신으로 하는 배열 생성
		
		int edgeCount = 0; // 연결된 길의 수
		
		for (Edge edge : fee) {
			if(union(edge.s, edge.e)) {
				answer += edge.w;
				// 연결 끝!
				if(++edgeCount == N-1) break;
			}
		}
		
		answer += min;
		System.out.println(answer);
		
	}

	private static void make() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	private static int find(int a) {
		// 자신이 최상위라면, 자신의 번호 그대로 return
		if(parent[a] == a) return a;
		else return parent[a] = find(parent[a]);
	}
	
	private static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		// 부모가 다르다면 하나의 부모로 합쳐준다. => Cycle이 생기지 않도록 만들어줌
		if(pa != pb) {
			parent[pb] = pa;
			return true;
		}
		// 이미 Cycle이 존재하는 경우
		return false;
	}
}
