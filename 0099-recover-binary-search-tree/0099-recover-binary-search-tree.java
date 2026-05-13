/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {

        inorder(root);

        // swap the two wrong nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {

        if (root == null) return;

        inorder(root.left);

        // violation found
        if (prev.val > root.val) {

            // first violation
            if (first == null) {
                first = prev;
            }

            // update second every time
            second = root;
        }

        prev = root;

        inorder(root.right);
    }
}