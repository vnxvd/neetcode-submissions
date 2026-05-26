class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder();
        int longest = 0;
        for (char c : s.toCharArray()) {
            String cs = String.valueOf(c);
            int i = sb.indexOf(cs);
            if(i >= 0) {
               sb = sb.delete(0, i + 1);
            }
            sb.append(cs);
            longest = Math.max(longest, sb.length());
        }
        return longest;
    }
}
