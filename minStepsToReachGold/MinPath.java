package minStepsToReachGold;

import java.util.Arrays;

public class MinPath {

    public static int findMin(int n, int m, int[][] dp) {
        if (n == 0 && m == 0)
            return 0;
        if (n < 0 || m < 0)
            return (int) Math.pow(10, 9);
        if (dp[n][m] != -1)
            return dp[n][m];

        int up = findMin(n - 1, m, dp);
        int right = findMin(n, m + 1, dp);
        int down = findMin(n + 1, m, dp);
        int left = findMin(n, m - 1, dp);

        return dp[n][m] = Math.min(up, Math.min(right, Math.min(down, left)));
    }

    public static int findCorrectMin(int[] adventurer, int[]gold, int[][] dp) {
        if (adventurer[0] == 0 || adventurer[1] == 0)
            return 0;
        int adventureIndex = 0;
        int up = findCorrectMin(adventurer, gold, dp);
        int right = findCorrectMin(adventurer, gold, dp);

        int left = findCorrectMin(adventurer, gold, dp);
        int down = findCorrectMin(adventurer, gold, dp);
    }

    public static void main(String[] args) {
        int[][] dp = new int[5][4];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        int[] adventurer = {5, 1};
        int[] gold = {1, 4};
        int val = findCorrectMin(adventurer, gold, dp);
        System.out.println(val);
    }
}