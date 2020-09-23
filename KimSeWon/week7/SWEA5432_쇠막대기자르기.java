package week7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class SWEA5432_쇠막대기자르기 {

	public static void main(String[] args) throws 
	Exception {
		// input
		System.setIn(new FileInputStream("src/5432_input .txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int TC=1; TC<=T; TC++) {
			String str = br.readLine();
			int cnt = 0;
			int[] stick = new int[500000];
			int idx = 0;
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) == '(') {
					if(str.charAt(i+1) == ')') {	// 레이저
						for(int k=0; k<idx; k++) {	// 모든 막대기를 자른다
							stick[k]++;	
						}
						i++;	// 한칸 건너 뜀
					}
					else {	// 막대기 추가
						stick[idx++] = 1;
					}
				}
				else if(str.charAt(i) == ')'){
					cnt += stick[--idx];
				}
			}
			
			// output
			System.out.println("#"+TC+" "+cnt);
		}
	}

}
