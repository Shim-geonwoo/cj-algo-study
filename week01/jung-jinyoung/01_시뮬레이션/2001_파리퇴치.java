/*
 * 전략
 *
 * 1. N x N 크기의 배열을 입력받는다.
 * 2. M x M 크기의 파리채를 놓을 수 있는 모든 시작 위치를 확인한다.
 * 3. 각 시작 위치에서 M x M 영역에 포함된 파리 수를 모두 더한다.
 * 4. 계산한 합 중 가장 큰 값을 정답으로 저장한다.
 *
 * 시간 복잡도: O((N - M + 1)^2 * M^2)
 * - 파리채를 놓을 수 있는 시작 위치는
 *   (N - M + 1)^2개이다.
 * - 각 위치에서 M^2개의 칸을 확인한다.
 *
 * 공간 복잡도: O(N^2)
 * - N x N 크기의 배열을 저장한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution2001 {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= testCount; tc++) {
            StringTokenizer st =
                    new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] map = new int[n][n];

            for (int row = 0; row < n; row++) {
                st = new StringTokenizer(br.readLine());

                for (int col = 0; col < n; col++) {
                    map[row][col] =
                            Integer.parseInt(st.nextToken());
                }
            }

            int maxFlies = 0;

            for (int startRow = 0;
                 startRow <= n - m;
                 startRow++) {

                for (int startCol = 0;
                     startCol <= n - m;
                     startCol++) {

                    int sum = 0;

                    for (int row = startRow;
                         row < startRow + m;
                         row++) {

                        for (int col = startCol;
                             col < startCol + m;
                             col++) {

                            sum += map[row][col];
                        }
                    }

                    maxFlies = Math.max(maxFlies, sum);
                }
            }

            output.append('#')
                  .append(tc)
                  .append(' ')
                  .append(maxFlies)
                  .append('\n');
        }

        System.out.print(output);
    }
}