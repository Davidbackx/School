public class test {
    public static void main(String[] args) {
        int b = 1;
        test.increment(b);

        System.out.println(b);
    }

    static void increment(int a ) {
        a++;
    }
}
