package ui;

import domain.BinarySearchTree;

public class BinarySearchTreeDriver {

    public static void main(String[] args) {
        BinarySearchTree<Integer> boom = new BinarySearchTree<>();
//        boom.addNode(6);
//        boom.addNode(4);
//        boom.addNode(8);
//        boom.addNode(3);
//        boom.addNode(5);
//        boom.addNode(7);
//        boom.addNode(9);
//
//        System.out.println("\nKnopen tussen 5 en 8: " + boom.geefKnopenBinnenInterval(5, 8));
//        System.out.println("\nKnopen tussen 3 en 5: " + boom.geefKnopenBinnenInterval(3, 5));
//        System.out.println("\nKnopen tussen 8 en 9: " + boom.geefKnopenBinnenInterval(8, 9));
//        System.out.println("\nKnopen tussen -10 en 0: " + boom.geefKnopenBinnenInterval(-10, 0));
//        System.out.println("\nKnopen tussen 100 en 110: " + boom.geefKnopenBinnenInterval(100, 110));

        printBoomInfo(boom);
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
