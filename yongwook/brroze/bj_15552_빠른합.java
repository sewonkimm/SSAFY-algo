package brroze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj_15552_빠른합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		String[] input = new  String[2];
		int A=0;
		int B=0;
		for (int i = 1; i <= T; i++) {
			input =br.readLine().trim().split(" ");
			
			//System.out.println(Integer.parseInt(input[0])+Integer.parseInt(input[1]));
			bw.write(Integer.parseInt(input[0])+Integer.parseInt(input[1])+ "\n");
		}
		bw.flush();
	}
}
