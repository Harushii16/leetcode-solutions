import java.util.*;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        
        q.add(s);
        seen.add(s);
        
        String ans = s;
        
        while (!q.isEmpty()) {
            String curr = q.poll();
            if (curr.compareTo(ans) < 0) {
                ans = curr;
            }

            char[] chars = curr.toCharArray();
            for (int i = 1; i < chars.length; i += 2) {
                int d = chars[i] - '0';
                d = (d + a) % 10;
                chars[i] = (char)(d + '0');
            }
            String op1 = new String(chars);

            if (!seen.contains(op1)) {
                seen.add(op1);
                q.add(op1);
            }

            String op2 = curr.substring(curr.length() - b) + curr.substring(0, curr.length() - b);

            if (!seen.contains(op2)) {
                seen.add(op2);
                q.add(op2);
            }
        }
        return ans;
    }
}
