import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int startR = -1, startC = -1;
        int litterCount = 0;
        int[][] litterId = new int[m][n];
        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    startR = i;
                    startC = j;
                } else if (c == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        // If there's no litter in the classroom, 0 moves required
        if (litterCount == 0) return 0;

        int targetMask = (1 << litterCount) - 1;

        // maxEnergySeen[r][c][mask] stores the max remaining energy seen at state (r, c, mask)
        int[][][] maxEnergySeen = new int[m][n][1 << litterCount];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(maxEnergySeen[i][j], -1);
            }
        }

        // BFS Queue stores: {row, col, mask, currentEnergy}
        Queue<int[]> queue = new LinkedList<>();

        int initialMask = 0;
        if (litterId[startR][startC] != -1) {
            initialMask |= (1 << litterId[startR][startC]);
        }

        queue.offer(new int[]{startR, startC, initialMask, energy});
        maxEnergySeen[startR][startC][initialMask] = energy;

        int moves = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                int mask = curr[2];
                int remEnergy = curr[3];

                // Target state reached: all litter collected
                if (mask == targetMask) {
                    return moves;
                }

                // Cannot make a move if energy reaches 0
                if (remEnergy == 0) {
                    continue;
                }

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && classroom[nr].charAt(nc) != 'X') {
                        int nextEnergy = remEnergy - 1;
                        int nextMask = mask;

                        char cellType = classroom[nr].charAt(nc);

                        // Reset area restores energy back to full capacity
                        if (cellType == 'R') {
                            nextEnergy = energy;
                        }

                        // Collect litter if present
                        if (litterId[nr][nc] != -1) {
                            nextMask |= (1 << litterId[nr][nc]);
                        }

                        // Pruning: skip if we've reached this cell/mask combo with equal or more energy
                        if (nextEnergy > maxEnergySeen[nr][nc][nextMask]) {
                            maxEnergySeen[nr][nc][nextMask] = nextEnergy;
                            queue.offer(new int[]{nr, nc, nextMask, nextEnergy});
                        }
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}