package lesson6;

public class Tree {
    private Node root;

    public void insert(Animal animal) {
        Node node = new Node();
        node.animal = animal;
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (animal.id < current.animal.id) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                }
            }

        }
    }

    public Node search(int key) {
        Node current = root;
        while (current.animal.id != key) {
            if (key < current.animal.id) {
                current = current.leftChild;
            } else current = current.rightChild;
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    private void prefixOrder(Node rootNode) {
        if (rootNode != null) {
            rootNode.display();
            prefixOrder(rootNode.leftChild);
            prefixOrder(rootNode.rightChild);
        }
    }

    private void postfixOrder(Node rootNode) {
        if (rootNode != null) {
            postfixOrder(rootNode.leftChild);
            postfixOrder(rootNode.rightChild);
            rootNode.display();
        }
    }

    private void inOrder(Node rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.leftChild);
            rootNode.display();
            inOrder(rootNode.rightChild);
        }
    }

    public Node max() {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    public Node min() {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public boolean delete(int id) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.animal.id != id) {
            parent = current;
            if (id < current.animal.id) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if (current == null) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (current == null) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public Node getSuccessor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != node.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
    }

    public void displayTree() {
        Node current = root;
        System.out.println("Symmetric order: ");
        inOrder(root);
        System.out.println("Direct order: ");
        prefixOrder(root);
        System.out.println("Indirect: ");
        postfixOrder(root);
    }
}
