import java.io.*;
import java.util.*;

public class algo_1022_boj16987_eggEgg {
	
	static int max;
	static int eggNum;
	static int count;
	static int[][] egg;
	
	//백준 계란으로 계란깨기 - 백트래킹
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		eggNum = Integer.parseInt(br.readLine());
		egg = new int[eggNum][2];
		StringTokenizer st;
		for(int i=0;i<eggNum;i++) {
			st = new StringTokenizer(br.readLine());
			egg[i][0] = Integer.parseInt(st.nextToken());
			egg[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		System.out.println(max);
	}
	//내구도 / 무게
	static void dfs(int nowNum) {
		if(nowNum == eggNum) { 
			if(max<count)
				max = count;
			return;
		}
			
		if(egg[nowNum][0]>0) {
			for(int i=0;i<eggNum;i++) {
				//count 복구용
				int flagEgg1 = 0;
				int flagEgg2 = 0;
				//계란 복구용
				int flagHit = 0;
				
				if(i != nowNum && egg[i][0]>0) {
					
					flagHit = 1;
					
					//계란 서로 내구도 감소
					egg[i][0] = egg[i][0] - egg[nowNum][1];
					egg[nowNum][0] = egg[nowNum][0] - egg[i][1];
					
					flagEgg1 = 0;
					flagEgg2 = 0;
					
					//couut 올려주기
					if(egg[nowNum][0]<=0) {
						flagEgg1 = 1;
						count++;
					}
					if(egg[i][0]<=0) {
						flagEgg2 = 1;
						count++;
					}
				}
				
				//이 부분 중요함, 안깨면 다음계란 집으면 안됨(무조건 넘어가는게 아니라 더 이상 칠게 없을때 넘어가는 거임)
				if(flagHit == 1 || i == eggNum-1) 
					dfs(nowNum+1);
				
				//flag 확인해서 복구
				if(flagHit == 1) {
					egg[i][0] = egg[i][0] + egg[nowNum][1];
					egg[nowNum][0] = egg[nowNum][0] + egg[i][1];
					if(flagEgg1 == 1) count--;
					if(flagEgg2 == 1) count--;
					flagEgg1 = 0;
					flagEgg2 = 0;
					flagHit = 0;
				}
			}
		}
		//지금 집은 계란이 깨진계란이면 넘어가기
		else dfs(nowNum+1);
	}
}
