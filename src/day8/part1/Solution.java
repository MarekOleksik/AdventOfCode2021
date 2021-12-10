package day8.part1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> listOfRows = getRows();
        System.out.println("result = " + getResult(listOfRows));
    }

    private static List<String> getRows() throws IOException {
        FileInputStream fileReader = new FileInputStream("src\\day8\\part1\\input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fileReader, StandardCharsets.UTF_8));
        ArrayList<String> list = new ArrayList<>();
        String row;

        while ((row = br.readLine()) != null) {
            list.add(row);
        }
        return list;
    }

    private static int getResult(List<String> list) {
        int sumOfNumbers = 0;
        for (String row : list) {
            String[] partOfRow = row.split("[|]");
            String[] stringsOfNumbers = partOfRow[1].split(" ");

            for (String s : stringsOfNumbers) {
                switch (s.length()) {
                    case 2, 3, 4, 7 -> sumOfNumbers++;
                }
            }
        }
        return sumOfNumbers;
    }
}
