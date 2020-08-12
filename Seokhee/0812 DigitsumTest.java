import java.util.*;

public class DigitsumTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			String st = sc.next();
			int len = st.length();
			
			stt(st);
			System.out.println("#"+t+" "+sum);
			sum = 0;
		}
		
	}
	static int sum = 0;
	static void stt(String st) {
		int len = st.length();
		for(int i=0;i<len;i++) {
			sum += st.charAt(i)-'0';
		}
		if(sum>=10) {
			String st2 = Integer.toString(sum);
			sum = 0;
			stt(st2);
		}
	}
}
