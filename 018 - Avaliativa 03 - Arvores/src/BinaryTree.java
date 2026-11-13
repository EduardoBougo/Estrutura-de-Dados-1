public class BinaryTree<T> {
    private BinaryNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryNode<T> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }
}