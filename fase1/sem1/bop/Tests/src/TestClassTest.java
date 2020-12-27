import org.junit.Test;


public class TestClassTest {
    @Test(expected = IllegalArgumentException.class)
    public void test () {
        new TestClass(null);
    }
}