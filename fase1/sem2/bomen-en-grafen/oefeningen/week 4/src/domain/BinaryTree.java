package domain;
import java.util.ArrayList;
public class BinaryTree<E> {
    private E data;
    private BinaryTree<E> leftTree, rightTree;

    public BinaryTree(E data) {
        this(data,null,null);
    }

    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        this.data = data;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }

    public boolean isStrikt () {
        if (this.leftTree == null && this.rightTree == null)
            return true;
        if (this.leftTree != null && this.rightTree != null) {
            return this.leftTree.isStrikt() && this.rightTree.isStrikt();
        }
        else return false;
    }
}