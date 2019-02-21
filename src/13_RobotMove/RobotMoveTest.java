/**
 * @Author sdh
 * @Date Created in 2019/2/21 21:25
 * @description
 */
public class RobotMoveTest
{
    public static void main(String[] args)
    {
        RobotMove test = new RobotMove();

        System.out.println(test.movingCount(5, 10, 10) + "[21]");
        System.out.println(test.movingCount(15, 20, 20) + "[359]");
        System.out.println(test.movingCount(10, 1, 100) + "[29]");
        System.out.println(test.movingCount(10, 1, 10) + "[10]");
        System.out.println(test.movingCount(15, 100, 1) + "[79]");
        System.out.println(test.movingCount(15, 10, 1) + "[10]");
        System.out.println(test.movingCount(5, 10, 10) + "[21]");
        System.out.println(test.movingCount(12, 1, 1) + "[1]");
        System.out.println(test.movingCount(-10, 10, 10) + "[0]");
    }
}
