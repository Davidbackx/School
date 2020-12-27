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

	public int count (E data) {
		if (data == null) {
			return 0;
		}
		return (this.data.equals(data) ? 1 : 0) + (this.leftTree == null ? 0 : this.leftTree.count(data)) + (this.rightTree == null ? 0 : this.rightTree.count(data));
	}

	public List<E> getNodesAtDistance (int k) {
		ArrayList<E> res = new ArrayList<>();
		if (k == 0){
			res.add(this.data);
		}
		else {
			if (this.leftTree != null) {
				res.addAll(this.leftTree.getNodesAtDistance(k - 1));
			}
			if (this.rightTree != null) {
				res.addAll(this.rightTree.getNodesAtDistance(k - 1));
			}
		}
		return res;
	}

	public BinaryTree<E> deelZonder (E wortelInfo) {
		if (wortelInfo == null || !this.contains(wortelInfo)) {
			return null;
		}

		if (wortelInfo == this.data) {
			return null;
		}
		if (this.leftTree != null && this.leftTree.data.equals(wortelInfo)) {
			return new BinaryTree<>(this.data, null, this.rightTree);
		}
		if (this.rightTree != null && this.rightTree.data.equals(wortelInfo)) {
			return new BinaryTree<>(this.data, this.leftTree, null);
		}
		BinaryTree newLeftTree, newRightTree;
		if (this.leftTree != null && this.leftTree.contains(wortelInfo)) {
			newLeftTree = this.leftTree.deelZonder(wortelInfo);
		}
		else {
			newLeftTree = this.leftTree;
		}
		if (this.rightTree != null && this.rightTree.contains(wortelInfo)) {
			newRightTree = this.rightTree.deelZonder(wortelInfo);
		}
		else {
			newRightTree = this.rightTree;
		}
		return new BinaryTree<>(this.data, newLeftTree, newRightTree);
	}

	public boolean isStrikt () {
		if (isLeaf()) {
			return true;
		}
		if (this.leftTree != null && this.rightTree != null) {
			return this.leftTree.isStrikt() && this.rightTree.isStrikt();
		}
		else return false;
	}
}
