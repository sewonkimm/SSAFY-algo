import java.util.*;
public class stickTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int sum = 0; //����� ����
		
		int now = 64; //64 ���� (������ �ڸ��ų� ����� ������ ���̸� ����)
		int cnt = 1; //����� ����
		sum+=now;
		
		while(true) {
			if(sum == x) { //������ �� cnt(������ ����) ���
				System.out.println(cnt);
				break;
			}
			else if(sum > x){ //ũ��
				now = now>>1; //������ �ڸ���
				sum -= now;  //�װ� ���տ��� ���� (2����1�� �����)
			}
			else if(sum < x) { //������
				//����
				
				now = now>>1; //�������ڸ���
				cnt++;  //����ⰳ���߰�
				sum += now; //���տ� ������ ������ �ڸ���
			}	
		}	
	}
}
