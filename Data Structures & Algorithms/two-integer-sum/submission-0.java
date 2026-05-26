class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap();
        for (int i = 0; i < nums.length; ++i) {
            int val = target - nums[i];
            if (seen.containsKey(val)) {
                int j = seen.get(val);
                return new int[] { Math.min(i, j), Math.max(i, j)};
            }
            seen.put(nums[i], i);    
        }
        return new int[0];
    }
}
