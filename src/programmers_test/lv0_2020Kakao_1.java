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
        //for���� ������ open�� close�� ���ԵǸ� u(�ùٸ� ��ȣ)�� v(�ָ� ���� ��ȣ)�� �����ش�.
        String u = p.substring(0,i+1);
        String v = p.substring(i+1, p.length());
        //collect()�Լ��� String���� �ֳ� ���� üũ�� �Ͽ� ����Լ��� ����.
        if(collect(u)) {
            ret = u + func(v);
        }
        else {
            ret = "(" + func(v) + ")";
            for(int j = 1; j < u.length()-1; j++) {
                char c = u.charAt(j);
                if(c == '(') ret += ")";
                else ret += "(";
            }
        }
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