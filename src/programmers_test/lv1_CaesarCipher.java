package programmers_test;

public class lv1_CaesarCipher {
	// 1. ���ĺ��� 26���� ���� �̿�.
	// 2. 1���� �̿��Ͽ� '%' �������� �̿��Ͽ� ó����.
	public static void main(String[] args) {
		System.out.println(solution2("A a z Z b B ", 1));

	}

	public static String solution2(String a, int n) {
		String answer = "";
		char[] test = new char[a.length()];
		int N = n;

		// ���ڿ��� �׽�Ʈ�� �ϳ��� ��´�..
		for (int i = 0; i < a.length(); i++) {
			test[i] = a.charAt(i);
		}

		
		//���ڿ� ó�� ����.
		for (int i = 0; i < a.length(); i++) {

			// ������ �״�� ����ó��.
			if (test[i] == ' ') {
				test[i] = test[i];

				
				
			// ���� �ҹ��� ó���ϴ� �κ�
			} else if (test[i] <= 'z' && test[i] >= 'a') {
				n = n % 26;
				test[i] = (char) (test[i] + n);

				// ���� �ҹ��� ó���ϰ� �ҹ��� ������ ����� '%'������ �����ڸ� �̿��Ͽ� ó��.
				if (test[i] > 'z' || test[i] < 'a') {
					n = n % 26;
					n = -(n + 26);
					test[i] = (char) (test[i] + n);
					n = N % 26;
					test[i] = (char) (test[i] + n);
				}

				
				
			// ���� �빮�� ó���ϴ� �κ�
			} else if (test[i] <= 'Z' && test[i] >= 'A') {
				n = n % 26;
				test[i] = (char) (test[i] + n);

				// ���� �ҹ��� ó���ϰ� �빮�� ������ ����� '%'������ �����ڸ� �̿��Ͽ� ó��.
				if (test[i] > 'Z' || test[i] < 'A') {
					n = n % 26;
					n = -(n + 26);
					test[i] = (char) (test[i] + n);
					n = N % 26;
					test[i] = (char) (test[i] + n);
				}

				
				
			// �ҹ���, �빮��, ���� �̿��� ���� �޽����� ����� ��.
			} else {
				return "���� �ҹ���, �빮�� �׸��� ���鸸 �Է��� �����մϴ�.";
			}

			answer += test[i];
		}
		return answer;
	}

}
