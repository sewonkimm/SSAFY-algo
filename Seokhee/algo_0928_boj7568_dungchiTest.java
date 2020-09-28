import java.util.*;

public class algo_0928_boj7568_dungchiTest {

	public static void main(String[] args) {
		//백준 7568 덩치
		//나보다 키도 크고 몸무게도 많이 나가는 사람의 수 +1 로 등수를 매기자
		Scanner sc = new Scanner(System.in);
		List<int[]> list = new ArrayList<>();
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list.add(new int[] {a,b}); //어레이리스트에 2칸짜리 익명 배열들을 넣자
		}
		
		int count =0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) { //선택한 녀석보다 키도 크고 몸무게도 많이 나가는 사람의 수 +1 이 등수가 된다
				if(list.get(i)[0] < list.get(j)[0] && list.get(i)[1] < list.get(j)[1])
					count++;
			}
			System.out.print((count+1)+" "); //등수 출력
			count = 0;
		}
		

	}

}
