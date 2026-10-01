
class Solution {
    public int[] solution(String s) {
        // [이진법 변환 횟수, 제거된 모든 0의 개수 ]
        int[] answer = new int[2];
                
        // s 가 "1"이 될 때 까지 
        while (s.length() > 1) {
            // 1의 개수 == 제거 후 길이 
            int l = 0;
            for (char c : s.toCharArray()){
                // 0 이면 추가하지 않고 제거 횟수 증가
                if (c == '0') {
                    answer[1] ++;
                } else {
                    l++;
                }
            }
            
            // 길이를 이진법으로 변환 후 s 문자열 변경 후 횟수 추가
            s = Integer.toBinaryString(l);     
            answer[0]++;
        }
        return answer;
    }
}