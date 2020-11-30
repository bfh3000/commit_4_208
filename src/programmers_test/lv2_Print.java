package programmers_test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class lv2_Print {

	public static void main(String[] args) {
		// priorites : 현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열.
		// return : 내가 인쇄를 요청한 문서가 몇번째로 인쇄되는지의 값
		int[] avb00 = { 1, 1, 9, 1, 1, 1 }; // 6
		int[] avb01 = { 1, 1, 9, 1, 1 }; // 5
		int[] avb02 = { 9, 1, 1, 3, 2 }; // 42
		int[] avb03 = { 1, 5, 3, 4 }; // 1
		int[] avb04 = { 5, 5, 4, 9 }; // 3
		System.out.println(solution(avb03, 1));
	}

	public static int solution(int[] priorities, int location) {

		int answer = 0;
		Queue<Integer> que = new LinkedList<>();
		
		for (int i = 0; i < priorities.length; i++) {
			que.add(priorities[i]); 
		 }

		Arrays.sort(priorities); 
		int length = priorities.length - 1; 

		while (!que.isEmpty()) {
			int current = que.poll();
 
			if (current == priorities[length - answer]) {
				answer++;
				location--;
				if (location < 0) {
					break ;
				}
			} else {

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