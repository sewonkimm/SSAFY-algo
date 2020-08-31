import java.io.*;
import java.util.*;
public class europeTravelTest {
	//백준 1185번 최소스패닝트리 문제
	//유럽여행
	//예시 4-5-4-2-3-2-1-2-4 를 확인하면 최소스패닝트리를 따라서 길을 2번씩 가고, 그 길로 연결된 도시에 2번씩 방문하게된다
	//추가로 시작점은 3번 방문하게된다 = 제일 싼 도시를 시작점으로 하자
	static int n;
	static int p;
	static int[] townCost; //도시에 들어갈 때 비용.
	static int[] parent;
	static Edge[] realCost; //(weight)진짜 비용 = 길*2 + 출발점도시 + 도착점도시
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
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		townCost = new int[n+1];
		parent = new int[n+1];
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=n;i++) {
			townCost[i] = Integer.parseInt(br.readLine());
			min = Math.min(min, townCost[i]);
		}
		int s,e,l;
		realCost = new Edge[p];
		
		for(int i=1;i<=p;i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());

			//(realCost.weight)진짜 비용 = 길*2 + 출발점도시 + 도착점도시
			realCost[i-1] = new Edge(s,e,2*l+townCost[s]+townCost[e]);
		}
		
		//진짜 비용으로 정렬 
		Arrays.sort(realCost, new Comparator<Edge>(){
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
        });

		makeSet(); //각 도시들의 부모를 자기자신으로 초기화
		
		int count = 0;
		long result = 0; 
		for(Edge edge : realCost) { //싸이클이 생기지 않으면서 최소인 도로를 다 선택해서 계속 더해준다
			if(union(edge.start,edge.end)) {
				result += edge.weight;
				count++;
				if(count == n-1) { //n-1개의 도로가 필요하므로 멈춤
					break;
				}
			}
		}
		result = result+min; //제일 저렴한 도시비용을 가진 곳을 시작점으로 한다, 3번 가야하므로
		System.out.println(result);
	}
	public static void makeSet() { //자기자신을 부모로
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}
	public static int findSet(int x){ //루트노드 찾기
		if(parent[x] == x) return x;// 자신이 루트이면 그냥 자신의 번호 리턴
		return parent[x] = findSet(parent[x]);
	}
	
	public static boolean union(int x, int y){ //루트노드가 다르면 합치기
		int px = findSet(x);
		int py = findSet(y);
		
		if(px != py){ // 두 노드의 root가 다르면 합침
			parent[py] = px;
			return true;
		}
		
		return false; // 두 x, y 가 포함된 집합을 합칠 수 없다.--> 이미 같은 집합이다 / cycle 이 존재한다.
	}	
}
