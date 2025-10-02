class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;   // total bottles drunk
        int empties = numBottles; // empty bottles after drinking initial ones

        while (empties >= numExchange) {
            // Use numExchange empties to get 1 full bottle
            empties = empties - numExchange + 1; 
            ans++;          // drank one more bottle
            numExchange++;  // exchange cost increases
        }

        return ans;
    }
}
