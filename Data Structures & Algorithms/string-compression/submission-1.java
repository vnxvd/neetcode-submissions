class Solution {
    public int compress(char[] chars) {
        int len = chars.length;
        int i = 0, j = 0;
        while (i < len) {
            char current = chars[i];
            int count = 1;
            while (i + count < len && chars[i + count] == current) {
                count++;
            }
            chars[j++] = current;
            if (count > 1) {
               for (char c : String.valueOf(count).toCharArray()) {
                 chars[j++] = c;
               }
            }
            i += count;
        }
        return j;
    }
}