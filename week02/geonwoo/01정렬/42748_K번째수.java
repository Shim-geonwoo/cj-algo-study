/*
 * 전략: 각 명령마다 array의 i~j번째 구간을 Arrays.copyOfRange로 잘라낸 뒤 정렬하고,
 *       정렬된 배열의 k번째 값(인덱스 k-1)을 answer에 저장한다.
 * 시간복잡도: O(C * N log N) (C: commands 길이, N: array 길이)
 */
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int c = 0; c < commands.length; c++) {
            int i = commands[c][0];
            int j = commands[c][1];
            int k = commands[c][2];

            int[] sliced = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(sliced);
            answer[c] = sliced[k - 1];
        }

        return answer;
    }
}
