package point.to.offer;

/**
 * Date: 2015-04-23
 * Time: 09:21
 * Declaration: All Rights Reserved !!!
 */
public class Test10 {

    /**
     * 不完善的实现
     *
     * @param n
     * @return
     */
    public static int numberOfOne1(int n) {
        // 记录数字中1的位数
        int result = 0;

        // JAVA语言规范中，int整形占四个字节，总计32位
        // 对每一个位置与1进行求与操作，再累加就可以求出当前数字的表示是多少位1
        while (n > 0) {
            if ((n & 1) == 1) {
                result++;
            }
            n = n >> 1;
        }

        // 返回求得的结果
        return result;
    }

    /**
     * 请实现一个函数， 输入一个整数，输出该数二进制表示中1的个数。
     * 例如把9表示成二进制是1001 ，有2位是1. 因此如果输入9，该出2。
     *
     * @param n 待的数字
     * @return 数字中二进制表表的1的数目
     */
    public static int numberOfOne(int n) {
        // 记录数字中1的位数
        int result = 0;

        // JAVA语言规范中，int整形占四个字节，总计32位
        // 对每一个位置与1进行求与操作，再累加就可以求出当前数字的表示是多少位1
        for (int i = 0; i < 32; i++) {
            result += (n & 1);
            n >>>= 1;
        }

        // 返回求得的结果
        return result;
    }

    /**
     * 请实现一个函数， 输入一个整数，输出该数二进制表示中1的个数。
     * 例如把9表示成二进制是1001 ，有2位是1. 因此如果输入9，该出2。
     * 【这种方法的效率更高】
     * 在分析这种算法之前，我们先来分析把一个数减去1的情况。如果一个整数不等于0，那么该整数的二进制表示中至少有一位是1。
     * 先假设这个数的最右边一位是1，那么减去1时，最后一位变成0而其他所有位都保持不变。也就是最后一位相当于做了取反操作，由1变成了0。
     * <p>
     * 接下来假设最后一位不是1而是0的情况。如果该整数的二进制表示中最右边1位于第m位，那么减去1时，第m位由1变成0，
     * 而第m位之后的所有0都变成1，整数中第m位之前的所有位都保持不变。
     * 举个例子：
     * 一个二进制数1100，它的第二位是从最右边数起的一个1。减去1后，第二位变成0，它后面的两位0变成1，而前面的1保持不变，因此得到的结果是1011。
     * <p>
     * 在前面两种情况中，我们发现把一个整数减去1，都是把最右边的1变成0。如果它的右边还有0的话，所有的0都变成1，
     * 而它左边所有位都保持不变。接下来我们把一个整数和它减去1的结果做位与运算，相当于把它最右边的1变成0。
     * 还是以前面的1100为例，它减去1的结果是1011。我们再把1100和1011做位与运算，得到的结果是1000。我们把1100最右边的1变成了0，结果刚好就是1000。
     * <p>
     * 我们把上面的分析总结起来就是：把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0。
     * 那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作。基于这种思路，我们可以写出新的代码：
     *
     * 把一个整数减去1之后再和原来的整数做位与运算，得到的结果相当于是把整数的二进制表示中的最右边一个1变成0。很多二进制的问题都可以用这个思路解决。
     *
     * @param n 待的数字
     * @return 数字中二进制表表的1的数目
     */
    public static int numberOfOne2(int n) {
        // 记录数字中1的位数
        int result = 0;

        // 数字的二进制表示中有多少个1就进行多少次操作
        // 如果一个整数不等于0，那么该整数的二进制表示中至少有一位是1
        while (n != 0) {
            ++result;
            // 从最右边的1开始，每一次操作都使n的最右的一个1变成了0，
            // 即使是符号位也会进行操作。
            n = (n - 1) & n;
        }

        // 返回求得的结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numberOfOne1(0x80000000)); // 0
        System.out.println(numberOfOne1(0B00000000_00000000_00000001_00000000)); // 0

        System.out.println(numberOfOne(0B00000000_00000000_00000000_00000000)); // 0
        System.out.println(numberOfOne(0B00000000_00000000_00000000_00000001)); // 1
        System.out.println(numberOfOne(0B11111111_11111111_11111111_11111111)); // -1
        System.out.println(0B01111111_11111111_11111111_11111111 == Integer.MAX_VALUE);
        System.out.println(numberOfOne(0B01111111_11111111_11111111_11111111)); // Integer.MAX_VALUE
        System.out.println(0B10000000_00000000_00000000_00000000 == Integer.MIN_VALUE);
        System.out.println(numberOfOne(0B10000000_00000000_00000000_00000000)); // Integer.MIN_VALUE

        System.out.println("");
        System.out.println(numberOfOne2(0B00000000_00000000_00000000_00000000)); // 0
        System.out.println(numberOfOne2(0B00000000_00000000_00000000_00000001)); // 1
        System.out.println(numberOfOne2(0B11111111_11111111_11111111_11111111)); // -1
        System.out.println(numberOfOne2(0B01111111_11111111_11111111_11111111)); // Integer.MAX_VALUE
        System.out.println(numberOfOne2(0B10000000_00000000_00000000_00000000)); // Integer.MIN_VALUE
        System.out.println(numberOfOne2(0B00000000_00000000_00000000_00001011)); //
    }
}
