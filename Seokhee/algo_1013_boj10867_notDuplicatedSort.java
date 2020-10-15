import java.util.*;
import java.io.*;

public class algo_1013_boj10867_notDuplicatedSort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//백준 10867 중복빼고 정렬하기
		//set에 담고 list로 변환하고 sb에 넣어서 출력하겠다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Set<Integer> set = new TreeSet<>();
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<n;i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);
	}

}
