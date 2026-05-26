class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, maxCount = 0, longest = 0;
        for (int right = 0; right < s.length(); right++) {
          char current = s.charAt(right);
          freq.merge(current, 1, Integer::sum);
          maxCount = Math.max(maxCount, freq.get(current));
          while (right - left + 1 - maxCount > k) {
            freq.merge(s.charAt(left), -1, Integer::sum);
            left++;
          }
          longest = Math.max(longest, right - left + 1); 
        }
        return longest;
    }
}
