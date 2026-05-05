import java.util.*;

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
    Node root;

    Trie() {
        root = new Node();
    }

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

    public int getMax(int num) {
        Node node = root;
        int maxNum = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

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
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);

        int q = queries.length;

        // [mi, xi, originalIndex]
        int[][] offlineQueries = new int[q][3];

        for (int i = 0; i < q; i++) {
            offlineQueries[i][0] = queries[i][1]; // mi
            offlineQueries[i][1] = queries[i][0]; // xi
            offlineQueries[i][2] = i;
        }

        Arrays.sort(offlineQueries, Comparator.comparingInt(a -> a[0]));

        Trie trie = new Trie();
        int[] ans = new int[q];

        int ind = 0;
        int n = nums.length;

        for (int i = 0; i < q; i++) {
            int mi = offlineQueries[i][0];
            int xi = offlineQueries[i][1];
            int qInd = offlineQueries[i][2];

            // insert all valid numbers <= mi
            while (ind < n && nums[ind] <= mi) {
                trie.insert(nums[ind]);
                ind++;
            }

            // if no number inserted
            if (ind == 0) {
                ans[qInd] = -1;
            } else {
                ans[qInd] = trie.getMax(xi);
            }
        }

        return ans;
    }
}