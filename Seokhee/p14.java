import java.io.*;
import java.util.*;

public class p14 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int[] ww = new int[w];
		int[] hh = new int[h];
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			if(Integer.parseInt(st.nextToken()) == 1) {
				int a = Integer.parseInt(st.nextToken());
				for(int j=a;j<w;j++) {
					ww[j]++;
				}
			}
			else {
				int a = Integer.parseInt(st.nextToken());
				for(int j=a;j<h;j++) {
					hh[j]++;
				}
			}
		}

		
		int maxW = 0;
		int maxH = 0;
		
		int cnt = 0;
		for(int i=0;i<w;i++) {
			if(i==w-1) {
				if(maxW<cnt+1)
					maxW = cnt+1;
				cnt=0;
				break;
			}
			if(ww[i] == ww[i+1])
				cnt++;
			else {
				if(maxW<cnt+1)
					maxW = cnt+1;
				cnt=0;
			}
		}
		
		for(int i=0;i<h;i++) {
			if(i==h-1) {
				if(maxH<cnt+1)
					maxH = cnt+1;
				cnt=0;
				break;
			}
			if(hh[i] == hh[i+1])
				cnt++;
			else {
				if(maxH<cnt+1)
					maxH = cnt+1;
				cnt=0;
			}
		}
		
		System.out.println(maxH * maxW);
	}
}
