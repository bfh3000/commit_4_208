package programmers_test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class loop_test {

	public static void main(String[] args) {
		
		String[] test_list = new String[]{"1", "2", "3"};
		String[] test_list2 = new String[]{"1", "2", "5"};
		
		List<String> same_list_value = new ArrayList<String>();
				
		loop:
			
			for(int j=0; j<test_list.length; j++){
				System.out.println(test_list[i]);
				System.out.println(test_list2[j]);
				if(test_list2[j] == test_list[i]) {
					same_list_value.add(test_list[i]);
					break loop;
				}
			}
		}
		
		System.out.println(same_list_value);
	}

}
