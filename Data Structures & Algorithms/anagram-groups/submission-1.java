class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap();
        for (String s : strs) {
              boolean isAnagram = false;   
              for(Map.Entry<String, List<String>> entry : groups.entrySet()) {
                if (isAnagram(entry.getKey(), s)) {
                    entry.getValue().add(s);  
                    isAnagram = true;
                    break;
                } 
              };
              if (!isAnagram) {
               List<String> list = new ArrayList(); 
               list.add(s);
               groups.put(s, list);
              }
        }
        List<List<String>> result = new ArrayList();
        groups.forEach((k , v) -> { 
            result.add(v);  
        });
        System.out.println(result);  
        return result;
    }

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
