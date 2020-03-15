package programmers_test;

import java.util.LinkedList;
import java.util.Queue;

public class lv0_2020Kakao_1 {
	public static void main(String[] args) {
		System.out.println(solution("())("));
	}
	
    public static String solution(String p) {
        String answer = "";
        if(p.equals("") || p==null) return "";
        answer = func(p);
        return answer;
    }

    public static String func(String p) {
        String ret = "";
        if(p.equals("")) return ret;
        int open = 0;
        int close = 0;
        int i;
        for(i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            if(ch == '(') open++;
            else close++;
            if(open == close) {
                break;              
            }
        }
//		for���� ������ open�� close�� ���ԵǸ� 
//				u�� "�������� ��ȣ ���ڿ�"�� �� �̻� �и��� �� ����� �ϴ� �����̰�, 
//				v�� �� ���ڿ��� ""(��)���� �� �� �ִ� �������� �����ش�.
        String u = p.substring(0,i+1);
        String v = p.substring(i+1, p.length());
        
        //3. ���ڿ� u�� "�ùٸ� ��ȣ ���ڿ�" �̶�� ���ڿ� v�� ���� 1�ܰ���� �ٽ� ����. 
        if(collect(u)) {
            ret = u + func(v);
        }
        //4. ���ڿ� u�� "�ùٸ� ��ȣ ���ڿ�"�� �ƴ϶�� �Ʒ� ������ ����.         
        else {
        	
        	// 4-1. �� ���ڿ��� ù ��° ���ڷ� '('�� ���δ�.
        	// 4-2. ���ڿ� v�� ���� 1�ܰ���� ��������� ������ ��� ���ڿ��� �̾� ���δ�. 
        	// 4-3. ')'�� �ٽ� ���δ�. 
            ret = "(" + func(v) + ")";
            
            // 4-4. u�� ù ��°�� ������ ���ڸ� �����ϰ�, ������ ���ڿ��� ��ȣ ������ ����� �ڿ� ���Դϴ�. 
            for(int j = 1; j < u.length()-1; j++) {
                char c = u.charAt(j);
                if(c == '(') ret += ")";
                else ret += "(";
            }
        }
        //4-5. ������ ���ڿ��� ��ȯ�մϴ�.
        return ret;
    }

    public static boolean collect(String s) {
        Queue<Character> q = new LinkedList<>();        
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                q.add(ch);
            }
            else {
                if(q.isEmpty()) return false;
                q.poll();
            }
        }
        return true;
    }
}