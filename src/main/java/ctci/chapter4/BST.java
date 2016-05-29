package ctci.chapter4;


/**
 * binary-search-tree property:
 * Let x be a node in a binary search tree.
 * If y is a node in the left subtree of x, then y.key <= x.key. If y is a node in the right subtree of x, then y.key >= x.key.
 */

public class BST {
    private Node root = null;

    /**
     * print the key of the tree in a sorted order
     * starting from BST's root. Takes Θ(n) time.
     */
    void inOrderTreeWalk(){
        inOrderTreeWalk(root);
    }

    private void inOrderTreeWalk(Node root) {
        if (root != null) {
            inOrderTreeWalk(root.left);
            System.out.println(root.key);
            inOrderTreeWalk(root.right);
        }
    }

    /**
     * Add an element to the BST
     */
    void add(Integer element) {
        Node node = new Node(null, null, null, element);
        treeInsert(node);
    }

    /**
     *
     * @return min element of the tree
     */
    Integer findMinimum() {
        Node x = root;

        if (x == null) {
            return null;
        }

        while (x.left != null) {
            x = x.left;
        }

        return x.key;
    }

    /**
     *
     * @return max element of the tree
     */
    Integer findMaximum() {
        Node x = root;

        if (x == null) {
            return null;
        }

        while (x.right != null) {
            x = x.right;
        }

        return x.key;
    }

    /**
     * @return the successor of @param n
     */
    Integer findSuccessor(Integer n) {
        throw new UnsupportedOperationException("not yet implemented");
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
            searchTreeForNode(node.left, key);
        } else {
            searchTreeForNode(node.right, key);
        }

        return null;
    }

    /**
     * removes all occurrences of @param data from the tree.
     */
    void remove(Integer data) {
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
                x = node.left;
            } else {
                x = node.right;
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

    private class Node {
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
            return "Node has: parent= " + p + " left= " + l + " right= " + r;
        }
    }
}
