package point.to.offer;

/**
 * Date: 2015-04-23
 * Time: 09:09
 * Declaration: All Rights Reserved !!!
 */
public class Test09V1 {

    /**
     * 写一个函数，输入n，求斐波那契（Fibonacci) 数列的第n项
     *
     * @param n Fibonacci数的项数
     * @return 第n项的结果
     */
    public static long fibonacci(int n) {

        // 当输入非正整数的时候返回0
        if (n <= 0) {
            return 0;
        }

        // 输入1或者2的时候返回1
        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(7));
        System.out.println(fibonacci(45));
    }
}
