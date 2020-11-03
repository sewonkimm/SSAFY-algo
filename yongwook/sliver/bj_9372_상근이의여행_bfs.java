package sliver;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_9372_상근이의여행_bfs {
	static int country , airplane ,tc , result ;
	static int arr[][];
	static int visit[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		 tc = sc.nextInt();
	
		 
		for (int i = 0; i < tc; i++) {
			
			  country =  sc.nextInt();
			 airplane = sc.nextInt();
			 arr = new int[country+1][country+1];
			 result = 0;
			 visit = new int[country+1];
			for (int j = 0; j < airplane; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				arr[x][y] = arr[y][x]=1;
			}
			
			bfs(1);
			System.out.println(result);
		}
		
	}
	static void bfs(int x) {
		
		Queue<Integer> queue = new LinkedList<Integer>(); 
			
		queue.add(x);	
			
		
		visit[x] =1;
		while(!queue.isEmpty()) {
			int temp= queue.poll(); 
			
			for (int i = 1; i < country+1; i++) {
					if(arr[temp][i]==1 && visit[i] ==0) {
						queue.add(i);
						visit[i]=1;
						result++;
						
				}
			}
		}
	}
	
	
}


