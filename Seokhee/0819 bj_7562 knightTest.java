package com.ssafy;
import java.util.*;

public class knightTest {
	//전형적인 bfs이면서 변형 8방탐색
	
	
	static int[][] map;
	
	//말의 동선에 따라서 8방탐색의 방향을 정해주자
	static int[] dx = {-1,-2,-2,-1, 1, 2, 2, 1};
	static int[] dy = {-2,-1, 1, 2, 2, 1,-1,-2};
	
	static int l,fx,fy,lx,ly;
	
	//횟수를 가진 move클래스
	public static class Move{
		int x;
		int y;
		int cnt;
		public Move(int x,int y,int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			l = sc.nextInt();
			map = new int[l][l];
			
			fx = sc.nextInt();
			fy = sc.nextInt();
			lx = sc.nextInt();
			ly = sc.nextInt();
			
			bfs(); //bfs실행
		}
	}
	static void bfs() {
		Queue<Move> queue = new LinkedList<>();
		queue.add(new Move(fx,fy,0));
		
		while(!queue.isEmpty()) {
			Move m = queue.poll();
			
			if(m.x == lx && m.y == ly) {
				queue.clear();
				System.out.println(m.cnt); 
				//어차피 목표지점에 도착했을때, bfs라서 사용한 턴이 최소값이므로 미련없이 출력
			}
			for(int i=0;i<8;i++) {
				int nx = m.x + dx[i];
				int ny = m.y + dy[i];
				
				//8방탐색, 시작점의 비용은 0이므로 값이 틀려질 위험이 있다고 판단.. 
				//(nx != fx || ny != fy) 를 통해 다시 시작점으로 돌아오는 것을 방지하자
				if((nx != fx || ny != fy) && nx>=0 && ny>=0 && nx<l && ny<l) {
					if(map[nx][ny] == 0) { //한번도 안갔다면 큐에 offer
						map[nx][ny] = m.cnt+1;
						queue.offer(new Move(nx,ny,m.cnt+1));
					}
					else if(map[nx][ny] > m.cnt+1) { //비용이 싸면 큐에 offer
						map[nx][ny] = m.cnt+1;
						queue.offer(new Move(nx,ny,m.cnt+1));
					}
				}
				
			}
		}
	}
}
