/*
 * D1 2068 �ִ�� ���ϱ�
 * �� �׽�Ʈ ���̽����� ���� �Է¹޴� ���ÿ� �ִ밪�� ���ؼ� ���
 */

package com.ssafy;

import java.util.Scanner;

public class D1_2068_findMaxNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int max = 0; // �ִ밪 ����
			for (int i = 0; i < 10; i++) {
				int a = sc.nextInt(); // �� �Է�
				if(max < a) max = a; // �ִ밪 ��
			}
			System.out.println("#"+t+" "+max);
		}
		sc.close();
	}
}
