class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Set<String> visited = new HashSet();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
               if (visited.contains(i+"#"+j)) continue; 
               if(matrix[i][j] == 0) {
                visited.add(i+"#"+j);
                  for (int k = 0; k < n; ++k) {
                    if (visited.contains(i+"#"+k) || matrix[i][k] == 0) continue; 
                     matrix[i][k] = 0;
                     visited.add(i+"#"+k);
                  }
                  for (int l = 0; l < m; ++l) {
                    if (visited.contains(l+"#"+j) || matrix[l][j] == 0) continue; 
                     matrix[l][j] = 0;
                     visited.add(l+"#"+j);
                  }
               }
            }
        }
    }
}
