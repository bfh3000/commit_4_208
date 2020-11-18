package programmers_test;

import java.util.Arrays;

public class lv2_Boat {

	public static void main(String[] args) {
		int[] people = {30, 40, 60, 30, 100};
		System.out.println(solution(people, 100));
	}
	public static int solution(int[] people, int limit) {
		 Arrays.sort(people);
	        int ship = 0; 
	        int first = 0; // 첫번
	        int last = people.length-1;

	        
	        while(first<=last) {
	            //제한을 초과하지 않는다면, 충족하기 때문에 두 사람을 뺀다. 첫번째빼는 조건으로 first++을 넣는다.  
	        	if(people[first] + people[last] <= limit) {
	                first++;
	            }
	        	//두 사람의 합이 제한을 초과했기 때문에, 마지막 사람이 가장 무거운식으로 정렬이 되었기때문에, 마지막 사람을 빼는 조건으로 last-- 해준다.
	            last--;
	            
	            
	            ship++;
	        }
	        return ship;
	}
}