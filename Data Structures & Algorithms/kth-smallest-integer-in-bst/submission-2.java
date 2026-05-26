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
    int count = 0, result = 0;

    public int kthSmallest(TreeNode root, int k) {
        explore(root, k);
        return result;
    }

    private void explore(TreeNode node, int k) {
        if (node == null) return;
        explore(node.left, k);
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        explore(node.right, k);
    }

    public int kthSmallest1(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        explore1(root, values);
        return values.get(k-1);
    }

    private void explore1(TreeNode node, List<Integer> values) {
        if (node == null) return;
        explore1(node.left, values);
        values.add(node.val);
        explore1(node.right, values);
    }
}
