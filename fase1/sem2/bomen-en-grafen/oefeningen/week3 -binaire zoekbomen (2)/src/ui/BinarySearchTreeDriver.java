package ui;

import domain.BinarySearchTree;

public class BinarySearchTreeDriver {

	public static void main(String[] args) {
		BinarySearchTree<Integer> boom = new BinarySearchTree<>();
		boom.addNode(5);
		boom.addNode(4);
		boom.addNode(8);
		boom.addNode(3);
		boom.addNode(7);
		boom.addNode(10);

		printBoomInfo(boom);
		System.out.println(boom.lookup(3));
		System.out.println(boom.getPath(7));

	}

	private static void printBoomInfo(BinarySearchTree<Integer> boom) {
		if (boom == null) System.out.println("Lege boom");
		else {
			boom.printInOrder();
			System.out.println();
			if (!boom.isEmpty()) {
				System.out.println("De grootste waarde uit deze boom = " + boom.searchGreatest());
				System.out.println("De kleinste waarde uit deze boom = " + boom.searchSmallest());
			}
		}


	}
}
