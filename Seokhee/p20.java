import java.io.*;
import java.util.*;
public class p20 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		
		int s;
		int num;
	
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<n;i++) {
			//4별 3동 2네 1세
			int[] a = new int[5];
			int[] b = new int[5];
			
			st = new StringTokenizer(br.readLine());
			
			s = Integer.parseInt(st.nextToken());
			for(int j=0;j<s;j++) {
				num = Integer.parseInt(st.nextToken());
				a[num] += 1;
			}
			
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			for(int j=0;j<s;j++) {
				num = Integer.parseInt(st.nextToken());
				b[num] += 1;
			}
			
			if(a[4]!=b[4]) {
				if(a[4]>b[4])
					sb.append("A\n");
				else sb.append("B\n");
			}
			else if(a[3] != b[3]) {
				if(a[3]>b[3])
					sb.append("A\n");
				else sb.append("B\n");
			}
			else if(a[2] != b[2]) {
				if(a[2]>b[2])
					sb.append("A\n");
				else sb.append("B\n");
			}
			else if(a[1] != b[1]) {
				if(a[1]>b[1])
					sb.append("A\n");
				else sb.append("B\n");
			}
			else sb.append("D\n");

		}
		
		System.out.println(sb);
	}

}
