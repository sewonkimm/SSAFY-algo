import java.util.Arrays;
import java.util.Scanner;

// 굳이 수열을 사용할 필요 없는 문제. 오름차순 한 방이면 해결.

public class Main {

	static int N;
	static int[] time;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		time = new int[N];	// i번째 사람이 돈을 인출하는 데 걸리는 시간 
		for(int i=0; i<N; i++) {
			time[i] = sc.nextInt();
		}
		
		Arrays.sort(time);
				
		int[] memo = new int[N];
		memo[0] = time[0];
		int sum = memo[0];
		
		for(int i=1; i<N; i++) {
			memo[i] = memo[i-1] + time[i];
			sum+= memo[i];
		}
	
		System.out.println(sum);
		sc.close();
	}

	
	
}
