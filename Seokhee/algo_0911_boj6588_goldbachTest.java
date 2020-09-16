import java.io.*;
import java.util.*;

public class algo_0911_boj6588_goldbachTest {
	
	//백준 6588 골드바흐의 추측
	final static int MAX = 1000000; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//소수 확인
		boolean[] isPrime = new boolean[MAX+1];
		
		for(int i = 2; i <= MAX; i++) {
            isPrime[i] = true;
        }
		
		//에라토스테네스의 체
		for(int i=2;i<=MAX;i++) {
			for(int j=i*2;j<=MAX;j+=i) { //2배한 수에서 
				if(!isPrime[j]) continue;
				isPrime[j] = false;
			}
		}
		
		//sb를 사용해서 가볍게
		StringBuilder sb = new StringBuilder("");
		
		while(true) {
			int flag = 0;
			int input = Integer.parseInt(br.readLine());
			if(input==0) break;
			
			//중반 너머가면 어차피 해왔던 연산과 동일해져서 의미가 없다.
			for(int i=2;i<=input/2;i++) { //b-a가 가장 큰 수를 원했으므로, a가 제일 작을 때부터 시작.
				if(isPrime[i] && isPrime[input-i]) {
					sb.append(input+" = "+i+" + "+(input-i)+"\n");
					flag = 1;
					break;
				}
			}
			
			//소수로 이뤄지지 않았다면
			if(flag == 0) {
				sb.append("Goldbach's conjecture is wrong.\n");
			}
		}
		System.out.println(sb);
	}
}
