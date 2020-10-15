import java.util.*;
import java.io.*;
public class algo_1007_boj12763_noLate {

	//백준 12763 지각하면 안돼
	//시간이 우선으로 적용이 되어야한다...?
	//돈이 더 들더라도 시간이 오바되면 안된다 ?
	static List<Point>[] list;
	static class Point implements Comparable<Point>{
		int nowBuilding;
		int nowTime;
		int nowMoney;
		public Point(int nowBuilding, int nowTime, int nowMoney) {
			super();
			this.nowBuilding = nowBuilding;
			this.nowTime = nowTime;
			this.nowMoney = nowMoney;
		}
		//시간이 먼저 그다음 돈, 여기가 젤 중요. 여기 제외하면 다 일반 다익스트라랑 같음
		@Override
		public int compareTo(Point o) {
			if(this.nowTime < o.nowTime) {
				return -1;
			}
			else if(this.nowTime > o.nowTime) {
				return 1;
			}
			else {
				if(this.nowMoney < o.nowMoney) return -1;
				else if(this.nowMoney > o.nowMoney) return 1;
				else return 0;
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //건물 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken()); //시간 
		int m = Integer.parseInt(st.nextToken()); //돈
		int l = Integer.parseInt(br.readLine()); //길 개수
		
		int INF = Integer.MAX_VALUE;
		
		int[][] dist = new int[n][t+1]; //최소비용 저장
		
		list = new ArrayList[n];
		for(int i=0;i<n;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<l;i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken())-1; //a에서
			int n2 = Integer.parseInt(st.nextToken())-1; //b로
			int t1 = Integer.parseInt(st.nextToken()); //시간
			int m1 = Integer.parseInt(st.nextToken()); //비용
			
			list[n1].add(new Point(n2, t1, m1));
			list[n2].add(new Point(n1, t1, m1));
		}
		
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		
		for(int i=0;i<n;i++) {
			Arrays.fill(dist[i], INF);
		}
		
		pq.add(new Point(0,0,0));
		dist[0][0] = 0;
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			if(dist[p.nowBuilding][p.nowTime] != p.nowMoney) continue;
			
			for(Point pp: list[p.nowBuilding]) { //foreach로 간단하게
				int nextTime = p.nowTime + pp.nowTime;
				
				if(nextTime <= t && p.nowMoney + pp.nowMoney <= m) {
					if(dist[pp.nowBuilding][nextTime] > pp.nowMoney + p.nowMoney) {
						dist[pp.nowBuilding][nextTime] = pp.nowMoney + p.nowMoney;
						
						pq.add(new Point(pp.nowBuilding, pp.nowTime+p.nowTime, dist[pp.nowBuilding][nextTime]));
					}
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<t+1;i++) {
			min = Math.min(dist[n-1][i], min);
		}
		if(min == Integer.MAX_VALUE)
			min = -1;
		
		System.out.println(min);
	}
}
