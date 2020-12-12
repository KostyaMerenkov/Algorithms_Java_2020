
import java.util.NoSuchElementException;

public class MyTreeMap<Key extends Comparable<Key>, Value> {
    private Node root;
    private int maxHeight = 0;

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }



    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;
        int height;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            size = 1;
            height = 0;
        }
    }
    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private void isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key shouldn't be null");
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        isKeyNotNull(key);
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    public void put(Key key, Value value) {
        isKeyNotNull(key);
        if (value == null) {
            //delete
            return;
        }
        int temp_height = 0;
        root = put(root, key, value, temp_height);
    }

    private Node put(Node node, Key key, Value value, int theight) {

        if (node == null) {
            Node tempNode = new Node(key, value);
            tempNode.height = theight;
            if (getMaxHeight() < theight) setMaxHeight(theight);
            return tempNode;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.height = theight;
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(node.left, key, value, ++theight);
        } else {
            node.right = put(node.right, key, value, ++theight);
        }

        node.size = size(node.left) + size(node.right) + 1;
        if (getMaxHeight() < theight) setMaxHeight(theight);
        return node;
    }

    public Key minKey() {
        if (isEmpty()) {
            throw new NoSuchElementException("map empty");
        }
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("map empty");
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key) {
        isKeyNotNull(key);
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node temp = node;
            node = min(node.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }

        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }


    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }
        return toString(node.left) + " " + node.key + " " + toString(node.right);
    }

    private Boolean isBalanced(Node node) {
        if(isEmpty()) return true;
        if(node.left == null || node.right == null) { return true; }
        return Math.abs(node.left.height - node.right.height)<=1 && isBalanced(node.left) && isBalanced(node.right);
    }

    public Boolean isBalanced() {
        return isBalanced(root);
    }
}
