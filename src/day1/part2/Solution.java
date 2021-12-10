package day1.part2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileReader = new FileInputStream("src\\day1\\part2\\input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fileReader, StandardCharsets.UTF_8));
        ArrayList<Integer> list = new ArrayList<>();
        String row;
        int numberInRow;
        int result = 0;

        while ((row = br.readLine()) != null) {
            numberInRow = Integer.parseInt(row);
            list.add(numberInRow);
        }
        ArrayList<Integer> listOfSums = new ArrayList<>();
        for (int j = 1; j < list.size()-1; j++) {
            int sum = list.get(j-1)+list.get(j)+list.get(j+1);
            listOfSums.add(sum);
        }


        for (int i = 1; i < listOfSums.size(); i++) {
            if (listOfSums.get(i) > listOfSums.get(i-1)) {
                result++;
            }
        }

        System.out.println("result = " + result);

    }
}
