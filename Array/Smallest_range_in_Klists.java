import java.util.*;

public class Smallest_range_in_Klists {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
            }
            ArrayList<Integer> range = new Solution().findSmallestRange(arr);
            System.out.println(range.get(0) + " " + range.get(1));
            System.out.println("~");
        }
    }
}

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

class Solution {
    
    
    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        // code here
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

            if (curr.col + 1 == n)
                break;

            int nextVal = arr[curr.row][curr.col + 1];
            pq.add(new Node(nextVal, curr.row, curr.col + 1));
            maxVal = Math.max(maxVal, nextVal);
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(minEl);
        result.add(maxEl);
        return result;
    }
}