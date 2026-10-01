/*
     * 전략
     *
     * 1. 각 기능이 완료되기까지 필요한 날짜를 계산한다.
     * 2. 계산한 완료일을 작업 순서대로 큐에 저장한다.
     * 3. 큐의 첫 번째 완료일을 현재 배포 기준일로 설정한다.
     * 4. 다음 기능의 완료일이 현재 배포 기준일 이하라면
     *    현재 기능과 함께 배포할 수 있으므로 배포 개수를 증가시킨다.
     * 5. 다음 기능의 완료일이 기준일보다 크다면 현재 배포 그룹의
     *    개수를 결과에 저장하고, 다음 기능부터 새로운 그룹을 시작한다.
     * 6. 큐를 모두 처리한 후 마지막 배포 그룹의 개수를 결과에 추가한다.
     * 7. List<Integer>에 저장한 결과를 int[]로 변환하여 반환한다.
     *
     * 시간 복잡도: O(N)
     * - N은 기능의 개수이다.
     * - 각 기능의 완료일을 한 번 계산하고 큐에 한 번 넣는다.
     * - 각 완료일을 큐에서 한 번씩 꺼내므로 전체 연산은 N에 비례한다.
     *
     * 공간 복잡도: O(N)
     * - 완료일을 저장하는 큐가 최대 N개의 값을 저장한다.
     * - 배포 결과를 저장하는 리스트도 최악의 경우 N개의 값을 저장한다.
     */


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> queue = new ArrayDeque<>();

        // 각 기능이 완료되기까지 필요한 날짜를 계산한다.
        for (int i = 0; i < progresses.length; i++) {
            int remaining = 100 - progresses[i];

            // 정수 나눗셈을 이용한 올림 계산
            int days = (remaining + speeds[i] - 1) / speeds[i];

            queue.offer(days);
        }

        List<Integer> result = new ArrayList<>();

        // 첫 번째 기능의 완료일을 현재 배포 기준일로 설정한다.
        int releaseDay = queue.poll();
        int count = 1;

        while (!queue.isEmpty()) {
            int nextDay = queue.peek();

            // 다음 기능이 현재 배포일까지 완성된다면 함께 배포한다.
            if (nextDay <= releaseDay) {
                queue.poll();
                count++;
            } else {
                // 현재 배포 그룹의 기능 개수를 저장한다.
                result.add(count);

                // 다음 기능부터 새로운 배포 그룹을 시작한다.
                releaseDay = queue.poll();
                count = 1;
            }
        }

        // 반복문에서 저장되지 않은 마지막 배포 그룹을 추가한다.
        result.add(count);

        // List<Integer>를 int[]로 변환한다.
        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}