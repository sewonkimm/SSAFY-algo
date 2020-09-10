/*
 * BJ 11279 최대 힙
 * 내림차순을 갖는 우선순위 큐를 생성하여 
 */

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ_11279_MaxHeap {

	public static void main(String[] args) {
		// 내림차순 우선 순위 큐 생성
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			// 0이 입력으로 들어올 때, 최대값을 출력하는데
			// 이때, 우선 순위 큐가 비어 있다면 0을 출력
			if(a == 0) {
				if(pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.poll());
			}else { // 자연수인 경우, 무조건 push
				pq.offer(a);
			}
		}
		sc.close();
	}

}
