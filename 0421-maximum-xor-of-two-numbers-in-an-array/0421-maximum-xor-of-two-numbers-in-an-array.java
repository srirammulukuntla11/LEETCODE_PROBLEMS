class Node {
    Node[] links = new Node[2];

    boolean containsKey(int bit) {
        return links[bit] != null;
    }

    Node get(int bit) {
        return links[bit];
    }

    void put(int bit, Node node) {
        links[bit] = node;
    }
}

class Trie {
    private Node root;

    Trie() {
        root = new Node();
    }

    // Insert number into Trie
    public void insert(int num) {
        Node node = root;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }

            node = node.get(bit);
        }
    }

    // Get maximum XOR for a number
    public int getMax(int num) {
        Node node = root;
        int maxNum = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            // Try opposite bit
            if (node.containsKey(1 - bit)) {
                maxNum |= (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }

        return maxNum;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();

        // Step 1: Insert all numbers
        for (int num : nums) {
            trie.insert(num);
        }

        // Step 2: Find max XOR
        int maxXor = 0;
        for (int num : nums) {
            maxXor = Math.max(maxXor, trie.getMax(num));
        }

        return maxXor;
    }
}