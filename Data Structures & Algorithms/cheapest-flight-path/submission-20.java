class Flight {
    int to;
    int cost;
    int stops;

    public Flight (int to, int cost, int stops) {
        this.to = to;
        this.cost = cost;
        this.stops = stops;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       Map<Integer, Map<Integer, Integer>> flightGraph = new HashMap<>();
       for (int[] flight : flights) {
        int from = flight[0];
        int to = flight[1];
        int cost = flight[2];
        flightGraph.putIfAbsent(from, new HashMap<>());
        flightGraph.get(from).put(to, cost);
       }

       Map<Integer, Integer> minCosts = new HashMap<>();

       Queue<Flight> queue = new LinkedList<>();
       queue.offer(new Flight(src, 0, 0));

       while(!queue.isEmpty()) {
         Flight flight = queue.poll();  
         if (flight.stops > k) continue;

         Map<Integer, Integer> destinations = flightGraph.get(flight.to);
         if (destinations == null) continue;
         
         for(Map.Entry<Integer, Integer> destination : destinations.entrySet()) {
            int to = destination.getKey();
            int minCost = minCosts.getOrDefault(to, Integer.MAX_VALUE);
            int newCost = flight.cost + destination.getValue();
            System.out.println("To "+ to +", Cost "+ newCost);
            //System.out.println("minCost "+ minCost);
            if (newCost < minCost) {
                minCosts.put(to, newCost);
                queue.offer(new Flight(to, newCost, flight.stops + 1));
            }
         };
       }
System.out.println("minCosts "+ minCosts);
       return minCosts.getOrDefault(dst, -1);
    }
}
