import java.util.*;
public class make3Test {
	//���� 1463�� �ǹ�3 1�θ����
	//3���� �����ų� 2�� �����ų� 1�� ���� ���� ���� 1�����
	//dp(���ͽ�Ʈ�� - �ش����� �� �� ������� ������ ���� ����)+bfs�� ����� �ɵ�?
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
			if(n.num == 1) { //bfs�̹Ƿ� ���� ���� 1�� �°� ���� �����°���
				queue.clear();
				System.out.println(n.cnt);
			}
			//3���� ���������� (0����)
			if(n.num%3==0 && n.num/3!=0) {
				if(dp[n.num/3] !=0 && dp[n.num/3]>n.cnt+1) //Ƚ�� �����ؼ� ������ dp��ü
					queue.offer(new Num(n.num/3,n.cnt+1));
				else if(dp[n.num/3] ==0) //�ѹ��� �ȿ����� Ȯ�� dp��ü
					queue.offer(new Num(n.num/3,n.cnt+1));
			}
			//2���� ���������� (0����)
			if(n.num%2==0 && n.num/2!=0) {
				if(dp[n.num/2] !=0 && dp[n.num/2]>n.cnt+1)//Ƚ�� �����ؼ� ������ dp��ü
					queue.offer(new Num(n.num/2,n.cnt+1));
				else if(dp[n.num/2] ==0) //�ѹ��� �ȿ����� Ȯ�� dp��ü
					queue.offer(new Num(n.num/2,n.cnt+1));
			}
			//-1�ص� 0�� �ȵǸ� 
			if(n.num-1 != 0) {
				if(dp[n.num-1] !=0 && dp[n.num-1]>n.cnt+1) //Ƚ�� �����ؼ� ������ dp��ü
					queue.offer(new Num(n.num-1,n.cnt+1));
				else if(dp[n.num-1] ==0) //�ѹ��� �ȿ����� Ȯ�� dp��ü
					queue.offer(new Num(n.num-1,n.cnt+1));
			}
		}
	}
}










