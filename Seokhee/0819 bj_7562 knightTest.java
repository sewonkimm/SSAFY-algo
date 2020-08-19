package com.ssafy;
import java.util.*;

public class knightTest {
	//�������� bfs�̸鼭 ���� 8��Ž��
	
	
	static int[][] map;
	
	//���� ������ ���� 8��Ž���� ������ ��������
	static int[] dx = {-1,-2,-2,-1, 1, 2, 2, 1};
	static int[] dy = {-2,-1, 1, 2, 2, 1,-1,-2};
	
	static int l,fx,fy,lx,ly;
	
	//Ƚ���� ���� moveŬ����
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
			
			bfs(); //bfs����
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
				//������ ��ǥ������ ����������, bfs�� ����� ���� �ּҰ��̹Ƿ� �̷þ��� ���
			}
			for(int i=0;i<8;i++) {
				int nx = m.x + dx[i];
				int ny = m.y + dy[i];
				
				//8��Ž��, �������� ����� 0�̹Ƿ� ���� Ʋ���� ������ �ִٰ� �Ǵ�.. 
				//(nx != fx || ny != fy) �� ���� �ٽ� ���������� ���ƿ��� ���� ��������
				if((nx != fx || ny != fy) && nx>=0 && ny>=0 && nx<l && ny<l) {
					if(map[nx][ny] == 0) { //�ѹ��� �Ȱ��ٸ� ť�� offer
						map[nx][ny] = m.cnt+1;
						queue.offer(new Move(nx,ny,m.cnt+1));
					}
					else if(map[nx][ny] > m.cnt+1) { //����� �θ� ť�� offer
						map[nx][ny] = m.cnt+1;
						queue.offer(new Move(nx,ny,m.cnt+1));
					}
				}
				
			}
		}
	}
}
