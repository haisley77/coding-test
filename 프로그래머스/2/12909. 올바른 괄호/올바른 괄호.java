import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack();
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                stack.push(cur);
            }
            if (cur == ')') {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                }
                if (stack.peek() == ')') {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }
        
        if (answer) answer = stack.isEmpty();
        return answer;
    }
}