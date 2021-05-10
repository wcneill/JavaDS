public class BinarySearchTree<T extends Comparable<T>> {

    BinarySearchTree<T> left, right;
    T data;

    public BinarySearchTree(T data){
        this.data = data;
    }

    public void insert(T value){

        int cmp = data.compareTo(value);

        if (cmp < 0 || cmp == 0) {
            if (left == null) {
                left = new BinarySearchTree<>(value);
            }
            else {
                left.insert(value);
            }
        }
        else {
            if (right == null){
                right = new BinarySearchTree<>(value);
            }
            else {
                right.insert(value);
            }
        }
    }

    public boolean contains(BinarySearchTree<T> root, T value) {

        if (root == null){
            return false;
        }

        int cmp = data.compareTo(value);

        if (cmp == 0) {
            return true;
        }
        else if (cmp < 0) {
            return left.contains(root, value);
        }
        else {
            return right.contains(root, value);
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(data);
        if (right != null) {
            right.printInOrder();
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<String> stringTree = new BinarySearchTree<>("Hello");
        stringTree.insert("World,");
        stringTree.insert("My");
        stringTree.insert("Name");
        stringTree.insert("is");
        stringTree.insert("Wesley!");

        stringTree.printInOrder();

        BinarySearchTree<Integer> intTree = new BinarySearchTree<>(22);
        intTree.insert(13);
        intTree.insert(22);
        intTree.insert(19);
        intTree.insert(-21);
        intTree.insert(-50);

        intTree.printInOrder();
    }



}
