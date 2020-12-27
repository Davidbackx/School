package domain;

import java.util.ArrayList;

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
	
	public void printPreorder(){
			System.out.print(this.data + " ");
			if (this.leftTree != null) this.leftTree.printPreorder();
			if (this.rightTree != null) this.rightTree.printPreorder();
	}

	public void printInOrder(){
		if (this.leftTree != null) this.leftTree.printInOrder();
		System.out.print(this.data + " ");
		if (this.rightTree != null) this.rightTree.printInOrder();
	}

	public void printPostOrder(){
		if (this.leftTree != null) this.leftTree.printPostOrder();
		System.out.print(this.data + " ");
		if (this.rightTree != null) this.rightTree.printPostOrder();
	}

	public int countNodes () {
		return 1 + (this.leftTree == null ? 0 : this.leftTree.countNodes()) + (this.rightTree == null ? 0 : this.rightTree.countNodes());
	}

	public int getDepth () {
		return 1 + Math.max ((this.leftTree == null ? 0 : this.leftTree.getDepth()), (this.rightTree == null ? 0 : this.rightTree.getDepth()));
	}

	public boolean isLeaf () {
		return this.leftTree == null && this.rightTree == null;
	}

	public int countLeaves () {
		if (isLeaf()) {
			return 1;
		}
		else return (this.leftTree == null ? 0 : this.leftTree.countLeaves()) + (this.rightTree == null ? 0 : this.rightTree.countLeaves());
	}

	public ArrayList<E> getDataLeaves () {
		ArrayList<E> result = new ArrayList<>();
		if (isLeaf()) {
			result.add(this.data);
			return result;
		}
		else {
			result.addAll (this.leftTree == null ? new ArrayList<>() : this.leftTree.getDataLeaves());
			result.addAll (this.rightTree == null ? new ArrayList<>() : this.rightTree.getDataLeaves());
		}
		return result;
	}

	public boolean contains (E s) {
		if (s == null) {
			return false;
		}
		if (s.equals(this.data)) {
			return true;
		}
		else {
			return (this.leftTree == null ? false : this.leftTree.contains(s)) || (this.rightTree == null ? false : this.rightTree.contains(s));
		}
	}
}
