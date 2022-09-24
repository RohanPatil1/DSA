public class ImplementTrie2 {

    class TNode {
        TNode links[] = new TNode[26];
        int countEndWith = 0;
        int countPrefix = 0;

        public TNode() {
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        TNode get(char ch) {
            return links[ch - 'a'];
        }

        void put(char ch, TNode node) {
            links[ch - 'a'] = node;
        }

        void incrementEndsWith() {
            countEndWith++;
        }

        void decrementEndsWith() {
            countEndWith--;
        }

        void increasePrefix() {
            countPrefix++;
        }

        void decreasePrefix() {
            countPrefix--;
        }

        public int getCountEndWith() {
            return countEndWith;
        }

        public int getCountPrefix() {
            return countPrefix;
        }


    }

    class Trie {
        private TNode root;

        public Trie() {
            root = new TNode();
        }

        public void insert(String word) {
            TNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch)) {
                    node.put(ch, new TNode());
                }
                node = node.get(ch);
                node.increasePrefix();
            }
            node.incrementEndsWith();
        }

        public int countWordsEqualTo(String word) {
            TNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.containsKey(ch)) {
                    node = node.get(ch);
                } else {
                    return 0;
                }
            }
            return node.getCountEndWith();
        }

        public int countWordsStartingWith(String word) {
            TNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.containsKey(ch)) {
                    node = node.get(ch);
                } else {
                    return 0;
                }
            }
            return node.getCountPrefix();
        }

        public void erase(String word) {
            TNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (node.containsKey(ch)) {
                    node = node.get(ch);
                    node.decreasePrefix();
                } else {
                    return;
                }
            }
            node.decrementEndsWith();
        }
    }


}
