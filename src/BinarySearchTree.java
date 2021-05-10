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

    public boolean contains(T value) {

        int cmp = data.compareTo(value);

        if (cmp == 0) {
            return true;
        }
        else if (cmp < 0) {
            if (left == null) {
                return false;
            }
            else {
                return left.contains(value);
            }
        }
        else {
            if (right == null) {
                return false;
            }
            else {
                return right.contains(value);
            }

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

        BinarySearchTree<Integer> intTree = new BinarySearchTree<>(22);
        intTree.insert(13);
        intTree.insert(22);
        intTree.insert(19);
        intTree.insert(-21);
        intTree.insert(-50);

        Integer searchFor = new Integer(33);
        System.out.printf("The tree contains %d: %b \n", searchFor, intTree.contains(searchFor));
        intTree.printInOrder();
    }
}
