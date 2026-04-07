package trees;

/**
 * ============================================================
 *        Maximum Depth of Binary Tree (LeetCode 104)
 * ============================================================
 *
 * Problem:
 * --------
 * Given the root of a binary tree, return its maximum depth.
 *
 * The maximum depth is defined as:
 * The number of nodes along the longest path from the root node
 * down to the farthest leaf node.
 *
 * ------------------------------------------------------------
 * Example:
 * ------------------------------------------------------------
 *
 *         1
 *        / \
 *       2   3
 *      / \
 *     4   5
 *
 * Paths:
 * 1 → 2 → 4 → depth = 3
 * 1 → 2 → 5 → depth = 3
 * 1 → 3     → depth = 2
 *
 * Output: 3
 *
 * ------------------------------------------------------------
 * Intuition:
 * ------------------------------------------------------------
 *
 * A tree is a recursive structure.
 * Each node depends on its left and right subtree.
 *
 * For any node:
 *
 *      depth(node) =
 *          1 + max(depth(node.left), depth(node.right))
 *
 * Why?
 * - We take the maximum depth from left and right subtree
 * - Add 1 to include the current node
 *
 * ------------------------------------------------------------
 * Base Case:
 * ------------------------------------------------------------
 *
 * If node == null:
 *      return 0
 *
 * This represents an empty tree.
 *
 * ------------------------------------------------------------
 * Approach:
 * ------------------------------------------------------------
 *
 * 1. Recursively compute depth of left subtree
 * 2. Recursively compute depth of right subtree
 * 3. Return 1 + max(leftDepth, rightDepth)
 *
 * ------------------------------------------------------------
 * Time Complexity:
 * ------------------------------------------------------------
 *
 * O(n)
 * Each node is visited exactly once.
 *
 * ------------------------------------------------------------
 * Space Complexity:
 * ------------------------------------------------------------
 *
 * O(h)
 * h = height of the tree (recursion stack)
 *
 * Worst case (skewed tree): O(n)
 * Balanced tree: O(log n)
 *
 */
public class MaxDepthBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MaxDepthBinaryTree maxDepthBinaryTree = new MaxDepthBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int depth = maxDepthBinaryTree.maxDepth(root);
        System.out.println("Max depth of the tree is: " + depth);
    }

    public int maxDepth(TreeNode root) {

        // Base case
        if(root == null) {
            return 0;
        }

        // Recursive case - compute depth of left and right subtree
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Return current depth.
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
