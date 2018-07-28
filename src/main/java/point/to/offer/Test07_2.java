package point.to.offer;

public class Test07_2 {


    /**
     * 公司员工的年龄有一个范围。允许的范围是0～99岁。数组timesOfAge用来统计每个年龄出现的次数。
     * 某个年龄出现了多少次，就在数组ages里设置几次该年龄，这样就相当于给数组ages排序了。
     *
     * @param ages
     */
    static void sortAges(int[] ages) {

        int oldestAge = 99;
        int[] timesOfAge = new int[oldestAge + 1];

        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            if (age < 0 || age > oldestAge)
                throw new RuntimeException(" age out of range.");

            ++timesOfAge[age];
        }

        int index = 0;
        for (int i = 1; i <= oldestAge; i++) {
            for (int j = 0; j < timesOfAge[i]; j++) {
                ages[index] = i;
                ++index;
            }
        }
    }

    public static void main(String[] args) {
        int[] ages = {2, 3, 4, 23, 34, 54, 92, 12, 21, 12, 99, 10, 12, 43};
        sortAges(ages);
        for (int i = 0; i < ages.length; i++) {
            System.out.println(ages[i]);
        }
    }

}
