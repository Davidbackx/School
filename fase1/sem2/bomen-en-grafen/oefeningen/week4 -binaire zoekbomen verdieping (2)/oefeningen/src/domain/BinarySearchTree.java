package domain;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> {
    private BinaryTree<E> root;

    public void printInOrder() {
        if (this.isEmpty()) System.out.println("Geen data in BST");
        else root.printInOrder();
    }

	public ArrayList<E> geefKnopenBinnenInterval(E min, E max) {
    	if (this.isEmpty())
    		throw new IllegalStateException("Empty tree");
    	return this.root.geefKnopenBinnenInterval(min, max);
    }

    public boolean isEmpty() {
        return this.root == null;
    }

	public ArrayList<E> getNodesAtDistance (int k) {
		if (this.isEmpty()) return null;
		return root.getNodesAtDistance(k);
	}

    public boolean lookup(E data) {
        if (this.isEmpty()) return false;
        return root.lookup(data);
    }

	public ArrayList<E> getPath(E data) {
		if (this.isEmpty()) return null;
		return root.getPath(data);
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
                if (data.compareTo(this.data) == 0) {
                    return true;
                } else {
                    if (data.compareTo(this.data) < 0) {
                        if (this.leftTree == null) return false;
                        return this.leftTree.lookup(data);
                    } else {
                        if (this.rightTree == null) return false;
                        return this.rightTree.lookup(data);
                    }
                }
            }
        }

        public boolean addNode(E data) {
            if (data == null) throw new IllegalArgumentException();
            else {
                if (data.compareTo(this.data) == 0) {
                    return false;
                } else {
                    if (data.compareTo(this.data) < 0) {
                        if (this.leftTree == null) {
                            this.leftTree = new BinaryTree<>(data);
                        } else return this.leftTree.addNode(data);
                    } else {
                        if (this.rightTree == null) {
                            this.rightTree = new BinaryTree<>(data);
                        } else return this.rightTree.addNode(data);
                    }
                }
                return false;
            }
        }


        public boolean removeNode(E data) {
            if (data == null) throw new IllegalArgumentException();
            if (this.data == null) return false;

            if (data.compareTo(this.data) == 0) {
                if (this.isLeaf()) {
                    this.data = null;
                    return true;
                } else {
                    if (this.leftTree != null) {
                        E grootsteLinks = this.leftTree.searchGreatest();
                        this.data = grootsteLinks;
                        boolean verwijderenGelukt = this.leftTree.removeNode(grootsteLinks);
                        if (verwijderenGelukt) {
                            this.leftTree.cleanUp();
                        }
                        return verwijderenGelukt;
                    } else {
                        E kleinsteRechts = this.rightTree.searchSmallest();
                        this.data = kleinsteRechts;
                        boolean verwijderenGelukt = this.rightTree.removeNode(kleinsteRechts);
                        if (verwijderenGelukt) {
                            this.rightTree.cleanUp();
                        }
                        return verwijderenGelukt;
                    }
                }
            } else {
                if (data.compareTo(this.data) < 0) {
                    if (this.leftTree == null) return false;
                    else return this.leftTree.removeNode(data);
                } else {
                    if (this.rightTree == null) return false;
                    else return this.rightTree.removeNode(data);
                }
            }
        }

        private void cleanUp() {
            if (this.data != null) {
                if (this.leftTree != null) {
                    if (this.leftTree.data == null) {
                        this.leftTree = null;
                    } else {
                        this.leftTree.cleanUp();
                    }
                }
                if (this.rightTree != null) {
                    if (this.rightTree.data == null) {
                        this.rightTree = null;
                    } else {
                        this.rightTree.cleanUp();
                    }
                }
            }
        }

        public E searchGreatest() {
            if (this.rightTree == null) return this.data;
            else {
                return this.rightTree.searchGreatest();
            }
        }


        public E searchSmallest() {
            if (this.leftTree == null) return this.data;
            else {
                return this.leftTree.searchSmallest();
            }
        }

        public boolean isLeaf() {
            return this.leftTree == null && this.rightTree == null;
        }

        public ArrayList<E> getPath (E data) {
			if (data == null) throw new IllegalArgumentException();
			if (!lookup(data)) return null;

			ArrayList<E> path = new ArrayList<>();
			if (data.compareTo(this.data) == 0) {
				path.add (data);
				return path;
			}
			else {
				path.add(this.data);
				if (this.data.compareTo(data) > 0){
					path.addAll(this.leftTree.getPath(data));
				}
				else {
					path.addAll(this.rightTree.getPath(data));
				}
			}

			return path;
		}

		public ArrayList<E> getNodesAtDistance (int k) {
			if (k < 0) throw new IllegalArgumentException("Foute waarde voor afstand");

			ArrayList<E> res = new ArrayList<>();
			if (k == 0) {
				res.add(this.data);
			}
			else {
				if (this.leftTree != null) {
					res = this.leftTree.getNodesAtDistance(k - 1);
				}
				if (this.rightTree != null) {
					ArrayList<E> rechterlijst = this.rightTree.getNodesAtDistance(k - 1);
					res.addAll(rechterlijst);
				}
			}
			return res;
		}

		public ArrayList<E> geefKnopenBinnenInterval (E min, E max) {
			if (min == null || max == null) throw new IllegalArgumentException();
			ArrayList<E> result = new ArrayList<>();
			if (min.compareTo(max) > 0) return result;
			if (this.leftTree != null)
				result.addAll(this.leftTree.geefKnopenBinnenInterval(min, getMaximum(this.data, max)));
			if (this.data.compareTo(min) >= 0 && this.data.compareTo(max) <= 0)
				result.add(this.data);
			if (this.rightTree != null)
				result.addAll(this.rightTree.geefKnopenBinnenInterval(getMaximum(min, this.data), max));
			return result;
		}

		public E getMinimum (E o1, E o2) {
			if (o1.compareTo(o2) <= 0)
				return o1;
			else return o2;
		}

		public E getMaximum (E o1, E o2) {
			if (o1.compareTo(o2) >= 0)
				return o1;
			else return o2;
		}
    }
}


