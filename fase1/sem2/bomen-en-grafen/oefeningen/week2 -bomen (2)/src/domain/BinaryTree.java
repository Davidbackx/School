package domain;

public class BinaryTree<E> {
	private E data;
	private BinaryTree<E> leftTree, rightTree;
	
	public BinaryTree(E data){
		this(data,null,null);
	}
	
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
		if (data == null) {
			throw new IllegalArgumentException();
		}
		this.data= data;
		this.leftTree= leftTree;
		this.rightTree= rightTree;
	}

	public boolean kinderSom () {
		if (this.isLeaf()) return true;
		else {
			int left_som = (this.leftTree != null ? (int)this.leftTree.data : 0);
			int right_som = (this.rightTree != null ? (int)this.rightTree.data : 0);
			if ((int)this.data != left_som + right_som) {
				return false;
			}
		}
		return (this.leftTree != null  ? this.leftTree.kinderSom() : true) &&
				(this.rightTree != null  ? this.rightTree.kinderSom() : true) ;
	}

	public boolean isStrikt() {
		if (this.isLeaf()) {
			return true;
		}
		if (this.leftTree != null && this.rightTree != null) {
			return this.leftTree.isStrikt() && this.rightTree.isStrikt();
		}
		return false;
	}

	private boolean isLeaf () {
		if (this.leftTree == null && this.rightTree == null) {
			return true;
		} else return false;
	}

	public void printPreorder(){
			System.out.print(this.data + " ");
			if (this.leftTree != null) this.leftTree.printPreorder();
			if (this.rightTree != null) this.rightTree.printPreorder();
	}

}
