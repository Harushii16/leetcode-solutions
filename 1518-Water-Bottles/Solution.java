class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;  // start with all full bottles
        int empty = numBottles;  // after drinking, all are empty

        while (empty >= numExchange) {
            int newBottles = empty / numExchange;   // exchange possible
            total += newBottles;                   // drink new bottles
            empty = empty % numExchange + newBottles; // remaining empties + new empties
        }

        return total;
    }
}
