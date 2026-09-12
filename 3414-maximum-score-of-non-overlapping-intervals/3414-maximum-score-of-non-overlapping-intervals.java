class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
    int n = intervals.size();
    int[][] sorted = new int[n][4];
    for (int i = 0; i < n; i++) {
        List<Integer> interval = intervals.get(i);
        sorted[i][0] = interval.get(0);
        sorted[i][1] = interval.get(1);
        sorted[i][2] = interval.get(2);
        sorted[i][3] = i;
    }

    Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));

    int[] starts = new int[n];
    for (int i = 0; i < n; i++) {
        starts[i] = sorted[i][0];
    }

    int[] nextIdx = new int[n];
    for (int i = 0; i < n; i++) {
        int end = sorted[i][1];
        int l = i + 1, r = n, ans = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (starts[mid] > end) {
                ans = mid;
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        nextIdx[i] = ans;
    }

    long[][] dp = new long[n + 1][5];
    List<Integer>[][] bestIndices = new List[n + 1][5];

    for (int i = 0; i <= n; i++) {
        for (int k = 0; k <= 4; k++) {
            bestIndices[i][k] = new ArrayList<>();
        }
    }

    for (int i = n - 1; i >= 0; i--) {
        for (int k = 0; k <= 4; k++) {
            dp[i][k] = dp[i + 1][k];
            bestIndices[i][k] = new ArrayList<>(bestIndices[i + 1][k]);

            if (k > 0) {
                int nxt = nextIdx[i];
                long takeWeight = (long) sorted[i][2] + dp[nxt][k - 1];
                List<Integer> takeIndices = new ArrayList<>();
                takeIndices.add(sorted[i][3]);
                takeIndices.addAll(bestIndices[nxt][k - 1]);
                Collections.sort(takeIndices);

                if (takeWeight > dp[i][k]) {
                    dp[i][k] = takeWeight;
                    bestIndices[i][k] = takeIndices;
                } else if (takeWeight == dp[i][k]) {
                    if (isLexicographicallySmaller(takeIndices, bestIndices[i][k])) {
                        bestIndices[i][k] = takeIndices;
                    }
                }
            }
        }
    }

    long maxWeight = 0;
    List<Integer> ansIndices = new ArrayList<>();

    for (int k = 1; k <= 4; k++) {
        if (dp[0][k] > maxWeight) {
            maxWeight = dp[0][k];
            ansIndices = bestIndices[0][k];
        } else if (dp[0][k] == maxWeight) {
            if (isLexicographicallySmaller(bestIndices[0][k], ansIndices)) {
                ansIndices = bestIndices[0][k];
            }
        }
    }

    int[] result = new int[ansIndices.size()];
    for (int i = 0; i < ansIndices.size(); i++) {
        result[i] = ansIndices.get(i);
    }
    return result;
}

private boolean isLexicographicallySmaller(List<Integer> a, List<Integer> b) {
    if (b.isEmpty()) return true;
    int minLen = Math.min(a.size(), b.size());
    for (int i = 0; i < minLen; i++) {
        if (!a.get(i).equals(b.get(i))) {
            return a.get(i) < b.get(i);
        }
    }
    return a.size() < b.size();
  }
}