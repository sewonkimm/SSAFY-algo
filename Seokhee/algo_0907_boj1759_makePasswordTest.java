
import java.io.*;
import java.util.*;
public class algo_0907_boj1759_makePasswordTest {
	//백준 1759 암호만들기
	//한번 정렬시키고 맨 앞에부터 채워나가는식으로 하고
	//암호의 남은 길이보다 문자가 조금 남았으면 관두는 식으로 가지치기를 하자, 상당히 많이 줄어들 것 같다
	static int l;
	static int c;
	static char[] str;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine()," ");
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		str = new char[c];
		String a = sc.nextLine().replace(" ", "");
		
		str = a.toCharArray(); 
		Arrays.sort(str); //정렬중요
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<c-l+1;i++) { //남은 글자수가 모자라면 시작조차 하지않음
			int mo = 0;
			sb.append(str[i]); //모음을 골랐을 때 +1하고 넘김
			if( str[i] == 'a' ||
				str[i] == 'e' ||
				str[i] == 'i' ||
				str[i] == 'o' ||
				str[i] == 'u')
				dfs(i+1,sb,1);
			else dfs(i+1,sb,0); //모음을 안골랐을 때 그대로 넘김
			sb.deleteCharAt(sb.length()-1);
		}
	}
	private static void dfs(int num, StringBuilder sb, int mo) {
		if(sb.length()==l && mo>=1 && sb.length()-mo >=2) { 
			//모음이 1개 이상이면서, 자음이 2개 이상이면서 길이가 만족할 때
			System.out.println(sb.toString());
			return;
		}
		if(sb.length()==l) return;
		for(int i=num;i<c-l+sb.length()+1;i++) { //남은 글자수가 모자라면 시작조차 하지않음
			sb.append(str[i]);//모음을 골랐을 때 +1하고 넘김
			if( str[i] == 'a' ||
				str[i] == 'e' ||
				str[i] == 'i' ||
				str[i] == 'o' ||
				str[i] == 'u')
				dfs(i+1,sb,mo+1);
			else dfs(i+1,sb,mo);//모음을 안골랐을 때 그대로 넘김
			sb.deleteCharAt(sb.length()-1);
		}
	}
}
