package com.himank.leetcode.problems;

public class Problem920 {

    // https://leetcode.com/problems/number-of-music-playlists/description/
    public static void main(String[] args) {
        int n = 3, goal = 3, k = 1;
        System.out.println("Number of music playlist : " + numMusicPlaylists(n, goal, k));
    }

    private static final long MOD = 1_000_000_007;

    private static long[] factorial;
    private static long[] invFactorial;

    public static int numMusicPlaylists(int n, int goal, int k) {
        precalculateFactorials(n);
        int sign = 1;
        long answer = 0;

        for (int i = n; i >= k; i--) {
            long temp = power(i - k, goal - k);
            temp = (temp * invFactorial[n - i]) % MOD;
            temp = (temp * invFactorial[i - k]) % MOD;

            answer = (answer + sign * temp + MOD) % MOD;

            sign *= -1;
        }
        return (int) ((factorial[n] * answer) % MOD);
    }

    private static void precalculateFactorials(int n) {
        factorial = new long[n + 1];
        invFactorial = new long[n + 1];
        factorial[0] = invFactorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
            invFactorial[i] = power(factorial[i], (int) (MOD - 2));
        }
    }

    private static long power(long base, int exponent) {
        long result = 1L;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % MOD;
            }
            exponent >>= 1;
            base = (base * base) % MOD;
        }

        return result;
    }
}
