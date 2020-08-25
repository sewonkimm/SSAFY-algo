import java.io.*;
import java.util.*;
public class lieTest {
	//백준 1043번 거짓말, 일단 감 안잡힘.
	//비트마스킹 필수로 사용해야만 하는가? 
	//풀고보니 이 문제는 그래프 문제였고 비트마스킹으로 접근하기위해서 1<<50까지의 경우를 생각해야했음.
	//30이상의 쉬프트를 하기위해선 1이라는 숫자 자체가 int형이므로 1L<<50의 형태로 쉬프트를 시켜주면 32이상의 쉬프트도 온전히 가능!!
	//구글링해도 비트마스킹으로 푼 사람이 아무도 없다.
	static int n;
	static int m;
	static int t;
	static long[] pArray;
	static long tArray;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //1~50
		m = Integer.parseInt(st.nextToken()); //1~50
		
		int cnt = m;
		
		st = new StringTokenizer(br.readLine());
		
		t = Integer.parseInt(st.nextToken());
		
		tArray = 0;
		int tInput;
		for(int i=0;i<t;i++) { //진실을 아는 자의 비트를 1로 만들어주자
			tInput = Integer.parseInt(st.nextToken());
			long a = (1L<<tInput); //long에 담고 | 연산하는 것을 구별하기 쉽게 2줄로 분리했음
			tArray = tArray | a;
		}

		pArray = new long[m]; //파티번호
		
		int tNum, nNum;
		for(int i=0;i<m;i++) { 
			//진실을 아는 자가 포함된 파티가 열리면 그 즉시 그 파티의 모든 인원이 진실을 아는 자가 되고
			//다시 처음부터 진실을 아는 자가 포함된 파티를 찾는다.
			st = new StringTokenizer(br.readLine());
			tNum = Integer.parseInt(st.nextToken());
			for(int j=0;j<tNum;j++) {
				nNum = Integer.parseInt(st.nextToken());
				long b = (1L<<nNum);
				pArray[i] = pArray[i] | b; //long에 담고 | 연산하는 것을 구별하기 쉽게 2줄로 분리했음
			}
		}

		
		int[] pTrue = new int[m]; //0은 거짓말해도 되는 파티 !
		for(int i=0;i<m;i++) {
			if(pArray[i] !=0 && pTrue[i] == 0 && (pArray[i] & tArray) > 0) {
				cnt--;
				tArray = (tArray | pArray[i]);
				pTrue[i] = 1;
				i = -1;
			}
		}
		System.out.print(cnt);
	}

}
