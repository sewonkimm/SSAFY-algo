import java.io.*;
import java.util.*;
public class algo_0911_boj10816_numCardTest {

	//백준 숫자 카드 map을 활용해보자
	//key와 value를 활용해서 값을 찾고, 존재여부를 확인할 수 있고, 값을 고쳐줄 수 있다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		HashMap<Integer,Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<n;i++) { //map에 집어넣기
			int card = Integer.parseInt(st.nextToken());
			if(map.containsKey(card)) //있으면 +1
				map.replace(card, map.get(card)+1);
			else map.put(card, 1); //없으면 1
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<m;i++) { //확인하기
			int card = Integer.parseInt(st.nextToken());
			if(map.containsKey(card)) //맵에 있으면
				sb.append(map.get(card)+" "); //카드 숫자 출력
			else sb.append(0+" "); //없으면 0 출력
		}		
		System.out.println(sb);
	}
}
