import java.util.*;
public class algo_0910_boj1541_calculTest {
	
	public static void main(String[] args) {
		//백준 1541 잃어버린 괄호
		//-가 나오면 다음 -가 나올때까지 묶어서 빼주면 가장 작은 값을 얻을 수 있다.
		Scanner sc = new Scanner(System.in);

		String a = sc.next();
		
		char[] arr = new char[a.length()];
		arr = a.toCharArray(); //char배열에 넣어주고
		
		Queue<Integer> num = new LinkedList<>();
		Queue<Character> op = new LinkedList<>();
		
		Stack<Integer> numStack= new Stack<>(); //스택을 활용

		for(int i=0;i<arr.length;i++) {
			if(arr[i] != '-' && arr[i] != '+') { //숫자일 경우 숫자스택에 푸시
				numStack.push(arr[i]-'0'); //푸시
				
				if(i == arr.length-1) { //그런데 끝까지 왔을 때, 마지막은 숫자일 것이므로
					//숫자변환 들어가야함, 자리수만큼 pop시키면서 계속 10씩곱해서 더해줌
					int n=0,ten=1;
					while(!numStack.isEmpty()) {
						n+=numStack.pop()*ten;
						ten = ten*10;
					}
					num.add(n);
					continue;
				}
			}
			else { //연산자일 경우
				op.add(arr[i]);
				//숫자변환 들어가야함, 자리수만큼 pop시키면서 계속 10씩곱해서 더해줌
				int n=0,ten=1;
				while(!numStack.isEmpty()) {
					n+=numStack.pop()*ten;
					ten = ten*10;
				}
				num.add(n);
			}
		}
		
		int num1 = num.poll(); //첫 수를 꺼내서
		
		if(op.isEmpty()) { //연산자 없으면 바로 출력
			System.out.println(num1);
			return;
		}
		while(true) {
			if(op.peek() == '+') { //+일 경우 그냥 기존의 수에 더해줌
				op.poll();
				num1 = num1 + num.poll();
				if(num.isEmpty()) { //뽑을 수가 없으면 그만함
					System.out.println(num1);
					return;
				}
			}
			else if(op.peek() == '-') { //-일경우 다음 -가 나올때까지 더해서 앞 수에서 빼줌
				op.poll();
				int num2 = num.poll();
				
				if(num.isEmpty()) { //뽑을 수가 없으면 그만함
					num1 = num1 - num2;
					System.out.println(num1);
					return;
				}
				
				while(true) { //-일경우 다음 -가 나올때까지 더해서 앞 수에서 빼줌
					if(op.peek() == '+') { //+가 나오면 수를 불려준다
						op.poll();
						num2 = num2 + num.poll();
						if(num.isEmpty()) { //뽑을 수가 없으면 그만함
							num1 = num1 - num2;
							System.out.println(num1);
							return;
						}
						
					}
					else if(op.peek() == '-' ) { //-가 나오면 모았던 수를 한번 빼준다
						num1 = num1 - num2;
						break;
					}
				}
			}
		}
			
	}

}
