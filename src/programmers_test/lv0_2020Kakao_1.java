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
        //for문을 나오면 open과 close가 같게되면 u(올바른 괄호)와 v(쌍만 맞은 괄호)로 나눠준다.
        String u = p.substring(0,i+1);
        String v = p.substring(i+1, p.length());
        //collect()함수로 String값이 있나 없나 체크를 하여 재귀함수를 쓴다.
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