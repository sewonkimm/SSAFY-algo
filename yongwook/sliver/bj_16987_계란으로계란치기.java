package sliver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 계란 : 내구도, 무게
 *	왼쪽부터 순서대로 하나씩 들어서, 다른계란을 내리친다 (한번씩 순회 하고 끝) 
 *
 */
public class bj_16987_계란으로계란치기 {
	private static int N;
	private static int[] s;
	private static int[] w;
	private static int maxCnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 계란의 수 N(1 ≤ N ≤ 8) 개수가 적으니까 완탐 가능
		
		s = new int[N]; // 내구도 
		w = new int[N]; // 무게
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			s[i] = Integer.parseInt(st.nextToken()); // 계란의 내구도, Si(1 ≤ Si ≤ 300)
			w[i] = Integer.parseInt(st.nextToken()); // 계란의 무게, Wi(1 ≤ Wi ≤ 300)
		}
		maxCnt = 0; // 깨진 계란의 최대 개수
		dfs(0, 0);
		System.out.println(maxCnt);
	} // end of main
	/** index 번째 계란을 들어서 깨지지않은 다른계란을 내리치기
	 * cnt : 지금까지 깨진 계란의 개수 */
	public static void dfs(int index, int cnt) {
		if (cnt >= N-1 || index == N) { // 종료파트, 남은 계란이 1개,0개  or 마지막 단계에 왔으면 
			if (maxCnt < cnt) { // 최대값 업데이트
				maxCnt = cnt;
			}
			return;
		} 
		if (s[index] <= 0) { // index 번째 들어올릴 계란이 깨져있는경우, 진행할 수 없음
			dfs(index+1, cnt);
			return;
		}
		// 재귀파트
		// index 번째 계란을 들어서 i번째 계란을 내리치는 상황을 표현
		// 하나를 깨는 행위를 하고, (재귀호출), 재귀호출 끝나고 돌아오면, 반복문의 다음차수가 실행됨
		// 반복문의 다음차수로 갈때, 이전의 깨는 행위는 없었던걸로 되돌려 줘야함
		for (int i = 0; i < N; i++) { // 매맞을 계란
			// 내리치는 작업을 하면 안되는 경우
			if (index == i) continue; // 자기계란으로 자기를 깰수 없음
			if (s[i] <= 0) continue; // 매맞을 계란이 이미 깨져있는경우
			
			s[i] -= w[index]; // 상대무게만큼 내구도 감소
			s[index] -= w[i];
			
			int tempCnt = 0; // 지금 동작으로인해 추가로 깨진 계란의 개수 카운팅
			if (s[i] <= 0) tempCnt++;
			if (s[index] <= 0) tempCnt++;
			
			dfs(index+1, cnt + tempCnt);
			
			s[i] += w[index]; // 원복
			s[index] += w[i];
		}
	}
} // end of class

// 반복문 보다 재귀함수가 느리다, 같은 구조로 만들었을 경우
// 재귀함수를 쓰는 이유, 가지치기



