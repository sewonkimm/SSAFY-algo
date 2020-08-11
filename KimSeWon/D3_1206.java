import java.util.*;
import java.io.*;
	
public class Solution {
	
	static int[] dir = {-2, -1, 1, 2};

	public static void main(String[] args) throws IOException{
		//System.setIn(new FileInputStream("res/input.txt"));	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int T=1; T<=10; T++){
			// input
			int n = Integer.parseInt(br.readLine());
			int[] buildings = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<n; i++){
				buildings[i] = Integer.parseInt(st.nextToken());
			}
			
			// 완전 탐색
			int cnt = 0;
			for(int i=0; i<n; i++){
				
				boolean isView = true;
				int diff = 300;
				
				for(int k=0; k<4; k++){
					int cmp = i+dir[k];	// 탐색할 빌딩의 index
					if(cmp >=0 && cmp <n){
						if(buildings[i]-buildings[cmp] <= 0){
							isView = false;
							break;
						}
						
						diff = Math.min(diff, buildings[i]-buildings[cmp]);
					}
				}
				
				if(isView == false)	continue;
				else cnt += diff;
			}
			
			System.out.println("#"+T+" "+cnt);
		}		
	}

}
