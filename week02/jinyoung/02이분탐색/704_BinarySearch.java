/*
 * 풀이 전략
 * - 배열이 오름차순으로 정렬되어 있으므로 이진탐색을 사용한다.
 * - 양 끝을 포함하는 [left, right]를 탐색 범위로 설정한다.
 * - 가운데 값이 target과 같으면 해당 인덱스를 반환한다.
 * - 가운데 값이 target보다 작으면 왼쪽 구간을 제외하고,
 *   크면 오른쪽 구간을 제외한다.
 * - 탐색 범위가 비면 target이 없으므로 -1을 반환한다.
 *
 * 시간 복잡도: O(log N)
 * - 반복마다 탐색 범위가 약 절반으로 줄어든다.
 * - 각 반복에서 수행하는 비교와 경계 갱신은 O(1)이다.
 *
 * 추가 공간 복잡도: O(1)
 * - 입력 크기와 관계없이 일정한 개수의 변수만 사용한다.
 */

class Solution704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
