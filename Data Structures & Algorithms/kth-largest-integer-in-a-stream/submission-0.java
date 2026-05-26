class KthLargest {
    PriorityQueue<Integer> minHeap = new PriorityQueue();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            addValue(num);
        }
    }
    
    public int add(int val) {
         addValue(val);
         return minHeap.peek();
    }

    private void addValue(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
                minHeap.poll();
        }
    }
}
