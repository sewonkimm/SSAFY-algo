import java.util.*;
public class make3Test {
	//백준 1463번 실버3 1로만들기
	//3으로 나누거나 2로 나누거나 1을 빼서 가장 빨리 1만들기
	//dp(다익스트라 - 해당점에 더 싼 비용으로 왔으면 연산 중지)+bfs로 만들면 될듯?
	static int[] dp;
	static int n;
	static class Num{
		int num;
		int cnt;
		public Num(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new int[n];
		
		bfs();
		
	}
	
	static void bfs() {
		Queue<Num> queue = new LinkedList<>();
		queue.add(new Num(n,0));
		
		while(!queue.isEmpty()) { 
			Num n = queue.poll();
			if(n.num == 1) { //bfs이므로 제일 먼저 1에 온게 제일 빨리온거임
				queue.clear();
				System.out.println(n.cnt);
			}
			//3으로 나누어지면 (0제외)
			if(n.num%3==0 && n.num/3!=0) {
				if(dp[n.num/3] !=0 && dp[n.num/3]>n.cnt+1) //횟수 적게해서 왔으면 dp교체
					queue.offer(new Num(n.num/3,n.cnt+1));
				else if(dp[n.num/3] ==0) //한번도 안왔으면 확정 dp교체
					queue.offer(new Num(n.num/3,n.cnt+1));
			}
			//2으로 나누어지면 (0제외)
			if(n.num%2==0 && n.num/2!=0) {
				if(dp[n.num/2] !=0 && dp[n.num/2]>n.cnt+1)//횟수 적게해서 왔으면 dp교체
					queue.offer(new Num(n.num/2,n.cnt+1));
				else if(dp[n.num/2] ==0) //한번도 안왔으면 확정 dp교체
					queue.offer(new Num(n.num/2,n.cnt+1));
			}
			//-1해도 0이 안되면 
			if(n.num-1 != 0) {
				if(dp[n.num-1] !=0 && dp[n.num-1]>n.cnt+1) //횟수 적게해서 왔으면 dp교체
					queue.offer(new Num(n.num-1,n.cnt+1));
				else if(dp[n.num-1] ==0) //한번도 안왔으면 확정 dp교체
					queue.offer(new Num(n.num-1,n.cnt+1));
			}
		}
	}
}










