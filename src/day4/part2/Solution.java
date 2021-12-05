package day4.part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src\\day4\\part1\\input.txt"));

        int[] input = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();

        System.out.println("result: " + getResult(input, br));
    }


    public static int getResult(int[] input, BufferedReader br) throws IOException {
        ArrayList<Board> boards = Board.createBoards(br);

        for (int i = 0; i < input.length; ++i) {

            for (int j = 0, boardSize = boards.size(); j < boardSize; ++j, boardSize = boards.size()) {
                int num = boards.get(j).markNumber(input[i]);
                if (num > 0 && boards.size() == 1) {
                    return num;
                } else if (num > 0) {
                    boards.remove(j);
                    --j;
                }
            }

        }

        return -5;
    }
}