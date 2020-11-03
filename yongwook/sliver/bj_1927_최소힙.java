package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bj_1927_최소힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			
			int input =  Integer.parseInt(br.readLine());
			
			if(input == 0 ) {
				
				if(pq.isEmpty()) {
					sb.append(0);
					sb.append('\n');
				}else{
					sb.append(pq.poll());
					sb.append('\n');
				}
			}else {
				pq.add(input);
			}
			
		}
		System.out.println(sb);
	}
}
