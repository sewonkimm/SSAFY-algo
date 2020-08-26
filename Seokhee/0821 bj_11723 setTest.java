import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class setTest {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//전형적인(?) 비트마스킹 문제
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String s;
		StringBuilder sb = new StringBuilder();
		int num = 0; //연산에서 들어오는 수 (1~20)
		int now = 0; //비트표현 할 수
		int temp; //막 쓸 temp
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine()," ");
			s=st.nextToken(); //x값
			
			if(st.hasMoreTokens())  //all과 empty는 x가 없다
				num = Integer.parseInt(st.nextToken());
			
			
			//now는 int지만 마치 20자리의 bit를 가진 2진수라고 생각해보자, 초기상태는 000000...0(=0)인 것처럼 사용
			switch(s) {
				case "add": //모든 연산은 비슷하게 진행된다
					temp = now; 
					temp = (temp<<(19-(num-1))) % (int)Math.pow(2,20); 
					//해당 자리를 맨 앞자리 까지 비트를 밀어줌(나머지 연산으로 앞에 다 잘라줌), 만약 존재한다면 10000....0의 형태가 될수 있도록 없다면 그냥 000000...0
					temp = temp>>19; //다시 원상복구하면 해당 자릿수만 1의자리에서 살아남게됨 존재하면 1, 없다면  0
					
					if(temp == 0) //해당 자리가 비어있던것이므로 채워주자
						now += 1<<(num-1);
					break;
				case "remove": //동일하게 하고 해당 자리가 있을 시에 제거
					temp = now;
					temp = (temp<<(19-(num-1))) % (int)Math.pow(2,20);
					temp = temp>>19;
					
					if(temp == 1)
						now -= 1<<(num-1);
					break;
				case "check": //테케중에 print가 너무 잦게 일어나서 시간초과가 발생하는 테케가 있어서 StringBuilder 사용함
					temp = now;
					temp = (temp<<(19-(num-1))) % (int)Math.pow(2,20);
					
					temp = temp>>19;
					
					if(temp == 0) {
						//System.out.println(0);
						sb.append(0);
						sb.append("\n");
					}
					else if(temp == 1) {
						//System.out.println(1);
						sb.append(1);
						sb.append("\n");
					}
					break;
				case "toggle":  //동일하게하고 add, remove 연산 합침
					temp = now;
					temp = (temp<<(19-(num-1))) % (int)Math.pow(2,20);
					temp = temp>>19;
					
					if(temp == 0)
						now += 1<<(num-1);
					else if(temp == 1)
						now -= 1<<(num-1);
					break;
				case "all":  //전부 1로 채움 = 2^20-1 하면 20칸 짜리의 bit가 모두 1로 되는 효과
					now = (int)Math.pow(2,20) - 1;
					break;
				case "empty":  //그냥 0으로 하면됨 -> "000000000...0"
					now = 0;
					break;
			}
			//구현
		}
		
		System.out.println(sb.toString());
		
		
	}

}
