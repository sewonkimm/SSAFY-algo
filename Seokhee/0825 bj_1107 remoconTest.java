import java.util.*;
public class remoconTest {

	//백준 1107번 리모컨
	//브루스포스문제 
	//100번 기준으로 먼저 갈 거리를 재고, 그 채널 바로 갈 수 있으면 재서 그 두개를 먼저 비교함
	//그다음에는 그 채널 위 아래로 반복해주면서 돌자, 찾는 채널은 50만까지지만 
	//버튼이 망가지는거때문에 100만까지 탐색해야함, 중요
	static int n;
	static int m;
	static boolean[] ch;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		ch = new boolean[1000001]; //999999번까지 
		
		Arrays.fill(ch, true); //갈수있다로 채움, 채널
		
		int bCh;
		for(int i=0;i<m;i++) {
			bCh = sc.nextInt();
		
			for(int j=0;j<=1000000;j++) { //망가진버튼 기준으로 안되는 채널 막기
				int temp = j;
				do {
					if(temp%10==bCh) ch[j] = false;
					temp = temp/10;
				} while(temp>0);
			}
		}

		ch[100] = true;
		int nowMove = Math.abs(n-100); //100번으로부터의 거리를 최소거리로 두고
		
		if(nowMove == 0) { //100번이면 그냥 0
			System.out.println(0);
			return;
		}
		int left = n, right = n;
		int leftNum,rightNum;

		if(ch[n] == true) { //가고싶은 채널이 눌러질때, 100번이랑 누가 더 싼지 비교
			int num = (int)Math.log10(n)+1;
			
			if(nowMove>num && n == 0) { //0일경우 로그가 안되서 예외로 빼고 0번버튼 1번누른것으로 처리
				nowMove = 1; 
				System.out.println(nowMove);	
				return;
			}
			else if(nowMove>num) { //나머지는 숫자의 자릿수로 버튼누른 횟수 처리
				nowMove = num; 
				System.out.println(nowMove);	
				return;
			}
		}
		//다 안되면 100만까지 다돌자, +1 -1로
		while(left>=0 | right<=1000000) {
			left--;
			right++;
			if(left>=0 && ch[left] == true) { //갈수있는곳이면 (와일문내에서는) 최소로 온것
				leftNum=Math.abs(n-left);
				
				if(nowMove>leftNum+1 && left == 0) { //0번은 따로 로그가 안되서  1(0번누르기)+움직인횟수
					nowMove = leftNum+1;
				}
				else if(nowMove>leftNum+(int)Math.log10(left)+1) { //로그(채널자릿수)+움직인횟수
					nowMove = leftNum+(int)Math.log10(left)+1;	
				}
				left = -1;
				right = 1000001;
			}
			else if(right<=1000000 && ch[right] == true) {  //갈수있는곳이면 (와일문내에서는) 최소로 온것
				rightNum=Math.abs(n-right);
				if(nowMove>rightNum+1 && right == 0) { //0번은 따로 로그가 안되서 1(0번누르기)+움직인횟수
					nowMove = rightNum+1;
				}
				else if(nowMove>rightNum+(int)Math.log10(right)+1) { //로그(채널자릿수)+움직인횟수
					nowMove = rightNum+(int)Math.log10(right)+1;
				}
				left = -1;
				right = 1000001;
			}				
		}
		System.out.println(nowMove);	
	}

}
