/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw04;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Pete
 */
public class TreeNode {

    private String value;
    private TreeNode left;
    private TreeNode right;
    ArrayList<String> list = new ArrayList<>();
    String s = "";

    // Constructor
    public TreeNode(String v) {
        value = v;
        left = right = null;
    }

    // Insert a new value
    public void insert(String v) {
        if (value.compareToIgnoreCase(v) >= 0) {
            // goes in left subtree
            if (left == null) {
                // No left child -- create new node
                left = new TreeNode(v);
            } else {
                // Delegate to left child
                left.insert(v);
            }
        } else // goes in right subtree        
         if (right == null) {
                // No right child -- create new node
                right = new TreeNode(v);
            } else {
                // Delegate to right child
                right.insert(v);
            }
    }

    // Check if value is in the tree
    public boolean contains(String v) {
        if (value.compareToIgnoreCase(v) == 0) {
            // Value found in the current node
            return true;
        } else if (value.compareToIgnoreCase(v) > 0) {
            // Value could be in left subtree
            if (left == null) {
                // No left child
                return false;
            } else {
                // Delegate to left child
                return left.contains(v);
            }
        } else // Value could be in the right subtree
         if (right == null) {

                // No right child
                return false;
            } else {

                // Delegate to right child
                return right.contains(v);
            }
    }

    // Remove a value from the tree
    public TreeNode remove(String v) {
        // check the subtrees
        if (value.compareToIgnoreCase(v) > 0) {
            // ask left child to remove value
            left = left.remove(v);
        } else if (value.compareToIgnoreCase(v) < 0) {
            // ask right child to remove value
            right = right.remove(v);
        } else // Current node getting removed -- OUCH!
         if (left == null && right == null) {
                // Case 1 : no children
                return null;
            } else if (left != null && right == null) {
                // Case 2 - promote left child
                return left;
            } else if (left == null && right != null) {
                // Case 2 - promote right child
                return right;
            } else {
                // Case 3 -- Node with two children
                Random r = new Random();  // Random value generator

                //  (1) Identify a new vlaue, then (2) remove the duplicate
                if (r.nextBoolean()) {
                    // get maximum value from left
                    value = left.rightMost();
                    // remove duplicate from the left
                    left = left.remove(value);
                } else {
                    // get minimum value from right
                    value = right.leftMost();
                    // remove duplicate from the right
                    right = right.remove(value);
                }

            }
        // Return current reference (may have a new value)        
        return this;
    }

    protected String leftMost() {
        // returns the left most value
        if (left == null) {
            // no more left children
            return value;
        } else {
            return left.leftMost();
        }
    }

    protected String rightMost() {
        // returns the right most value
        if (right == null) {
            // no more right children
            return value;
        } else {
            return right.rightMost();
        }
    }

// Traversals
    public String inOrder() {
        String leftSide;
        String rightSide;

        if (left != null) {
            leftSide = left.inOrder();
        } else {
            leftSide = "";
        }

        if (right != null) {
            rightSide = right.inOrder();
        } else {
            rightSide = "";
        }
        return leftSide + "[" + value + "]" + rightSide;

    }

    public String preOrder() {
        String rightSide;
        String leftSide;

        if (left != null) {
            leftSide = left.preOrder();
        } else {
            leftSide = "";
        }

        if (right != null) {
            rightSide = right.preOrder();
        } else {
            rightSide = "";
        }
        return "[" + value + "]" + leftSide + rightSide;
    }

    public String postOrder() {
        String rightSide;
        String leftSide;

        if (left != null) {
            leftSide = left.postOrder();
        } else {
            leftSide = "";
        }
        
        if (right != null) {
            rightSide = right.postOrder();
        } else {
            rightSide = "";
        }
        
        return   leftSide + rightSide + "[" + value + "]";
    }

}
