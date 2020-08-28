import java.io.*;
import java.util.*;

public class SushiTest {

	//회전초밥 백준 15961, 2531
	//데큐를 사용해서 풀었는데 이래도 메모리를 20만이나 잡아먹는다
	//더 좋은 방법이 있을까?
	static int n,d,k,c;
	static int[] sushiAll;
	static int[] sushiChoice;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		sushiAll = new int[n];
		d = Integer.parseInt(st.nextToken()); //가짓수
		sushiChoice = new int[d+1];
		k = Integer.parseInt(st.nextToken()); //연속해서먹는접시의 수
		
		c = Integer.parseInt(st.nextToken()); 

		Deque<Integer> deque= new ArrayDeque<>();

		int cnt = 0;
		int result = 0;
		for(int i=0;i<n;i++) { //초밥 다 넣기
			sushiAll[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<k;i++) { //제일 처음 k번째까지 넣기, 그것을 초기 max값으로!(쿠폰은 밑에서 할 것)
			int num = sushiAll[i];
			
			if(sushiChoice[num] == 0) {
				
				cnt++;
			}
			sushiChoice[num]++;
			deque.addLast(num);
			
			result = Math.max(result, cnt);
		}
		
		for(int i=0;i<n-1;i++) { //맨 앞 꺼내고 맨 뒤 채우고
			int nowOutput = deque.pollFirst();
			sushiChoice[nowOutput]--;
			if((sushiChoice[nowOutput]) == 0) { //뺀 초밥이 0개가 되면 초밥종류의 개수 -1
				cnt--;
			}
			
			int nowInput = sushiAll[(i+k)%n];
			deque.addLast(nowInput);
			
			sushiChoice[nowInput]++;
			if((sushiChoice[nowInput])==1) { //더한 초밥이 1개가 되면 초밥종류의 개수 +1
				cnt++;
			}
			
			if(sushiChoice[c] == 0) { //회전초밥안에 쿠폰초밥이 있고없고는 상관이 없었다
				//k개를 고른상태에서 쿠폰초밥이 없으면 +1
				result = Math.max(result,cnt+1);
			} //있으면 +0 으로 max와 계속 비교, 진행
			else result = Math.max(result, cnt);
			
			
			
		}
		
		System.out.println(result);
		
	}

}
