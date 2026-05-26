class Twitter {
    class Tweet {
        int tweetId;
        int time;
        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }

        public int getTweetId() {
            return this.tweetId;
        }
    }

    private Map<Integer, List<Tweet>> tweets;
    private Map<Integer, Set<Integer>> follows;
    private static int count = 0;

    public Twitter() {
        this.tweets = new HashMap();
        this.follows = new HashMap();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (tweets.containsKey(userId)) {
            List<Tweet> postedTweets = tweets.get(userId);
            postedTweets.add(new Tweet(tweetId, count++));
        } else {
            List<Tweet> postedTweets = new ArrayList();
            postedTweets.add(new Tweet(tweetId, count++));
            tweets.put(userId, postedTweets);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
         Set<Integer> followees = follows.getOrDefault(userId, new HashSet());
         followees.add(userId);
         PriorityQueue<Tweet> queue = new PriorityQueue<>((t1, t2) -> t1.time - t2.time);
         for (int followee : followees) {
            List<Tweet> posts = tweets.getOrDefault(followee, new ArrayList());
            for (int i = posts.size() - 1; i >= 0 && i >= posts.size() - 10; i--) {
                queue.offer(posts.get(i));
                if (queue.size() > 10) queue.poll();
            }
         }
         List<Tweet> list = new ArrayList(queue);
        Collections.sort(list, (t1, t2) -> t2.time - t1.time);
         List<Integer> feed = list.stream().map(Tweet::getTweetId)
         .collect(Collectors.toList());
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            Set<Integer> followees = follows.get(followerId);
            followees.add(followeeId);
        } else {
            Set<Integer> followees = new HashSet();
            followees.add(followeeId);
            follows.put(followerId, followees);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            Set<Integer> followees = follows.get(followerId);
            followees.remove(followeeId);
        }
    }
}
