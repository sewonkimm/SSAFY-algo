import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class virusTest {

	static int v;
	static int e;
	
	static int[] checked;
	static int[][] map;
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		v = Integer.parseInt(br.readLine());
		e = Integer.parseInt(br.readLine());
		
		int from, to;
		checked = new int[v+1]; //0�̸� �Ȱɸ��� 1�̸� �ɸ��� 
		
		map = new int[101][101]; //0�̸� ����ȵ�
		
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine()," ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			map[from][to] = 1;
			map[to][from] = 1; //���� �׷��� !! 
			//1�ϰ�� from-to(to-from)�� ����Ǿ��ִ�
		}
		
		//1�� ����� �ֵ���� �����غ���
		for(int i=2;i<=v;i++) {
			if(map[1][i] == 1 && checked[i] == 0) {
				cnt++;
				checked[i] = 1;
				bfs(1,i);	
			}
		}
		
		System.out.println(cnt);
		
	}
	
	static void bfs(int a, int b) {
		for(int i=2;i<=v;i++) {
			//�ڱ��ڽ��� �鸱 �ʿ䰡 ����, bfs����
			if(b!=i && map[b][i] == 1 && checked[i] == 0) {
				cnt++;
				checked[i] = 1;
				bfs(b,i);
			}
		}
	}

}
