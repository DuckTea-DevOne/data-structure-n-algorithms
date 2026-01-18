package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    // Brute Force
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> solution = new ArrayList<>();
        if (numRows == 0) {
            return solution;
        }
        // {{1}}
        List<Integer> list = new ArrayList<>();
        list.add(1);
        solution.add(list);

        if (numRows == 1) {
            return solution;
        }
        //{{1},{1,1}}
        List<Integer> newList = new ArrayList<>();
        newList.add(1);
        newList.add(1);
        solution.add(newList);

        if (numRows == 2) {
            return solution;
        }
        // {{1},{1,1},...}
        for (int i = 2; i < numRows; i++) {
            List<Integer> innerList = new ArrayList<>();
            innerList.add(1);
            for (int j = 1; j < i; j++) {
                innerList.add(solution.get(i-1).get(j) + solution.get(i-1).get(j-1));
            }
            innerList.add(1);
            solution.add(innerList);
        }

        return solution;
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().generate(5));
        System.out.println(new PascalsTriangle().generateV2(5));
    }

    // Optimised 1 : Optimize the iteration;

    public List<List<Integer>> generateV2(int numRows) {
        List<List<Integer>> solution = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // Ends of a row {1,...., 1}
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    // { 1, <[i-1][j] + [i-1][j-1]>, 1 }
                    list.add(solution.get(i - 1).get(j -1) + solution.get(i - 1).get(j));
                }
            }
            solution.add(list);
        }

        return solution;
    }

    // Optimised 2 : Pascal's Triangle by theory is based on [nCr = n! / (r! * (n-r)!) ]

//    List<List<Integer>> generateV3(int numRows) {
//
//    }
//
//    int nCr(int n, int r) {
//
//    }
}
