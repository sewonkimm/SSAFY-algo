/*
 * D3 1209 Sum
 * 1) �� �������� �ݺ�
 * 2) �� �������� �ݺ�
 * 3) �밢�� 2��
 * 1), 2), 3)�� �����ϸ鼭 �� ��, ��, �밢����
 * �ִ밪 ��
 */

package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1209_Sum {
	
	static int[][] arr; // �� ������ �迭
	static int max; // ���� ���� �ִ밪

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			// �迭 �Է�
			arr = new int[100][100];
			max = 0;
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// ��� ��
			for (int i = 0; i < 100; i++) {
				int temp1 = 0;
				int temp2 = 0;
				for (int j = 0; j < 100; j++) {
					temp1 += arr[i][j]; // �� ���� ���ϱ�
					temp2 += arr[j][i]; // �� ���� ���ϱ�
				}
				// Ȯ��
				if(temp1 > max) max = temp1;
				if(temp2 > max) max = temp2;
			}
			// �밢
			int temp1 = 0; 
			int temp2 = 0;
			for (int i = 0; i < 100; i++) {
				temp1 += arr[i][i]; // ������ �Ʒ��� �������� �밢��
				temp2 += arr[i][99-i]; // ���� �Ʒ��� �������� �밢��
			}
			// Ȯ��
			if(temp1 > max) max = temp1;
			if(temp2 > max) max = temp2;
			
			System.out.println("#"+t+" "+max);
		}
	}

}
