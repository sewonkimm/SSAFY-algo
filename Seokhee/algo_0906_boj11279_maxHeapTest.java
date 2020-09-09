import java.io.*;
import java.util.*;
public class algo_0906_boj11279_maxHeapTest {

	//백준 11279 최대힙
	//우선순위큐는 이미 자바 내에서 자료구조로 구현되어있으며 
	//reverseOrder() 사용시 컬렉션의 sort 등을 반대로 동작하게하거나 뒤집을 수 있다.
	
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	//최대힙
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int att = Integer.parseInt(br.readLine()); //시도횟수
		for(int i=0;i<att;i++) {
			int nowNum = Integer.parseInt(br.readLine());
			if(nowNum == 0) { //0일떄
				if(!pq.isEmpty()) //안 비었으면 poll해주자
					System.out.println(pq.poll());
				else System.out.println(0); //비었으면 0 출력
			}
			else pq.add(nowNum); //큐에 삽입
		}
	}

}
