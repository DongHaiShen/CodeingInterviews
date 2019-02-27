import java.util.ArrayList;

/**
 * @Author sdh
 * @Date Created in 2019/2/27 12:32
 * @description
 */
public class PrintMatrixTest
{
    public static void main(String[] args)
    {
        PrintMatrix test = new PrintMatrix();

        int[][] numbers = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9},
        };
        print(test.printMatrix(numbers));
        System.out.println();

        int[][] numbers2 = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {22, 23, 24, 25, 26, 27, 28, 9},
                {21, 36, 37, 38, 39, 40, 29, 10},
                {20, 35, 34, 33, 32, 31, 30, 11},
                {19, 18, 17, 16, 15, 14, 13, 12},

        };
        print(test.printMatrix(numbers2));
        System.out.println();


        int[][] numbers3 = {
                {1, 2, 3, 4, 5, 6, 7, 8}
        };
        print(test.printMatrix(numbers3));
        System.out.println();

        int[][] numbers4 = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {16, 15, 14, 13, 12, 11, 10, 9}
        };
        print(test.printMatrix(numbers4));
        System.out.println();


        int[][] numbers5 = {
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8}
        };
        print(test.printMatrix(numbers5));
        System.out.println();

        int[][] numbers6 = {
                {0, 1},
                {15, 2},
                {14, 3},
                {13, 4},
                {12, 5},
                {11, 6},
                {10, 7},
                {9, 8}
        };
        print(test.printMatrix(numbers6));
        System.out.println();


        int[][] numbers7 = {
                {1, 2},
                {4, 3}
        };
        print(test.printMatrix(numbers7));
        System.out.println();

        int[][] numbers8 = {
                {1}
        };
        print(test.printMatrix(numbers8));
        System.out.println();

        // 0个元素的数组
        print(test.printMatrix(new int[][]{{}}));
        // 空数组
        print(test.printMatrix(null));
    }

    public static void print(ArrayList<Integer> arrayList)
    {
        for (Integer n : arrayList)
            System.out.print(n + " ");
    }
}
