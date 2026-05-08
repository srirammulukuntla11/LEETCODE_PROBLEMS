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
 class BSTIterator {
    Stack<TreeNode> stk = new Stack<>();
    boolean reverse = true;
    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }
    
    public int next() {
        TreeNode el = stk.pop();
        if(!reverse)
             pushAll(el.right);
        else pushAll(el.left);
        return el.val;
    }
    
    public boolean hasNext() {
        return !stk.isEmpty();
    }
    public void pushAll(TreeNode node){
        while(node!=null)
        {
            stk.push(node);
            if(reverse == true)
                node = node.right;
            else node = node.left;
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        // for next
        BSTIterator l = new BSTIterator(root,false);
        // for before
        BSTIterator r = new BSTIterator(root,true);
        int i = l.next();
        int j = r.next();
        while(i<j)
        {
            if(i+j == k) return true;
            else if(i+j<k) i = l.next();
            else j = r.next();
        }
        return false;

    }
}