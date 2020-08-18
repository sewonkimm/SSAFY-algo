package com.ssafy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RestoreTest {

	//���μ���� �ſ� ����ϰ� ����˴ϴ�. 
	final static int MAX = Integer.MAX_VALUE;
	static int[][] map;
	static int[][][] checked; //��� �޲ٰ� �����ߴ°�? ���� ���� ó������ 0 , �����ϸ� 1
	
	static int[] dx = {-1,1,0,0}; //�����¿�
	static int[] dy = {0,0,-1,1};

	static int n; 
	static int min;
	
	//��ǥ�� ��Ƶ� Ŭ����, �켱����ť�� ������ �ٲ��ֱ����� implements Comparable
	static public class Point implements Comparable<Point>{
		int x;
		int y;
		int res; //�󸶳� ���� �޲ٸ鼭 x,y���� �����ߴ°�
		
		public Point(int x,int y,int res){
			this.x = x;
			this.y = y;
			this.res = res;
		}

		//res�� ���� ���Ľ��Ѽ� �ִ��� ���� �޲ٸ鼭 ������ �ֵ� �켱������ ť���� ������ �ֵ��� (�̹� ���̵��� ��������� ����� ��귮�� ���̱����ؼ�)
		@Override
		public int compareTo(Point o) {
			return this.res - o.res;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			n = Integer.parseInt(br.readLine());
			
			map = new int[n][n];
			checked = new int[n][n][1000];
			
			for(int i=0;i<n;i++) {
				String st = new String(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j] = st.charAt(j)-'0';
				}
			}

			//min�� �ִ�� ���� bfs����
			min = MAX;
			bfs();
			System.out.println("#"+t+" "+min);
		}
		
		
	}

	static void bfs() {
		//Queue<Point> queue = new LinkedList<Point>();	

		//�켱����ť�� �ϳ� �����մϴ� ���⿡ �� �༮���� restore�� ���� ������� �տ��� �ڵ����� �˴ϴ�(�켱����ť�� ���ļӵ��� ����Ʈ�� �ӵ��� �ſ� �����ϴ�)
		PriorityQueue<Point> queue = new PriorityQueue<Point>();
		queue.add(new Point(0,0,0));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			checked[p.x][p.y][p.res] = 1; //x�� y���� res��ŭ ���� �޲ٸ鼭 �Դ� �湮üũ 
			
			//System.out.println(p.x+" "+p.y+" "+p.res);
			
			if(p.x == n-1 && p.y == n-1) {
				if(min>p.res)   //�����Ʒ� ������ ������ min�� ��
					min = p.res;
			}
			else {
				for(int i=0;i<4;i++) {
					int nx = p.x+dx[i];
					int ny = p.y+dy[i]; //�������� �����¿� Ž��
					if(nx>=0 && ny>=0 && nx<n && ny<n) { //�������� �����¿� ����
						int restore = p.res + map[nx][ny]; //������ �� ������ �޲���� �� + ���� �޲� ��
						for(int j=restore;j>=0;j--) { //�̰ź��� ���޲ٰ� �� ���� ������ ���� �ִ�?
							if(checked[nx][ny][j] == 1) { //������ for�� ����
								j = -1;
							}
							if(j == 0) { //���ٸ� offer
								queue.offer(new Point(nx,ny,restore));
								checked[nx][ny][restore] = 1; //�ϰ� �ش��� �湮üũ 
							}
						}
					}
				}
			}
		}
	}
	
}
