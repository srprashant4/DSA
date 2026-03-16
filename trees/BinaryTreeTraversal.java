package trees;
public class BinaryTreeTraversal {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Preorder Traversal
     * Root → Left → Right
     */
    public void preorder(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");

        preorder(root.left);
        preorder(root.right);
    }

    /**
     * Inorder Traversal
     * Left → Root → Right
     */
    public void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        System.out.print(root.val + " ");

        inorder(root.right);
    }

    /**
     * Postorder Traversal
     * Left → Right → Root
     */
    public void postorder(TreeNode root) {

        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);

        System.out.print(root.val + " ");
    }

    /**
     * Sample Tree Creation
     *
     *         1
     *        / \
     *       2   3
     *      / \
     *     4   5
     */
    public static void main(String[] args) {

        BinaryTreeTraversal tree = new BinaryTreeTraversal();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.print("Preorder: ");
        tree.preorder(root); // Output: 1 2 4 5 3

        System.out.println();

        System.out.print("Inorder: ");
        tree.inorder(root); // Output: 4 2 5 1 3

        System.out.println();

        System.out.print("Postorder: ");
        tree.postorder(root); // Output: 4 5 2 3 1
    }
}