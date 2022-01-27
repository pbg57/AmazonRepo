package com.griffin.utility;

/*
Single node class used to construct a binary tree. A binary tree has at most two leaf nodes,
 */
public class BinaryTreeNode {

    private final int key;
    private BinaryTreeNode leftChild = null;
    private BinaryTreeNode rightChild = null;

    /*
    Construct a node with a key and no children
     */
    public BinaryTreeNode(int key) {
        this.key = key;
    }

    /*
    Construct a node with a key and two children.
     */
    public BinaryTreeNode(int key, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
        this.key = key;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    /*
    Set left child node.
     */
    public void setLeftChild(BinaryTreeNode child) {
        this.leftChild = child;
    }

    /*
    Set right child node.
     */
    public void setRightChild(BinaryTreeNode child) {
        this.rightChild = child;
    }

    /*
     Get right child node or null if none exist.
     */
    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    /*
      Get left child node or null if none exist.
      */
    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    /*
    Get this node's key.
     */
    public int getKey() {
        return key;
    }
}
