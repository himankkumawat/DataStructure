package com.himank.leetcode.problems;

public class Problem1220 {

    // https://leetcode.com/problems/count-vowels-permutation/
    public static void main(String[] args) {
        int n = 2;
        System.out.println("Total number of vowel permutation: " + countVowelPermutation(n));
    }

    public static int countVowelPermutation(int n) {
        long aCount = 1, eCount = 1, iCount = 1, oCount = 1, uCount = 1;
        int MOD = 1000000007;

        for (int i = 1; i < n; i++) {
            long aCountNew = (eCount + iCount + uCount) % MOD;
            long eCountNew = (aCount + iCount) % MOD;
            long iCountNew = (eCount + oCount) % MOD;
            long oCountNew = (iCount) % MOD;
            long uCountNew = (iCount + oCount) % MOD;
            aCount = aCountNew;
            eCount = eCountNew;
            iCount = iCountNew;
            oCount = oCountNew;
            uCount = uCountNew;
        }
        long result = (aCount + eCount + iCount + oCount + uCount)  % MOD;
        return (int)result;
    }
}
