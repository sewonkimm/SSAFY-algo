import java.io.*;
import java.util.*;
public class nearShortestPathTest {
	//���ͽ�Ʈ�� .. �ѹ� ���ϰ� ����ġ �������� ����� �ٽ� ������
	//���ͽ�Ʈ��� class ���� �������迭�� ����
	static int N,M;
	static int start,end;
	static int INF = 0x3f3f3f3f; //����ū��
	static int dist[];
	static List<Integer>[] trace;
	static int[][] node;

	static class Element {
		int pos,dist;
		public Element(int pos,int dist) {
			super();
			this.pos = pos;
			this.dist = dist;
		}
	}
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] lines = br.readLine().split(" ");
			N = Integer.parseInt(lines[0]);
			M = Integer.parseInt(lines[1]);
			
			if(N == 0 && M == 0) {
				break;
			}
			lines = br.readLine().split(" ");
			start = Integer.parseInt(lines[0]);
			end = Integer.parseInt(lines[1]);
			
			dist = new int[N];
			node = new int[N][N];
			trace = new ArrayList[N];
			
			for(int i=0;i<N;i++) {
				dist[i] = INF;
				Arrays.fill(node[i], -1);
				trace[i] = new ArrayList<>();
			}
			for (int i = 0; i < M; i++) {
				lines = br.readLine().split(" ");
				node[Integer.parseInt(lines[0])][Integer.parseInt(lines[1])] = Integer.parseInt(lines[2]);
			}
			
			dijkstra();
			traceback();
			Arrays.fill(dist, INF);
			System.out.println(dijkstra()); //�ѹ���
		}
	}
	static int dijkstra() {
		PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparingInt(e1-> e1.pos));
		pq.offer(new Element(start,dist[start]=0));
		
		while(!pq.isEmpty()) {
			Element e = pq.poll();
			int curPos = e.pos;
			int curDist = e.dist;
			for(int next = 0; next <N;next++) {
				if(node[curPos][next] != -1 && curDist + node[curPos][next] <= dist[next]) {
					pq.offer(new Element(next, dist[next] = curDist + node[curPos][next]));
					trace[next].add(curPos);
				}
			}
			
			
		}
		return dist[end] >= INF? -1 : dist[end];
	}
	static void traceback() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(end);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(Integer pre : trace[cur]) {
				if(node[pre][cur] != -1 && dist[cur] == node[pre][cur] + dist[pre]) {
					q.offer(pre);
					node[pre][cur] = -1;
				}
			}
		}
	}
	
	
}
