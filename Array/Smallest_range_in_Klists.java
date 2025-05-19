import java.util.*;
class Node implements Comparable<Node> {
    int val, row, col;

    Node(int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }

    // For min-heap based on value
    public int compareTo(Node other) {
        return this.val - other.val;
    }
}

class Smallest_range_in_Klists {
    // Function to find the smallest range
    static ArrayList<Integer> findSmallestRange(int[][] arr) {
        int k = arr.length;
        int n = arr[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int maxVal = Integer.MIN_VALUE;

        // Push the first element of each list into the min-heap
        for (int i = 0; i < k; i++) {
            pq.add(new Node(arr[i][0], i, 0));
            maxVal = Math.max(maxVal, arr[i][0]);
        }

        int minRange = Integer.MAX_VALUE, minEl = -1, maxEl = -1;

        while (true) {
            Node curr = pq.poll();
            int minVal = curr.val;

            // Update range if better
            if (maxVal - minVal < minRange) {
                minRange = maxVal - minVal;
                minEl = minVal;
                maxEl = maxVal;
            }

            // If we've reached the end of a list, break
            if (curr.col + 1 == n)
                break;

            // Push next element from the same list
            int nextVal = arr[curr.row][curr.col + 1];
            pq.add(new Node(nextVal, curr.row, curr.col + 1));
            maxVal = Math.max(maxVal, nextVal);
        }

        // Return result as ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        result.add(minEl);
        result.add(maxEl);
        return result;
    }
}