package ProblemSolving.Tree.MaximumDepthBinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumDepthBinaryTree {
    
    // Solving the problem using queue
    // The Node class is provided in the LeetCode Implementation. For e.g.: TreeNode node

    public int maxDepth(TreeNode node) {
        // queue to store the nodes
        Queue<TreeNode> queue = new ArrayDeque<>();
        int depth = 0;

        // if null return 0
        if(node == null) return 0;

        // Add the root node into the queue
        queue.offer(node);

        // use a while loop to traverse elements until empty
        while(!queue.isEmpty()){
            // each iteration represents one level since the for loop iterates through one level at a time.
            depth++;
            // its important to save the size of the queue here as within the for loop the size of the queue changes and directly using queue.size() in the forloop will create chaos.
            int size = queue.size();

            // for loop to iterate through the size of the queue which represents the previous level nodes.
            for(int i = 0; i < size; i++){
                // Dequeue the first node
                TreeNode current = queue.poll();
                // If left is present enqueue the left node.
                if(current.left != null) queue.offer(current.left); 
                // If right is present enqueue the right node.
                if(current.right != null) queue.offer(current.right);
            }
        }

        return depth;
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
