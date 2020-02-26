package programmers_test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class lv2_Print {
	// 1. 알파벳이 26개인 것을 이용.
	// 2. 1번을 이용하여 '%' 나머지를 이용하여 처리함.
	public static void main(String[] args) {
		
		//priorites : 현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열.
		//return : 내가 인쇄를 요청한 문서가 몇번째로 인쇄되는지의 값
		//location : 위치 ( 0부터 시작 )
		int[] avb00 = {1, 1, 9, 1, 1, 1}; 	// 5
		int[] avb01 = {1, 1, 9, 1, 1}; 		// 4
		int[] avb02 = {9, 1, 1, 3, 2}; 		// 5
		
		System.out.println(solution(avb02, 2));

	}
	public static int solution(int[] priorities, int location) {
	
        int answer = 0;

        Queue<Integer> que = new LinkedList<>();

        for(int pri : priorities){
            que.add(pri);
        }

        Arrays.sort(priorities); //우선순위를 비교하기 위해 오름 차순 정렬
        int length = priorities.length-1; //오름차순 한 마지막 요소가 가장 큰 수 

        while(!que.isEmpty()){
            int current = que.poll();

            //우선순위가 가장 높은 수 == 현재 큐에 담긴 (프린트 순서)가 같으면
            if(current == priorities[length - answer]){
                answer++;
                location--;
                if(location<0){
                    break;
                }
            }else{
                //처음에 que.poll을 했던 수를 add 함으로써 맨 뒤로 밀림
                que.add(current);
                location--; // 1
                if(location<0){
                    location = que.size()-1;
                }
            }
        }
        return answer;
    }
}