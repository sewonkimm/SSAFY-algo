import java.util.Scanner;

/*
 * BJ 15787 기차가 어둠을 헤치고 은하수를
 * 비트 마스킹
 * 자리를 옮길 때, 첫 자리와 마지막 자리는 자리 수를 맞춰야 한다.
 */

public class BJ_15787_Train {
	
	// 기차의 수, 명령의 수, 명령, 기차번호, 자리 
	static int N, M, order, noTrain, seat, result;
	static int[] trains; // 각 기차의 탑승한 사람
	static boolean[] visited = new boolean[1<<21];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		trains = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			order = sc.nextInt();
			switch (order) {
			case 1: // 탑승
				noTrain = sc.nextInt();
				seat = sc.nextInt();
				trains[noTrain] |= (1<<20-seat+1);
				break;
			case 2: // 하차
				noTrain = sc.nextInt();
				seat = sc.nextInt();
				trains[noTrain] &= ~(1<<20-seat+1);		
				break;
			case 3: // >> 자리 이동
				noTrain = sc.nextInt();
				// 하나 옆으로 밀고 자리 맞추기
				trains[noTrain] = trains[noTrain] >> 1;
				trains[noTrain] = trains[noTrain] & ~1;
				break;
			case 4: // << 자리 이동
				noTrain = sc.nextInt();
				// 하나 늘리고 자리 맞추기
				trains[noTrain] = trains[noTrain] << 1;
				trains[noTrain] = trains[noTrain] & ((1<<21)-1);
				break;
			}
		}
		// 지나가는 기차 확인
		for (int i = 1; i <= N; i++) {
			if(!visited[trains[i]]) {
				result++;
				visited[trains[i]] = true;
			}
		}
		
		System.out.println(result);
		sc.close();
	}

}
