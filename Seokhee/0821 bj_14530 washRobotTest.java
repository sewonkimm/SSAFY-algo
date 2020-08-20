import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class washRobotTest {

	static int n; //����(���� - x)
	static int m; //����(�ʺ� - y)
	static int r,c;
	static int d; //0-��, 1-��, 2-��, 3-��
	
	static int cnt; 
	
	//���Ǹ� ���ؼ� ������ 
	//������
	static int[] dx = {-1, 0, 1, 0}; //�ϵ�����
	static int[] dy = { 0, 1, 0,-1}; //�ϵ�����
	
	//ȸ����
	static int[] lx = { 0,-1, 0, 1};//~�� �ٶ󺸰� ����
	static int[] ly = {-1, 0, 1, 0};
			
	
	static int[][] map;
	//û���ϸ� 2�� �ٲ�����?
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		st = new StringTokenizer(br.readLine()," ");
		r = Integer.parseInt(st.nextToken()); //�κ�û�ұ� x
		c = Integer.parseInt(st.nextToken()); //�κ�û�ұ� y
		d = Integer.parseInt(st.nextToken()); //0-��, 1-��, 2-��, 3-��
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		recursive(r,c,d);
		System.out.println(cnt); //û���ϴ� ĭ�� ����
		
	}
	//0-��, 1-��, 2-��, 3-��
	static void recursive(int x,int y, int dir) { 
		if(map[x][y] ==0) cnt++;
		map[x][y] = 2;
		
		
		//����.. �׳� d�� �Ἥ 4�� �ݺ��ϴ°� ������
		for(int i=0;i<4;i++) { //����Ž��->����������ȸ��->����Ž��->����������ȸ�� �ݺ�
			//�ٶ󺸴¹������ ����ĭ�� ������ ��ȿ�Ѱ�? (�� �ٶ󺸴� ������ for���� ���� �ٲ�)
			if(x+lx[(dir+4-i)%4]>=0 && y+ly[(dir+4-i)%4]>=0 
					&& x+lx[(dir+4-i)%4]<n && y+ly[(dir+4-i)%4]<m) {
				//�ش籸���� û�Ҿ��Ѱ��̸�?
				if(map[x+lx[(dir+4-i)%4]][y+ly[(dir+4-i)%4]] == 0) {
					//�������� �̵��ϸ鼭 ���⵵ �ٲ��ش�
					recursive(x+lx[(dir+4-i)%4],y+ly[(dir+4-i)%4],(dir+3-i)%4);
					//û���� �� ã������ �� �ݺ��� ��������
					return;
				}		
			}
		}		
		
		//����� û�ҵǾ��ְų� ���̸� �ٶ󺸴� ���� �״�� ����, ������ �� �������� �״�� û�� ��(recursive����)
		if(x-dx[dir]>=0 && y-dy[dir]>=0 && x-dx[dir]<n && y-dy[dir]<m) {
			if(map[x-dx[dir]][y-dy[dir]] != 1)
				recursive(x-dx[dir],y-dy[dir],dir);
		}	
	}
}






