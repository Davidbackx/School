package ui;

import domain.BinaryTree;

public class BinaryTreeDriver {
    public static void main(String[] args) {

        BinaryTree<String> m = new BinaryTree<>("m");

        BinaryTree<String> r = new BinaryTree<>("r");
        BinaryTree<String> p = new BinaryTree<>("p");
        BinaryTree<String> g = new BinaryTree<>("g");
        BinaryTree<String> f = new BinaryTree<>("f", m, null);

        BinaryTree<String> e = new BinaryTree<>("e", r, p);
        BinaryTree<String> a = new BinaryTree<>("a", g, f);

        BinaryTree<String> j = new BinaryTree<>("j", e, a);

        System.out.println("volledige binaire boom strikt? -> " + j.isStrikt());
        System.out.println("binaire boom met enkel node R strikt? -> " + r.isStrikt());
        System.out.println("binaire boom met node E en kinderen R en P strikt? -> " + e.isStrikt());

    }
}
