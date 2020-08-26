import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class setTest {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//��������(?) ��Ʈ����ŷ ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String s;
		StringBuilder sb = new StringBuilder();
		int num = 0; //���꿡�� ������ �� (1~20)
		int now = 0; //��Ʈǥ�� �� ��
		int temp; //�� �� temp
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine()," ");
			s=st.nextToken(); //x��
			
			if(st.hasMoreTokens())  //all�� empty�� x�� ����
				num = Integer.parseInt(st.nextToken());
			
			
			//now�� int���� ��ġ 20�ڸ��� bit�� ���� 2������� �����غ���, �ʱ���´� 000000...0(=0)�� ��ó�� ���
			switch(s) {
				case "add": //��� ������ ����ϰ� ����ȴ�
					temp = now; 
					temp = (temp<<(19-(num-1))) % (int)Math.pow(2,20); 
					//�ش� �ڸ��� �� ���ڸ� ���� ��Ʈ�� �о���(������ �������� �տ� �� �߶���), ���� �����Ѵٸ� 10000....0�� ���°� �ɼ� �ֵ��� ���ٸ� �׳� 000000...0
					temp = temp>>19; //�ٽ� ���󺹱��ϸ� �ش� �ڸ����� 1���ڸ����� ��Ƴ��Ե� �����ϸ� 1, ���ٸ�  0
					
					if(temp == 0) //�ش� �ڸ��� ����ִ����̹Ƿ� ä������
						now += 1<<(num-1);
					break;
				case "remove": //�����ϰ� �ϰ� �ش� �ڸ��� ���� �ÿ� ����
					temp = now;
					temp = (temp<<(19-(num-1))) % (int)Math.pow(2,20);
					temp = temp>>19;
					
					if(temp == 1)
						now -= 1<<(num-1);
					break;
				case "check": //�����߿� print�� �ʹ� ��� �Ͼ�� �ð��ʰ��� �߻��ϴ� ���ɰ� �־ StringBuilder �����
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
				case "toggle":  //�����ϰ��ϰ� add, remove ���� ��ħ
					temp = now;
					temp = (temp<<(19-(num-1))) % (int)Math.pow(2,20);
					temp = temp>>19;
					
					if(temp == 0)
						now += 1<<(num-1);
					else if(temp == 1)
						now -= 1<<(num-1);
					break;
				case "all":  //���� 1�� ä�� = 2^20-1 �ϸ� 20ĭ ¥���� bit�� ��� 1�� �Ǵ� ȿ��
					now = (int)Math.pow(2,20) - 1;
					break;
				case "empty":  //�׳� 0���� �ϸ�� -> "000000000...0"
					now = 0;
					break;
			}
			//����
		}
		
		System.out.println(sb.toString());
		
		
	}

}
