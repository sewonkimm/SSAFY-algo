import java.io.*;
import java.util.*;

public class boj2810_0906_cupHolderTest {

	//job2810 컵홀더 
	//컵홀더 수를 세서 출력하고, 좌석수(사람수)보다 많을 경우 사람수를 출력
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 1; //자리는 최소 1자리 이상 들어올 것이므로 1로 시작
		int h = Integer.parseInt(br.readLine());
		String s = br.readLine(); 
		
		for(int i=0;i<s.length();i++) { 
			if(s.charAt(i) == 'S') //컵홀더 1개추가 1자리 옮기기
				cnt++; 
			else if(s.charAt(i) == 'L') { //컵홀더 1개추가 2자리 옮기기
				cnt++;
				i++;
			}
		}
		if(cnt>h) //컵홀더수>사람수 => 사람수출력
			System.out.println(h);
		else System.out.println(cnt); //컵홀더 개수 출력
		
	}

}
