class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> count = new HashMap();
        int l = 0, r = 0, maxCount = 0, res = 0;
        
        while (r < s.length()) {
          char rc = s.charAt(r);
          count.put(rc, count.getOrDefault(rc, 0) + 1);
          maxCount = Math.max(maxCount, count.get(rc));
          while(r - l + 1 - maxCount > k) {
            char lc = s.charAt(l);
            count.put(lc, count.get(lc) - 1);
            l++;
          }
          res = Math.max(res, r - l + 1);
          r++;
        }

        return res;
    }
}
