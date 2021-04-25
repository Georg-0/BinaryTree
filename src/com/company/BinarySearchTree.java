package com.company;

//binary search tree
public class BinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();//20, 18, 28, 15, 19, 23, 22, 16, 5, 37, 90, 3, 2, 75, 39, 25
/* Let us create following BST
                20
             /      \
          18          28
        /    \       /   \
      15      19    23    37
     /  \          /  \     \
    5   16        22   25    90
   /                         /
  3                        75
 /                        /
2                        39 */




        tree.insert(20);
        tree.insert(18);
        tree.insert(28);
        tree.insert(15);
        tree.insert(19);
        tree.insert(23);
        tree.insert(22);
        tree.insert(16);
        tree.insert(5);
        tree.insert(37);
        tree.insert(90);
        tree.insert(3);
        tree.insert(2);
        tree.insert(75);
        tree.insert(39);
        tree.insert(25);

        // print inorder traversal of the BST
        tree.inorder();
    }

    /* Class containing left
    and right child of current node
   * and key value*/


    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // This method mainly calls insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }

    /* A recursive function to
    insert a new key in BST */
    Node insertRec(Node root, int key) {

		/* If the tree is empty,
		return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder() {
        inorderRec(root);
    }

    // A utility function to
    // do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    // A utility function to search a given key in BST
    public Node search(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.key == key)
            return root;

        // Key is greater than root's key
        if (root.key < key)
            return search(root.right, key);

        // Key is smaller than root's key
        return search(root.left, key);
    }
}

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

