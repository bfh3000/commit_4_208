package programmers_test;

public class lv3_tile {

	public static void main(String[] args) {
		//1이면 (1+1+1+1) 	= 2  + 2 = 4
		//2이면 (2+2+1+1) 	= 4  + 2 = 6
		//3이면 (3+3+2+2) 	= 6  + 4 = 10
		//4이면 (5+5+3+3) 	= 10 + 6 = 16
		int solution = solution(test);
		System.out.println(solution);
	}


//test
	private static int solution(int a) {
		int sum = 0;
		int pre_sum1 = 0;
		int pre_sum2 = 0;
		int i = 1;
			while(i <= a) { 
				if(i==1) {
					pre_sum1 = 2;
					pre_sum2
					= 2;
					sum = pre_sum1 + pre_sum2;
					pre_sum2 = pre_sum1;
					pre_sum1 = sum;
				}else if(i==2){
					pre_sum2 = 2;
					sum = pre_sum1 + pre_sum2;
					pre_sum2 = pre_sum1;
					pre_sum1 = sum;
				}else {
					sum = pre_sum1 + pre_sum2;
					pre_sum2 = pre_sum1;
					pre_sum1 = sum;
					
				}
				i++;
			}
		return sum;
		
	}

}

