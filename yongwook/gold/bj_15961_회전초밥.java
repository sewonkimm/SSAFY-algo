package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj_15961_회전초밥 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int chobab[] = new int[N];
		int visit[] = new int[d+1];
		int arr[] = new int[k];
		int cnt =  0;
		int max = 0;
		//초밥 배열받기
		for (int i = 0; i < N; i++) {			
			chobab[i] = Integer.parseInt(br.readLine());
		}		
		// ///////////////////////////////////////
		
		for (int i = 0; i <k+1 ; i++) {
			for (int j = 0; j < k; j++) {
				if(j+i<N) {
					arr[j] = chobab[j+i];
					if(visit[chobab[j+i]]==0) {
						visit[chobab[j+i]] =1;
						cnt++;
					}
				}
			}
			if(visit[c]==0)
				cnt += 1;
			
			else if(max< cnt)
				max = cnt;
			
			cnt=0;
			
			for (int j = 0; j < visit.length; j++) {
				visit[j]= 0;
			}
		}
		
		System.out.println(max);

	
	}
}
