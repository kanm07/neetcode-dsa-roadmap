/*
Approach:
1. Pair each car's position and speed.
2. Sort the cars in decreasing order of position (closest to target first).
3. Compute the time each car takes to reach the target.
4. Use a stack to track fleets:
   - If the current car takes more time than the fleet ahead, it forms a new fleet.
   - Else, it merges into the fleet ahead (no new fleet).

Time Complexity: O(n log n) for sorting.
Space Complexity: O(n) for the stack.
*/

import java.util.*;

public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();
        for (double[] car : cars) {
            double time = car[1];
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}
