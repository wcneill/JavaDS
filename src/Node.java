public class Node<T extends Comparable<T>> {

    Node<T> left, right;
    T data;

    public Node(T data){
        this.data = data;
    }

    public void insert(T value){

        int cmp = data.compareTo(value);

        if (cmp < 0 || cmp == 0) {
            if (left == null) {
                left = new Node<>(value);
            }
            else {
                left.insert(value);
            }
        }
        else {
            if (right == null){
                right = new Node<>(value);
            }
            else {
                right.insert(value);
            }
        }
    }

    public boolean contains(Node<T> root, T value) {

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

}
