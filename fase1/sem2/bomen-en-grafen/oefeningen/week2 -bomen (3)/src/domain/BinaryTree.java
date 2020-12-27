package domain;

import java.util.ArrayList;
import java.util.List;

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

	public int getDepth () {
		return 1 + Math.max( (leftTree == null ? 0 : leftTree.getDepth()),  (rightTree == null ? 0 : rightTree.getDepth()));
	}

	public int countLeaves () {
		if (isLeaf()) {
			return 1;
		}
		return (leftTree == null ? 0 : leftTree.countLeaves()) + (rightTree == null ? 0 : rightTree.countLeaves());
	}

	public List<E> getDataLeaves () {
		List<E> t = new ArrayList<>();
		if (isLeaf()) {
			t.add(this.data);
		}
		else {
			if (this.leftTree != null) {
				t.addAll(this.leftTree.getDataLeaves());
			}
			if (this.rightTree != null) {
				t.addAll(this.rightTree.getDataLeaves());
			}
		}
		return t;
	}

	public void printPreorder(){
			System.out.print(this.data + " ");
			if (this.leftTree != null) this.leftTree.printPreorder();
			if (this.rightTree != null) this.rightTree.printPreorder();
	}

	private boolean isLeaf() {
		return leftTree == null && rightTree == null;
	}

	public boolean contains (E data) {
		if (data == null){
			return false;
		}
		if (this.data.equals(data)) return true;
		else {
			return (this.leftTree == null ? false : this.leftTree.contains(data)) || (this.rightTree == null ? false : this.rightTree.contains(data));
		}
	}
}
