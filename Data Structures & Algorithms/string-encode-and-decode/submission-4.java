class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String s : strs) {
            result.append(s.length()).append("#").append(s);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList();
        int i = 0;
        while(i < str.length()) {
          int previous = i;  
          while (str.charAt(i) != '#') {
            i++;
          }
          int length = Integer.valueOf(str.substring(previous, i));
          result.add(str.substring(i+1, i+1+length));
          i = i + 1 + length;
        }
        return result;
    }
}
