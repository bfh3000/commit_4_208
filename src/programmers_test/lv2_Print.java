package programmers_test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class lv2_Print {

	public static void main(String[] args) {

		// priorites : ���� ����Ͽ� �ִ� ������ �߿䵵�� ������� ��� �迭.
		// return : ���� �μ⸦ ��û�� ������ ���°�� �μ�Ǵ����� ��
		// location : ��ġ ( 0���� ���� )

		// �����
		int[] avb00 = { 1, 1, 9, 1, 1, 1 }; // 6
		int[] avb01 = { 1, 1, 9, 1, 1 }; // 5
		int[] avb02 = { 9, 1, 1, 3, 2 }; // 4
		int[] avb03 = { 1, 5, 3, 4 }; // 1
		int[] avb04 = { 5, 5, 4, 9 }; // 3

		System.out.println(solution3(avb04, 1));

		// 1-1) {5, 5, 4, 9}
		// 1-2) {4, 5, 5, 9} // ���� ���� ����
		// 2) {5, 5, 4, 0} count ++
		// 3) {5, 5, 4, 9} result = count + (location+1)

		// 1-1) {9, 1, 1, 3, 2}
		// 1-2) {1, 1, 2, 3, 9} ���� ���� ����
		// 1-3) {1, 1, 2, 3, 0} �ƽ��� 0���� �ϰ� �� count ++
		// 2-1) {0, 1, 1, 2, 3} ���� ���� ����
		// 2-2) {0, 1, 1, 2, 0} �ƽ��� 0���� �ϰ� �� count ++
		// 3-1) {0, 0, 1, 1, 2} ���� ���� ����
		// 3-2) {0, 0, 1, 1, 0} �ƽ��� 0���� �ϰ� �� count ++
		// 4-1) {0, 0, 0, 1, 1} ���� ���� ����
		// 3) {1, 1, 2, 3, 9} max���� location�� ���� �����Ƿ� result = count +
		// (location+1) �� : 4
	}

	public static int solution2(int[] priorities, int location) {
		int defalt[] = new int[priorities.length];
		defalt = priorities;
		int test[] = new int[priorities.length];
		test = defalt;
		int count = 0;
		int result = 0;

		// for (int i = 0; i < priorities.length; i++) {
		// test[i] = priorities[i];

		Arrays.sort(priorities); // �켱������ ���ϱ� ���� ���� ���� ����
		int max = priorities[priorities.length - 1]; // �������� �� ������ ��Ұ� ���� ū ��

		if (defalt[location] < max) {
			for (int j = 0; j < priorities.length; j++) {
				if (test[j] == max) {
					test[j] = 0;
					count++;
				}
			}
		} else if (defalt[location] >= max) {
			result = location + count;
		} else {

		}
		return result;
	}

		public static int solution3(int[] priorities, int location) {
			int answer = 0;
			LinkedList<Integer> q = new LinkedList<Integer>();

			for (int t : priorities) {
				q.addLast(t);
			}

			while (!q.isEmpty()) {
				int item = q.removeFirst();
				boolean isPrint = true;

				for (int t : q) {
					if (item < t) {
						isPrint = false;
						break;
					}
				}
				if (isPrint) {
					if (location == 0) {
						return answer + 1;
					} else {
						answer++;
					}
				} else {
					q.addLast(item);
				}

				location--;
				if (location < 0) {
					location = q.size() - 1;
				}
			}
			return answer;
		}

		
	public static int solution(int[] priorities, int location) {

		int answer = 0;

		Queue<Integer> que = new LinkedList<>();

		for (int pri : priorities) {
			que.add(pri);
		}

		Arrays.sort(priorities); // �켱������ ���ϱ� ���� ���� ���� ����
		int length = priorities.length - 1; // �������� �� ������ ��Ұ� ���� ū ��

		while (!que.isEmpty()) {
			int current = que.poll();

			// �켱������ ���� ���� �� == ���� ť�� ��� (����Ʈ ����)�� ������
			if (current == priorities[length - answer]) {
				answer++;
				location--;
				if (location < 0) {
					break;
				}
			} else {
				// ó���� que.poll�� �ߴ� ���� add �����ν� �� �ڷ� �и�
				que.add(current);
				location--; // 1
				if (location < 0) {
					location = que.size() - 1;
				}
			}
		}
		return answer;
	}
}