import java.util.*;
import java.io.*;

public class algo_1014_boj1002_turret {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			double d = Math.pow(x1-x2,2) + Math.pow(y1-y2,2);
			double sum = Math.pow(r1+r2, 2);
			double diff = Math.pow(r1-r2, 2);
			
			if(d == 0) { //두 점이 한 점일때
				if(r1 == r2) //반지름이 같으면 점이 무한대로 겹침 = -1
					System.out.println(-1);
				else System.out.println(0); //반지름이 다르면 절대 만날 수 없음 = 0
			}
			else {
				if(d == sum || d == diff) //두 반지름의 합과 점 사이의 거리가 같다면 한 점에서 만남 or 두 반지름의 차와 점 사이의 거리가 같다면 한 점에서 만남 = 1
					System.out.println(1);

				else if(diff<d && d<sum) //두 점에서 만나는 경우는 두 점사이의 거리보다 
					System.out.println(2);
				
				else System.out.println(0); //그 외 안 만남
			}
		}
	}
}
