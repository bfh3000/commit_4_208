package programmers_test;

public class lv1_CaesarCipher {
	// 1. 알파벳이 26개인 것을 이용.
	// 2. 1번을 이용하여 '%' 나머지를 이용하여 처리함.
	public static void main(String[] args) {
		System.out.println(solution2("A a z Z b B ", 1));

	}

	public static String solution2(String a, int n) {
		String answer = "";
		char[] test = new char[a.length()];
		int N = n;

		// 문자열을 테스트에 하나씩 담는다..
		for (int i = 0; i < a.length(); i++) {
			test[i] = a.charAt(i);
		}

		
		//문자열 처리 시작.
		for (int i = 0; i < a.length(); i++) {

			// 공백은 그대로 공백처리.
			if (test[i] == ' ') {
				test[i] = test[i];

				
				
			// 영어 소문자 처리하는 부분
			} else if (test[i] <= 'z' && test[i] >= 'a') {
				n = n % 26;
				test[i] = (char) (test[i] + n);

				// 영어 소문자 처리하고 소문자 범위를 벗어나면 '%'나머지 연산자를 이용하여 처리.
				if (test[i] > 'z' || test[i] < 'a') {
					n = n % 26;
					n = -(n + 26);
					test[i] = (char) (test[i] + n);
					n = N % 26;
					test[i] = (char) (test[i] + n);
				}

				
				
			// 영어 대문자 처리하는 부분
			} else if (test[i] <= 'Z' && test[i] >= 'A') {
				n = n % 26;
				test[i] = (char) (test[i] + n);

				// 영어 소문자 처리하고 대문자 범위를 벗어나면 '%'나머지 연산자를 이용하여 처리.
				if (test[i] > 'Z' || test[i] < 'A') {
					n = n % 26;
					n = -(n + 26);
					test[i] = (char) (test[i] + n);
					n = N % 26;
					test[i] = (char) (test[i] + n);
				}

				
				
			// 소문자, 대문자, 공백 이외의 값은 메시지를 띄우기로 함.
			} else {
				return "영어 소문자, 대문자 그리고 공백만 입력이 가능합니다.";
			}

			answer += test[i];
		}
		return answer;
	}

}
