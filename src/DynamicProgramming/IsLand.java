package DynamicProgramming;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author make
 * @desc 小岛问题。
 */
public class IsLand {
    public int numIsLands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] visited = new boolean[row][column];
        int number = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, i, j, visited);
                    number++;
                }
            }
        }
        return number;
    }

    /**
     * 宽度优先算法。
     *
     * @param grid
     * @param i
     * @param j
     * @param visited
     */
    public void bfs(char[][] grid, int i, int j, boolean[][] visited) {
        //设置上下左右的移动。
        int[] kx = {1, -1, 0, 0};
        int[] ky = {0, 0, 1, -1};
        visited[i][j] = true;
        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();
        xQueue.offer(i);
        yQueue.offer(j);
        while (!xQueue.isEmpty()) {
            int currentX = xQueue.poll();
            int currentY = yQueue.poll();
            for (int k = 0; k < 4; k++) {
                int newX = currentX + kx[k];
                int newY = currentY + ky[k];
                if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && !visited[newX][newY]) {
                    if (grid[newX][newY] == '1') {
                        xQueue.offer(newX);
                        yQueue.offer(newY);
                        visited[newX][newY] = true;
                    }
                }

            }
        }
    }
}
