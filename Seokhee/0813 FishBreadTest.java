package com.ssafy;
import java.util.*;

public class FishBreadTest {

	static int[] human;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			human = new int[n];
			for(int i=0;i<n;i++) {
				human[i] = sc.nextInt();
			}
			Arrays.sort(human); //�����»������ �ִ°ŷ� ����
			
			//fishsub �̹� �Դٰ� �մԼ�(�̹� �����Ŵϱ� ����ð��� �ѻ��귮 ��꿡�� ���ֱ����ؼ�)
			int fishSub = 0;
			
			for(int i=0;i<n;i++) {
				//true, false ���θ� ����, (�մ��� �� �ð� /���꿡 �ɸ��� �ð�) �� ������ ���귮�� ���Ѵ�
				int TF = ((human[i]/m) * k -(fishSub+1)); 
				fishSub++; //�Ѹ�Դٰ�
				if(TF<0) { //���귮�� ����(�մ��� ������)�� �Ұ���
					System.out.println("#"+t+" "+"Impossible");
					i = n;
					fishSub=0;
				}
				if(i==n-1) { //�մ��� ��� �޾����� ����
					System.out.println("#"+t+" "+"Possible");
				}
			}
			
			
		}

	}

}
