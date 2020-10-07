import java.io.*;
import java.util.*;

public class algo_1007_boj18442_postOffice1 {

	static int N,R;
	static long L;
	static int[] ip,pp;
	static long[] town;
	static long distCount;
	
	//nextPermutation + 거리를 구하는 식을 이용하겠다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=1;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //마을 개수
			R = Integer.parseInt(st.nextToken()); //경찰서 개수, V보다 작거나 같음
			L = Long.parseLong(st.nextToken()); //마을 둘레, 1000보다 작거나 같음
			
			town = new long[N]; //마을위치를 나타냄
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) { //입력받음
				town[i] = Long.parseLong(st.nextToken());
			}
			ip = new int[N];
			pp = new int[N];
			
			for (int i = 0; i < N; i++) {
				ip[i] = i; //마을번호를 임의로 정하겠다, 마을위치를 배열에서 꺼내쓸 것이므로 0부터 넣는 것이 편할 것이다.
			}
			
			int cnt = 0;
			while(++cnt<=R) {
				pp[N-cnt] = 1; 
			}
			
			//여기서 nextPermutation을 위한 정렬은 할 필요없다.이미 오름차순으로 넣었으므로
			long min = Long.MAX_VALUE;
			long minPol = Long.MAX_VALUE;
			
			int[] nn = new int[N];
			
			//횟수마다 count증가
			do {
				for(int i=0;i<N;i++) { //고른마을
					for(int j=0;j<N;j++) { //경찰서
						if(pp[j]==1) { //경찰서가 존재하는 곳과 고른마을의 거리를 비교한다
							long dis = Math.abs(town[i]-town[j]); //거리 절댓값을 2번 사용하므로 1번만 해놓고 사용하자. 
							long disP = Math.min(dis,L-dis); //원형의 마을이므로 이런식으로 마을과 경찰서간의 거리를 구함
							if(minPol>disP) //그 마을에게 가장 가까운 경찰서를 구함 = minPol
								minPol = disP;
						}
					}
					distCount += minPol; //그 마을에게 가장 가까운 경찰서를 구해서 더해줌
					minPol = Long.MAX_VALUE; //다시 쓸 것이므로 초기화(min이므로 MAX_VALUE로)
				}
				
				if(distCount <= min) {//모든 마을의 가장 가까운 경찰서를 구했으면 다시 한번 비교
					min = distCount;
					
					nn = new int[N];
					for(int i=0;i<N;i++) {
						nn[i] = pp[i];
					}
				}
				distCount=0; //또 사용할 것이므로 0으로 초기화
			}while(nextPermutation(pp));
			
			//System.out.println("#"+t+" "+min); //모든 마을의 가장 가까운 경찰서를 구하는 경우의 수 중에서 가장 거리가 짧은 min을 구해서 출력
			System.out.println(min);
			for(int i=0;i<N;i++) {
				if(nn[i] == 1) {
					System.out.print(town[i]+" ");
				}
			}
		}
	}
	
	//swap함수 i와 j자리의 숫자를 교환해준다.
	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
			
	public static boolean nextPermutation(int[] numbers) {
		//꼭대기 찾기
		int i = N-1;
		while(i>0 && numbers[i-1] >= numbers[i]) i--;
		if(i==0) return false; //마지막 순열의 상태이면 다음 순열은 없다 = false 반환
		
		//i-1위치와 교환할 다음단계 큰 수 뒷쪽에서 찾기
		int j = N-1;
		while(numbers[i-1]>=numbers[j]) j--; //무조건 존재함
		
		//i-1 위치값과 j 위치값 교환
		swap(numbers,i-1,j);
		
		//i위치부터 맨 뒤까지 오름차순 정렬
		int k = N-1;
		while(i<k) {
			swap(numbers,i++,k--);
		}
		return true; //정상적으로 됐다면 true 반환
	}
}
