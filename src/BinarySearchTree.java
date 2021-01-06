/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw04;

/**
 *
 * @author Pete
 */
public class BinarySearchTree {
    private TreeNode root;

    // Constructor
    public BinarySearchTree() {
        root = null;
    }

    // Insert a new value
    public void insert(String v) {
        if (root == null) {
            // first node
            root = new TreeNode(v);
        } else {
            root.insert(v);
        }
    }

    // Check if a value is contained in the tree
    public boolean contains(String v) {
        // check for an empty tree
        if (root == null) {
            // empty
            return false;
        } else {
            return root.contains(v);
        }
    }

    // Remove a value from the tree
    public void remove(String v) {
        if (root != null) {
            root = root.remove(v);
        }
    }

    // Traversals
    public String inOrder() {
        // check if root is null
        if (root != null) {
            return root.inOrder();   
        }
        else{
            return null;
        }
    }
    
    public String preOrder() {
        // check if root is null
        if (root != null) {
            return root.preOrder();
        }else{
            return null;
        }
    }
    
    public String postOrder() {
        // check if root is null
        if (root != null) {
            return root.postOrder();
        }else{
            return null;
        }
    }
    

}


