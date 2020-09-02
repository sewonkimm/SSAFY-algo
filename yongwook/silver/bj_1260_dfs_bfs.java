package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1260_dfs_bfs {
	
	static int N ,M, V;
	static int map[][];

	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		 V = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		//간선상태저장
		
		for (int i = 0; i < M; i++) {
			 st = new StringTokenizer(br.readLine());
			 int x = Integer.parseInt(st.nextToken());
			 int y = Integer.parseInt(st.nextToken());
			 
			 map[x][y] = 1;
		}
		
		dfs(V);
		System.out.println();
		  visit = new boolean[N+1]; //확인상태 초기화
		bfs();
	}
	
	
	public static void dfs(int i) {
		visit[i] = true ;
		System.out.print(i+" ");
		for (int j = 1; j <= N; j++) {
			if(map[i]
					[j] ==1 && visit[j] == false) {
				dfs(j);
			}
		}
	}
	public static void bfs() {
	    Queue<Integer> queue = new LinkedList<Integer>();
	    queue.offer(V); //시작점도 Queue에 넣어야 함	
	    visit[V] = true;
	    System.out.print(V + " ");
	    
	    //Queue가 빌 때까지 반복. 방문 정점은 확인, 출력 후 Queue에 넣어 순서대로 확인
	    while(!queue.isEmpty()) {
	      int temp = queue.poll();
	      
	      for(int j = 1; j <= N; j++) {
	        if(map[temp][j] == 1 && visit[j] == false) {
	          queue.offer(j);
	          visit[j] = true;
	          System.out.print(j + " ");
	        }
	      }
	    }
	  }
	}

/*
4 5 1
1 2
1 3
1 4
2 4
3 4
*/