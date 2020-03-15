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
//		for문을 나오면 open과 close가 같게되면 
//				u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하는 조건이고, 
//				v는 빈 문자열이 ""(빈)값도 될 수 있는 조건으로 나눠준다.
        String u = p.substring(0,i+1);
        String v = p.substring(i+1, p.length());
        
        //3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행. 
        if(collect(u)) {
            ret = u + func(v);
        }
        //4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행.         
        else {
        	
        	// 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙인다.
        	// 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙인다. 
        	// 4-3. ')'를 다시 붙인다. 
            ret = "(" + func(v) + ")";
            
            // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
            for(int j = 1; j < u.length()-1; j++) {
                char c = u.charAt(j);
                if(c == '(') ret += ")";
                else ret += "(";
            }
        }
        //4-5. 생성된 문자열을 반환합니다.
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