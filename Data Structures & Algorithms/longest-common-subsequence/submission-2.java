class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        if (m < n) return longestCommonSubsequence(text2, text1);
        int[] dp = new int[n+1];
        for (int i = 1; i <=m ; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
             int temp = dp[j];   
             if (text1.charAt(i-1) == text2.charAt(j-1)) {
                dp[j] = 1 + prev;
             } else {
                dp[j] = Math.max(dp[j], dp[j-1]);
             }
             prev = temp;
            }
        }
        return dp[dp.length-1];
    }

    public int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <= n; j++) {
             if (text1.charAt(i-1) == text2.charAt(j-1)) {
                dp[i][j] = 1 + dp[i-1][j-1];
             } else {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
             }
            }
        }
        return dp[m][n];
    }
}
