package ctci.chapter4;

/**
 * binary-search-tree property:
 * Let x be a node in a binary search tree.
 * If y is a node in the left subtree of x, then y.key <= x.key. If y is a node in the right subtree of x, then y.key > x.key.
 */

class BST implements Tree {
    private Node root = null;

    /**
     * print the key of the tree in a sorted order
     * starting from BST's root. Takes Θ(n) time.
     */
    @Override
    public void inOrderTreeWalk(){
        inOrderTreeWalk(root);
    }

    private void inOrderTreeWalk(Node node) {
        if (node != null) {
            inOrderTreeWalk(node.left);
            System.out.println(node.key);
            inOrderTreeWalk(node.right);
        }
    }

    /**
     * Add an element to the BST
     */
    @Override
    public void add(Integer element) {
        Node node = new Node(null, null, null, element);
        treeInsert(node);
    }

    /**
     *
     * @return min element of the tree
     */
    @Override
    public Integer findMinimum() {
        Node min = findMinimum(root);

        return min == null ? null : min.key;
    }

    /**
     *
     * @param node
     * @return min element starting from @param node
     */
    private Node findMinimum(Node node) {
        Node x = node;

        if (x == null) {
            return null;
        }

        while (x.left != null) {
            x = x.left;
        }

        return x;
    }

    /**
     *
     * @return max element of the tree
     */
    @Override
    public Integer findMaximum() {
        Node max = findMaximum(root);

        return max == null ? null : max.key;
    }

    private Node findMaximum(Node node) {
        Node x = node;

        if (x == null) {
            return null;
        }

        while (x.right != null) {
            x = x.right;
        }

        return x;
    }

    /**
     * @return the successor of @param n
     */
    Integer findSuccessor(Integer n) {
        Node node = searchTreeForNode(root, n);

        return findSuccessor(node).key;
    }

    private Node findSuccessor(Node node) {

        if (node.right != null) {
            return findMinimum(node);
        }

        Node successor = node.parent;
        while (successor != null && node == successor.right) {
            node = successor;
            successor = successor.parent;
        }

        return successor;
    }

    /**
     *
     * @param key to look for
     * @return true if key is found otherwise false
     */
    boolean contains(Integer key) {
        return null == searchTreeForNode(root, key);
    }

    /**
     *
     * @param node to start the search from.
     * @param key the int to look for.
     * @return node if found else null
     */
    private Node searchTreeForNode(Node node, Integer key) {

        if (node == null || node.key.equals(key)) {
            return node;
        }

        if (key < node.key) {
            return searchTreeForNode(node.left, key);
        } else {
            return searchTreeForNode(node.right, key);
        }

    }

    /**
     * removes all occurrences of @param data from the tree.
     */
    @Override
    public void remove(Integer data) {
        Node node = searchTreeForNode(root, data);
        removeAll(node);
    }

    /**
     * Removes all nodes where node.key == data
     */
    private void removeAll(Node node) {
        while (node != null) {
            if (node.left == null) {
                transplant(node, node.right);

            } else if (node.right == null) {
                transplant(node, node.left);
            } else {
                Node min = findMinimum(node.right);
                if (min != null) {

                    if (min.parent != node) {
                        transplant(min, min.right);
                        min.right = node.right;
                        min.right.parent = min;
                    }

                    transplant(node, min);
                    min.left = node.left;
                    min.left.parent = min;
                }
            }

            node = searchTreeForNode(root, node.key);
        }
    }

    /**
     * Replaces the subtree rooted at node u with the subtree rooted at node v.
     * Node u’s parent becomes node v's parent, and u's parent ends up having v as its appropriate child.
     *
     * @param u subtree to be replaced
     * @param v replacement subtree
     */
    private void transplant(Node u, Node v) {

        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }

        if (v != null) {
            v.parent = u.parent;
        }

    }

    private void treeInsert(Node node) {
        Node y = null;
        Node x = root;

        while (x != null) {
            y = x;

            if (node.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;

        if (y == null) { // tree was empty
            root = node;

        } else if (node.key <  y.key) {
            y.left = node;

        } else {
            y.right = node;
        }
    }

    @Override
    public Node getRoot() {
        return root;
    }

    private static int checkHeight(Node node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = checkHeight(node.left);

        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int rightHeight = checkHeight(node.right);

        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int height = Math.abs(leftHeight - rightHeight);
        if (height > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }

    }

    /**
     * Find if a tree is balanced or not.
     */
    static boolean isBalanced(Node node) {
        int result = checkHeight(node);

        return result != Integer.MIN_VALUE;
    }

    /**
     * 4.5 Check if a binary tree is BST or not
     */

    static boolean isBinarySearchTree(Tree tree) {
        Node rootNode = tree.getRoot();
        return isBinarySearchTree(rootNode, rootNode.key).isBinary;
    }

    private static Pair isBinarySearchTree(Node node, Integer rootKey) {

        if (node != null) {
            Pair left = isBinarySearchTree(node.left, rootKey);
            Integer parent = node.key;

            if (left != null && (node.key > rootKey || left.data > parent || !left.isBinary)) {
                return new Pair(left.data, false);
            }

            Pair right = isBinarySearchTree(node.right, rootKey);

            if (right != null && ((node.key <= rootKey && node.parent != null) ||
                                                               right.data <= parent ||
                                                               !right.isBinary)) {
                return new Pair(right.data, false);
            }

            return new Pair(node.key, true);
        }

        return null;
    }

    /**
     * Helper class for the isBinarySearchTree method
     */
    private static class Pair {
        final Integer data;
        final boolean isBinary;

        public Pair(Integer data, boolean isBinary) {
            this.data = data;
            this.isBinary = isBinary;
        }
    }

    static class Node {
        Node parent;
        Node left;
        Node right;
        Integer key;

        Node(Node parent, Node left, Node right, int key) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.key = key;
        }

        @Override
        public String toString() {
            Integer p = (parent == null) ? null : parent.key;
            Integer l = (left == null) ? null : left.key;
            Integer r = (right == null) ? null : right.key;
            return "Node: " + key + " parent= " + p + " left= " + l + " right= " + r;
        }
    }
}
