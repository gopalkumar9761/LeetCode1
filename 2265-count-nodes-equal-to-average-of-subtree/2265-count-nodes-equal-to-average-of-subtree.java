class Solution {
    private int count = 0;

    public int averageOfSubtree(TreeNode root) {
        count = 0;
        postOrder(root);
        return count;
    }

    private int[] postOrder(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = postOrder(node.left);
        int[] right = postOrder(node.right);

        int sum = left[0] + right[0] + node.val;
        int nodes = left[1] + right[1] + 1;

        if (sum / nodes == node.val) {
            count++;
        }

        return new int[]{sum, nodes};
    }
}