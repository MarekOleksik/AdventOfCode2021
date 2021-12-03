package day3.part1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileReader = new FileInputStream("src\\day3\\part1\\input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fileReader, StandardCharsets.UTF_8));
        ArrayList<String> list = new ArrayList<>();
        String row;

        int lengthOfRow = 0;

        while ((row = br.readLine()) != null) {
            list.add(row);
            lengthOfRow = row.length();
        }
        int[] numbers = new int[lengthOfRow];

        for (int i = 0; i < list.size(); i++) {
            String[] splittedRow = list.get(i).split("");

            for (int j = 0; j < splittedRow.length; j++) {
                int number = Integer.parseInt(splittedRow[j]);
                if (number == 1) {
                    numbers[j]++;
                }
            }
        }
        String finalGammaString = "";
        String finalEpsilonString = "";
        for (int n : numbers) {
            if (n > list.size() - n) {
                finalGammaString += "1";
                finalEpsilonString += "0";
            } else {
                finalGammaString += "0";
                finalEpsilonString += "1";
            }
        }

        int gamma = Integer.parseInt(finalGammaString, 2);
        int epsilon = Integer.parseInt(finalEpsilonString, 2);

        int result = gamma * epsilon;

        System.out.println("result = " + result);

    }
}

