import java.io.*;
import java.util.*;
public class algo_0913_boj1927_priorqueueTest {

	//백준 1927 최소힙
	//우선순위큐를 만들고 삽입 출력을 하자 간단함
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(pq.isEmpty())
					sb.append(0+"\n");
				else sb.append(pq.poll()+"\n");
			}
			else pq.add(num);
		}
		
		System.out.println(sb);
	}

}
