class Solution {
    public int numMatchingSubseq(String s, String[] words) {
    List<int[]>[] heads = new List[26];
    for (int i = 0; i < 26; i++) {
        heads[i] = new ArrayList<>();
    }

    for (int i = 0; i < words.length; i++) {
        heads[words[i].charAt(0) - 'a'].add(new int[]{i, 0});
    }

    int count = 0;

    for (char c : s.toCharArray()) {
        List<int[]> oldBucket = heads[c - 'a'];
        heads[c - 'a'] = new ArrayList<>();

        for (int[] node : oldBucket) {
            int wordIdx = node[0];
            int charIdx = node[1] + 1;

            if (charIdx == words[wordIdx].length()) {
                count++;
            } else {
                heads[words[wordIdx].charAt(charIdx) - 'a'].add(new int[]{wordIdx, charIdx});
            }
        }
    }

    return count;
  }
}