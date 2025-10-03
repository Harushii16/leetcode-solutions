import java.util.*;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m <= 2 || n <= 2) return 0; // no space to trap water

        boolean[][] vis = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        // Step 1: Push all boundary cells
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            vis[i][0] = vis[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            vis[0][j] = vis[m - 1][j] = true;
        }

        int ans = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: Process heap
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int x = cell[0], y = cell[1], h = cell[2];

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny]) continue;

                vis[nx][ny] = true;
                // If neighbor is lower, water can be trapped
                if (heightMap[nx][ny] < h) {
                    ans += h - heightMap[nx][ny];
                }
                // push neighbor with max of its height and current water level
                pq.offer(new int[]{nx, ny, Math.max(heightMap[nx][ny], h)});
            }
        }

        return ans;
    }
}
