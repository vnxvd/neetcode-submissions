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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        explore(root, values);
        return values.get(k-1);
    }

    private void explore(TreeNode node, List<Integer> values) {
        if (node == null) return;
        explore(node.left, values);
        values.add(node.val);
        explore(node.right, values);
    }
}
