import java.util.*;

public class algo_1008_boj2942_apple {

	//퍼거슨과 사과
	//숫자가 크긴하지만 for문으로 찾아내서 몫을 구하자
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int g = sc.nextInt();
		
		int big = r>=g ? r : g;
		
		int cnt = 0;
		StringBuilder sb = new StringBuilder("");
		for(int i=1;i<=big;i++) {
			if(r%i == 0 && g%i == 0) {
				sb.append(i+" "+r/i+" "+g/i+"\n");
			}	
		}
		System.out.println(sb);
	}
}
