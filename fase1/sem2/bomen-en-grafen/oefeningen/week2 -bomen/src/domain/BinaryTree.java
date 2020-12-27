package domain;

import java.lang.reflect.Array;
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

	public void printInorder(){
		if (this.leftTree != null) this.leftTree.printInorder();
		System.out.print(this.data + " ");
		if (this.rightTree != null) this.rightTree.printInorder();
	}


	public void printPostorder(){
		if (this.leftTree != null) this.leftTree.printPostorder();
		if (this.rightTree != null) this.rightTree.printPostorder();
		System.out.print(this.data + " ");
	}

	public int countNodes () {
		return 1 +
				(this.leftTree == null ? 0: this.leftTree.countNodes() ) +
				(this.rightTree == null ? 0: this.rightTree.countNodes() );
	}

	public int getDepth () {
		return 1 +
				Math.max ((this.leftTree == null ? 0 : leftTree.getDepth()) , this.rightTree == null ? 0: rightTree.getDepth());
	}

	public boolean isLeaf () {
		return this.rightTree == null && this.leftTree == null;
	}

	public int countLeaves () {
		if (isLeaf()) return 1;
		else {
			return (this.leftTree == null ? 0 : leftTree.countLeaves())
					+ (this.rightTree == null ? 0 : rightTree.countLeaves());
		}
	}

	public ArrayList<E> getDataLeaves () {
		ArrayList<E> res = new ArrayList<>();
		if (this.isLeaf()) res.add(this.data);
		else {
			res = (this.leftTree == null ? new ArrayList<>() : this.leftTree.getDataLeaves());
			ArrayList<E> rightLeaves =
					(this.rightTree == null ? new ArrayList<>() : this.rightTree.getDataLeaves());
			res.addAll(rightLeaves);
		}
		return res;
	}

	public boolean contains (E s) {
		if (s == null) return false;
		if (this.data.equals(s)) return true;
		else {
			return (this.leftTree == null ? false : this.leftTree.contains(s)) ||
					(this.rightTree == null ? false : this.rightTree.contains(s));
		}
	}

	public boolean kinderSom () {
		if (this.isLeaf())
			return true;

		int som = (Integer) this.data;
		som -= (this.leftTree == null ? 0 : (Integer)this.leftTree.data);
		som -= (this.rightTree == null ? 0 : (Integer)this.rightTree.data);
		if (som != 0)
			return false;

		return (leftTree != null ? leftTree.kinderSom() : true) && (rightTree != null ? rightTree.kinderSom() : true);
	}
}
