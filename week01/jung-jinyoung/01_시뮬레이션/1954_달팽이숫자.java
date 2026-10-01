/*
 * 전략
 *
 * 1. (0, 0)에서 시작하여 오른쪽으로 이동한다.
 * 2. 현재 위치에 1부터 N * N까지 숫자를 차례대로 저장한다.
 * 3. 다음 위치가 배열 범위를 벗어나거나 이미 숫자가 저장된
 *    위치라면 시계 방향으로 방향을 전환한다.
 * 4. 오른쪽, 아래, 왼쪽, 위 순서로 이동하면서
 *    모든 칸을 채운다.
 *
 * 시간 복잡도: O(N^2)
 * - N x N 배열의 각 칸을 한 번씩 채운다.
 *
 * 공간 복잡도: O(N^2)
 * - 완성된 달팽이 숫자를 저장할 이차원 배열이 필요하다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {


    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        for (int tc = 1; tc <= testCount; tc++) {
            int n = Integer.parseInt(br.readLine());

            int[][] snail = new int[n][n];

            int row = 0;
            int col = 0;
            int direction = 0;

            for (int number = 1;
                 number <= n * n;
                 number++) {

                snail[row][col] = number;

                int nextRow = row + dr[direction];
                int nextCol = col + dc[direction];

                boolean outOfRange =
                        nextRow < 0 || nextRow >= n
                        || nextCol < 0 || nextCol >= n;

                boolean alreadyFilled =
                        !outOfRange
                        && snail[nextRow][nextCol] != 0;

                if (outOfRange || alreadyFilled) {
                    direction = (direction + 1) % 4;

                    nextRow = row + dr[direction];
                    nextCol = col + dc[direction];
                }

                row = nextRow;
                col = nextCol;
            }

            output.append('#')
                  .append(tc)
                  .append('\n');

            for (int[] line : snail) {
                for (int i = 0; i < n; i++) {
                    if (i > 0) {
                        output.append(' ');
                    }

                    output.append(line[i]);
                }

                output.append('\n');
            }
        }

        System.out.print(output);
    }
}