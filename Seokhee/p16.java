import java.io.*;
import java.util.*;
public class p16 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] bd = new int[1001];
		
		StringTokenizer st;
		int a1,a2;
		int max = 0;
		int maxNum = 0;
		int last = 0;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			a1 = Integer.parseInt(st.nextToken());
			a2 = Integer.parseInt(st.nextToken());
			
			bd[a1] = a2;
			if(max<a2) {
				maxNum = a1;
				max = a2;
			}
			if(last < a1)
				last = a1;
		}
		
		int area = 0;
		
		int maxLf = 0;
		for(int i=0;i<maxNum;i++) {
			if(maxLf<bd[i])
				maxLf = bd[i];
			area += maxLf * 1;
		}
		
		area += max * 1;
		
		maxLf = 0;
		for(int i=last;i>maxNum;i--) {
			if(maxLf<bd[i])
				maxLf = bd[i];
			area += maxLf * 1;
		}
		
		System.out.println(area);
	}

}
