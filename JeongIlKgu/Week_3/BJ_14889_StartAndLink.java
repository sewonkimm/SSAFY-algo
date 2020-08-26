/*
 * BJ 14889 스타트와 링크
 * 조합 & 브루트 포스
 * => 조합이 생성되면, start팀과 link팀의 전력차를 계산!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14889_StartAndLink {
	
	static int[][] startAndLink; // 전체 팀의 전력 표
	static int N, min; // 인원수, 전력차이의 최소값
	static int[] srcArray; // 전체 인원의 구성 인원
	static int[] tgtArray; // 조합을 통해 만들어지는 구성 인원
	
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		startAndLink = new int[N][N];
		srcArray = new int[N];
		tgtArray = new int[N/2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			srcArray[i] = i;
			for (int j = 0; j < N; j++) {
				startAndLink[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		comb(0,0);
		System.out.println(min);
	}

	// 조합
	public static void comb(int srcIndex, int tgtIndex) {
		if( tgtIndex == N/2 ) {
			checkMin(tgtArray);
			return;
		}
		
		if( srcIndex == srcArray.length) return;
		
		tgtArray[tgtIndex] = srcArray[srcIndex];
		comb(srcIndex + 1, tgtIndex + 1);
		comb(srcIndex + 1, tgtIndex);
	}
	
	// 전력 차이의 최소값을 구하는 Method
	public static void checkMin(int[] array) {
		int[] other = new int[N/2];
		boolean[] isVisited = new boolean[N];
		int index = 0;
		int start = 0; // start팀
		int link = 0; // link팀
		
		// 조합에 구성되지 않은 팀을 구성하기 위한 과정
		for (int i = 0; i < N/2; i++) {
			isVisited[array[i]] = true;
		}
		for (int i = 0; i < N; i++) {
			if(!isVisited[i]) {
				other[index] = i;
				index++;
			}
		}
		
		// Start팀과 Link팀의 전력을 계산
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < N/2; j++) {
				if(array[i] != array[j]) start += startAndLink[array[i]][array[j]];
			}
		}
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < N/2; j++) {
				if(other[i] != other[j]) link += startAndLink[other[i]][other[j]];
			}
		}
		
		if(min > Math.abs(start-link)) min = Math.abs(start-link);
	}
}
