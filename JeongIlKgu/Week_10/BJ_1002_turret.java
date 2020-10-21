/*
 * BJ 1002 터렛
 * => 점과 점사이의 거리, 반지름을 이용해서 푸는 문제
 * double과 int 비교 조심!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1002_turret {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 첫번째 원의 중심과 반지름
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			// 두번째 원의 중심과 반지름
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			// 계산
			int dist = (int)(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
			int diff = (int) Math.pow(r1+r2, 2);
			int diff2 = (int) Math.pow(r1-r2, 2);
			
			if(x1==x2 && y1==y2 && r1==r2) {
				System.out.println(-1);
			}else if(dist == diff2 || dist == diff) {
				System.out.println(1);
			}else if(dist < diff2 || dist > diff) {
				System.out.println(0);
			}else {
				System.out.println(2);
			}
		}
	}
}
