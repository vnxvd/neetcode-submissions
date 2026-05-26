public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }     
        count.forEach((key, value) -> {
            freq[value].add(key);
        });

        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i >= 0; --i) {
           for (int num : freq[i]) {
                res[index++] = num;
                if (index == k) {
                    return res;
                }
            }
        };
            
        return res;
    }
}