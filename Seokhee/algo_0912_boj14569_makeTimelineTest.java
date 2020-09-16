import java.io.*;
import java.util.*;
public class algo_0912_boj14569_makeTimelineTest {

	//백준 14569 시간표짜기
	//비트마스킹인데 50시간이라서 .. 64까지 가능한 long형 비트마스크를 활용해야겠다
	static int n,m;
	static long[] classTime;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		classTime = new long[n];
		
		int t;
			
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			t = Integer.parseInt(st.nextToken());
			for(int j=0;j<t;j++) {//long형 비트마스크 활용
				classTime[i] |= 1L<<Integer.parseInt(st.nextToken());
			}
		}
		
		long timeline = 0;
		int cnt;
		StringBuilder sb = new StringBuilder("");
		m = Integer.parseInt(br.readLine());
		
		for(int i=0;i<m;i++) {
			timeline = 0;
			st = new StringTokenizer(br.readLine()," ");
			t = Integer.parseInt(st.nextToken());
			
			for(int j=0;j<t;j++) { //long형 비트마스크 활용
				timeline |= 1L<<Integer.parseInt(st.nextToken());
			}
			cnt = 0;
			for(int j=0;j<n;j++) {
				if((classTime[j] & timeline) == classTime[j]) 
					//수업 시간만큼의 빈 시간이 존재한다면 cnt를 +1
					cnt++;
			}
			sb.append(cnt+"\n");
		}
		
		System.out.println(sb);
		
	}

}
