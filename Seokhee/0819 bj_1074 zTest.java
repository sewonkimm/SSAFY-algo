package com.ssafy;
import java.util.*;
public class zTest {
	
	//������ ��� �䱸�ϴ� 1074�� ����
	//������ �迭�� ���� �ʿ���� ��и����� ����� �����ϸ� ���� ���̶�� �Ǵ�
	static int n;
	static int r;
	static int c;
	static int size1;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		//������ �迭 ����(����)����
		size1 = (int)Math.pow(2, n); 
		//�迭 ����� ���ϵ���
		
		recursive(r,c,size1); //��͹ݺ�
	}
	
	static void recursive(int x,int y,int size1) {
		
		if(size1 ==2) { //2*2�迭�� ���°� �ǵ��� ��� 4���� 1 �丷�� ������
			cnt = cnt+x*2+y; //2*2�϶��� �������� Ƚ���� ���Ͽ� ���
			System.out.println(cnt);
			return;
		}
		
		int wide = size1/2; //��и� �Ǵ��� ���� wide
		int sum = (size1/2)*(size1/2); //���� �迭 ũ�⿡ 4����1 ����, ��и��� ������ �� ���ϱ⽱����
		//���� ��귮�� skip�ϰ� ������
		
		if(x<wide && y<wide) {
			cnt+=0;
			recursive(x,y,wide); //4����1�丷, �»�и����� �̵���Ű�� (�̹� �»�и�)
		}
		else if(x<wide && y<2*wide) {
			cnt+=sum; //�»�и� 4����1��ŭ�� ��������
			recursive(x,y-wide,wide); //4����1�丷, �»�и����� �̵���Ű��
		}
		else if(x<2*wide && y<wide) {
			cnt+=2*sum; //���Ϻи� 4����2��ŭ�� ��������
			recursive(x-wide,y,wide); //4����1�丷, �»�и����� �̵���Ű��
		}
		else if(x<2*wide && y<2*wide) {
			cnt+=3*sum; //���Ϻи� 4����3��ŭ�� ��������
			recursive(x-wide,y-wide,wide); //4����1�丷, �»�и����� �̵���Ű��
		}
	}
}
