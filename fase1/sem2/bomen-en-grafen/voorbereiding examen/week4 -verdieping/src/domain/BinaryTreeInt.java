package domain;

public class BinaryTreeInt {
    private int data;
    private BinaryTreeInt leftTree, rightTree;

    public BinaryTreeInt(int data){
        this(data,null,null);
    }

    public BinaryTreeInt(int data, BinaryTreeInt leftTree, BinaryTreeInt rightTree){
        this.data= data;
        this.leftTree= leftTree;
        this.rightTree= rightTree;
    }

    public boolean kinderSom () {
        if (this.isLeaf()) {
            return true;
        }
        else {
            int i = this.data;

            i -= (this.leftTree != null ? this.leftTree.data : 0);
            i -= (this.rightTree != null ? this.rightTree.data : 0);
            if (i != 0){
                return false;
            }
            else {
                return (this.leftTree == null ? true : this.leftTree.kinderSom()) && (this.rightTree == null ? true : this.rightTree.kinderSom());
            }
        }
    }

    public boolean isLeaf () {
        return this.leftTree == null && this.rightTree == null;
    }
}
