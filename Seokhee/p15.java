import java.io.*;
import java.util.*;

public class p15 {
	static int n,ans,accum;
	static int[][] dice;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dice = new int[n][6];
		StringTokenizer st;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			dice[i][0] = Integer.parseInt(st.nextToken());
			dice[i][1] = Integer.parseInt(st.nextToken());
			dice[i][2] = Integer.parseInt(st.nextToken());
			dice[i][4] = Integer.parseInt(st.nextToken());
			dice[i][5] = Integer.parseInt(st.nextToken());
			dice[i][3] = Integer.parseInt(st.nextToken());
		}

		
		for (int i = 0; i < 6; i++) {
			roll(0, dice[0][i]);
		}
			
		
		System.out.println(ans);
	}
	
	static void roll(int now_dice, int prev_val) {
		if (now_dice == n) {
			ans = Math.max(ans, accum);
			return;
		}
		for (int now_side = 0; now_side < 6; now_side++) {
			if (dice[now_dice][now_side] != prev_val) continue;
			int tmp = -1;
			for (int j = 0; j < 3; j++) {
				if (j == now_side || j + 3 == now_side) continue;
				tmp = Math.max(tmp, dice[now_dice][j]);
				tmp = Math.max(tmp, dice[now_dice][j + 3]);
			}
			accum += tmp;
			roll(now_dice + 1, dice[now_dice][(now_side + 3) % 6]);
			accum -= tmp;
		}
	}
}
