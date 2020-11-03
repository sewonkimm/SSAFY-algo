import java.util.*;
import java.io.*;

public class algo_1029_boj3190_snake {

	static int n; //보드크기
	static int k; //사과개수
	static int l;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};//상우하좌 D -> +1 / L -> -1
	static Deque<Snake> dq = new ArrayDeque<>(); 
	static List<Apple> apple;
	static List<Move> move;
	static int cnt;
	static int snakeSize;
	static class Snake{
		int x;
		int y;
		public Snake(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static class Apple{
		int x;
		int y;
		public Apple(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static class Move{
		int time;
		char dir;
		public Move(int time, char dir) {
			super();
			this.time = time;
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		apple = new ArrayList<>();
		StringTokenizer st;
		int ax,ay,mx;
		char my;
		
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			ax = Integer.parseInt(st.nextToken());
			ay = Integer.parseInt(st.nextToken());
			apple.add(new Apple(ax-1,ay-1));
		}
		
		l = Integer.parseInt(br.readLine());
		
		move = new ArrayList<>();
		
		for(int i=0;i<l;i++) {
			st = new StringTokenizer(br.readLine());
			mx = Integer.parseInt(st.nextToken());
			my = st.nextToken().charAt(0);
			move.add(new Move(mx,my));
		}
		
		dq.add(new Snake(0,0));
		cnt = 0;
		snakeSize = 1;
		snake(0,0,1);
	}
	
	static void snake(int x,int y,int dir) {
		cnt++;
		System.out.println(x+" "+y+" "+snakeSize);
		//머리
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		if(nx>=0 && ny>=0 && nx<n && ny<n) {
			Iterator<Snake> iter = dq.iterator();
			
			while(iter.hasNext()) {
				Snake s = iter.next();
				if(s.x == nx && s.y == ny) {
					System.out.println(cnt);
					return;
				}
			}
			
			for(int i=0;i<apple.size();i++) {
				if(apple.get(i).x == nx && apple.get(i).y == ny) {
					snakeSize++;
					dq.addFirst(new Snake(nx,ny));
					apple.remove(i);
					break;
				}
				if(i == apple.size()-1) {
					dq.addFirst(new Snake(nx,ny));
					dq.pollLast();
				}
			}
			
			for(int i=0;i<move.size();i++) {
				if(move.get(i).time == cnt) {
					if(move.get(i).dir == 'L') {
						dir = (dir+3)%4;
					}
					else if(move.get(i).dir == 'D') {
						dir = (dir+1)%4;
					}
					move.remove(i);
					break;
				}	
			}
			snake(nx,ny,dir);
		}
		else {
			System.out.println(cnt);
			return;
		}
	}
}
