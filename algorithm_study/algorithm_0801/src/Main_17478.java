import java.util.Scanner;

/*
 * 2022.08.01
 * 입력 : 교수님이 출력을 원하는 재귀 횟수 N(1 ≤ N ≤ 50)이 주어진다.
 * 출력 : 재귀 횟수에 따른 챗봇의 응답을 출력한다.
 * */
public class Main_17478 {
	static String space = "";
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		callMsg(num);
	}

	public static void callMsg(int n) {
		String line = space;
		if(n <= 0) {
			System.out.println(line + "재귀함수가 뭔가요?");
			System.out.println(line + "재귀함수는 자기 자신을 호출하는 함수라네");
			return;
		}
		System.out.println(line + "재귀함수가 뭔가요?");
		System.out.println(line + "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		System.out.println(line + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		System.out.println(line + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.");
		
		space += " _ _ ";
		
		callMsg(n-1);
		
		System.out.println(line + "라고 답변하였지");
	}
	
	
	
}

