package domain;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> {
    private BinaryTree<E> root;

    public void printInOrder() {
        if (this.isEmpty()) System.out.println("Geen data in BST");
        else root.printInOrder();
    }

    public boolean isEmpty() {
        return this.root == null;
    }

	public List<E> getPath(E data) {
		if (this.isEmpty()) return null;
		if (this.lookup(data) == false) return null;
		return root.getPath(data);
	}

    public boolean lookup(E data) {
        if (this.isEmpty()) return false;
        return root.lookup(data);
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

    public List<E> geefKnopenBinnenInterval(E min, E max) {
        if (this.isEmpty()) throw new IllegalStateException();
        return this.root.geefKnopenBinnenInterval(min, max);
    }

    private class BinaryTree<E extends Comparable<E>> {
        private E data;
        private BinaryTree<E> leftTree, rightTree;

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

        public boolean isLeaf() {
            return this.leftTree == null && this.rightTree == null;
        }

        public boolean lookup(E data) {
            if (data == null) {
                return false;
            } else if (data.compareTo(this.data) == 0) {
                return true;
            } else {
                return (this.leftTree == null ? false : this.leftTree.lookup(data)) || (this.rightTree == null ? false : this.rightTree.lookup(data));
            }
        }

        public boolean addNode(E data) {
            if (data == null) {
                throw new IllegalArgumentException();
            }
            if (this.data.compareTo(data) == 0) {
                return false;//geen twee keer zelfde data in BST
            } else if (this.data.compareTo(data) > 0) {
                //ga naar linkersubboom
                if (this.leftTree == null) {
                    this.leftTree = new BinaryTree<>(data);
                    return true;
                } else return (this.leftTree.addNode(data));
            } else if (this.rightTree == null) {

                this.rightTree = new BinaryTree<>(data);
                return true;
            } else
                return (this.rightTree.addNode(data));
        }

        public boolean removeNode(E data) {
           return false;
        }

        private void cleanUp() {

        }

        public E searchGreatest() {
            if (this.rightTree == null)
                return this.data;
            else
                return this.rightTree.searchGreatest();
        }


        public E searchSmallest() {
            if (this.leftTree == null)
                return this.data;
            else
                return this.leftTree.searchSmallest();
        }

        public List<E> getPath (E data) {
			List<E> path = new ArrayList<>();
			int i = data.compareTo(this.data);
			if (i == 0) {
				path.add(data);
				return path;
			}
			else {
				path.add(this.data);
				if (i < 0) {
					path.addAll(this.leftTree.getPath(data));
				}
				else path.addAll(this.rightTree.getPath(data));
			}
			return path;
		}

		public List<E> geefKnopenBinnenInterval(E min, E max) {
            if (min == null || max == null)
                throw new IllegalArgumentException();

            List<E> result = new ArrayList<>();
            if (min.compareTo(max) > 0) {
                return result;
            }

            if (this.leftTree != null) {
                result.addAll(this.leftTree.geefKnopenBinnenInterval(min, getMininmum(data, max)));
            }
            if (this.data.compareTo(min) >= 0 && this.data.compareTo(max) <= 0) {
                result.add(this.data);
            }
            if (this.rightTree != null) {
                result.addAll(this.rightTree.geefKnopenBinnenInterval(getMaximum(min, this.data), max));
            }
            return result;
        }

        private E getMininmum (E o1, E o2) {
            if (o1.compareTo(o2) <= 0)
                return o1;
            else
                return o2;
        }

        private E getMaximum (E o1, E o2) {
            if (o1.compareTo(o2) >= 0)
                return o1;
            else
                return o2;
        }
    }
}


