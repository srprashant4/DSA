package trees;

/**
 * ============================================================
 *       Balanced Binary Tree (LeetCode 110)
 * ============================================================
 * 
 * Problem:
 * --------
 * Given a binary tree, determine if it is height-balanced. 
 * 
 * A height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 * 
 * ------------------------------------------------------------
 * Example:
 * ------------------------------------------------------------
 *        1
 *      / \
 *     2   3
 *   / \
 *  4   5
 * * Output: true
 * 
 * * ------------------------------------------------------------
 * Intuition:
 * * ------------------------------------------------------------
 * A tree is a recursive structure.
 * Each node depends on its left and right subtree.
 * For any node:
 * *      height(node) =
 * *          1 + max(height(node.left), height(node.right))
 * * Why?
 * * - We take the maximum height from left and right subtree
 * * - Add 1 to include the current node
 * 
 * * ------------------------------------------------------------
 * Base Case:
 * * ------------------------------------------------------------
 * * If node == null:
 * *      return 0
 * * This represents an empty tree.
 * 
 * * ------------------------------------------------------------
 * Approach:
 * * * ------------------------------------------------------------
 * We can use a depth-first search (DFS) approach to check the height of each subtree.
 * We return -1 if we find any subtree that is not balanced. This way, we can avoid unnecessary calculations and improve efficiency.
 * We return the height of the current node if it is balanced.
 * This is a special value that indicates the subtree is balanced and allows us to calculate the height of the parent node.
 * 
 * * Time Complexity: O(n) where n is the number of nodes in the tree.
 * * * Space Complexity: O(h) where h is the height of the tree (due to recursion stack).
 */
public class BalancedBinaryTree {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(isBalanced(root)); // Output: true
    }

    // Returns true if the tree is balanced, false otherwise.
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // Returns the height of the tree if balanced, -1 if not balanced.
    public static int checkHeight(TreeNode root) {

        // Base case: An empty tree is balanced and has height 0.
        if(root == null) {
            return 0;
        }

        // Check left subtree height. If it's -1, the subtree is not balanced.
        int left = checkHeight(root.left);
        if(left == -1) return -1;

        // Check right subtree height. If it's -1, the subtree is not balanced.
        int right = checkHeight(root.right);
        if(right == -1) return -1;

        // If the difference in height is greater than 1, the tree is not balanced.
        if(Math.abs(left - right) > 1) return -1;

        // Return the height of the current node.
        return 1 + Math.max(left, right);
    }
}
