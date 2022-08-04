import java.util.Scanner;
import java.util.Stack;

public class Solution_1218_이해민 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			Stack<Character> stack = new Stack<Character>();
			int length = sc.nextInt();
			char[] str = new char[length];
			int result = 1;//1 - 유효함, 0 - 유효하지 않음
			char[][] bracket = {{'(', ')'}, {'[', ']'}, {'{', '}'}, {'<', '>'}};
			
			String temp = sc.next();
			for(int i = 0; i < length; i++) {
				str[i] = temp.charAt(i);
			}
			
			
			stack.push(str[0]);
			
			while(!stack.isEmpty()) {
				int i = 0;
				//top이랑 그 다음으로 들어올 값이랑 비교
				while(++i < str.length) {
					if(stack.isEmpty()) {
						stack.push(str[i]);
						continue;
					}
					char topElement = stack.peek();
					int idx = -1;
					
					
					for(int k = 0; k < bracket.length; k++) {
						//닫는 괄호인지 확인
						if(bracket[k][1] == str[i]) {
							//닫는 괄호와 짝궁인지 확인
							if(topElement == bracket[k][0]) {
								stack.pop();
							}
							idx = k;
							break;
						}
					}
					
					//여는 괄호는 무조건 스택에 넣음
					if(idx == -1) {
						stack.push(str[i]);
					}	
				}
				
				//idx를 끝까지 돌았는데 stack이 비어있지 않은 경우는 유효하지 않은 경우
				if(!stack.isEmpty()) {
					result = 0;
					break;
				}
			}
			System.out.println("#" +test_case + " " + result);
		}
		
	}

}
