import java.util.*;
public class algo_0911_boj11866_joseTest {

	public static void main(String[] args) {
		//백준 11866 요세푸스 문제
		//원을 이루며 앉아있는 사람을 마치 큐에 담긴사람처럼 생각해서
		//맨 앞에서 꺼내서 맨 뒤에 넣어줌으로써 원처럼 활용
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			queue.add(i);
		}
		 
		StringBuilder sb = new StringBuilder("<");
		int cnt=0,a;
		
		while(true) {
			a = queue.poll();
			if(queue.isEmpty()) { //비었다면 = 마지막 원소를 poll했다면
				sb.append(a+">");
				System.out.println(sb.toString());
				return;
			}
			cnt++;
			if(cnt==k) { //해당할 시에 add안해줌, append
				sb.append(a+", ");
				cnt=0;
				continue;
			}
			queue.add(a);
		}
	}
}
