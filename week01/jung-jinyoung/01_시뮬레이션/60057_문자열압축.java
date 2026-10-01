/*
 * 전략
 *
 * 1. 문자열을 자르는 단위를 1부터 문자열 길이의 절반까지
 *    하나씩 변경하며 모든 경우를 확인한다.
 * 2. 문자열의 맨 앞부터 선택한 단위만큼 잘라 비교한다.
 * 3. 이전 문자열 조각과 현재 문자열 조각이 같으면
 *    반복 횟수를 증가시킨다.
 * 4. 두 문자열 조각이 다르면 지금까지 센 반복 횟수와
 *    이전 문자열 조각을 압축 결과에 추가한다.
 * 5. 반복 횟수가 1이면 숫자 1은 생략한다.
 * 6. 각 단위로 만든 압축 문자열의 길이 중 최솟값을 반환한다.
 *
 * 시간 복잡도: O(N^2)
 * - 최대 N / 2개의 압축 단위를 확인한다.
 * - 각 단위마다 전체 문자열을 순회하고 문자열 조각을 비교한다.
 *
 * 공간 복잡도: O(N)
 * - 각 압축 단위의 결과를 저장하는 StringBuilder가
 *   최대 문자열 길이에 비례하는 공간을 사용한다.
 */

class Solution {
    public int solution(String s) {
        int length = s.length();

        if (length == 1) {
            return 1;
        }

        int minLength = length;

        for (int unit = 1; unit <= length / 2; unit++) {
            StringBuilder compressed = new StringBuilder();

            String previous = s.substring(0, unit);
            int count = 1;

            for (int start = unit;
                 start < length;
                 start += unit) {

                int end = Math.min(start + unit, length);
                String current = s.substring(start, end);

                if (previous.equals(current)) {
                    count++;
                } else {
                    appendCompressed(
                            compressed,
                            previous,
                            count
                    );

                    previous = current;
                    count = 1;
                }
            }

            appendCompressed(compressed, previous, count);

            minLength = Math.min(
                    minLength,
                    compressed.length()
            );
        }

        return minLength;
    }

    private void appendCompressed(
            StringBuilder compressed,
            String value,
            int count
    ) {
        if (count > 1) {
            compressed.append(count);
        }

        compressed.append(value);
    }
}