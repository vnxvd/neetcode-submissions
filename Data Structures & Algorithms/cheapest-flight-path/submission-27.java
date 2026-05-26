class Flight {
    int destination;
    int price;
    int stops;

    public Flight (int destination, int price, int stops) {
        this.destination = destination;
        this.price = price;
        this.stops = stops;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> flightGraph = new HashMap<>();
       for (int[] flight : flights) {
        int source = flight[0];
        int destination = flight[1];
        int price = flight[2];
        flightGraph.putIfAbsent(source, new HashMap<>());
        flightGraph.get(source).put(destination, price);
       }

       Map<Integer, Integer> minPrices = new HashMap<>();

       Queue<Flight> queue = new LinkedList<>();
       queue.offer(new Flight(src, 0, 0));

       while(!queue.isEmpty()) {
         Flight flight = queue.poll();  

         if (flight.stops > k) continue;

         Map<Integer, Integer> destinations = flightGraph.get(flight.destination);
         if (destinations == null) continue;
         
         for(Map.Entry<Integer, Integer> destination : destinations.entrySet()) {
            int destinationCode = destination.getKey();
            int minPrice = minPrices.getOrDefault(destinationCode, Integer.MAX_VALUE);
            int newPrice = flight.price + destination.getValue();
            if (newPrice < minPrice) {
                minPrices.put(destinationCode, newPrice);
                queue.offer(new Flight(destinationCode, newPrice, flight.stops + 1));
            }
         };
       }
       
       return minPrices.getOrDefault(dst, -1);
    }
}