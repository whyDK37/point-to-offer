package point.to.offer;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Test07Test {

    @Test
    public void test() {
        Test07.MList<String> mList = new Test07.MList<>();
        mList.appendTail("a");
        mList.appendTail("b");
        mList.appendTail("c");
        assertEquals(mList.deleteHead(), "a");
    }

    @Test
    public void testDouble() {
        double d1, d2;
        d1 = 1.0;
        d2 = 1.0;
        d1 = d1 * d2;
        d1 = d1 - 1;
        d1 = d1 + 1;
        if (d1 == d2) {
            System.out.println("equals");
        }
    }

}
