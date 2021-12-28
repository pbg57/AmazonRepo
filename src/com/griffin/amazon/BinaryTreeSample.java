package com.griffin.amazon;

import com.griffin.utility.BinaryTreeNode;

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

        // Construct a binary tree with depth levels
        // Recurse for each needed level
        int newDepth = ++startingKey;
        if (newDepth >= depth) {
            return;
        } else {

            BinaryTreeNode leftChild = new BinaryTreeNode(newDepth);
            rootNode.setLeftChild(leftChild);
            BinaryTreeNode rightChild = new BinaryTreeNode(newDepth);
            rootNode.setRightChild(rightChild);

            constructBinaryTree(newDepth, depth, leftChild);
            constructBinaryTree(newDepth, depth, rightChild);
        }
    }

    public void displayBinaryTree(BinaryTreeNode startingNode, String childID) {


        BinaryTreeNode currentNode = startingNode;
        if (currentNode == null)
            return;
        System.out.println("DisplayBinaryTree: Level: " + currentNode.getKey() + childID);
        if (currentNode.getLeftChild() != null)
            displayBinaryTree(currentNode.getLeftChild(), "L");
        if (currentNode.getRightChild() != null)
            displayBinaryTree(currentNode.getRightChild(), "R");

    }
}
