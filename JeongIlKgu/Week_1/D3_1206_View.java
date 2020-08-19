/*
 * D3 1206 View
 * �� �׽�Ʈ ���̽����� �ǹ��� ���̸� �����ϰ�
 * �ݺ����� ���� �翷 2ĭ���� �ǹ� ���̸� ���Ѵ�.
 */

package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1206_View {
	
	static int N; // ������ ���� �̾����� �ǹ��� �� 
	static int[] building; // �ǹ����� ���̸� ������ �迭
	static int result; // �������� Ȯ���� ���� ��

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			// �� �ǹ��� ���� �Է�
			building = new int[N];
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				building[i] = Integer.parseInt(st.nextToken());
			}
			result = 0;
			// �� �ǹ� �A �� 2ĭ �� -> �� 2ĭ�� �� 2ĭ�� 0�̹Ƿ� Ȯ�� X
			for (int i = 2; i < N-2; i++) {
				result += compare(i);
			}
			System.out.println("#"+t+" "+result);
		}
	}

	private static int compare(int b) {
		int a = 256;
		for (int i = 1; i <= 2; i++) {
			// �� ��
			if(building[b] > building[b-i]) {
				a = Math.min(a, building[b] - building[b-i]);
			}else {
				a = 0;
				break;
			}
			// �� ��
			if(building[b] > building[b+i]) {
				a = Math.min(a, building[b] - building[b+i]);
			}else {
				a = 0;
				break;
			}
		}
		return a;
	}
}
