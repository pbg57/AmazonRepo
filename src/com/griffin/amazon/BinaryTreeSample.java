package com.griffin.amazon;

import com.griffin.utility.BinaryTreeNode;

/*
Write a binary tree class that creates a binary tree of a given depth and can also
walk each tree node. Use recursion.
 */
public class BinaryTreeSample {

    public static void main(String[] args) {

        // Create a root node with no children
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(0);

        // Add n levels to the root tree
        BinaryTreeSample binaryTreeSample = new BinaryTreeSample();
        binaryTreeSample.constructBinaryTree(0, 5, binaryTreeNode);

        binaryTreeSample.displayBinaryTree(binaryTreeNode, "");
    }

    public void constructBinaryTree(int startingKey, int depth, BinaryTreeNode rootNode) {

        // Construct a binary tree with 'depth' levels. Each level should have twice as
        // many tree nodes as its parent node.

        // Recurse for each needed level
        int newDepth = ++startingKey;
        if (newDepth < depth) {
            BinaryTreeNode leftChild = new BinaryTreeNode(newDepth);
            rootNode.setLeftChild(leftChild);
            BinaryTreeNode rightChild = new BinaryTreeNode(newDepth);
            rootNode.setRightChild(rightChild);

            // Recurse for child nodes.
            constructBinaryTree(newDepth, depth, leftChild);
            constructBinaryTree(newDepth, depth, rightChild);
        }
    }

    public void displayBinaryTree(BinaryTreeNode startingNode, String childID) {
        /*
        Walk the binary tree using recursion. Print the key indicating the tree level
        and whether this is a left or right child node.
         */
        if (startingNode != null) {
            System.out.println("DisplayBinaryTree: Level: " + startingNode.getKey() + childID);
            if (startingNode.getLeftChild() != null)
                displayBinaryTree(startingNode.getLeftChild(), "L");
            if (startingNode.getRightChild() != null)
                displayBinaryTree(startingNode.getRightChild(), "R");
        }
    }
}
