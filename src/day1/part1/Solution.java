package day1.part1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileReader = new FileInputStream("src\\day1\\part1\\input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fileReader, StandardCharsets.UTF_8));
        ArrayList<Integer> list = new ArrayList<>();
        String row;
        int numberInRow;
        int result = 0;

        while ((row = br.readLine()) != null) {
            numberInRow = Integer.parseInt(row);
            list.add(numberInRow);
        }

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(i-1)) {
                result++;
            }
        }

        System.out.println("result = " + result);

    }
}
