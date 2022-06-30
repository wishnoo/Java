package ProblemSolving.Tree.MaximumDepthBinaryTree;

public class MaximumDepthBinaryTree2 {
    // Using Recursion
    public int maxDepth(TreeNode root) {
        return recursiveDepth(root);
    }
    
    public int recursiveDepth(TreeNode node){
        // This return represents where to end the recursion
        if(node == null) return 0;
        else{
            // Iterate all the way to left most node and climb up
            int left_height = recursiveDepth(node.left);
            // Iterate to the right most node following the left above.
            int right_height = recursiveDepth(node.right);
            // Returns the current depth value to previous call to recursiveDepth in the call stack.
            return (Math.max(left_height,right_height) + 1);
        }
        
    }
    public static void main(String[] args) {
        // Create treenode that represents [3,9,20,null,null,15,7]
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        TreeNode right_node = node.right;
        right_node.left = new TreeNode(15);
        right_node.right = new TreeNode(7);
        MaximumDepthBinaryTree obj = new MaximumDepthBinaryTree();
        System.out.println(obj.maxDepth(node));
    }
}
