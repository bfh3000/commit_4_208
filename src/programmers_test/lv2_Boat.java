package programmers_test;

import java.util.Arrays;

public class lv2_Boat {

	public static void main(String[] args) {
		
	}

	public int solution(int[] people, int limit) {
		 Arrays.sort(people);
	        int ship = 0; 
	        int first = 0; // Ã¹¹ø
	        int last = people.length-1;
	        
	        while(first<=last) {
	            if(people[first] + people[last] <= limit) {
	                first++;
	            }
	            last--;
	            ship++;
	        }
	        return ship;
	}
}