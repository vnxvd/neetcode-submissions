class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;
    
    public TrieNode() {
        children = new HashMap<>();
    }
}

class Suggestion {
    String text;
    int frequency;

    public String getText() {
        return this.text;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public Suggestion(String text, int frequency) {
        this.text = text;
        this.frequency = frequency;
    }
}

class Trie {
    TrieNode root;
    Map<String, Integer> frequency;

    public Trie () {
        root = new TrieNode();
        frequency = new HashMap<>();
    }

    public void add(String sentence) {
        add(sentence, frequency.getOrDefault(sentence, 0) + 1);
    } 

    public void add(String sentence, int freq) {
        if (sentence == null || sentence.isEmpty()) return;
        
        TrieNode current = root;
        for (char c : sentence.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }

        current.endOfWord = true;
        frequency.put(sentence, freq);
    }

    public List<String> search(String prefix, int limit) {
        if (prefix == null || prefix.isEmpty()) return Collections.emptyList();

        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            if (!current.children.containsKey(c)) return Collections.emptyList();
            current = current.children.get(c);
        }

        List<Suggestion> result = new ArrayList<>();
        collectResult(current, prefix, result);
        sortResult(result);
        result = limitResult(result, limit);

        return result.stream().map(Suggestion::getText).collect(Collectors.toList());
    }

    private void sortResult(List<Suggestion> result) {
      Comparator<Suggestion> comparators = Comparator
        .comparing(Suggestion::getFrequency, Comparator.reverseOrder())
        .thenComparing(Suggestion::getText); 
      Collections.sort(result, comparators);
    }

    private List<Suggestion> limitResult(List<Suggestion> result, int limit) {
        if (limit >= result.size()) limit = result.size();

        List<Suggestion> limitedResult = new ArrayList<>();
        for (int i = 0; i < limit; ++i) {
          limitedResult.add(result.get(i));
        }
        
        return limitedResult;
    }

    private void collectResult(TrieNode node, String prefix, List<Suggestion> result) {
        if (node.endOfWord) result.add(new Suggestion(prefix, frequency.getOrDefault(prefix, 0)));

        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            collectResult(entry.getValue(), prefix + entry.getKey(), result);
        }
    }
}

class AutocompleteSystem {
    Trie trie;
    StringBuilder typedWord;

    public AutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        for (int i = 0; i < sentences.length; ++i) {
            trie.add(sentences[i], times[i]);
        }
        typedWord = new StringBuilder();
    }
    
    public List<String> input(char c) {
        if (c == '#') {
           trie.add(typedWord.toString());
           typedWord.setLength(0);
        } else {
            typedWord.append(c);
        }
        return trie.search(typedWord.toString(), 3);
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
