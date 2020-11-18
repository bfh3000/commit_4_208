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
	        int first = 0; // ù��
	        int last = people.length-1;

	        
	        while(first<=last) {
	            //������ �ʰ����� �ʴ´ٸ�, �����ϱ� ������ �� ����� ����. ù��°���� �������� first++�� �ִ´�.  
	        	if(people[first] + people[last] <= limit) {
	                first++;
	            }
	        	//�� ����� ���� ������ �ʰ��߱� ������, ������ ����� ���� ���ſ������ ������ �Ǿ��⶧����, ������ ����� ���� �������� last-- ���ش�.
	            last--;
	            
	            
	            ship++;
	        }
	        return ship;
	}
}