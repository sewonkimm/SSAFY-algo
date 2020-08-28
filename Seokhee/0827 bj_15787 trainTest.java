import java.io.*;
import java.util.*;

public class trainTest {
	//< 스터디과제 >
	//백준 15787번 기차가 어둠을 헤치고 은하수를
	//비트마스킹문제 !
	//1 i x i번째 기차에 x번째 좌석에 사람 태우기
	//2 i x i번째 x좌석 사람 하차
	//3 i i번째 기차에 앉은사람들 한칸 씩 뒤로 20번째는 하차
	//4 i i번째 기차에 앉은 승객들은 모두 한칸씩 앞으로, 1번째 사람 하차
	static int n,m;
	static int[] train;
	static boolean[] trainPass;
	static int[] trainCopy;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		train = new int[n+1];
		trainCopy = new int[n+1];
		trainPass = new boolean[n+1];
		
		Arrays.fill(trainPass, true);
		int a,b,c;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = 0;
			if(st.hasMoreTokens())
				c = Integer.parseInt(st.nextToken());
			trainCommand(a,b,c);
		}
		passCheck();
		System.out.println(cnt);
	}
	static void trainCommand(int num, int tNum, int sNum) {
		switch(num) {
		//숫자가 크면 뒷자리!
			case 1: train[tNum] = train[tNum] | (1<<sNum-1); //1<<0 이 1번자리
			break;
			case 2: train[tNum] &= ~(1<<sNum-1); //이렇게 하면 해당 자리만 0으로 비워주기
			break;
			case 3: train[tNum] = (train[tNum]<<1) % (1<<20); //한자리씩 뒤로! + 20좌석위는 짤라주기
			break;
			case 4: train[tNum] = train[tNum]>>1; //한자리씩 앞으로
			break;			
		}	
	}
	static void passCheck() {
		for(int i=1;i<=n;i++) {
			for(int j=0;j<cnt;j++) {
				if(train[i] == trainCopy[j]) { //통과명단에 좌석이 같은 기차가 있으면 해당 기차패스를 false하고 해당 기차탐색 for문 종료 
					j=cnt; 
					trainPass[i] = false;
				}	
			}
			if(trainPass[i]==true) { //기차패스가 true일 경우 통과명단에 넣어주고 통과 기차수 올려주기
				trainCopy[cnt] = train[i];
				cnt++;
			}
		}
	}
}
