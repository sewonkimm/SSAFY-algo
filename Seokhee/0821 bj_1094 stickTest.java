import java.util.*;
public class stickTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int sum = 0; //막대기 총합
		
		int now = 64; //64 시작 (앞으로 자르거나 사용할 막대의 길이를 뜻함)
		int cnt = 1; //막대기 개수
		sum+=now;
		
		while(true) {
			if(sum == x) { //동일할 시 cnt(막대의 개수) 출력
				System.out.println(cnt);
				break;
			}
			else if(sum > x){ //크면
				now = now>>1; //반으로 자르고
				sum -= now;  //그거 총합에서 빼줌 (2분의1로 만든다)
			}
			else if(sum < x) { //작으면
				//없음
				
				now = now>>1; //반으로자르고
				cnt++;  //막대기개수추가
				sum += now; //총합에 더해줌 반으로 자른거
			}	
		}	
	}
}
