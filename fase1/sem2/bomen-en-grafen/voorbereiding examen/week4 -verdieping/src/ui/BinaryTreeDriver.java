package ui;

import domain.BinarySearchTree;
import domain.BinaryTree;
import domain.BinaryTreeInt;

public class BinaryTreeDriver {

    public static void main(String[] args) {
        oefening421_isStrikt();
    }

    public static void oefeningenReeks1() {
        BinaryTree<String> nodeE1 = new BinaryTree<>("E");
        BinaryTree<String> nodeE2 = new BinaryTree<>("E");

        BinaryTree<String> nodeC = new BinaryTree<>("C", null, nodeE1);
        BinaryTree<String> nodeE3 = new BinaryTree<>("E");
        BinaryTree<String> nodeH1 = new BinaryTree<>("H", null, nodeE2);
        BinaryTree<String> nodeE4 = new BinaryTree<>("E");

        BinaryTree<String> nodeA = new BinaryTree<>("A");
        BinaryTree<String> nodeH2 = new BinaryTree<>("H", nodeC, nodeE3);
        BinaryTree<String> nodeI = new BinaryTree<>("I", nodeH1, nodeE4);

        BinaryTree<String> nodeH3 = new BinaryTree<>("H", nodeA, nodeH2);
        BinaryTree<String> nodeG = new BinaryTree<>("G", null, nodeI);

        BinaryTree<String> boom = new BinaryTree<>("A", nodeH3, nodeG);
        boom.printPreorder();

        System.out.println("\n");
        System.out.println("#Nodes= " + boom.countNodes());
        System.out.println("Depth= " + boom.getDepth());
        System.out.println("#Leaves= " + boom.countLeaves());
        System.out.println("Data leaves= " + boom.getDataLeaves());
        System.out.println("Contains H= " + boom.contains("H"));
        System.out.println("\n");
        System.out.println("Voorkomens I= " + boom.count("I"));
        System.out.println("Voorkomens A= " + boom.count("A"));
        System.out.println("Voorkomens H= " + boom.count("H"));
        System.out.println("Voorkomens E= " + boom.count("E"));
        System.out.println("Voorkomens Q= " + boom.count("Q"));
        System.out.println("\n");
        System.out.println("Distance 0= " + boom.getNodesAtDistance(0));
        System.out.println("Distance 1= " + boom.getNodesAtDistance(1));
        System.out.println("Distance 2= " + boom.getNodesAtDistance(2));
        System.out.println("Distance 3= " + boom.getNodesAtDistance(3));
        System.out.println("Distance 4= " + boom.getNodesAtDistance(4));
    }

    public static void oefeningenReeks2() {
        BinaryTreeInt node1 = new BinaryTreeInt(8);
        BinaryTreeInt node2 = new BinaryTreeInt(-3);
        BinaryTreeInt node3 = new BinaryTreeInt(-1);
        BinaryTreeInt node4 = new BinaryTreeInt(10);
        BinaryTreeInt node5 = new BinaryTreeInt(-7);

        BinaryTreeInt node6 = new BinaryTreeInt(5, node1, node2);
        BinaryTreeInt node7 = new BinaryTreeInt(-1, node3, null);
        BinaryTreeInt node8 = new BinaryTreeInt(0);
        BinaryTreeInt node9 = new BinaryTreeInt(3, node4, node5);

        BinaryTreeInt node10 = new BinaryTreeInt(4, node6, node7);
        BinaryTreeInt node11 = new BinaryTreeInt(3, node8, node9);

        BinaryTreeInt boom = new BinaryTreeInt(7, node10, node11);

        System.out.println("Kindersom= " + boom.kinderSom());
    }

    public static void oefening420_deelZonder() {
        BinaryTree<String> nodeA = new BinaryTree<>("A");
        BinaryTree<String> nodeC = new BinaryTree<>("C");
        BinaryTree<String> nodeE = new BinaryTree<>("E");
        BinaryTree<String> nodeH = new BinaryTree<>("H");
        BinaryTree<String> nodeD = new BinaryTree<>("D", nodeC, nodeE);
        BinaryTree<String> nodeB = new BinaryTree<>("B", nodeA, nodeD);
        BinaryTree<String> nodeI = new BinaryTree<>("I", nodeH, null);
        BinaryTree<String> nodeG = new BinaryTree<>("G", null, nodeI);
        BinaryTree<String> boom = new BinaryTree<>("F", nodeB, nodeG);

        System.out.println("\nVolledige boom preorder:");
        boom.printPreorder();
        System.out.println("\nVolledige boom inorder:");
        boom.printInOrder();
        BinaryTree<String> boomZonderI = boom.deelZonder("I");
        System.out.println("\nBoom zonder I preorder: ");
        boomZonderI.printPreorder();
        System.out.println("\nBoom zonder I inorder: ");
        boomZonderI.printInOrder();
        BinaryTree<String> boomZonderB = boom.deelZonder("B");
        System.out.println("\nBoom zonder B preorder: ");
        boomZonderB.printPreorder();
        System.out.println("\nBoom zonder B inorder: ");
        boomZonderB.printInOrder();
    }

    public static void oefening421_isStrikt() {
        BinaryTree<String> nodeM = new BinaryTree<>("M");

        BinaryTree<String> nodeR = new BinaryTree<>("R");
        BinaryTree<String> nodeP = new BinaryTree<>("P");
        BinaryTree<String> nodeG = new BinaryTree<>("G");
        BinaryTree<String> nodeF = new BinaryTree<>("F", nodeM, null);

        BinaryTree<String> nodeE = new BinaryTree<>("E", nodeR, nodeP);
        BinaryTree<String> nodeA = new BinaryTree<>("A", nodeG, nodeF);

        BinaryTree<String> boom = new BinaryTree<>("J", nodeE, nodeA);

        System.out.println("volledige binaire boom strikt -> " + boom.isStrikt());
        System.out.println("binaire boom met enkel node R strikt -> " + nodeR.isStrikt());
        System.out.println("binaire boom met node E en kinderen R en P strikt -> " + nodeR.isStrikt());
    }

    public static void oefening422_binnenInterval() {
        BinarySearchTree<Integer> boom = new BinarySearchTree<>();
        boom.addNode(6);
        boom.addNode(4);
        boom.addNode(8);
        boom.addNode(3);
        boom.addNode(5);
        boom.addNode(7);
        boom.addNode(9);
        System.out.println("\nKnopen tussen 5 en 8: " + boom.geefKnopenBinnenInterval(5, 8));
        System.out.println("\nKnopen tussen 3 en 5: " + boom.geefKnopenBinnenInterval(3, 5));
        System.out.println("\nKnopen tussen 8 en 9: " + boom.geefKnopenBinnenInterval(8, 9));
        System.out.println("\nKnopen tussen -10 en 0: " + boom.geefKnopenBinnenInterval(-10, 0));
        System.out.println("\nKnopen tussen 100 en 110: " + boom.geefKnopenBinnenInterval(100, 110));
    }

}
