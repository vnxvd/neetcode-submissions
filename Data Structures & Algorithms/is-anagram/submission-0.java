class Solution {
    public boolean isAnagram(String s, String t) {
       if (s.length() != t.length()) return false; 
       Map<Character, Integer> count = new HashMap();
       for (char c : s.toCharArray()) {
         count.put(c, count.getOrDefault(c, 0) + 1);
       }
       for (char c : t.toCharArray()) {
         count.put(c, count.getOrDefault(c, 0) - 1);
       }
       for (int i : count.values()) {
        if (i != 0) return false;
       }
       return true;
    }
}
