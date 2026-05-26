class Solution {
    public int coinChange(int[] coins, int amount) {
        int minCoins = minCoins(coins, amount);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    private Map<Integer, Integer> cache = new HashMap<>();

    private int minCoins(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (cache.containsKey(amount)) return cache.get(amount);
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin >= 0) {
               int min = minCoins(coins, amount - coin); 
               if (min != Integer.MAX_VALUE) {
                  minCoins = Math.min(minCoins, 1 + min);
               }
            }
        }
        cache.put(amount, minCoins);
        return minCoins;
    }
}
