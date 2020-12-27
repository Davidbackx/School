package ui;

import domain.BinaryTree;

public class BinaryTreeDriver {

	public static void main(String[] args) {

//		BinaryTree<Integer> node2 = new BinaryTree<>(8);
//		BinaryTree<Integer> node3 = new BinaryTree<>(-3);
//		BinaryTree<Integer> node4 = new BinaryTree<>(-1);
//		BinaryTree<Integer> node5 = new BinaryTree<>(10);
//		BinaryTree<Integer> node6 = new BinaryTree<>(-7);
//
//		BinaryTree<Integer> node7 = new BinaryTree<>(5, node2, node3);
//		BinaryTree<Integer> node8 = new BinaryTree<>(-1, node4, null);
//
//		BinaryTree<Integer> node9 = new BinaryTree<>(0);
//		BinaryTree<Integer> node10 = new BinaryTree<>(3, node5, node6);
//
//		BinaryTree<Integer> node11 = new BinaryTree<>(4, node7, node8);
//		BinaryTree<Integer> node12 = new BinaryTree<>(3, node9, node10);
//
//		BinaryTree<Integer> boom = new BinaryTree<>(7, node11, node12);
//		System.out.println(boom.kinderSom());

		BinaryTree<String> nodeM = new BinaryTree<>("M");
		BinaryTree<String> nodeF = new BinaryTree<>("F", nodeM, null);
		BinaryTree<String> nodeG = new BinaryTree<>("G");
		BinaryTree<String> nodeP = new BinaryTree<>("P");
		BinaryTree<String> nodeR = new BinaryTree<>("R");
		BinaryTree<String> nodeA = new BinaryTree<>("A", nodeG, nodeF);
		BinaryTree<String> nodeE = new BinaryTree<>("E", nodeR, nodeP);
		BinaryTree<String> boom = new BinaryTree<>("J", nodeE, nodeA);
		System.out.println("Volledige binaire boom strikt? -> " + boom.isStrikt());
		System.out.println("Binaire boom met enkel node R strikt? -> " + nodeR.isStrikt());
		System.out.println("Binaire boom met node E en kinden R en P strikt? -> " + nodeR.isStrikt());
	}

}
