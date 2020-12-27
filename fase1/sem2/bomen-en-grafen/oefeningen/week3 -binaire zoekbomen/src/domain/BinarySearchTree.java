package domain;

import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> {
    private BinaryTree<E> root;

    public void printInOrder() {
        if (this.isEmpty()) System.out.println("Geen data in BST");
        else root.printInOrder();
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean lookup(E data) {
        if (this.isEmpty()) return false;
        return root.lookup(data);
    }

    public void getPath (E data) {
    	if (data == null) throw new IllegalArgumentException();
    	else {
    		ArrayList<E> path = root.getPath(data);
    		System.out.println(path);
		}
	}

    public boolean addNode(E data) {
        if (this.isEmpty()) {
            root = new BinaryTree<>(data);
            return true;
        } else return root.addNode(data);
    }

    public boolean removeNode(E data) {
        if (this.isEmpty()) return false;
        else {
            boolean ok = root.removeNode(data);
            if (ok && root.isEmpty()) root = null;
            return ok;
        }
    }

    public E searchSmallest() {
        if (this.isEmpty()) throw new IllegalStateException();
        return this.root.searchSmallest();
    }

    public E searchGreatest() {
        if (this.isEmpty()) throw new IllegalStateException();
        return this.root.searchGreatest();
    }

    private class BinaryTree<E extends Comparable<E>> {
        private E data;
        private BinaryTree<E> leftTree, rightTree;

		public ArrayList<E> getPath (E data) {
			if (!lookup(data)) return null;
			ArrayList<E> pad = new ArrayList<>();
			if (this.data.compareTo(data) == 0) {
				pad.add(data);
				return pad;
			}
			else {
				pad.add(this.data);
				if (this.data.compareTo(data) > 0)  {
					pad.addAll(this.leftTree.getPath(data));
				}
				else {
					pad.addAll(this.rightTree.getPath(data));
				}
			}
			return pad;
		}

        public BinaryTree(E data) {
            if (data == null) throw new IllegalArgumentException();
            this.data = data;
        }

        public void printInOrder() {
            if (leftTree != null) leftTree.printInOrder();
            System.out.print(" " + data);
            if (rightTree != null) rightTree.printInOrder();
        }

        public boolean isEmpty() {
            return false;
        }

        public boolean lookup(E data) {
            if (data == null) throw new IllegalArgumentException();
            else {
                if (data.compareTo(this.data) == 0) return true;
                else {
                    if (data.compareTo(this.data) < 0) {
                        if (leftTree == null) return false;
                        else return leftTree.lookup(data);
                    } else {
                        if (rightTree == null) return false;
                        else return rightTree.lookup(data);
                    }
                }
            }
        }

        public boolean addNode(E data) {
            if (data == null) throw new IllegalArgumentException();
            else {
                if (data.compareTo(this.data) == 0) return false;
                else {
                    if (data.compareTo(this.data) < 0) {
                        if (leftTree == null) {
                            leftTree = new BinaryTree<>(data);
                            return true;
                        }
                        return leftTree.addNode(data);
                    } else {
                        if (rightTree == null) {
                            rightTree = new BinaryTree<>(data);
                            return true;
                        }
                        return rightTree.addNode(data);
                    }
                }
            }
        }


        public boolean removeNode(E data) {
           return false;
        }

        public E searchGreatest() {
            if (rightTree == null) return this.data;
            else return rightTree.searchGreatest();
        }

        public E searchSmallest() {
            if (leftTree == null) return this.data;
            else return leftTree.searchSmallest();
        }
    }
}