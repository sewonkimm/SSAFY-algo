import java.io.*;
import java.util.*;
public class stackSeqTest {

	static int n;
	static int[] num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//백준 1874번 스택수열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		n = Integer.parseInt(br.readLine());
		num = new int[n+1];
		int now;
		Stack<Integer> s = new Stack<>();
		for(int i=1;i<=n;i++) {
			num[i] = Integer.parseInt(br.readLine());
		}//이 순서에 맞추자
		for(int i=1,j=1;i<=n;i++) { //i와 동시에 j도주자
			s.push(i);   //1 2 3 4 5 6 7.... n까지 푸시
			sb.append("+\n");
			while(!s.empty() && num[j] == s.peek()) { //차있으면 계속돈다, j보면서 같으면 pop시켜주기
				j++;
				s.pop();
				sb.append("-\n");
			}
		}
		if(!s.isEmpty()) //비어있지않으면
			System.out.println("NO"); //방법이 없다 더이상
		else System.out.println(sb.toString()); //다비웠다 = 완료
	}

}
