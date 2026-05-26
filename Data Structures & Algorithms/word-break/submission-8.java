class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return canBreak(s, new HashSet<>(wordDict), 0, memo);
    }

    private boolean canBreak(String s, Set<String> words, int begin, Boolean[] memo) {
        if (begin == s.length()) return true;
        if (memo[begin] != null) return memo[begin];
        for (int end = begin + 1; end <= s.length(); end++) {
            if (words.contains(s.substring(begin, end)) && canBreak(s, words, end, memo)) {
                memo[begin] = true;
                return true;
            }
        }
        memo[begin] = false;
        return false;
    }
}
