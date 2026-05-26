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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0) return null;
    Stack<TreeNode> stack = new Stack<>();
    TreeNode root = new TreeNode(preorder[0]);
    stack.push(root);
    int inorderIndex = 0;
    for (int i = 1; i < preorder.length; i++) {
        TreeNode node = new TreeNode(preorder[i]);
        if (stack.peek().val != inorder[inorderIndex]) {
            stack.peek().left = node;
        } else {
            TreeNode parent = null;
            while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                parent = stack.pop();
                inorderIndex++;
            }
            parent.right = node;
        }
        stack.push(node);
    }
    return root;
}

    /**
    Solution 1
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int mid = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                mid = i;
                break;
            }    
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1), 
        Arrays.copyOfRange(inorder, 0, mid));
        root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length), 
        Arrays.copyOfRange(inorder, mid + 1, inorder.length));
        return root;
    }
    
    Solution 2
    int preorderIndex = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        for (int i = 0; i < inorder.length; i++) inorderMap.put(inorder[i], i);
        return build(preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) return null;
        TreeNode root = new TreeNode(preorder[preorderIndex++]);
        int mid = inorderMap.get(root.val);
        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);
        return root;
    }
    **/
}
