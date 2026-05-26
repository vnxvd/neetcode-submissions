class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while(maxHeap.size() > 1) {
            int highest = maxHeap.poll();
            int secondHighest = maxHeap.poll();
            if (highest > secondHighest) {
                maxHeap.offer(highest - secondHighest);
            }
        }

        maxHeap.offer(0);

        return maxHeap.peek();
    }
}
