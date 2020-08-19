/**
 * @author sewonKim
 * 완전 탐색 for 0 ~ n-2
 * 1. (다음 블록 - 현재 블록)으로 변화가 올라가기인지 내려가기인지 판단
 * 2. 계산할 때마다 올라가기, 내려가기 난이도의 최댓값을 비교해서 저장 
 */
import java.util.*;
import java.io.*;

public class Solution {
	
	static int block[];
	static int up, down;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int TC=1; TC<=T; TC++){
			
			// input
			int n = Integer.parseInt(br.readLine());
			block = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<n; i++){
				block[i] = Integer.parseInt(st.nextToken());
			}
			
			// 탐색
			up = 0;
			down = 0;
			for(int i=0; i<n-1; i++){
				int diff = block[i+1]-block[i];
				if(diff < 0){	// 올라가기
					up = Math.max(up, Math.abs(diff));
				}
				else {	// 내려가기
					down = Math.max(down, diff);
				}
			}
			
			// output
			System.out.println("#"+TC+" "+down+" "+up);
		}
	}

}
