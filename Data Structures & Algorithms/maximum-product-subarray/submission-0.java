class Solution {
    public int maxProduct(int[] nums) {
        int currentMax = 1, currentMin = 1, max = nums[0];
        for (int num : nums) {
          int temp = currentMax;
          currentMax = Math.max(num, Math.max(currentMax*num, currentMin*num));  
          currentMin = Math.min(num, Math.min(temp*num, currentMin*num));
          max = Math.max(max, currentMax);
        }
        return max;
    }
}
