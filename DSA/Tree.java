package DSA;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int val) {
        this.value = val;
        this.left = null;
        this.right = null;
    }
}

public class Tree {
    Node root = null;

    private int deeper(Node parent) {
        if (parent == null) {
            return 0; // empty tree has height 0
        }

        int leftHeight = deeper(parent.left);
        int rightHeight = deeper(parent.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public void height() {
        int height = deeper(root);
        System.out.println(height);
    }

    private Node insertrecur(Node parent, int value) {
        if (parent == null) {
            Node nn = new Node(value);
            return nn;
        }
        if (parent.value > value) {
            parent.left = insertrecur(parent.left, value);
        } else {
            parent.right = insertrecur(parent.right, value);
        }
        return parent;

    }

    public void insert(int value) {
        root = insertrecur(root, value);
    }

    public void traverse(String type) {
        if (type.equals("preorder")) {
            preorder(root);
            System.out.println();
        } else if (type.equals("postorder")) {
            postorder(root);
            System.out.println();
        } else {
            inorder(root);
            System.out.println();
        }
    }

    private void searcher(Node parent, int value) {
        if (parent == null) {
            System.out.println("Not Found");
            return;
        }
        if (parent.value == value) {
            System.out.println("Found the value");
            return;
        } else if (parent.value > value) {
            searcher(parent.left, value);
        } else {
            searcher(parent.right, value);
        }
    }

    public void search(int value) {
        searcher(root, value);
    }

    private void preorder(Node parent) {
        if (parent == null) {
            return;
        }
        System.out.print(parent.value + " ");
        preorder(parent.left);
        preorder(parent.right);
    }

    private void postorder(Node parent) {
        if (parent == null) {
            return;
        }
        postorder(parent.left);
        postorder(parent.right);
        System.out.print(parent.value + " ");
    }

    private void inorder(Node parent) {
        if (parent == null) {
            return;
        }
        inorder(parent.left);
        System.out.print(parent.value + " ");
        inorder(parent.right);
    }

    private Node deleter(Node parent, int value) {
        if (parent == null) {
            System.out.println("Not found");
            return null;
        }

        if (value < parent.value) {
            parent.left = deleter(parent.left, value);
        } else if (value > parent.value) {
            parent.right = deleter(parent.right, value);
        } else {
            // node found
            // Case 1: no children
            if (parent.left == null && parent.right == null) {
                return null;
            }
            // Case 2: one child
            else if (parent.left == null) {
                return parent.right;
            } else if (parent.right == null) {
                return parent.left;
            }
            // Case 3: two children
            else {
                Node successor = findMin(parent.right);
                parent.value = successor.value;
                parent.right = deleter(parent.right, successor.value);
            }
        }
        return parent;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void delete(int value) {
        root = deleter(root, value);
    }

}