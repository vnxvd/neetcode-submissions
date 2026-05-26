class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            boolean found = false;
            for (int row = 0; row < board.length && !found; row++) {
                for (int column = 0; column < board[0].length; column++) {
                    if (board[row][column] != word.charAt(0)) continue;
                    if (search(board, row, column, word, 0)) {
                       result.add(word);
                       found = true;
                       break;
                    }    
                }
            }
        }
        return result;
    }

    private boolean search(char[][]board, int row, int column, String word, int index) {
       if (index == word.length()) return true;
       if (row < 0 || row >= board.length) return false;
       if (column < 0 || column >= board[0].length) return false;
       if (board[row][column] != word.charAt(index)) return false;

       board[row][column] = '#';

       boolean ans = search(board, row + 1, column, word, index + 1) || 
       search(board, row - 1, column, word, index + 1) || 
       search(board, row, column + 1, word, index + 1) || 
       search(board, row, column - 1, word, index + 1);
      
       board[row][column] = word.charAt(index);

       return ans;
    }
}
