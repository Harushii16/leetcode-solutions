import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> fullLakes = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();
        
        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake == 0) {
                dryDays.add(i);
                ans[i] = 1; // default
            } else {
                ans[i] = -1;
                if (fullLakes.containsKey(lake)) {
                    // find next dry day after lake was filled
                    Integer dryDay = dryDays.higher(fullLakes.get(lake));
                    if (dryDay == null) return new int[0]; // flood
                    ans[dryDay] = lake; // dry this lake
                    dryDays.remove(dryDay);
                }
                fullLakes.put(lake, i);
            }
        }
        return ans;
    }
}
