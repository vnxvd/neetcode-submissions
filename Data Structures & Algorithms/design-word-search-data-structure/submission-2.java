class WordDictionary {
    private List<String> dictionary;

    public WordDictionary() {
      dictionary = new ArrayList<>();
    }

    public void addWord(String word) {
       
       dictionary.add(word);
    }

    public boolean search(String keyword) {
      for (String word : dictionary) {
         if (word.equals(keyword)) {
            return true;
         }

         char[] array1 = keyword.toCharArray();
         char[] array2 = word.toCharArray();
         if (array1.length != array2.length) continue;

         int matchCount = 0;
         for (int i = 0; i < array1.length; ++i) {
            if (array1[i] == '.' || array1[i] == array2[i]) matchCount++;
         }
         if (matchCount == array1.length) return true;
      }
      return false;
    }
}
