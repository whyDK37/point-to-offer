package point.to.offer;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Test11Test {

    int times = Integer.MAX_VALUE;
    int base = 123;

    @Test
    public void testPower() {

        assertFalse(0.0000000000000000000000001111 == 0);
        assertTrue(0.0000000000000000000000000000 == 0);

        assertEquals(Test11.power(2, 4), 16.0);
        assertEquals(Test11.power(2, 5), 32.0);

//        System.out.println(power(2, -4));
//        System.out.println(power(2, 0));
//        System.out.println(power(0.00000000000000000000000000001, -1));
//        System.out.println(power(0.00000000000000000000000000001, 1));
//        System.out.println(power(0.00000000000000000000000000001, 0));
        // throw exception
//        System.out.println(power(0.00000000000000000000000000000, 0));
    }

    @Test
    public void testMode1() {
        for (int i = 0; i < times; i++) {
            if ((base & 0x1) == 1) {
            }
        }
    }

    @Test
    public void testMode2() {
        for (int i = 0; i < times; i++) {
            if ((base % 2) == 1) {
            }
        }
    }
}
