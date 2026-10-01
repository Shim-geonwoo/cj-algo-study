import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] prices) {
        
        // 주식 길이만큼 정답 배열 초기화 
        int[] answer = new int[prices.length];
        
        // [인덱스, 주식가격] 저장할 큐 초기화
        Deque<int[]> stack = new ArrayDeque<>();
        // 순서대로 조회
        for (int i = 0 ; i < prices.length ; i++) {
            int stock = prices[i];
            
            // 스택이 비어있으면 추가 후 continue
            if (stack.isEmpty()){
                stack.push(new int[] {i, stock});
                continue;
            }
            
            // 가장 최근에 들어간 값과 비교 
            while (!stack.isEmpty()) {
                int[] last = stack.peek();
                // 이전가격보다 떨어졌으면
                if (last[1] > stock) {
                    // 해당 위치에 떨어지지 않은 기간 저장 
                    // 현재 위치 - 해당 주식 위치 
                    answer[last[0]] = i - last[0];
                    stack.pop();
                    continue;
                } 
                // 떨어지지 않았으면
                break;
            
            }
            
            // 현재 주식 저장
            stack.push(new int[] {i, stock});
            
            // 남은 주식 stack 조회 후 정답에 반영
            for (int[] rest : stack) {
                answer[rest[0]] = prices.length - rest[0] - 1;
            }
            
        }
        return answer;
    }
}