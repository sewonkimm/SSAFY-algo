/*
 * BJ 1922 네트워크 연결 
 * MST => make, find, union
 * Array를 활용 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1922_NetworkConnection {
	// 각 노드를 이어주는 Egde를 표현
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int weight;
		
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	static int[] parent; // 같은 부모를 갖는지 확인하기 위한 배
	static Edge[] edgeList;	
	static int V,E; // 정점과 간선 
	
	public static void main(String[] args) throws IOException {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		V = Integer.parseInt(in.readLine());
		E = Integer.parseInt(in.readLine());
		parent = new int[V+1];
		edgeList = new Edge[E];
		// Edge 등록 
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(start, end, weight);
		}
		// 가장 먼저, 오름차순으로 정렬한다.
		Arrays.sort(edgeList);
		make(); // 각 부모를 자기 자신으로 초기화 
		
		long result = 0; // 각 간선의 weight의 합
		int count = 0; // 연결된 간선의 수 
		
		for(Edge edge : edgeList){
			if( union(edge.start, edge.end) ){ // 싸이클이 발생하지 않았으면
				result += edge.weight;
				if(++count == V-1){ // 연결 간선수가 정점수-1이면 다 연결한 것임.
					break;
				}
			}
		}
		System.out.println(result);
	}

	public static void make() {
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}
	
	public static int find(int x) {
		if(parent[x] == x) return x; // 자신이 루트이면 자신의 번호 반환 
		return parent[x] = find(parent[x]);
	}
	
	public static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px != py){ // 두 노드의 root가 다르면 합침
			parent[py] = px;
			return true;
		}
		
		return false; // 두 x, y 가 포함된 집합을 합칠 수 없다.--> 이미 같은 집합이다 / cycle 이 존재한다.
	}
}
