package sliver;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class bj_11279_최대힙 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 우선순위큐를 역으로 배열 
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		//입력받고
		int N = sc.nextInt();
		int input = 0;
		for (int i = 0; i < N; i++) {
			input= sc.nextInt();
			
			if(input==0) {
				if(!pq.isEmpty()) { //비어있지않으면 뺀다.
					System.out.println(pq.poll());
				}else {
					System.out.println(0);
				}
					
			}else {
				pq.add(input);
			}
		}
	}
	
}
