/*
 * BJ 2217 로프
 * 1) 오름차순 우선순위 큐에 넣어준다.
 * 2) 하나씩 빼면서 (그 수 X (우선 선위 큐 크기+1)) 의 최대값을 구한다.
 */

import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ_2217_Rope {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int max = Integer.MIN_VALUE;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			pq.offer(sc.nextInt());
		}
		// 병렬 연결에서의 중량 확인
		 while(!pq.isEmpty()) {
			 int temp = pq.poll()*(pq.size()+1);
			 if(max < temp) max = temp;
		 }
		
		 System.out.println(max);
		 sc.close();
	}

}
