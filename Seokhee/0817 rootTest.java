import java.util.*;
public class rootTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long n, answer, tmp;
		
		for(int t=1;t<=t;t++) {
			answer = 0;
			n = Long.parseLong(sc.next());
			
			while(true) {
				if(n==2) break;
				tmp = (long)Math.sqrt(n);
				
				if(tmp*tmp == n) 
					n = tmp;
				else {
					answer += (tmp+1)*(tmp+1) -n;
					n = tmp +1;
				}
				answer++;
			}
			System.out.println("#"+t+" "+answer);
		}
	}
}














