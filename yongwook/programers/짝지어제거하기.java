package programers;
import java.util.Scanner;
import java.util.Stack;

public class 짝지어제거하기 {
	public static void main(String[] args) {
		System.out.println(solution("baabaa"));
	}
	  public static int solution(String s)
	    {
	        int answer = 0;
	        Stack<Character> stack = new Stack<Character>();
			
			char temp = 0;
			for (int i = 0; i < s.length(); i++) {
				temp = s.charAt(i);
				if(stack.isEmpty())
					stack.push(temp);
				else if(stack.peek() == temp) {
					stack.pop();
				}else {
					stack.push(temp);
				}
				
			}
			if(stack.isEmpty()){
				answer = 1;
			}else
				answer = 0;
	        return answer;
	    }
}
