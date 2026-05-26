class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> frequents = new HashMap();
        for (char task : tasks) {
            frequents.put(task, frequents.getOrDefault(task, 0) + 1);
        }
        Collection<Integer> counts = frequents.values();
        int maxFrequent = Collections.max(counts);
        int maxFrequentCount = Collections.frequency(counts, maxFrequent);
        int leastInterval = (maxFrequent - 1) * (n + 1) + maxFrequentCount;
        return Math.max(leastInterval, tasks.length);
    }
}
