import java.util.*;
public class luckyStringTest {

	//<스터디과제> -> 실패한 버전임!! 하지만 참고는 될 듯
	
	//백준 1342번 행운의문자열
	//원소에 같은게 들어있는 조합은 짜본적이 없어서 조금 고민
	//조합 초반부터 행운이 아닐경우 아예 멈춰서 시간복잡도를 줄이자
	//모든 경우를 set에 넣어서 set size를 구해도 좋을듯?
	static char[] ch;
	static int[] check;
	static String s;
	static HashSet<String> set;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		s = sc.next();
		ch = new char[s.length()];
		check = new int[s.length()]; 
		for(int i=0;i<s.length();i++) {
			ch[i] = s.charAt(i);
		} //세팅
		
		//stringbuilder를 써서 오버헤드를 낮추자, set으로 개수를 세주자
		set = new HashSet<>();
		
		for(int i=0;i<s.length();i++) {
			StringBuilder sb = new StringBuilder("");
			
			sb.append(ch[i]);
			check[i]=1;
			dfs(check,sb);
			check[i]=0;
		}
		System.out.println(set.size());
	}
	public static void dfs(int[] c, StringBuilder sb) {
		if(sb.length() == s.length()) {
			String s = sb.toString();
			set.add(s);
		}
		for(int i=0;i<s.length();i++) {
			if(check[i] == 0) {
				sb.append(ch[i]);
				if(checkLucky(sb)) {
					check[i]=1;
					dfs(check,sb);
					check[i]=0;
				}
				sb.delete(sb.length()-1, sb.length());
			}
		}
	}
	public static boolean checkLucky(StringBuilder sb) {
		String s = sb.toString();
		for(int i=0;i<s.length()-1;i++){
			if(s.charAt(i) == s.charAt(i+1))
				return false;
		}
		return true;
	}
}
