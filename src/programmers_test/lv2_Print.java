package programmers_test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class lv2_Print {
	// 1. ���ĺ��� 26���� ���� �̿�.
	// 2. 1���� �̿��Ͽ� '%' �������� �̿��Ͽ� ó����.
	public static void main(String[] args) {
		
		//priorites : ���� ����Ͽ� �ִ� ������ �߿䵵�� ������� ��� �迭.
		//return : ���� �μ⸦ ��û�� ������ ���°�� �μ�Ǵ����� ��
		//location : ��ġ ( 0���� ���� )
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

        Arrays.sort(priorities); //�켱������ ���ϱ� ���� ���� ���� ����
        int length = priorities.length-1; //�������� �� ������ ��Ұ� ���� ū �� 

        while(!que.isEmpty()){
            int current = que.poll();

            //�켱������ ���� ���� �� == ���� ť�� ��� (����Ʈ ����)�� ������
            if(current == priorities[length - answer]){
                answer++;
                location--;
                if(location<0){
                    break;
                }
            }else{
                //ó���� que.poll�� �ߴ� ���� add �����ν� �� �ڷ� �и�
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