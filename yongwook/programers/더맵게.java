package programers;

import java.util.PriorityQueue;

public class 더맵게 {
	public static void main(String[] args) {
		int scoville[] = {1,2,3,9,10,12};
		System.out.println(solution(scoville,7));
	}
	public static int solution(int[] scoville, int K) {
		int answer = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for (int i = 0; i < scoville.length; i++) {
				pq.add(scoville[i]);
		}
		int result = 0;
		while(true) {
			if(pq.peek()>=K) {
				break;
			}
			else if(pq.size()==1 && pq.peek()<K) {
				answer = -1;
				break;
			}
			
			else if(pq.peek() < K) {
				result = pq.poll()+(pq.poll()*2);
				pq.add(result);
				answer++;
			}
			
			
			
		}

		return answer;


	}
}
