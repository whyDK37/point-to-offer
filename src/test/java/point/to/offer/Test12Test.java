package point.to.offer;

import org.testng.annotations.Test;

import static point.to.offer.Test12.printOneToNthDigits;
import static point.to.offer.Test12.printOneToNthDigits2;

public class Test12Test {


    @Test
    public void testPrintArray() {
        printOneToNthDigits2(2);
        System.out.println();
        printOneToNthDigits(2);
    }
}
