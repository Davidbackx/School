package ui;

import domain.BinaryTree;

public class BinaryTreeDriver {

	public static void main(String[] args) {
//		BinaryTree<String> nodeA = new BinaryTree<>("A");
//		BinaryTree<String> nodeC = new BinaryTree<>("C");
//		BinaryTree<String> nodeE = new BinaryTree<>("E");
//		BinaryTree<String> nodeH = new BinaryTree<>("H");
//
//
//		BinaryTree<String> nodeI = new BinaryTree<>("I",nodeH,null);
//		BinaryTree<String> nodeG = new BinaryTree<>("G",null, nodeI);
//		BinaryTree<String> nodeD = new BinaryTree<>("D",nodeC,nodeE);
//		BinaryTree<String> nodeB = new BinaryTree<>("B",nodeA, nodeD);
//		BinaryTree<String> boom = new BinaryTree<>("F",nodeB, nodeG);
//		boom.printPostorder();

		BinaryTree<Integer> nodeA = new BinaryTree<>(8);
		BinaryTree<Integer> nodeB = new BinaryTree<>(-3);
		BinaryTree<Integer> nodeC = new BinaryTree<>(-1);
		BinaryTree<Integer> nodeD = new BinaryTree<>(10);
		BinaryTree<Integer> nodeE = new BinaryTree<>(-7);

		BinaryTree<Integer> nodeF = new BinaryTree<>(5, nodeA, nodeB);
		BinaryTree<Integer> nodeG = new BinaryTree<>(-1, nodeC, null);
		BinaryTree<Integer> nodeH = new BinaryTree<>(0);
		BinaryTree<Integer> nodeI = new BinaryTree<>(3, nodeD, nodeE);

		BinaryTree<Integer> nodeK = new BinaryTree<>(4, nodeF, nodeG);
		BinaryTree<Integer> nodeL = new BinaryTree<>(3, nodeH, nodeI);

		BinaryTree<Integer> boom = new BinaryTree<>(7, nodeK, nodeL);

		boom.printPreorder();
		System.out.println(boom.kinderSom());
	}

}