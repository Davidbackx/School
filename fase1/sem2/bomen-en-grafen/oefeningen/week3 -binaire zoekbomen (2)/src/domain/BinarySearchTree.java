package domain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> {
	private BinaryTree<E> root;

	public void printInOrder() {
			if (this.isEmpty()) System.out.println("Geen data in BST");
			else root.printInOrder();
	}

	public boolean isEmpty(){
		return this.root == null;
	}

	public List<E> getPath (E data) {
		if (data == null) throw new IllegalArgumentException();
		if (root.lookup(data) == false) throw new IllegalArgumentException();
		return root.getPath(data);
	}

	public boolean lookup(E data){
		if (this.isEmpty()) return false;
		return root.lookup(data);
	}

	public boolean addNode(E data){
		if (this.isEmpty()) {
			root = new BinaryTree<>(data);
			return true;
		}
		else return root.addNode(data);
	}

	public boolean removeNode(E data){
		if (this.isEmpty()) return false;
		else {
			boolean ok = root.removeNode(data);
			if (ok && root.isEmpty()) root = null;
			return ok;
		}
	}

	public E searchSmallest(){
		if(this.isEmpty()) throw new IllegalStateException();
		return this.root.searchSmallest();
	}

	public E searchGreatest(){
		if (this.isEmpty()) throw new IllegalStateException();
		return this.root.searchGreatest();
	}

	private class BinaryTree<E extends Comparable<E>>{
		private E data;
		private BinaryTree<E> leftTree, rightTree;

		public BinaryTree(E data){
			if (data == null) throw new IllegalArgumentException();
			this.data = data;
		}

		public void printInOrder(){
			if (leftTree != null) leftTree.printInOrder();
			System.out.print(" " + data);
			if (rightTree != null) rightTree.printInOrder();
		}

		public boolean isEmpty() {
			return false;
		}

		public boolean lookup(E data){
			if (data == null) return false;
			if (this.data.compareTo(data) == 0) return true;
			else {
				int i = this.data.compareTo(data);
				if (i > 0) {
					return (leftTree == null ? false : leftTree.lookup(data));
				}
				else {
					return (rightTree == null ? false : rightTree.lookup(data));
				}
			}
		}

		public boolean addNode(E data){
			if (data == null) throw new IllegalArgumentException();
			if (this.data.compareTo(data) == 0) return false;
			else if (this.data.compareTo(data) > 0) {
				if (this.leftTree == null) {
					this.leftTree = new BinaryTree<>(data);
					return true;
				}
				else return (leftTree.addNode(data));
			}
			else if (this.rightTree == null) {
				this.rightTree = new BinaryTree<>(data);
				return true;
			}
			else return this.rightTree.addNode(data);
		}


		public boolean removeNode(E data){
			return false;
		}

		private void cleanUp(){
			
		}

		public E searchGreatest() {
			if (this.rightTree == null) {
				return data;
			}
			else {
				return this.rightTree.searchGreatest();
			}
		}


		public E searchSmallest() {
			if (this.leftTree == null) {
				return data;
			}
			else {
				return this.leftTree.searchSmallest();
			}
		}

		public ArrayList<E> getPath (E data) {
			if (!lookup(data)) return null;
			ArrayList<E> pad = new ArrayList<>();
			if (this.data.compareTo(data) == 0) {
				pad.add(data);
				return pad;
			}
			else {
				pad.add(this.data);
				if (this.data.compareTo(data) > 0)
					pad.addAll(this.leftTree.getPath(data));
				else
					pad.addAll(this.rightTree.getPath(data));
			}
			return pad;
		}
	}
}


