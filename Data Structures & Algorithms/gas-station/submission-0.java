class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int numberOfStations = gas.length;
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < numberOfStations; ++i) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) return - 1;

        int tank = 0, startStation = 0;
        for (int i = 0; i < numberOfStations; ++i) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                startStation = i + 1;
                tank = 0;
            }
        }
        return startStation;
    }
}
