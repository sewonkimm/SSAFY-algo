/*
 * BJ 14569 시간표 짜기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14569_TimeTable {
	
	// 과목 수, 각 과목의 수업시간의 수, 학생 수, 각 학생들의 비어 있는 교시 개수, 과목 교시, 빈 교시
	static int N, k, M, p, t, q;
	static long[] subject; // 각 과목의 시간표 => 총 50bit가 필요하기 때문에 long으로 선언

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		subject = new long[N];
		// 과목 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++) {
				t = Integer.parseInt(st.nextToken());
				subject[i] |= (1L<<t); // Long형은 1L로 표시
			}
		}
		// 학생 입력과 동시에 처리
		M = Integer.parseInt(in.readLine());
		for (int i = 0; i < M; i++) {
			int count = 0;
			st = new StringTokenizer(in.readLine(), " ");
			p = Integer.parseInt(st.nextToken());
			long empty = 0; // 학생의 비어있는 시간
			for (int j = 0; j < p; j++) {
				q = Integer.parseInt(st.nextToken());
				empty |= (1L<<q);
			}
			// 각 과목의 시간표와 비교하면서 &처리했을 때, 그 값이 과목과 같다면 count+1
			for (int j = 0; j < N; j++) {
				if((subject[j] & empty) == subject[j]) count++;
			}
			System.out.println(count);
		}
		
	}

}
