class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> finalResult = new ArrayList<>();
        dfs(nums, 0, target, new ArrayList<>(), finalResult);
        return finalResult;
    }

    private void dfs(int[] nums, int currentIndex, int remaining, 
    List<Integer> currentResult, List<List<Integer>> finalResult) {
        if (remaining == 0) {
            finalResult.add(new ArrayList<>(currentResult));
            return;
        }
        if (currentIndex >= nums.length || remaining < 0) return;
        int currentNum = nums[currentIndex];
        currentResult.add(currentNum);
        dfs(nums, currentIndex, remaining - currentNum, currentResult, finalResult);
        currentResult.remove(currentResult.get(currentResult.size()-1));
        dfs(nums, currentIndex + 1, remaining, currentResult, finalResult);
    }
}
