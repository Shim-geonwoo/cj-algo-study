
/*
 * 전략
 * 1. 문자열을 왼쪽부터 한 글자씩 확인한다.
 * 2. 여는 괄호 '('를 만나면 스택에 저장한다.
 * 3. 닫는 괄호 ')'를 만나면 스택의 여는 괄호와 짝을 맞춰 제거한다.
 * 4. 닫는 괄호를 처리할 수 없는 상태라면 올바르지 않은 괄호 문자열이다.
 * 5. 모든 문자를 처리한 후 스택이 비어 있어야 모든 괄호가 짝을 이룬 것이다.
 *
 * 시간 복잡도: O(n)
 * - 길이가 n인 문자열을 한 번 순회한다.
 * - ArrayDeque의 push, pop, peek는 평균 O(1)이다.
 *
 * 공간 복잡도: O(n)
 * - 최악의 경우 모든 문자가 '('여서 n개의 문자가 스택에 저장된다.
 */

import java.util.Deque;
import java.util.ArrayDeque;
    

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            
            // 스택이 비어 있으면 push 
            if(stack.isEmpty()){
                stack.push(c);
                continue;
            }

            // 스택 top 확인 
            char top = stack.peek();
            
            if (top == ')') { 
                return false;
            } else {
                if (c == ')') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }            
        }
        
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}