/*
 * 풀이 전략
 * - 배열이 오름차순으로 정렬되어 있으므로 경계 탐색을 사용한다.
 * - lowerBound로 target 이상인 첫 위치를 찾는다.
 * - upperBound로 target보다 큰 첫 위치를 찾는다.
 * - 두 탐색 모두 오른쪽 끝을 제외하는 [left, right] 구간을 사용하며,
 *   조건을 만족하는 원소가 없으면 배열 길이 N을 반환한다.
 * - lower가 N이거나 nums[lower]가 target과 다르면
 *   target이 존재하지 않으므로 [-1, -1]을 반환한다.
 * - target이 존재하면 첫 위치는 lower,
 *   마지막 위치는 upper - 1이므로 [lower, upper - 1]을 반환한다.
 *
 * 시간 복잡도: O(log N)
 * - 각 경계 탐색은 반복마다 탐색 범위를 약 절반으로 줄인다.
 * - 두 번 탐색하므로 O(log N) + O(log N) = O(log N)이다.
 *
 * 추가 공간 복잡도: O(1)
 * - 입력 크기와 관계없이 일정한 개수의 변수와
 *   길이가 2인 결과 배열만 사용한다.
 */

class Solution34 {
    // target 이상인 범위를 찾아 시작 인덱스 left를 반환하는 함수
    public int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length ;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // target을 초과하는 시작 인덱스를 찾는 함수
    public int upperBound(int[] nums, int target) {
        int left = 0 ;
        int right = nums.length ;

        while (left < right) {
            int mid = left + (right - left) / 2 ;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int[] searchRange(int[] nums, int target) {
        // 정답 배열 초기화
        int[] answer = new int[2];
        // 이상, 초과 시작 인덱스 찾기
        int lower = lowerBound(nums, target);
        int upper = upperBound(nums, target);

        // 시작 인덱스를 확인 : 타겟이 아니거나, 못찾았으면 [-1, -1 반환]
        if (lower == nums.length || nums[lower] != target) {
            answer[0] = -1;
            answer[1] = -1;
            return answer;
        }

        answer[0] = lower;
        answer[1] = upper - 1; // 초과 바로 앞까지가 범위이기 때문

        return answer;

    }
}
