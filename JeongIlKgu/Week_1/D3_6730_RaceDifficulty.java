/*
 * D3 6730 ��ֹ� ���� ���̵�
 * �� �׽�Ʈ ���̽����� �Է��� �����鼭
 * 1) i > i+1 �̸� ������ ���̵� ��
 * 2) i < i+1 �̸� ������ ���̵� ��
 * 1)�� 2)�� �ִ밪 ã��
 */

package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_6730_RaceDifficulty {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(in.readLine()," ");
			int N = Integer.parseInt(st.nextToken()); // ��� ����
			int UpMax = 0; // ������ �ִ�
			int DownMax = 0; // ������ �ִ�
			st = new StringTokenizer(in.readLine()," ");
			int num = Integer.parseInt(st.nextToken()); // ��
			for (int i = 0; i < N-1; i++) {
				int temp = Integer.parseInt(st.nextToken()); // �� 
				if(num > temp) { // ������
					if(DownMax < (num - temp)) DownMax = num - temp;
				}else if(num < temp) { // ������
					if(UpMax < (temp - num)) UpMax = temp - num;
				}
				// ���� ��ֹ��� ���� ��ֹ��� �ٲ��ֱ�
				num = temp;
			}
			System.out.println("#"+t+" "+UpMax+" "+DownMax);
		}	
	}

}
