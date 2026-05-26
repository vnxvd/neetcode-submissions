class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int longest = 0;
        char[] arr = s.toCharArray();
        for (int right = 0; right < arr.length; ++right) {
            if (map.containsKey(arr[right])) {
                left = Math.max(left, map.get(arr[right]) + 1);
                System.out.println(map);
                System.out.println("left="+left);
            }
            map.put(arr[right], right);
            longest = Math.max(longest, right - left + 1);
            System.out.println(arr[right] + ",longest="+longest);
        }
        return longest;
    }
}
