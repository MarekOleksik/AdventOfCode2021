package day3.part2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileReader = new FileInputStream("src\\day3\\part2\\input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fileReader, StandardCharsets.UTF_8));
        ArrayList<String> list = new ArrayList<>();
        String row;

        int lengthOfRow = 0;

        while ((row = br.readLine()) != null) {
            list.add(row);
            lengthOfRow = row.length();
        }
        ArrayList<String> oxygenList = list;

        for (int k = 0; k < lengthOfRow; k++) {
            ArrayList<String> zeroNumbers = new ArrayList<>();
            ArrayList<String> oneNumbers = new ArrayList<>();
            for (String s : oxygenList) {
                String[] splittedRow = s.split("");
                int number = Integer.parseInt(splittedRow[k]);

                if (number == 1) {
                    oneNumbers.add(s);
                } else {
                    zeroNumbers.add(s);
                }
            }
            if (oneNumbers.size() >= zeroNumbers.size()) {
                oxygenList = oneNumbers;
            } else {
                oxygenList = zeroNumbers;
            }

            if (oxygenList.size() == 1) break;
        }


        String oxygenGeneratorRatingString = oxygenList.get(0);
        int oxygenGeneratorRating = Integer.parseInt(oxygenGeneratorRatingString, 2);

        ArrayList<String> co2List = list;

        for (int k = 0; k < lengthOfRow; k++) {
            ArrayList<String> zeroNumbers = new ArrayList<>();
            ArrayList<String> oneNumbers = new ArrayList<>();
            for (String s : co2List) {
                String[] splittedRow = s.split("");
                int number = Integer.parseInt(splittedRow[k]);

                if (number == 1) {
                    oneNumbers.add(s);
                } else {
                    zeroNumbers.add(s);
                }
            }
            if (zeroNumbers.size() <= oneNumbers.size()) {
                co2List = zeroNumbers;
            } else {
                co2List = oneNumbers;
            }

            if (co2List.size() == 1) break;

        }

        String co2GeneratorRatingString = co2List.get(0);
        int co2GeneratorRating = Integer.parseInt(co2GeneratorRatingString, 2);


        int result = oxygenGeneratorRating * co2GeneratorRating;

        System.out.println("result = " + result);

    }
}

