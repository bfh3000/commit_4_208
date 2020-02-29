package programmers_test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class lv2_Print {

	public static void main(String[] args) {
		// priorites : 현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열.
		// return : 내가 인쇄를 요청한 문서가 몇번째로 인쇄되는지의 값
		// location : 위치 ( 0부터 시작 )
		// 여↓기
		int[] avb00 = { 1, 1, 9, 1, 1, 1 }; // 6
		int[] avb01 = { 1, 1, 9, 1, 1 }; // 5
		int[] avb02 = { 9, 1, 1, 3, 2 }; // 4
		int[] avb03 = { 1, 5, 3, 4 }; // 1
		int[] avb04 = { 5, 5, 4, 9 }; // 3
		System.out.println(solution(avb04, 1));
	}

	//나의 실패한 코드
	public static int solution2(int[] priorities, int location) {
		int defalt[] = new int[priorities.length];
		int test[] = new int[priorities.length];
		//test = priorities;
		defalt = priorities;
		int count = 0;
		int result = 0;

		 for (int i = 0; i < priorities.length; i++) {
			 test[i] = priorities[i];
		 }

		Arrays.sort(defalt); // 우선순위를 비교하기 위해 오름 차순 정렬
		int max = priorities[priorities.length - 1]; // 오름차순 한 마지막 요소가 가장 큰 수

		if (defalt[location] < max) {
			for (int j = 0; j < priorities.length; j++) {
				if (test[j] == max) {
					test[j] = 0;
					count++;
				}
			}
		} else if (defalt[location] == max) {
			result = location + count;
		} else {

		}
		return result;
	}
	//큐는 이해가 안가.. .
	// 1-1) {5, 5, 4, 9}
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

		// 커뮤니티 제출한 코드
	public static int solution(int[] priorities, int location) {

		int answer = 0;

		Queue<Integer> que = new LinkedList<>();

		for (int pri : priorities) {
			que.add(pri);
		}

		Arrays.sort(priorities); // 우선순위를 비교하기 위해 오름 차순 정렬
		int length = priorities.length - 1; // 오름차순 한 마지막 요소가 가장 큰 수

		while (!que.isEmpty()) {
			int current = que.poll();

			// 우선순위가 가장 높은 수 == 현재 큐에 담긴 (프린트 순서)가 같으면
			if (current == priorities[length - answer]) {
				answer++;
				location--;
				if (location < 0) {
					break ;
				}
			} else {
				// 처음에 que.poll을 했던 수를 add 함으로써 맨 뒤로 밀림
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