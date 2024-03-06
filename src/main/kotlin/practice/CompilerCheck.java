package practice;

import java.util.Arrays;

public class CompilerCheck {
    public static void main(String[] args) {
        int[][] roads = new int[3][2];
        roads[0][0] = 1;
        roads[0][1] = 2;
//        roads[0][2] = 3;
        roads[1][0] = 2;
        roads[1][1] = 3;
        roads[2][0] = 4;
        roads[2][1] = 5;
//        roads[1][2] = 3;
        System.out.println(roads.length);
        System.out.println(Arrays.toString(roads[0]));


    }
}

